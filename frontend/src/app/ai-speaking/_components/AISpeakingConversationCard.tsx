interface AISpeakingConversationCardProps {
  conversationTitle: string
  conversationDescription: string
}

export default function AISpeakingConversationCard({
  conversationTitle,
  conversationDescription,
}: AISpeakingConversationCardProps) {
  return (
    <div className="w-80 h-[28rem] rounded-3xl flex flex-col bg-white overflow-hidden text-gray-900 shadow-md">
      <div className="h-3/5">
        <img
          src="https://images.unsplash.com/photo-1517048676732-d65bc937f952?w=1000&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8b2ZmaWNlfGVufDB8fDB8fHww"
          alt="course-image"
          className="h-full object-cover"
        />
      </div>
      <div className="p-4 flex-1 flex flex-col justify-center items-center text-center gap-6">
        <h2 className="font-medium">{conversationTitle}</h2>
        <p className="text-sm">{conversationDescription}</p>
      </div>
    </div>
  )
}
