'use client'

import Play from '/public/icons/play.svg'
import Pause from '/public/icons/pause.svg'
import { useEffect, useState } from 'react'
import { SentenceContent } from '@/app/apis/review'
import { getWebSpeech, stopWebSpeech, getGoogleSpeech } from '@/app/apis/ttsSententce'

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
  let source:AudioBufferSourceNode
  
  const handleChangeSelected = () => {
    OnSentenceSelect(sentence.review_sentence_id)
  }
  
  const handlePlaying = async () => {
    const audioContext = new window.AudioContext()
    const arraybuff = await getGoogleSpeech(sentence.sentence_text)
    const audiobuff = await audioContext.decodeAudioData(arraybuff)
    source = await audioContext.createBufferSource()
    source.buffer = audiobuff
    await source.connect(audioContext.destination)
    source.start()
    await setPlaying(true)
    source.onended = () => setPlaying(false)
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
