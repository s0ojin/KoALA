'use client'

import SentenceAddCard from '@/app/_components/SentenceAddCard'
import UploadIcon from '/public/icons/cloud-upload.svg'
import { useState } from 'react'

const dummy = [
  {
    sentence_id: 33,
    sentence_text:
      '선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
  {
    sentence_id: 33,
    sentence_text: '선생님이 제공하는 개쩌는 문장',
  },
]

export default function AddSentenceModal() {
  const [status, setStatus] = useState('initial')

  return (
    <div className="bg-white max-w-[60rem] min-w-80 max-h-[44rem] rounded-3xl p-12 flex flex-col">
      {status === 'initial' ? (
        <div className="bg-primary-400 rounded-full py-4 px-6 text-center text-white mx-auto flex gap-3 items-center shadow-md">
          <UploadIcon className="w-8" />
          추가할 문장을 업로드 해주세요.
        </div>
      ) : status === 'loading' ? (
        <div>분석중입니다....</div>
      ) : (
        <>
          <h1 className="text-2xl text-gray-900">
            학습을 원하는 문장을 추가해주세요.
          </h1>
          <hr className="w-full my-4" />
          <div className="h-full overflow-auto">
            <ul className="flex flex-col gap-3 pr-3">
              {dummy.map((sentence) => (
                <SentenceAddCard
                  key={sentence.sentence_id}
                  sentenceId={sentence.sentence_id}
                  sentence={sentence.sentence_text}
                />
              ))}
            </ul>
          </div>
        </>
      )}
    </div>
  )
}
