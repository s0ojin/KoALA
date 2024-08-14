import Image from 'next/image'

interface ChatBubbleProps {
  isMine: boolean
  message: string
  senderName?: string
  senderProfile?: string
  timeStamp?: string
}

export default function ChatBubble({
  isMine,
  message,
  senderName,
  senderProfile,
  timeStamp,
}: ChatBubbleProps) {
  const getFormattedTime = (timestamp: string) => {
    const date = new Date(timestamp)
    return date.toLocaleTimeString('ko-KR', {
      hour: 'numeric',
      minute: 'numeric',
      hour12: true,
    })
  }

  return (
    <div className={`flex gap-2 ${isMine && 'self-end flex-row-reverse'}`}>
      {!isMine && senderProfile && (
        <div className="profile w-10 h-10 rounded-3xl bg-black">
          <Image src={senderProfile} alt="profile" width={16} height={16} />
        </div>
      )}
      <div>
        {!isMine && <p className="text-sm mb-1">{senderName}</p>}
        <div
          className={`w-full px-4 py-3 ${isMine ? 'bg-primary-400 text-white rounded-3xl rounded-tr-none' : 'bg-gray-100 rounded-full rounded-tl-none'}`}
        >
          <p>{message}</p>
        </div>
      </div>
      <p className="whitespace-nowrap self-end text-xs text-gray-500">
        {timeStamp && getFormattedTime(timeStamp)}
      </p>
    </div>
  )
}
