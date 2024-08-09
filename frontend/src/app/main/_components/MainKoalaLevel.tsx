export default function MainKoalaLevel({
  percent = 0,
  level = 1,
}: {
  percent: number
  level: number
}) {
  return (
    <div className="w-full flex flex-col justify-center gap-3">
      <div className="text-white w-full flex justify-between items-end">
        <p className="transform -translate-x-3 text-xl font-semibold">
          Lv.{level}
        </p>
        <p className="transform translate-x-3 text-3xl font-black">
          Lv.{level + 1}
        </p>
      </div>
      <div className="w-full bg-white rounded-full h-5 dark:bg-gray-700 overflow-hidden">
        <div
          className="bg-[#FFA3E6] h-5 rounded-full"
          style={{ width: `${percent}%` }}
        ></div>
      </div>
      <div className="text-white w-full flex justify-between">
        <p className="transform -translate-x-9 text-base">애기코알라</p>
        <p className="transform translate-x-9 font-black text-xl">졸업코알라</p>
      </div>
    </div>
  )
}
