import RemoveBtn from '/public/icons/cancel-btn.svg'

export default function OnlineLearningLectureNoteCard() {
  return (
    <div className="w-full h-32 p-5 rounded-3xl bg-primary-400 text-white">
      <div className="flex justify-between">
        <h1 className="text-xl font-medium">제목</h1>
        <RemoveBtn width="16" height="16" />
      </div>
      <p>강의 내용의 메모합니다</p>
    </div>
  )
}
