import OnlineLearningLectureNoteCard from './OnlineLearningLectureNoteCard'
import OnlineLearningLectureNoteInput from './OnlineLearningLectureNoteInput'

export default function OnlineLearningLectureNotePanel() {
  return (
    <div className="h-full flex flex-col justify-between ">
      <OnlineLearningLectureNoteCard />
      <OnlineLearningLectureNoteInput />
    </div>
  )
}
