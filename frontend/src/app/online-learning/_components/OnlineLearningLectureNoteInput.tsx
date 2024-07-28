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
      className="w-full h-32 p-5 rounded-3xl bg-gray-100 flex flex-col gap-2"
    >
      <input
        type="text"
        {...register('title')}
        placeholder="제목"
        className="bg-transparent text-xl font-medium outline-none text-gray-900"
      />
      <input
        type="text"
        {...register('content')}
        placeholder="강의 내용을 메모해보세요!"
        className="bg-transparent outline-none text-gray-900"
      />
      <button type="submit" className="text-gray-400 w-6 self-end">
        <NoteAddBtn />
      </button>
    </form>
  )
}
