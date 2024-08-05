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
import ChartDataLabels from 'chartjs-plugin-datalabels';
import { Context } from 'chartjs-plugin-datalabels';

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
    },
    datalabels:{
      display: (context:Context) => {
        return context.dataset.data[context.dataIndex] > 0;
      },
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
    },
  }
}

const labels = ['받아쓰기', 'AI회화', '강의']; //x축 기준

const data:ChartData <'pie', number[]> = {
  labels,
  datasets: [
    {
      label: '총합', //그래프 분류되는 항목
      data: [4, 3, 3], //실제 그려지는 데이터(Y축 숫자)
      backgroundColor: [
        'rgb(255, 99, 132)',
        'rgb(54, 162, 235)',
        'rgb(255, 205, 86)'
      ],
    }
  ],
};

export default function ReportFieldPieChart() {
  return (
    <div className='contentWrap'>
      <div className='w-[12rem]'>
        <Pie options={options} data={data} />
      </div>
    </div>
  );
}