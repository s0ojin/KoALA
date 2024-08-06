import AiIcon from '/public/icons/report-ai-conversation.svg'
import DictationIcon from '/public/icons/report-dictation.svg'
import OnlineLearningIcon from '/public/icons/report-online-learning.svg'

export default function ReportStudyInfo() {
  return (
    <div className="inline-flex">
      <div className="w-[15rem] h-[6rem] bg-primary-400 rounded-2xl px-5 mr-4">
        <div className="inline-flex items-center w-full h-full justify-between">
          <div className="flex w-16 h-16 bg-white rounded-full mr-3">
            <DictationIcon width={40} height={40} className="m-auto" />
          </div>
          <div className="text-white">
            <p>받아쓰기 문장 수</p>
            <p className="font-bold text-center text-2xl mt-2">16</p>
          </div>
        </div>
      </div>
      <div className="w-[15rem] h-[6rem] bg-primary-400 rounded-2xl px-5 mr-4">
        <div className="inline-flex items-center w-full h-full">
          <div className="flex w-16 h-16 bg-white rounded-full mr-3">
            <AiIcon width={40} height={40} className="m-auto" />
          </div>
          <div className="text-white">
            <p>AI회화 진행 시간</p>
            <p className="font-bold text-center text-2xl mt-2">16</p>
          </div>
        </div>
      </div>
      <div className="w-[15rem] h-[6rem] bg-primary-400 rounded-2xl px-5">
        <div className="inline-flex items-center w-full h-full justify-between">
          <div className="flex w-16 h-16 bg-white rounded-full mr-3">
            <OnlineLearningIcon width={40} height={40} className="m-auto" />
          </div>
          <div className="text-white">
            <p>학습한 강의 수</p>
            <p className="font-bold text-center text-2xl mt-2">16</p>
          </div>
        </div>
      </div>
    </div>
  )
}
