'use client'

import Play from '/public/icons/play.svg'
import Pause from '/public/icons/pause.svg'
import { useState } from 'react'

interface SentenceProps {
  sentence: any
  isSelected: boolean
  OnSentenceSelect: (sentence_id:number) => void
}

export default function ReviewAreaSentence({ sentence, isSelected, OnSentenceSelect }: SentenceProps) {
  
  const [isPlaying, setPlaying] = useState<Boolean>(false)

  const handleChangeSelected = () => {
    OnSentenceSelect(sentence.review_sentence_id)
  }

  const handlePlaying = () => {
    setPlaying((isPlaying) => !isPlaying)
  }

  return (
    <div
      className={`flex items-center w-full rounded-full px-5 ${isSelected ? 'bg-primary-400' : 'bg-gray-200'}`}
    >
      <p
        onClick={handleChangeSelected}
        className={`h-full grow py-4 ${isSelected ? 'text-white' : ''}`}
      >
        {sentence.sentence_text}
      </p>
      <button onClick={handlePlaying}>
        {isPlaying ? (
          <Pause fill={`${isSelected ? 'white' : ''}`} />
        ) : (
          <Play fill={`${isSelected ? 'white' : ''}`} />
        )}
      </button>
    </div>
  )
}
