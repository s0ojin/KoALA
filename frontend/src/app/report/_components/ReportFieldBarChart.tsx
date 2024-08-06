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

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarController,
  BarElement,
  Title,
  Tooltip,
  Legend
)

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
      listeners:{
        enter: function(context) {
          context.hovered = true

          return true
        },
        leave: function(context) {
          context.hovered = false;
          return true;
        }
      },
      color: function (context) {
        return context.hovered ? 'white' : context.dataset.backgroundColor
      },
      display: function (context) {
        return context.dataset.data[context.dataIndex] > 1
      }
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
      data: [4, 3, 3, 1, 7, 6, 3],
      backgroundColor: '#4F46F2',
    },
    {
      label: 'AI회화',
      data: [4, 3, 3, 1, 7, 6, 3],
      backgroundColor: '#7A72FF',
    },
    {
      label: '강의',
      data: [4, 3, 3, 1, 7, 6, 3],
      backgroundColor: '#C7C4FF',
    },
  ],
}

export default function ReportFieldBarChart() {
  return (
    <div className="px-11 py-6 bg-white rounded-2xl w-full h-full">
      <div className="flex justify-between mb-8">
        <p className="text-primary-400 ml-8">7/15 ~ 7/21</p>
        <div>
          <div className="inline-flex items-center mr-8">
            <div className="w-[3rem] h-[1rem] mr-1.5 bg-primary-400 rounded-2xl my-auto" />
            <p className="text-primary-400 text-pink-400">받아쓰기</p>
          </div>
          <div className="inline-flex items-center mr-8">
            <div className="w-[3rem] h-[1rem] mr-1.5 bg-primary-300 rounded-2xl my-auto" />
            <p className="text-primary-300">AI회화</p>
          </div>
          <div className="inline-flex items-center">
            <div className="w-[3rem] h-[1rem] mr-1.5 bg-primary-100 rounded-2xl my-auto" />
            <p className="text-primary-100">강의</p>
          </div>
        </div>
      </div>
      <div>
        <Bar options={options} data={data} plugins={[ChartDataLabels]} />
      </div>
    </div>
  )
}
