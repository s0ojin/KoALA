'use client'

import { useState } from 'react'
import { motion, PanInfo } from 'framer-motion'
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
    id: 2,
    title: '1',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 3,
    title: '2',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 4,
    title: '3',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 5,
    title: '4',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 6,
    title: '5',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 7,
    title: '6',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
  {
    id: 8,
    title: '7',
    description:
      '관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다! 관공서에서 민원을 넣는 상황을 가정합니다. AI와 함께 연습해 봅시다!',
  },
]

const POSITIONS = ['farLeft', 'left', 'center', 'right', 'farRight']

export default function AISpeakingSlider() {
  const [cardList, setCardList] = useState(dummy)
  const [activeIndex, setActiveIndex] = useState(0)

  const handleClick = (direction: number) => {
    setActiveIndex(
      (prevIndex) => (prevIndex + direction + cardList.length) % cardList.length
    )
  }

  const handleDragEnd = (
    _: MouseEvent | TouchEvent | PointerEvent,
    info: PanInfo
  ) => {
    if (info.offset.x < -100) {
      handleClick(1)
    } else if (info.offset.x > 100) {
      handleClick(-1)
    }
  }

  const getVisibleCards = () => {
    const totalCards = cardList.length
    const visibleCards = []
    for (let i = -2; i <= 2; i++) {
      visibleCards.push(cardList[(activeIndex + i + totalCards) % totalCards])
    }
    return visibleCards
  }

  const imageVariants = {
    center: { x: '0%', scale: 1, zIndex: 5, rotate: '0deg' },
    left: {
      x: '-70%',
      scale: 0.85,
      zIndex: 2,
      rotate: '1deg',
      filter: 'blur(2px)',
    },
    farLeft: {
      x: '-130%',
      y: '10%',
      scale: 0.8,
      zIndex: 1,
      rotate: '-10deg',
      filter: 'blur(2px)',
    },
    farRight: {
      x: '130%',
      y: '10%',
      scale: 0.8,
      zIndex: 1,
      rotate: '10deg',
      filter: 'blur(2px)',
    },
    right: {
      x: '70%',
      scale: 0.85,
      zIndex: 2,
      rotate: '-1deg',
      filter: 'blur(2px)',
    },
  }

  const visibleCardList = getVisibleCards()

  return (
    <div className="h-screen flex flex-col items-center justify-center w-full">
      <div className="z-10 w-[28rem] absolute flex justify-between text-gray-900">
        <NextBtn
          onClick={() => handleClick(-1)}
          className="right-[30%] w-10 rotate-180 cursor-pointer"
        />
        <NextBtn
          onClick={() => handleClick(1)}
          className="left-[30%] w-10 cursor-pointer"
        />
      </div>
      {visibleCardList.map((card, idx) => {
        const canDrag = POSITIONS[idx] === 'center'
        return (
          <motion.div
            key={card.id}
            className={`absolute ${canDrag ? 'cursor-pointer' : 'cursor-auto'}`}
            initial="center"
            animate={POSITIONS[idx]}
            variants={imageVariants}
            transition={{ duration: 0.5 }}
            drag={canDrag ? 'x' : false}
            onDragEnd={handleDragEnd}
            dragConstraints={{ left: 0, right: 0 }}
          >
            <AISpeakingConversationCard
              conversationTitle={card.title}
              conversationDescription={card.description}
            />
          </motion.div>
        )
      })}
    </div>
  )
}
