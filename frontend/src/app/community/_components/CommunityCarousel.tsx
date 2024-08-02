'use client'

import { useState } from 'react'
import { motion } from 'framer-motion'
import Image from 'next/image'
import LeftButton from '/public/icons/left-circle-button.svg'
import RightButton from '/public/icons/right-circle-button.svg'

const slides = [
  '/images/koala-sleep.png',
  '/images/koala-sleep.png',
  '/images/koala-sleep.png',
]

export default function CommunityCarousel() {
  const [currentSlide, setCurrentSlide] = useState(0)

  const nextSlide = () => {
    setCurrentSlide((prevSlide) => (prevSlide + 1) % slides.length)
  }

  const prevSlide = () => {
    setCurrentSlide(
      (prevSlide) => (prevSlide - 1 + slides.length) % slides.length
    )
  }

  return (
    <div className="flex-col w-full flex gap-2 justify-center pt-14 pb-9 overflow-hidden">
      <div className="">
        <motion.div
          initial={{ x: 200 }}
          animate={{ x: 200 + -currentSlide * 500 }}
          transition={{ stiffness: 0 }}
          className="flex gap-10 w-full"
        >
          {slides.map((src, index) => {
            return (
              <Image
                src={src}
                width={0}
                height={0}
                sizes="100%"
                className={`w-[460px] h-[460px] aspect-square border border-gray-200 rounded-2xl ${index === currentSlide ? '' : 'opacity-30'}`}
                alt="profile"
                key={index}
              />
            )
          })}
        </motion.div>
        <button
          onClick={prevSlide}
          className="absolute left-[140px] top-1/2 rounded-full"
        >
          <LeftButton />
        </button>
        <button
          onClick={nextSlide}
          className="absolute right-[140px] top-1/2 rounded-full"
        >
          <RightButton />
        </button>
      </div>
      <div className="flex gap-2 justify-center">
        {new Array(3).fill(0).map((_, index) => {
          return (
            <span
              key={index}
              className={` w-3 h-3 flex cursor-pointer rounded-full
              ${currentSlide === index ? 'bg-blue-300' : 'bg-gray-300'}
                `}
              onClick={() => {
                setCurrentSlide(index)
              }}
            ></span>
          )
        })}
      </div>
    </div>
  )
}
