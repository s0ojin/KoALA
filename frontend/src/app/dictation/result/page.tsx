import DictationResultLayout from '@/app/dictation/_components/DictationResultLayout'
import GradingSheet from '@/app/dictation/_components/DictationGradingSheet'
import Replay from '/public/icons/re-button.svg'

export default function DictationResult() {
  return (
    <DictationResultLayout>
      <div className="gap-20 pt-44 pb-40 w-full h-full min-h-screen flex items-center flex-col">
        <GradingSheet />
        <div className="flex flex-col gap-12 items-center">
          <button className="px-48 text-2xl font-medium text-white gap-2 items-center rounded-full py-4 bg-primary-400 flex">
            <Replay className="w-8" />
            <p className="leading-10">다시하기</p>
          </button>
          <button className="text-gray-500 font-normal text-2xl py-2">
            나가기
          </button>
        </div>
      </div>
    </DictationResultLayout>
  )
}
