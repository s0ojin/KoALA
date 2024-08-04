import ReportLayout from "@/app/report/_components/ReportLayout"
import ReportWeekChart from "@/app/report/_components/ReportWeekChart"

export default function ReportMain () {
  return (
    <ReportLayout>
      <div className="relative bg-white w-[80%] h-auto min-h-main-height mx-auto mt-11 p-8 z-10 rounded-2xl">
        <ReportWeekChart />
      </div>
    </ReportLayout>
  )
}
