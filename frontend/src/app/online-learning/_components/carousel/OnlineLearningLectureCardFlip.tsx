'use client'

import { motion, useSpring } from 'framer-motion'
import React, { useState, useRef, useEffect } from 'react'
import OnlineLearningLectureCard from '@/app/online-learning/_components/carousel/OnlineLearningLectureCard'
import { LectureCard } from '@/app/apis/online-learning'

const spring = {
  type: 'spring',
  stiffness: 300,
  damping: 40,
}

export default function OnlineLearningLectureCardFlip({
  ...cardData
}: LectureCard) {
  const [isFlipped, setIsFlipped] = useState(false)

  const handleClick = () => {
    setIsFlipped((prevState) => !prevState)
  }

  const [rotateXaxis, setRotateXaxis] = useState(0)
  const [rotateYaxis, setRotateYaxis] = useState(0)
  const ref = useRef(null)

  const handleMouseMove = (event: React.MouseEvent<HTMLElement>) => {
    const element = ref.current
    const elementRect = (element as any).getBoundingClientRect()
    const elementWidth = elementRect.width
    const elementHeight = elementRect.height
    const elementCenterX = elementWidth / 2
    const elementCenterY = elementHeight / 2
    const mouseX = event.clientY - elementRect.y - elementCenterY
    const mouseY = event.clientX - elementRect.x - elementCenterX
    const degreeX = (mouseX / elementWidth) * 20
    const degreeY = (mouseY / elementHeight) * 20
    setRotateXaxis(degreeX)
    setRotateYaxis(degreeY)
  }

  const handleMouseEnd = () => {
    setRotateXaxis(0)
    setRotateYaxis(0)
  }

  const dx = useSpring(0, spring)
  const dy = useSpring(0, spring)

  useEffect(() => {
    dx.set(-rotateXaxis)
    dy.set(rotateYaxis)
  }, [dx, dy, rotateXaxis, rotateYaxis])

  return (
    <motion.div
      className="max-w-[20rem] min-w-[10rem] aspect-[5/7]"
      onClick={handleClick}
      transition={spring}
      style={{
        perspective: '1200px',
        transformStyle: 'preserve-3d',
      }}
    >
      <motion.div
        ref={ref}
        onMouseMove={handleMouseMove}
        onMouseLeave={handleMouseEnd}
        transition={spring}
        style={{
          width: '100%',
          height: '100%',
          rotateX: dx,
          rotateY: dy,
        }}
      >
        <div
          style={{
            perspective: '1200px',
            transformStyle: 'preserve-3d',
            width: '100%',
            height: '100%',
          }}
        >
          <motion.div
            animate={{ rotateY: isFlipped ? -180 : 0 }}
            transition={spring}
            style={{
              width: '100%',
              height: '100%',
              zIndex: isFlipped ? 0 : 1,
              backfaceVisibility: 'hidden',
              position: 'absolute',
            }}
          >
            <OnlineLearningLectureCard cardVariant="Front" {...cardData} />
          </motion.div>
          <motion.div
            initial={{ rotateY: 180 }}
            animate={{ rotateY: isFlipped ? 0 : 180 }}
            transition={spring}
            style={{
              width: '100%',
              height: '100%',
              zIndex: isFlipped ? 1 : 0,
              backfaceVisibility: 'hidden',
              position: 'absolute',
            }}
          >
            <OnlineLearningLectureCard cardVariant="Back" {...cardData} />
          </motion.div>
        </div>
      </motion.div>
    </motion.div>
  )
}
