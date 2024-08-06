// CardSlide.tsx

'use client'

import Image from 'next/image'
import { useState } from 'react'
import { Virtual, Autoplay } from 'swiper/modules'
import { Swiper, SwiperSlide, SwiperClass } from 'swiper/react'
import OnlineLearningLectureCardFlip from '@/app/online-learning/_components/carousel/OnlineLearningLectureCardFlip'

// Import Swiper styles
import 'swiper/css'
import 'swiper/css/navigation'

export interface CardDataProps {
  cardLectureTitle: String
  cardLectureDescription: String
  cardLectureTeacher: String
  cardLectureSchedule: String
  cardLectureSessionID: String
}

// Dummy Data
const cardList = [
  {
    cardLectureTitle: '식당에 방문 했을 때 II',
    cardLectureDescription:
      '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    cardLectureTeacher: '고동연 선생님',
    cardLectureSchedule: '월 수 금 15:00 ~ 17:00',
    cardLectureSessionID: '1',
  },
  {
    cardLectureTitle: '식당에 방문 했을 때 II',
    cardLectureDescription:
      '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    cardLectureTeacher: '고동연 선생님',
    cardLectureSchedule: '월 수 금 15:00 ~ 17:00',
    cardLectureSessionID: '1',
  },
  {
    cardLectureTitle: '식당에 방문 했을 때 II',
    cardLectureDescription:
      '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    cardLectureTeacher: '고동연 선생님',
    cardLectureSchedule: '월 수 금 15:00 ~ 17:00',
    cardLectureSessionID: '1',
  },
  {
    cardLectureTitle: '식당에 방문 했을 때 II',
    cardLectureDescription:
      '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    cardLectureTeacher: '고동연 선생님',
    cardLectureSchedule: '월 수 금 15:00 ~ 17:00',
    cardLectureSessionID: '1',
  },
]

export default function OnlineLearningLectureCardSlide() {
  const slides = cardList.map((data: CardDataProps, index: number) => (
    <OnlineLearningLectureCardFlip key={index} {...data} />
  ))

  const [swiper, setSwiper] = useState<SwiperClass>()

  const handlePrev = () => {
    swiper?.slidePrev()
  }
  const handleNext = () => {
    swiper?.slideNext()
  }

  return (
    <div className="flex mx-auto max-h-[26rem] min-w-[48rem] m-auto max-w-[75rem]">
      <div className="md:mx-[1rem] lg:mx-[2.5rem] my-auto">
        <button
          onClick={handlePrev}
          className={cardList.length <= 3 ? 'hidden' : ''}
        >
          <Image
            src="/icons/chevron-left.svg"
            alt="chevron-left"
            width={0}
            height={0}
            className="w-[2.5rem]"
          />
        </button>
      </div>
      <Swiper
        className={
          cardList.length < 2
            ? 'max-w-[20rem]'
            : cardList.length < 3
              ? 'max-w-[40rem]'
              : 'max-w-[60rem]'
        }
        modules={[Virtual, Autoplay]}
        onSwiper={(e) => {
          setSwiper(e)
        }}
        slidesPerView={cardList.length < 3 ? cardList.length : 3}
        centeredSlides={false}
        spaceBetween={30}
        loop={true}
        autoplay={{
          delay: 5000,
          disableOnInteraction: false,
        }}
      >
        {slides.map((card, index) => (
          <SwiperSlide key={index} virtualIndex={index}>
            {card}
          </SwiperSlide>
        ))}
      </Swiper>
      <div className="md:mx-[1rem] lg:mx-[2.5rem] my-auto">
        <button
          onClick={handleNext}
          className={cardList.length <= 3 ? 'hidden' : ''}
        >
          <Image
            src="/icons/chevron-right.svg"
            alt="chevron-right"
            width={0}
            height={0}
            className="w-[2.5rem]"
          />
        </button>
      </div>
    </div>
  )
}
