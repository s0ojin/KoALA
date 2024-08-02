import DictationResultLayout from '@/app/dictation/_components/DictationResultLayout'
import GradingSheet from '@/app/dictation/_components/DictationGradingSheet'
import Replay from '/public/icons/re-button.svg'

export default function DictationResult() {
  return (
    <DictationResultLayout>
      <div className="gap-20 pt-44 pb-40 w-full h-full min-h-screen flex items-center flex-col">
        <GradingSheet />
        <div className="flex flex-col gap-14 items-center">
          <div className="px-52 gap-2 items-center rounded-full py-4 bg-primary-400 flex">
            <p>
              <Replay fill="#ffffff" />
            </p>
            <button className="flex items-center submit-btn text-3xl">
              다시하기
            </button>
          </div>
          <button className="text-gray-500 font-normal text-3xl">나가기</button>
        </div>
      </div>
    </DictationResultLayout>
  )
}
