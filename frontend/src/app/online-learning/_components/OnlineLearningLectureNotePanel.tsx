import OnlineLearningLectureNoteCard from './OnlineLearningLectureNoteCard'
import OnlineLearningLectureNoteInput from './OnlineLearningLectureNoteInput'

const dummy = [
  { id: 1, title: '제목이고', content: '내용임다' },
  { id: 2, title: '제목이고', content: '내용임다' },
  { id: 2, title: '제목이고', content: '내용임다' },
  { id: 2, title: '제목이고', content: '내용임다' },
  { id: 2, title: '제목이고', content: '내용임다' },
  { id: 2, title: '제목이고', content: '내용임다' },
]

export default function OnlineLearningLectureNotePanel() {
  return (
    <div className="h-full flex flex-col gap-2 justify-between">
      <div className="overflow-scroll">
        <div className="flex flex-col gap-3 pr-3">
          {dummy.map((note) => (
            <OnlineLearningLectureNoteCard
              key={note.id}
              noteTitle={note.title}
              noteContent={note.content}
            />
          ))}
        </div>
      </div>
      <div className="flex-1">
        <OnlineLearningLectureNoteInput />
      </div>
    </div>
  )
}
