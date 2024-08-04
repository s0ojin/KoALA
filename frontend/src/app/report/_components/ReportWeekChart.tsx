'use client'

import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
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
  PointElement,
  LineElement,
  Title,
  Tooltip,
  Legend
);
export const options = {
  responsive: true,
  plugins: {
    legend: {
      position: 'top' as const,
      align: 'start' as const,
      labels: {
        padding:0,
        boxWidth: 51,
        color: '#000',
        font: {
          family: 'Noto Sans KR',
          lineHeight: 2,
        },
      }
    },
    tooltip:{
      reverse: true
    },
    title: {
      display: false,
      text: 'Chart.js Line Chart',
    },
  },
};

const labels = ['월', '화', '수', '목', '금', '토', '일']; //x축 기준

export const data = {
  labels,
  datasets: [
    {
      label: '지난 주', //그래프 분류되는 항목
      data: [1, 2, 3, 4, 5, 6, 7], //실제 그려지는 데이터(Y축 숫자)
      borderColor: '#F162CA', //그래프 선 color
      backgroundColor: 'rgba(255, 99, 132, 0.5)', //마우스 호버시 나타나는 분류네모 표시 bg
      cubicInterpolationMode: 'monotone',
      pointStyle: 'circle',
      pointBackgroundColor:'#F162CA',
      pointRadius: 5,
      pointHoverRadius: 7,
      borderWidth:5,
      borderCapStyle:'round',
    },
    {
      label: '이번 주',
      data: [2, 3, 4, 5, 4, 7, 8],
      borderColor: '#4F46F2', //실제 그려지는 데이터(Y축 숫자)
      backgroundColor: 'rgba(53, 162, 235, 0.5)',
      cubicInterpolationMode: 'monotone',
      pointStyle: 'circle',
      pointRadius: 5,
      pointHoverRadius: 15,
      borderWidth:5,
      borderCapStyle:'round',
      // borderDash:[160,10],
      borderDashOffset:1,
      borderJoinStyle:'round',
    },
  ],
};

export default function ReportWeekChart() {
  return (
    <div className='contentWrap'>
      <div className='contentInner'>
        <Line options={options} data={data} />
      </div>
    </div>
  );
}