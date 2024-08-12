'use client'

import { useEffect, useState } from 'react'
import { OpenVidu, Publisher, Session } from 'openvidu-browser'
import {
  postCreateOpenViduConnection,
  postCreateOpenViduSession,
} from '@/app/apis/online-learning'
import useSWR from 'swr'

export default function OnlineLearningVideoChat({
  lectureId,
}: {
  lectureId: string
}) {
  const { data: userInfo } = useSWR('/users')
  const [session, setSession] = useState<Session | null>(null)
  const [publisher, setPublisher] = useState<Publisher | null>(null)

  useEffect(() => {
    console.log('useEffect 계속 작동하는중!!!!!!')
    const initializeSession = async () => {
      if (!userInfo || !userInfo.data) return

      try {
        // await postCreateOpenViduSession(`/lectures/${lectureId}/session`)
        const tokenResponse = await postCreateOpenViduConnection(
          `/lectures/${lectureId}/connections`
        )
        const token = tokenResponse?.data

        if (!token) {
          console.error('세션에 참여하기 위한 토큰을 받아오지 못했습니다!')
          return
        }

        const OV = new OpenVidu()
        const session = OV.initSession()

        session.on('streamCreated', (event) => {
          session.subscribe(event.stream, 'subscriber')
        })

        await session
          .connect(token, {})
          .then(() => {
            if (userInfo.data.auth_id === 2) {
              const publisher = OV.initPublisher('publisher', {
                audioSource: true,
                videoSource: true,
                publishAudio: true,
                publishVideo: true,
                resolution: '320x240',
                insertMode: 'REPLACE',
                mirror: true,
              })

              session.publish(publisher)
              setPublisher(publisher)
            }
            setSession(session)
          })
          .catch((error) => {
            console.error('세션 연결 중 에러 발생:', error)
          })
      } catch (error) {
        console.error('OpenVidu 세션 초기화 중 에러 발생:', error)
      }
    }

    initializeSession()

    return () => {
      if (session) {
        session.disconnect()
        setSession(null)
      }
    }
  }, [lectureId, userInfo?.data?.nickname])

  return (
    <div className="flex flex-col items-center justify-center gap-4 h-full">
      <div className="flex-1 bg-black w-full max-w-[720px] h-[480px] rounded-[3rem] overflow-hidden">
        {userInfo && userInfo.data.auth_id === 2 ? (
          <div id="publisher"></div>
        ) : (
          <div id="subscriber"></div>
        )}
      </div>
    </div>
  )
}
