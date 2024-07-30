import AISpeakingBackgroundLayout from './_components/AISpeakingBackgroundLayout'
import AISpeakingCourseCard from './_components/AISpeakingCourseCard'

const dummy = [
  {
    id: 1,
    title: '관공서에서 민원을 넣을 때',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 1,
    title: '관공서에서 민원을 넣을 때',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
]

export default function AISpeakingMain() {
  return (
    <AISpeakingBackgroundLayout>
      <div className="flex">
        {dummy.map((conversation) => (
          <AISpeakingCourseCard
            key={conversation.id}
            conversationTitle={conversation.title}
            conversationDescription={conversation.description}
          />
        ))}
      </div>
    </AISpeakingBackgroundLayout>
  )
}
