import Image from 'next/image'
import Correct from '/public/icons/correct.svg'
import Wrong from '/public/icons/wrong.svg'

interface GradingResultProps {
  result: {
    idx: number
    question: string
    isCorrect: boolean
  }
}

export default function DictationGradingResult({
  result: { idx, question, isCorrect },
}: GradingResultProps) {
  return (
    <div className="flex flex-col gap-6 relative">
      <p className="absolute -left-10 -top-5">
        {isCorrect ? <Correct /> : <Wrong />}
      </p>
      <div className="flex items-center gap-4 text-2xl font-normal">
        <p>{idx}.</p>
        <p className="">{question}</p>
      </div>
      <Image
        src="/images/dictation.png"
        alt="받아쓰기 답안"
        width={0}
        height={0}
        sizes="100%"
        className="w-[38rem] h-auto pl-6"
      />
    </div>
  )
}
