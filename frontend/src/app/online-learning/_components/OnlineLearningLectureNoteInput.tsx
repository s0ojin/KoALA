'use client'

import { useForm } from 'react-hook-form'
import NoteAddBtn from '/public/icons/simple-edit.svg'

export default function OnlineLearningLectureNoteInput() {
  const { register, handleSubmit } = useForm()

  const onSubmit = (data) => {
    console.log(data)
  }

  return (
    <form
      onSubmit={handleSubmit(onSubmit)}
      className="w-full h-36 p-5 rounded-3xl bg-gray-100 flex gap-1"
    >
      <div>
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
      <button type="submit" className="text-gray-400 w-8 self-end">
        <NoteAddBtn />
      </button>
    </form>
  )
}
