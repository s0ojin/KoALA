'use client'

import { useForm } from 'react-hook-form'
import NoteAddBtn from '/public/icons/simple-edit.svg'

export default function OnlineLearningLectureNoteInput() {
  const { register, handleSubmit } = useForm()

  const onSubmit = (data: any) => {
    console.log(
      'api연결 후 삭제될거지만 필요해서 console찍어놨어요 ㅠ이건 지우면 안되어요...',
      data
    )
  }

  return (
    <form
      onSubmit={handleSubmit(onSubmit)}
      className="w-full h-36 p-5 rounded-3xl bg-gray-100 flex"
    >
      <div className="flex flex-col flex-1">
        <input
          type="text"
          {...register('title')}
          placeholder="제목"
          className="bg-transparent text-xl font-medium outline-none text-gray-900"
        />
        <textarea
          {...register('content')}
          placeholder="강의 내용을 메모해보세요!"
          className="bg-transparent flex-1 w-full outline-none text-gray-900 resize-none"
        />
      </div>
      <button type="submit" className="text-gray-400 w-6 self-end">
        <NoteAddBtn />
      </button>
    </form>
  )
}
