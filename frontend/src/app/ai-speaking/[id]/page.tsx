'use client'
import ChatBubble from '@/app/_components/ChatBubble'
import MicBtn from '/public/icons/microphone.svg'
import SendBtn from '/public/icons/send.svg'
import Image from 'next/image'
import { useState } from 'react'
import AISpeakingBackgroundLayout from '../_components/AISpeakingBackgroundLayout'

const dummy = [
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지dddddddddddddddddddd',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 1,
    isMine: true,
    message: '내가보낸 메세지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '내가보낸 메세지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
]

export default function AISpeakingLearningRoom() {
  const [isSpeakMode, setIsSpeakMode] = useState(true)
  return (
    <AISpeakingBackgroundLayout>
      <div className="h-main-screen flex items-center">
        <div className="h-[90%] w-[80%] max-w-7xl bg-white rounded-3xl mx-auto flex gap-10 p-8">
          <div className="relative bg-gray-300 rounded-tr-3xl overflow-hidden w-[50%] ">
            <img
              src="https://plus.unsplash.com/premium_photo-1680807869780-e0876a6f3cd5?q=80&w=871&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
              alt="background"
              className="w-full h-full object-cover blur-sm"
            />
            <Image
              src="/images/koala-front.png"
              alt="koala-front"
              width={300}
              height={300}
              className="absolute bottom-16 left-16"
            />
          </div>
          <div className="w-[50%] flex flex-col gap-12 items-center">
            <div className="w-full overflow-auto pr-3">
              {dummy.map((chat) => (
                <ChatBubble
                  key={chat.id}
                  isMine={chat.isMine}
                  message={chat.message}
                  senderName={chat.senderName}
                  senderProfile={chat.senderProfile}
                  timeStamp={chat.timeStamp}
                />
              ))}
            </div>
            <div className="flex-1 w-full text-center">
              {isSpeakMode ? (
                <button>
                  <MicBtn className="w-16 text-primary-400" />
                </button>
              ) : (
                <div className="flex gap-3">
                  <input type="text" className="input" />
                  <button className="w-16 text-white bg-primary-400 rounded-full p-3">
                    <SendBtn />
                  </button>
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </AISpeakingBackgroundLayout>
  )
}
