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
} from 'chart.js';
import { Line } from 'react-chartjs-2';

ChartJS.register(
  CategoryScale,
  LinearScale,
  LineController,
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);

const options:ChartOptions<'line'> = {
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
  },
  scales:{
    y: {
      beginAtZero: true
    }
  }
};

const labels = ['월', '화', '수', '목', '금', '토', '일']; //x축 기준

const data:ChartData <'line', number[]> = {
  labels,
  datasets: [
    {
      label: '지난 주', //그래프 분류되는 항목
      data: [4, 3, 3, 1, 7, 6, 3], //실제 그려지는 데이터(Y축 숫자)
      borderColor: '#F6C4E8', //그래프 선 color
      // backgroundColor: 'rgba(255, 99, 132, 0.5)', //마우스 호버시 나타나는 분류네모 표시 bg
      cubicInterpolationMode: 'monotone',
      pointBackgroundColor:'#F162CA',
      pointBorderColor:'#F162CA',
      pointRadius: 5,
    },
    {
      label: '이번 주',
      data: [3, 2, 2, 1, 6, 5, 2],
      borderColor: '#DAD8FF', //실제 그려지는 데이터(Y축 숫자)
      // backgroundColor: 'rgba(53, 162, 235, 0.5)',
      cubicInterpolationMode: 'monotone',
      pointBackgroundColor:'#4F46F2',
      pointBorderColor:'#4F46F2',
      pointRadius: 5,
    },
  ],
};

export default function ReportWeekLineChart() {
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
        <Line options={options} data={data} />
      </div>
    </div>
  );
}