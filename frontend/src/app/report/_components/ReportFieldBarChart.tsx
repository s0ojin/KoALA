'use client'

import {
  Chart as ChartJS,
  ChartData,
  ChartOptions,
  CategoryScale,
  LinearScale,
  BarController,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js'
import { Bar } from 'react-chartjs-2'
import ChartDataLabels from 'chartjs-plugin-datalabels'
import { Context } from 'chartjs-plugin-datalabels'
import { WeekData } from '@/app/report/_components/ReportFieldWeekLineChart'

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarController,
  BarElement,
  Title,
  Tooltip,
  Legend
)

interface thisWeekDataProps {
  thisWeekData: WeekData
}

export default function ReportFieldBarChart({
  thisWeekData,
}: thisWeekDataProps) {
  const dictationData: number[] = [
    thisWeekData.Mon.writing,
    thisWeekData.Tue.writing,
    thisWeekData.Wed.writing,
    thisWeekData.Thu.writing,
    thisWeekData.Fri.writing,
    thisWeekData.Sat.writing,
    thisWeekData.Sun.writing,
  ]

  const speakingData: number[] = [
    thisWeekData.Mon.speaking,
    thisWeekData.Tue.speaking,
    thisWeekData.Wed.speaking,
    thisWeekData.Thu.speaking,
    thisWeekData.Fri.speaking,
    thisWeekData.Sat.speaking,
    thisWeekData.Sun.speaking,
  ]

  const lectureData: number[] = [
    thisWeekData.Mon.lectures,
    thisWeekData.Tue.lectures,
    thisWeekData.Wed.lectures,
    thisWeekData.Thu.lectures,
    thisWeekData.Fri.lectures,
    thisWeekData.Sat.lectures,
    thisWeekData.Sun.lectures,
  ]

  const options: ChartOptions<'bar'> = {
    responsive: true,
    plugins: {
      legend: {
        display: false,
      },
      tooltip: {
        enabled: false,
      },
      datalabels: {
        listeners: {
          enter: function (context: Context) {
            context.hovered = true

            return true
          },
          leave: function (context: Context) {
            context.hovered = false
            return true
          },
        },
        color: function (context: Context) {
          return context.hovered ? 'white' : context.dataset.backgroundColor
        },
        display: function (context: Context) {
          return context.dataset.data[context.dataIndex] > 1
        },
      },
    },
    scales: {
      x: {
        stacked: true,
      },
      y: {
        beginAtZero: true,
        stacked: true,
      },
    },
  }

  const data: ChartData<'bar', number[]> = {
    labels: ['월', '화', '수', '목', '금', '토', '일'],
    datasets: [
      {
        label: '받아쓰기',
        data: dictationData,
        backgroundColor: '#4F46F2',
      },
      {
        label: 'AI회화',
        data: speakingData,
        backgroundColor: '#7A72FF',
      },
      {
        label: '강의',
        data: lectureData,
        backgroundColor: '#C7C4FF',
      },
    ],
  }
  return (
    <div className="md:p-3 xl:px-11 xl:py-6 bg-white rounded-2xl w-full h-full">
      <div className="flex justify-between mb-8">
        <p className="text-primary-400 mr-2 flex items-center xl:ml-8 whitespace-nowrap md:text-sm lg:text-base">
          7/15 ~ 7/21
        </p>
        <div className="flex md:gap-1 lg:gap-4 xl:gap-8 lg:flex-grow justify-end">
          <div className="inline-flex items-center">
            <div className="xl:w-[3rem] w-[1rem] h-[1rem] mr-1.5 bg-primary-400 rounded-2xl my-auto" />
            <p className="text-primary-400 whitespace-nowrap md:text-xs lg:text-base">
              받아쓰기
            </p>
          </div>
          <div className="inline-flex items-center">
            <div className="xl:w-[3rem] w-[1rem] h-[1rem] mr-1.5 bg-primary-300 rounded-2xl my-auto" />
            <p className="text-primary-300 whitespace-nowrap md:text-xs lg:text-base">
              AI회화
            </p>
          </div>
          <div className="inline-flex items-center">
            <div className="xl:w-[3rem] w-[1rem] h-[1rem] mr-1.5 bg-primary-100 rounded-2xl my-auto" />
            <p className="text-primary-100 whitespace-nowrap md:text-xs lg:text-base">
              강의
            </p>
          </div>
        </div>
      </div>
      <div>
        <Bar options={options} data={data} plugins={[ChartDataLabels]} />
      </div>
    </div>
  )
}
