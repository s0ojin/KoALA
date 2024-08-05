'use client'

import React from 'react'
import { useForm } from 'react-hook-form'
import CommunityImageUploader from '@/app/community/_components/CommunityImageUploader'

export default function CommunityPostEditor() {
  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({ mode: 'onChange' })

  const onSubmit = (data: any) => {
    console.log(data)
  }

  return (
    <form
      onSubmit={handleSubmit(onSubmit)}
      className=" flex flex-col gap-4 w-[65rem]"
    >
      <div className="flex flex-col px-20 py-12 bg-white w-full max-w-[65rem] h-[40rem] rounded-[4rem]">
        <input
          type="text"
          className={`text-2xl pb-3 border-b 'border-gray-300 outline-none`}
          placeholder="제목을 입력하세요"
          {...register('title', { required: true })}
        />

        <textarea
          className="h-full resize-none mt-9 text-gray-900 text-base outline-none"
          placeholder="내용을 입력하세요"
          {...register('content', { required: true })}
        />
      </div>

      <div className="flex items-start justify-between px-11">
        <CommunityImageUploader />
        <button
          type="submit"
          className="bg-primary-400 py-2 px-12 text-white rounded-full whitespace-nowrap"
        >
          저장
        </button>
      </div>
    </form>
  )
}
