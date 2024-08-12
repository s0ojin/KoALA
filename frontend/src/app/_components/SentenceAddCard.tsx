import { postTeacherSentence } from '@/app/apis/online-learning'
import SentenceAddBtn from '/public/icons/plus-circle.svg'
import { useParams } from 'next/navigation'
import { mutate } from 'swr'

interface SentenceAddCardProps {
  sentence: string
  sentenceId: number
}

export default function SentenceAddCard({
  sentence,
  sentenceId,
}: SentenceAddCardProps) {
  const params = useParams()
  const { lecture_id } = params

  const handleAddSeuntence = async () => {
    const res = await postTeacherSentence('/reviews', {
      sentence_id: sentenceId,
    })
    if (res?.status === 201) {
      mutate(`/lectures/${lecture_id}/sentences`)
    }
  }

  return (
    <div className="w-full min-h-12 rounded-[1.5rem] bg-primary-400 text-white flex justify-between items-center px-4 py-2">
      <p>{sentence}</p>
      <div>
        <SentenceAddBtn
          onClick={handleAddSeuntence}
          className="w-8 cursor-pointer"
        />
      </div>
    </div>
  )
}
