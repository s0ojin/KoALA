'use client'

import Play from '/public/icons/play.svg'
import Pause from '/public/icons/pause.svg'
import { useState } from 'react'

export default function Sentence() {
  const [isSelected, setSelected] = useState<Boolean>(false)
  const [isPlaying, setPlaying] = useState<Boolean>(false)

  const handleChangeSelected = () => {
    setSelected((isSelected) => !isSelected)
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
        안녕? 나는 이주형이라고 해 안녕? 나는 이주형이라고 해 안녕? 나는
        이주형이라고 해
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
