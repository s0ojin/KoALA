import Image from 'next/image'

interface LectureNoteList {
  noteId: number
  noteTitle: string
  noteContent: string
  noteCreatedAt: string
}

export default function LectureNoteBookmark({
  noteId,
  noteTitle,
  noteContent,
  noteCreatedAt,
}: LectureNoteList) {
  return (
    <div className="w-full flex flex-col gap-2 ">
      <div className="flex gap-1 items-center px-5">
        <Image
          src="/icons/play.svg"
          width={0}
          height={0}
          alt="teacher"
          sizes="100%"
          className="w-5 h-5"
        />
        <p className="text-sm text-primary-900 font-normal">{noteCreatedAt}</p>
      </div>
      <div className="flex flex-col items-start bg-gray-100 rounded-[2rem] py-5 px-7 gap-3 text-gray-900">
        <h3>{noteTitle}</h3>
        <div className="whitespace-pre-line">{noteContent}</div>
      </div>
    </div>
  )
}
