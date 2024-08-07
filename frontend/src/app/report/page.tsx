import ReportLayout from '@/app/report/_components/ReportLayout'
import ReportWeekLineChart from '@/app/report/_components/ReportWeekLineChart'
import ReportFieldBarChart from '@/app/report/_components/ReportFieldBarChart'
import ReportFieldPieChart from '@/app/report/_components/ReportFieldPieChart'
import ReportStudyInfo from '@/app/report/_components/ReportStudyInfo'
import ReportRankingBoard from '@/app/report/_components/ReportRankingBoard'

const totalData = {
  writing: 2,
  speaking: 3,
  lectures: 5,
}

const weekData = {
  last_week: {
    Mon: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Tue: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Wed: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Thu: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Fri: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Sat: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Sun: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
  },
  this_week: {
    Mon: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Tue: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Wed: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Thu: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Fri: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Sat: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
    Sun: {
      writing: 2,
      speaking: 3,
      lectures: 5,
    },
  },
}

const rankingData = {
  rankings: [
    {
      userId: 1,
      nickname: '고라니',
      ranking: 1,
    },
    {
      userId: 902,
      nickname: '싸피짱',
      ranking: 2,
    },
    {
      userId: 2,
      nickname: '고라니스',
      ranking: 3,
    },
    {
      userId: 102,
      nickname: '선생님',
      ranking: 4,
    },
    {
      userId: 903,
      nickname: '대주형',
      ranking: 5,
    },
  ],
  myRank: 1,
}

export default function ReportMain() {
  return (
    <ReportLayout>
      <div className="relative bg-white w-[80%] max-w-[80rem] h-auto mx-auto mt-11 pt-16 pb-8 px-8 z-10 rounded-t-2xl">
        <p className="text-3xl text-primary-400 font-bold ml-7 mb-7">
          코알라님의 학습 리포트
        </p>
        <div className="relative flex justify-between w-full h-full md:flex-col-reverse lg:flex-row">
          <div className="md:w-full lg:w-[55%] xl:w-[65%] h-full">
            <div className="bg-gray-50 px-6 py-8 lg:rounded-2xl">
              <div className="w-full">
                <p className="text-gray-600 text-2xl ml-2.5 mb-4">
                  오늘의 총 공부량
                </p>
                <ReportStudyInfo
                  writing={totalData.writing}
                  speaking={totalData.speaking}
                  lectures={totalData.lectures}
                />
              </div>
              <div className="mt-16 w-full">
                <p className="text-gray-600 text-2xl ml-2.5 mb-4">
                  주별 학습 현황
                </p>
                <ReportWeekLineChart
                  lastWeekData={weekData.last_week}
                  thisWeekData={weekData.last_week}
                />
              </div>
              <div className="mt-16 w-full">
                <p className="text-gray-600 text-2xl ml-2.5 mb-4">
                  분야별 학습 현황
                </p>
                <ReportFieldBarChart thisWeekData={weekData.this_week} />
              </div>
            </div>
          </div>
          <div className="lg:-translate-y-20 md:translate-y-0 flex gap-4 lg:flex-col md:flex-row justify-between md:w-full lg:w-[40%] xl:w-[30%] md:h-auto lg:h-[47rem] bg-gray-50 md:rounded-t-2xl lg:rounded-2xl p-4">
            <div className="md:w-[18rem] lg:w-full md:h-full lg:h-auto bg-white rounded-2xl shadow-md p-4">
              <p className="text-xl text-primary-400 mb-4">전체 총합</p>
              <ReportFieldPieChart
                writing={totalData.writing}
                speaking={totalData.speaking}
                lectures={totalData.lectures}
              />
            </div>
            <ReportRankingBoard rankingData={rankingData.rankings} />
          </div>
        </div>
      </div>
    </ReportLayout>
  )
}
