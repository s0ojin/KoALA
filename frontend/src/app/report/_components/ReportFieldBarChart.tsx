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
import ChartDataLabels from 'chartjs-plugin-datalabels';

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
    datalabels: {
      listeners : {
        enter: function(context, event) {
          // console.log(context.dataset.data[context.dataIndex])
          console.log(context)
          context.active = true
          return true
        },
        leave: function(context, event) {
          // console.log(context.dataset.data[context.dataIndex])
          console.log(context)
          context.active = false
          return false
        }
      }
    }
  },
  scales: {
    x:{
      stacked: true
    },
    y: {
      beginAtZero: true,
      stacked: true
    },
  },
}

const data: ChartData<'bar', number[]> = {
  labels: ['월', '화', '수', '목', '금', '토', '일'] ,
  datasets: [
    {
      label: '받아쓰기', //그래프 분류되는 항목
      data: [4, 3, 3, 1, 7, 6, 3], //실제 그려지는 데이터(Y축 숫자)
      backgroundColor: '#4F46F2', //마우스 호버시 나타나는 분류네모 표시 bg
    },
    {
      label: 'AI회화', //그래프 분류되는 항목
      data: [4, 3, 3, 1, 7, 6, 3], //실제 그려지는 데이터(Y축 숫자)
      backgroundColor: '#7A72FF', //마우스 호버시 나타나는 분류네모 표시 bg
    },
    {
      label: '강의', //그래프 분류되는 항목
      data: [4, 3, 3, 1, 7, 6, 3], //실제 그려지는 데이터(Y축 숫자)
      backgroundColor: '#C7C4FF', //마우스 호버시 나타나는 분류네모 표시 bg
    },
  ],
}

export default function ReportFieldBarChart() {
  
  return (
    <div className="contentWrap">
      <div className="flex">
        <div className="inline-flex items-center mr-8">
          <div className="w-[3rem] h-[1rem] mr-1.5 bg-pink-400 rounded-2xl my-auto" />
          <p className="text-primary-400 text-pink-400">7/8 ~ 7/14</p>
        </div>
        <div className="inline-flex items-center">
          <div className="w-[3rem] h-[1rem] mr-1.5 bg-primary-400 rounded-2xl my-auto" />
          <p className="text-primary-400">7/15 ~ 7/21</p>
        </div>
      </div>
      <div className="w-full">
        <Bar options={options} data={data} plugins={[ChartDataLabels]}/>
      </div>
    </div>
  )
}
