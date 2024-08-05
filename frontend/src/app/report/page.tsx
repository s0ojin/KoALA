import ReportLayout from '@/app/report/_components/ReportLayout'
import ReportWeekLineChart from '@/app/report/_components/ReportWeekLineChart'
import ReportFieldBarChart from '@/app/report/_components/ReportFieldBarChart'
import ReportFieldPieChart from '@/app/report/_components/ReportFieldPieChart'

export default function ReportMain() {
  return (
    <ReportLayout>
      <div className="relative bg-white w-[80%] h-auto min-h-main-height mx-auto mt-11 p-8 z-10 rounded-2xl">
        <ReportWeekLineChart />
        <ReportFieldBarChart />
        <ReportFieldPieChart />
      </div>
    </ReportLayout>
  )
}
