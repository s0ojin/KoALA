'use client'

import React from 'react'
import { useForm, FormProvider } from 'react-hook-form'
import AutoResizeTextarea from '@/app/_components/AutoResizeTextarea'

export default function CommunityCommentInput() {
  const methods = useForm()

  return (
    <FormProvider {...methods}>
      <form className="p-6 gap-3 w-full flex flex-col border border-gray-400 rounded-2xl overflow-hidden">
        <AutoResizeTextarea
          fieldName={'test'}
          placeholder={'댓글을 입력해주세요'}
          className={'text-base font-normal text-gray-700'}
        />
        <button
          type="submit"
          className="p-0 inline-block self-end text-base text-gray-500 font-normal"
        >
          등록
        </button>
      </form>
    </FormProvider>
  )
}
