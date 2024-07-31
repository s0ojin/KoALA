'use client'

import { useState } from 'react'
import { motion } from 'framer-motion'
import AISpeakingConversationCard from './AISpeakingConversationCard'
import NextBtn from '/public/icons/arrow-right.svg'

const dummy = [
  {
    id: 1,
    title: '관공서에서 민원을 넣을 때',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 1,
    title: '1',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 1,
    title: '2',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 1,
    title: '3',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 1,
    title: '4',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
]

export default function AISpeakingSlider() {
  const [positionIndexes, setPositionIndexes] = useState([0, 1, 2, 3, 4])

  const imageVariants = {
    center: { x: '0%', scale: 1, zIndex: 5, rotate: '0deg' },
    left1: {
      x: '-70%',
      scale: 0.85,
      zIndex: 2,
      rotate: '1deg',
      filter: 'blur(3px)',
    },
    left: {
      x: '-130%',
      y: '10%',
      scale: 0.8,
      zIndex: 1,
      rotate: '-10deg',
      filter: 'blur(3px)',
    },
    right1: {
      x: '130%',
      y: '10%',
      scale: 0.8,
      zIndex: 1,
      rotate: '10deg',
      filter: 'blur(3px)',
    },
    right: {
      x: '70%',
      scale: 0.85,
      zIndex: 2,
      rotate: '-1deg',
      filter: 'blur(3px)',
    },
  }

  const positions = ['center', 'left1', 'left', 'right1', 'right']

  const handleNext = () => {
    setPositionIndexes((prevIndexes) => {
      return prevIndexes.map((prevIndex) => (prevIndex + 1) % 5)
    })
  }
  const handlePrev = () => {
    setPositionIndexes((prevIndexes) => {
      return prevIndexes.map((prevIndex) => (prevIndex - 1 + 5) % 5)
    })
  }
  return (
    <div className="h-screen flex flex-col items-center justify-center w-full">
      <div className="z-10 w-[28rem] absolute flex justify-between text-gray-900">
        <NextBtn
          onClick={handlePrev}
          className="right-[30%] w-10 rotate-180 cursor-pointer"
        />
        <NextBtn
          onClick={handleNext}
          className="left-[30%] w-10 cursor-pointer"
        />
      </div>
      {dummy.map((conversation, idx) => (
        <motion.div
          key={conversation.id}
          initial="center"
          animate={positions[positionIndexes[idx]]}
          variants={imageVariants}
          //   drag={canDrag ? 'y' : false}
          //   dragConstraints={{
          //     top: 0,
          //     bottom: 0,
          //   }}
          //   onDragStart={handleDragStart}
          //   onDrag={handleDrag}
          //   onDragEnd={() => handleDragEnd()}

          transition={{ duration: 0.5 }}
          style={{ position: 'absolute' }}
        >
          <AISpeakingConversationCard
            conversationTitle={conversation.title}
            conversationDescription={conversation.description}
          />
        </motion.div>
      ))}
    </div>
  )
}
