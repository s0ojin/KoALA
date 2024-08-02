import SentenceAddCard from '@/app/_components/SentenceAddCard'

const dummy = [
  {
    sentence_id: 33,
    sentence_text:
      '선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
]

export default function OnlineLearningHandoutPanel() {
  return (
    <div className="h-full overflow-auto">
      <div className="flex flex-col gap-2 pr-3">
        {dummy.map((sentence) => (
          <SentenceAddCard
            key={sentence.sentence_id}
            sentenceId={sentence.sentence_id}
            sentence={sentence.sentence_text}
          />
        ))}
      </div>
    </div>
  )
}
