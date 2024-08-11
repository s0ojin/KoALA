'use client'

import { useEffect, useState } from 'react'
import { OpenVidu, Publisher, Session, Subscriber } from 'openvidu-browser'
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
  const [subscribers, setSubscribers] = useState<Subscriber[]>([])

  useEffect(() => {
    const initializeSession = async () => {
      if (!userInfo) return

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
          const streamId = event.stream.streamId

          if (
            !subscribers.some(
              (subscriber) => subscriber.stream.streamId === streamId
            )
          ) {
            console.log(
              `Subscribing to ${event.stream.connection.connectionId}`
            )

            const subscriber = session.subscribe(
              event.stream,
              `subscriber-${streamId}`
            )
            setSubscribers((prevSubscribers) => [
              ...prevSubscribers,
              subscriber,
            ])
          } else {
            console.warn(`${streamId}은 이미 세션에 참여해 있습니다.`)
          }
        })

        await session
          .connect(token, {})
          .then(() => {
            const publisher = OV.initPublisher('publisher', {
              audioSource: true,
              videoSource: true,
              publishAudio: true,
              publishVideo: true,
              resolution: '1280x720',
              insertMode: 'APPEND',
              mirror: true,
            })

            session.publish(publisher)
            setPublisher(publisher)
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
        setSubscribers([])
      }
    }
  }, [userInfo])

  return (
    <div className="flex flex-col items-center justify-center gap-4 h-full">
      <div className="flex-1 bg-black w-full max-w-[720px] h-[480px] rounded-[3rem] overflow-hidden">
        <div id="publisher"></div>
      </div>

      <div id="subscriber" className="flex">
        {subscribers.map((subscriber) => (
          <video
            autoPlay
            key={`subscriber-${subscriber.stream.streamId}`}
            id={`subscriber-${subscriber.stream.streamId}`}
            className="w-[200px] h-[150px] bg-gray-900 m-2"
          ></video>
        ))}
      </div>
    </div>
  )
}
