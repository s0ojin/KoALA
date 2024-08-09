'use client'

import {
  Chart as ChartJS,
  ChartData,
  ChartOptions,
  CategoryScale,
  LinearScale,
  LineController,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js'
import { Line } from 'react-chartjs-2'
import { StudyInfoProps } from '@/app/report/_components/ReportFieldStudyInfo'

ChartJS.register(
  CategoryScale,
  LinearScale,
  LineController,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
)

export interface WeekData {
  Mon: StudyInfoProps
  Tue: StudyInfoProps
  Wed: StudyInfoProps
  Thu: StudyInfoProps
  Fri: StudyInfoProps
  Sat: StudyInfoProps
  Sun: StudyInfoProps
}

interface WeekDataProps {
  lastWeekData: WeekData
  thisWeekData: WeekData
}

export default function ReportFieldWeekLineChart({
  lastWeekData,
  thisWeekData,
}: WeekDataProps) {
  const lastWeek: number[] = [
    lastWeekData.Mon.writing +
      lastWeekData.Mon.speaking +
      lastWeekData.Mon.lectures,
    lastWeekData.Tue.writing +
      lastWeekData.Tue.speaking +
      lastWeekData.Tue.lectures,
    lastWeekData.Wed.writing +
      lastWeekData.Wed.speaking +
      lastWeekData.Wed.lectures,
    lastWeekData.Thu.writing +
      lastWeekData.Thu.speaking +
      lastWeekData.Thu.lectures,
    lastWeekData.Fri.writing +
      lastWeekData.Fri.speaking +
      lastWeekData.Fri.lectures,
    lastWeekData.Sat.writing +
      lastWeekData.Sat.speaking +
      lastWeekData.Sat.lectures,
    lastWeekData.Sun.writing +
      lastWeekData.Sun.speaking +
      lastWeekData.Sun.lectures,
  ]

  const thisWeek: number[] = [
    thisWeekData.Mon.writing +
      thisWeekData.Mon.speaking +
      thisWeekData.Mon.lectures,
    thisWeekData.Tue.writing +
      thisWeekData.Tue.speaking +
      thisWeekData.Tue.lectures,
    thisWeekData.Wed.writing +
      thisWeekData.Wed.speaking +
      thisWeekData.Wed.lectures,
    thisWeekData.Thu.writing +
      thisWeekData.Thu.speaking +
      thisWeekData.Thu.lectures,
    thisWeekData.Fri.writing +
      thisWeekData.Fri.speaking +
      thisWeekData.Fri.lectures,
    thisWeekData.Sat.writing +
      thisWeekData.Sat.speaking +
      thisWeekData.Sat.lectures,
    thisWeekData.Sun.writing +
      thisWeekData.Sun.speaking +
      thisWeekData.Sun.lectures,
  ]

  const options: ChartOptions<'line'> = {
    responsive: true,
    plugins: {
      legend: {
        display: false,
      },
      tooltip: {
        enabled: false,
      },
    },
    scales: {
      y: {
        beginAtZero: true,
      },
    },
  }

  const labels: string[] = ['월', '화', '수', '목', '금', '토', '일'] //x축 기준

  const data: ChartData<'line', number[]> = {
    labels,
    datasets: [
      {
        label: '지난 주',
        data: lastWeek,
        borderColor: '#F6C4E8',
        cubicInterpolationMode: 'monotone',
        pointBackgroundColor: '#F162CA',
        pointBorderColor: '#F162CA',
        pointRadius: 5,
      },
      {
        label: '이번 주',
        data: thisWeek,
        borderColor: '#DAD8FF',
        cubicInterpolationMode: 'monotone',
        pointBackgroundColor: '#4F46F2',
        pointBorderColor: '#4F46F2',
        pointRadius: 5,
      },
    ],
  }
  return (
    <div className="md:p-3 xl:px-11 xl:py-6 bg-white rounded-2xl w-full h-full">
      <div className="flex mb-8">
        <div className="inline-flex items-center mr-8">
          <div className="xl:w-[3rem] md:w-[1rem] h-[1rem] mr-1.5 bg-pink-400 rounded-2xl my-auto" />
          <p className="text-pink-400">7/8 ~ 7/14</p>
        </div>
        <div className="inline-flex items-center">
          <div className="xl:w-[3rem] md:w-[1rem] h-[1rem] mr-1.5 bg-primary-400 rounded-2xl my-auto" />
          <p className="text-primary-400">7/15 ~ 7/21</p>
        </div>
      </div>
      <div>
        <Line options={options} data={data} />
      </div>
    </div>
  )
}
