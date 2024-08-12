'use client'

import ChatBubble from '@/app/_components/ChatBubble'
import { useState } from 'react'
import { useForm } from 'react-hook-form'
import ChatSendBtn from '/public/icons/send.svg'

const dummy = [
  {
    id: 1,
    isMine: true,
    message: '내가 보낸 메시지',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
  {
    id: 2,
    isMine: false,
    message: '받은 메시지',
    senderName: '응 위엔',
    senderProfile: '/public/images/koala-sleep.png',
    timeStamp: '2024-07-30T13:45:00+09:00',
  },
]

export default function OnlineLearningChatPanel() {
  const [messages, setMessages] = useState(dummy)
  const {
    register,
    handleSubmit,
    formState: { isValid },
  } = useForm()

  const onSubmit = (data) => {
    console.log('Sending message:', data)
  }

  return (
    <div className="h-full flex flex-col justify-between gap-6">
      <div className="overflow-auto">
        <div className="flex flex-col gap-3 pr-3">
          {messages.map((chat, index) => (
            <ChatBubble
              key={index}
              isMine={chat.isMine}
              message={chat.message}
              senderName={chat.senderName}
              senderProfile={chat.senderProfile}
              timeStamp={chat.timeStamp}
            />
          ))}
        </div>
      </div>
      <form
        onSubmit={handleSubmit(onSubmit)}
        className="flex justify-between w-full gap-1 p-5 h-32 rounded-3xl bg-gray-100"
      >
        <textarea
          {...register('chat', { required: true })}
          placeholder="메시지 보내기"
          className="bg-transparent w-full outline-none text-gray-900 resize-none"
        />
        <button
          type="submit"
          className={`text-gray-400 w-6 self-end ${isValid && 'text-primary-400'}`}
        >
          <ChatSendBtn />
        </button>
      </form>
    </div>
  )
}
