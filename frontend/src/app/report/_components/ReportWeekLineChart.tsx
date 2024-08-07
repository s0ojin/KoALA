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

const labels = ['월', '화', '수', '목', '금', '토', '일'] //x축 기준

const data: ChartData<'line', number[]> = {
  labels,
  datasets: [
    {
      label: '지난 주',
      data: [4, 3, 3, 1, 7, 6, 3],
      borderColor: '#F6C4E8',
      cubicInterpolationMode: 'monotone',
      pointBackgroundColor: '#F162CA',
      pointBorderColor: '#F162CA',
      pointRadius: 5,
    },
    {
      label: '이번 주',
      data: [3, 2, 2, 1, 6, 5, 2],
      borderColor: '#DAD8FF',
      cubicInterpolationMode: 'monotone',
      pointBackgroundColor: '#4F46F2',
      pointBorderColor: '#4F46F2',
      pointRadius: 5,
    },
  ],
}

export default function ReportWeekLineChart() {
  return (
    <div className="md:p-3 lg:xl-11 lg:xl-6 bg-white rounded-2xl w-full h-full">
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
