'use client'

import Image from 'next/image'
import { useState } from 'react'
import { motion } from 'framer-motion'

const SCALE_FACTOR = 0.3
const TOP_OFFSET = 20

interface MainEucalyptusButtonProps {
  eucalyptusCount: number
}

export default function MainEucalyptusButton({
  eucalyptusCount = 0,
}: MainEucalyptusButtonProps) {
  const [eucalyptus, setEucalyptusCount] = useState(eucalyptusCount)
  const [isAnimate, setIsAnimate] = useState(false)
  const [isPressed, setIsPressed] = useState(false)

  const handleClickEucalyptusButton = () => {
    if (eucalyptus <= 0) return
    setIsAnimate(true)
    setEucalyptusCount((eucalyptus) => eucalyptus - 1)
  }

  return (
    <div className="inline-block relative w-auto">
      <div className="relative flex justify-center">
        {new Array(5).fill(0).map((_, index) => {
          return (
            <motion.p
              key={`${eucalyptus}`}
              className={`absolute z-10 ${isAnimate ? 'block' : 'hidden'}  pointer-events-none`}
              animate={
                isAnimate
                  ? {
                      top: -50 + index * -TOP_OFFSET,
                      scale: 2 - index * SCALE_FACTOR,
                      left: index % 2 === 0 ? 40 : 'none',
                      right: index % 2 === 1 ? 10 : 'none',
                      opacity: 0,
                    }
                  : {}
              }
              transition={{ duration: 1.5 }}
            >
              <Image
                src="/images/eucalyptus.png"
                width={0}
                height={0}
                sizes="100%"
                className="w-[3rem] h-[3rem]"
                alt="eucalyptus"
                draggable="false"
              />
            </motion.p>
          )
        })}
      </div>
      <button
        className={`bg-[#FFF8DA] w-24 h-24 rounded-full shadow-lg cursor-pointer transition-transform duration-200 ease-in-out ${isPressed ? 'transform scale-95 shadow-inner' : ''}`}
        onClick={handleClickEucalyptusButton}
        onMouseDown={() => {
          if (eucalyptus <= 0) return
          setIsPressed(true)
        }}
        onMouseUp={() => setIsPressed(false)}
        onMouseLeave={() => setIsPressed(false)}
      >
        <Image
          src="/images/eucalyptus.png"
          width={0}
          height={0}
          sizes="100%"
          className="w-full h-full rounded-full"
          alt="eucalyptus"
          draggable="false"
        />
      </button>
      <span className="select-none cursor-pointer absolute -right-2 top-0 bg-[#FF7A7A] text-white text-sm h-8 aspect-square rounded-full flex justify-center items-center font-bold z-0">
        {eucalyptus}
      </span>
    </div>
  )
}
