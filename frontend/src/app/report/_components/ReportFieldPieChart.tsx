'use client'

import {
  Chart as ChartJS,
  ChartData,
  ChartOptions,
  PieController,
  ArcElement,
  Title,
  Tooltip,
  Legend,
} from 'chart.js';
import { Pie } from 'react-chartjs-2';

ChartJS.register(
  PieController,
  ArcElement,
  Title,
  Tooltip,
  Legend
);

const options:ChartOptions<'pie'> = {
  responsive: true,
  plugins: {
    legend: {
      display:false,
      position: 'top' as const,
      align: 'start' as const,
      labels: {
        padding:20,
        boxWidth: 1,
        boxHeight:10,
        color: '#000',
        font: {
          family: 'Noto Sans KR',
          lineHeight: 2,
        },
        usePointStyle: true,
        pointStyle: 'rectRounded',
        pointStyleWidth: 30,
        useBorderRadius: true,
        borderRadius:0
      }
    },
    tooltip:{

    },
    title: {
      display: false,
      text: 'Chart.js Line Chart',
    },
  },
};

const labels = ['월', '화', '수']; //x축 기준

const data:ChartData <'pie', number[]> = {
  labels,
  datasets: [
    {
      label: '지난 주', //그래프 분류되는 항목
      data: [4, 3, 3], //실제 그려지는 데이터(Y축 숫자)
      borderColor: '#F6C4E8', //그래프 선 color
      // backgroundColor: 'rgba(255, 99, 132, 0.5)', //마우스 호버시 나타나는 분류네모 표시 bg
    }
  ],
};

export default function ReportFieldPieChart() {
  return (
    <div className='contentWrap'>
      <div className='flex'>
        <div className='inline-flex items-center mr-8'>
          <div className='w-[3rem] h-[1rem] mr-1.5 bg-pink-400 rounded-2xl my-auto'/>
          <p className='text-primary-400 text-pink-400'>
            7/8 ~ 7/14
          </p>
        </div>
        <div className='inline-flex items-center'>
          <div className='w-[3rem] h-[1rem] mr-1.5 bg-primary-400 rounded-2xl my-auto'/>
          <p className='text-primary-400'>
            7/15 ~ 7/21
          </p>
        </div>
      </div>
      <div className='w-full'>
        <Pie options={options} data={data} />
      </div>
    </div>
  );
}