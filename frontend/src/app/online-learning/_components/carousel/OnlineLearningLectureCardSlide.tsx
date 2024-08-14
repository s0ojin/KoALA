// CardSlide.tsx

'use client'

import Image from 'next/image'
import { useEffect, useState } from 'react'
import { Virtual, Autoplay } from 'swiper/modules'
import { Swiper, SwiperSlide, SwiperClass } from 'swiper/react'
import OnlineLearningLectureCardFlip from '@/app/online-learning/_components/carousel/OnlineLearningLectureCardFlip'

// Import Swiper styles
import 'swiper/css'
import 'swiper/css/navigation'
import useSWR from 'swr'
import { LectureCard, getLectureList } from '@/app/apis/online-learning'

export interface CardDataProps {
  cardLectureTitle: String
  cardLectureDescription: String
  cardLectureTeacher: String
  cardLectureSchedule: String
  cardLectureSessionID: String
}

// {
//   "lecture_id": 1,
//   "teacher_name": "teacher",
//   "lecture_title": "한국어 기초 강의",
//   "lecture_detail": "이거 들으면 기초 완료",
//   "session_id": "ses_QrYAlauJ0B",
//   "lecture_schedule": "월 수 금 15:00 ~ 17:00",
//   "lecture_img_url": "https://images.unsplash.com/photo-1550177205-89d100b75c34?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
// },

export default function OnlineLearningLectureCardSlide() {
  const { data: cardList } = useSWR('/lectures/all', getLectureList)
  const [swiper, setSwiper] = useState<SwiperClass>()
  const [slides, setSildes] = useState<React.JSX.Element[]>([])

  useEffect(() => {
    if (Array.isArray(cardList?.data)) {
      setSildes(
        cardList.data.map((data: LectureCard, index: number) => (
          <OnlineLearningLectureCardFlip key={index} {...data} />
        ))
      )
    } else {
      console.error('cardList.data is not an array:', cardList?.data)
    }
  }, [cardList?.data])

  const handlePrev = () => {
    swiper?.slidePrev()
  }
  const handleNext = () => {
    swiper?.slideNext()
  }

  if (!cardList?.data) {
    return <div>Loading</div>
  }

  return (
    <div className="flex mx-auto max-h-[26rem] min-w-[48rem] m-auto max-w-[75rem]">
      <div className="md:mx-[1rem] lg:mx-[2.5rem] my-auto">
        <button
          onClick={handlePrev}
          className={cardList.data.length <= 3 ? 'hidden' : ''}
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
          cardList.data.length < 2
            ? 'max-w-[20rem]'
            : cardList.data.length < 3
              ? 'max-w-[40rem]'
              : 'max-w-[60rem]'
        }
        modules={[Virtual, Autoplay]}
        onSwiper={(e) => {
          setSwiper(e)
        }}
        slidesPerView={cardList.data.length < 3 ? cardList.data.length : 3}
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
          className={cardList.data.length <= 3 ? 'hidden' : ''}
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
