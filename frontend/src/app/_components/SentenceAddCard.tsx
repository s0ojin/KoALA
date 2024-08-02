import SentenceAddBtn from '/public/icons/plus-circle.svg'

interface SentenceAddCardProps {
  sentence: string
  sentenceId: number
}

export default function SentenceAddCard({
  sentence,
  sentenceId,
}: SentenceAddCardProps) {
  const handleAddSeuntence = () => {
    console.log('문장추가~')
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
