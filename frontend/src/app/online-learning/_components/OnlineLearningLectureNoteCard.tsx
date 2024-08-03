import RemoveBtn from '/public/icons/cancel-btn.svg'

interface OnlineLearningLectureNoteCardProps {
  noteTitle: string
  noteContent: string
}

export default function OnlineLearningLectureNoteCard({
  noteTitle,
  noteContent,
}: OnlineLearningLectureNoteCardProps) {
  return (
    <div className="w-full p-5 rounded-3xl bg-primary-400 text-white">
      <div className="flex justify-between">
        <h1 className="text-xl font-medium">{noteTitle}</h1>
        <RemoveBtn width="16" height="16" />
      </div>
      <p>{noteContent}</p>
    </div>
  )
}
