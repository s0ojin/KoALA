'use client'

import Play from '/public/icons/play.svg'
import Pause from '/public/icons/pause.svg'
import { useEffect, useState } from 'react'
import { SentenceContent } from '@/app/apis/review'
import { getWebSpeech, stopWebSpeech } from '@/app/apis/ttsSententce'
import { getSpeech } from '@/app/apis/googleSentence'

interface SentenceProps {
  sentence: SentenceContent
  isSelected: boolean
  isNowPlaying: boolean
  OnSentenceSelect: (sentence_id: number) => void
}

export default function ReviewAreaSentence({
  sentence,
  isSelected,
  isNowPlaying,
  OnSentenceSelect,
}: SentenceProps) {
  const [isPlaying, setPlaying] = useState<Boolean>(false)

  const handleChangeSelected = () => {
    OnSentenceSelect(sentence.review_sentence_id)
  }
  
  const handlePlaying = async () => {
    if (isPlaying) {
      setPlaying(isPlaying => false)
      stopWebSpeech()
    } else {
      // getWebSpeech(sentence.sentence_text, () => setPlaying(true), () => setPlaying(false))
      getSpeech(sentence.sentence_text)
    }
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
        {isPlaying || isNowPlaying ? (
          <Pause fill={`${isSelected ? 'white' : ''}`} />
        ) : (
          <Play fill={`${isSelected ? 'white' : ''}`} />
        )}
      </button>
    </div>
  )
}
