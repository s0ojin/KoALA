import SentenceAddBtn from '/public/icons/plus-circle.svg'
import { useParams } from 'next/navigation'
import { mutate } from 'swr'
import { postUserSentence } from '../apis/sentence'

interface SentenceAddCardProps {
  sentence: string
  sentenceId: number
  handleDeleteuserSentence?: () => void
}

export default function SentenceAddCard({
  sentence,
  handleDeleteuserSentence,
}: SentenceAddCardProps) {
  const params = useParams()
  const { lecture_id } = params

  const handleAddSeuntence = async () => {
    const res = await postUserSentence('/sentences', {
      sentence_text: sentence,
    })
    if (res?.status === 201) {
      alert('문장이 잘 추가되었습니다')
      if (handleDeleteuserSentence) handleDeleteuserSentence()
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
