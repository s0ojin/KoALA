import ChatBubble from '@/app/_components/ChatBubble'
import OnlineLearningChatInput from './OnlineLearningChatInput'

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

export default function OnlineLearningChatPanel() {
  return (
    <div className="h-full flex flex-col justify-between gap-6">
      <div className="overflow-auto ">
        <div className="flex flex-col gap-3 pr-3">
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
      </div>
      <div className="flex-1">
        <OnlineLearningChatInput />
      </div>
    </div>
  )
}
