import Image from 'next/image'
import GradingResult from '@/app/dictation/_components/DictationGradingResult'

const ResultList = [
  { idx: 1, question: '아가라구욥', isCorrect: true },
  { idx: 2, question: '아가라고요!', isCorrect: false },
  { idx: 3, question: '아 가 라 고 요!', isCorrect: false },
  { idx: 4, question: '아가라구욥', isCorrect: true },
  { idx: 5, question: '아가라구욥', isCorrect: true },
  { idx: 6, question: '아가라구욥', isCorrect: true },
  { idx: 7, question: '아가라구욥', isCorrect: true },
  { idx: 8, question: '아가라구욥', isCorrect: true },
  { idx: 9, question: '아가라구욥', isCorrect: true },
  { idx: 10, question: '아가라구욥', isCorrect: true },
]

export default function GradingSheet() {
  return (
    <div className="relative px-24 pt-20 pb-32 gap-20 flex flex-col items-center h-auto bg-[url('/images/texture.png')]">
      <div className="flex items-end">
        <p className="text-[#D14848] text-6xl font-black">80</p>
        <p className="text-primary-900 text-xl font-medium">/100</p>
      </div>
      <div className="flex flex-col gap-16">
        {ResultList.map((result) => {
          return <GradingResult result={result} key={result.idx} />
        })}
      </div>
      <Image
        src="/images/cloud.svg"
        alt="astronaut"
        width={0}
        height={0}
        sizes="100%"
        className="w-60 h-32 absolute -top-16 -right-36"
      />
      <Image
        src="/images/cloud.svg"
        alt="astronaut"
        width={0}
        height={0}
        sizes="100%"
        className="w-40 h-20 absolute top-20 -left-20"
      />
      <Image
        src="/images/astronaut.png"
        alt="astronaut"
        width={0}
        height={0}
        sizes="100%"
        className="w-36 h-36 absolute -bottom-20 -right-20"
      />
    </div>
  )
}
