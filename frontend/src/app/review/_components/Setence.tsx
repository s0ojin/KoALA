'use client'

import Image from 'next/image'
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
      className={`flex items-center w-full min-h-[4rem] max-h-[8rem] rounded-[4.5rem] mb-[0.75rem] px-[1.25rem] ${isSelected ? 'bg-primary-400' : 'bg-gray-200'}`}
    >
      <p
        onClick={handleChangeSelected}
        className={`h-full grow pr-[1rem] py-[1.25rem] ${isSelected ? 'text-white' : ''}`}
      >
        안녕? 나는 이주형이라고 해 안녕? 나는 이주형이라고 해 안녕? 나는
        이주형이라고 해rrrrrrrrrrrrrrrrrrrrrrrrrfasdfasdfasdfsdafasdf
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
