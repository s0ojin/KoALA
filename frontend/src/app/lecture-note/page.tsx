import LectureNoteElement from './_components/LectureNoteElement'
import LectureNoteLayout from './_components/LectureNoteLayout'

const lectureNoteList = [
  {
    lecture_id: 1,
    teacher_name: '김성현 선생님',
    lecture_title: '한글의 이해',
    note_counts: 23,
  },
  {
    lecture_id: 2,
    teacher_name: '김성현 선생님',
    lecture_title: '한글의 이해',
    note_counts: 20,
  },
  {
    lecture_id: 3,
    teacher_name: '김성현 선생님',
    lecture_title: '한글의 이해',
    note_counts: 5,
  },
  {
    lecture_id: 4,
    teacher_name: '김성현 선생님',
    lecture_title: '한글의 이해',
    note_counts: 58,
  },
]

export default function LectureNoteMain() {
  return (
    <LectureNoteLayout>
      <div className="flex flex-col items-center gap-7 h-full pt-20">
        <h1 className="text-3xl font-medium text-primary-900">강의 노트</h1>
        <div className="h-auto bg-white pt-10 pb-36 px-16 w-full max-w-[65rem] rounded-t-[4rem] flex-grow">
          {lectureNoteList.map((lectureNote) => {
            return (
              <LectureNoteElement
                key={lectureNote.lecture_id}
                lectureId={lectureNote.lecture_id}
                teacherName={lectureNote.teacher_name}
                lectureTitle={lectureNote.lecture_title}
                lectureNoteCounts={lectureNote.note_counts}
              />
            )
          })}
        </div>
      </div>
    </LectureNoteLayout>
  )
}
