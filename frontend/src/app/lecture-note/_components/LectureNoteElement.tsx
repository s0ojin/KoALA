import Image from 'next/image'

interface LectureNoteListElement {
  lectureId: number
  teacherName: string
  lectureTitle: string
  lectureNoteCounts: number
}

export default function LectureNoteElement({
  lectureId,
  teacherName,
  lectureTitle,
  lectureNoteCounts,
}: LectureNoteListElement) {
  return (
    <div className="border-b-[1px] border-gray-200 bg-white w-full flex py-5 px-8 items-center">
      <div className="flex flex-col w-full gap-2">
        <p className="text-xl font-medium">{lectureTitle}</p>
        <div className="flex items-center gap-3 text-base text-primary-900">
          <p>노트수 {lectureNoteCounts}개</p>
          <hr className="w-[1px] bg-primary-900 h-3" />
          <p>{teacherName}</p>
        </div>
      </div>
      <Image
        src="/images/koala-sleep.png"
        width={0}
        height={0}
        alt="teacher"
        sizes="100%"
        className="w-40 h-20 border rounded-lg"
      />
    </div>
  )
}
