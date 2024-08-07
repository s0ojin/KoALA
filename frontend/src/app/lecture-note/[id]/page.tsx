import LectureNoteLayout from '@/app/lecture-note/_components/LectureNoteLayout'
import LectureNoteBookmark from '../_components/LectureNoteBookmark'
import Image from 'next/image'

const lectureNoteList = [
  {
    note_id: 1,
    note_title: '노트 제목',
    note_content: '노트 내용',
    note_created_at: '2024-07-17',
  },
  {
    note_id: 2,
    note_title: '노트 제목',
    note_content: '노트 내용',
    note_created_at: '2024-07-17',
  },
  {
    note_id: 3,
    note_title: '노트 제목',
    note_content: '노트 내용',
    note_created_at: '2024-07-17',
  },
]

export default function LectureNoteDetail() {
  return (
    <LectureNoteLayout>
      <div className="flex flex-col items-center gap-6 h-full pt-20">
        <div className="flex items-center pl-3 max-w-[65rem] w-full gap-2">
          <Image
            src="/icons/arrow-right-circle.svg"
            width={0}
            height={0}
            alt="teacher"
            sizes="100%"
            className="w-5 h-5"
          />
          <p className="text-gray-500 text-xl font-normal">
            강의노트 리스트로 가기
          </p>
        </div>

        <div className="h-auto bg-white pt-12 pb-36 px-16 w-full max-w-[65rem] rounded-t-[4rem] flex-grow">
          <div className="flex flex-col gap-1 items-center pb-10  border-b-[1px] border-gray-900">
            <h1 className="text-gray-900 text-3xl font-medium">
              식당에 방문 했을 때 II
            </h1>
            <h3 className="text-gray-900 text-lg font-normal">고동연선생님</h3>
          </div>

          <div className="mt-14 flex flex-col gap-8">
            {lectureNoteList.map((lectureNote) => {
              return (
                <LectureNoteBookmark
                  key={lectureNote.note_id}
                  noteId={lectureNote.note_id}
                  noteTitle={lectureNote.note_title}
                  noteContent={lectureNote.note_content}
                  noteCreatedAt={lectureNote.note_created_at}
                />
              )
            })}
          </div>
        </div>
      </div>
    </LectureNoteLayout>
  )
}
