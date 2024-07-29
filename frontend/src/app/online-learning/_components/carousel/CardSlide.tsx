// CardSlide.tsx

'use client'

import Image from 'next/image'
import ChevronLeft from '/public/icons/chevron-left.svg'
import ChevronRight from '/public/icons/chevron-right.svg'
import { useState } from 'react'
import { Virtual, Autoplay } from 'swiper/modules'
import { Swiper, SwiperSlide } from 'swiper/react'
import CardFlip from '@/app/online-learning/_components/carousel/CardFlip'
// Import Swiper styles
import 'swiper/css'
import 'swiper/css/navigation'

const cardList = [
  { lecture: '식당에 방문 했을 때 II',
    teacher: '고동연 선생님',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: 'lecture/1'
  },
  { lecture: '안녕2',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/2'
  },
  { lecture: '안녕3',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
  },
  { lecture: '안녕4',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
  },
  // { lecture: '안녕5',
  //   teacher: '빡빡이 아저씨야.',
  //   description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
  //   schedule: '월 수 금 15:00 ~ 17:00',
  //   pagelink: '/1'
  // },
]

export default function CardSlide() {
  const [slides, setSlides] = useState(
    cardList.map((data, index) => <CardFlip key={index} {...data} />)
  )

  // 1. 연결을 위한 state 만들기
  const [swiperIndex, setSwiperIndex] = useState(0); // -> 페이지네이션용
  const [swiper, setSwiper] = useState<SwiperClass>(); // -> 슬라이드용

  // 2. 슬라이드 이벤트핸들러
  const handlePrev = () => {
      swiper?.slidePrev()
  }
  const handleNext = () => {
    swiper?.slideNext()
  }

  return (
    <div className='flex mt-24 max-w-[75rem] min-w-[48rem] h-[26rem] mx-auto'>
      <div className='m-auto'>
        <button onClick={handlePrev} className={ cardList.length <= 3 ? 'hidden' : '' }>
          <Image src={ChevronLeft} className='w-[2.5rem]' alt='chevron-left'/>
        </button>
      </div>
      <Swiper
        className='max-w-[60rem] max-h-[26rem] m-auto'
        modules={[Virtual, Autoplay]}
        onActiveIndexChange={(e)=>setSwiperIndex(e.realIndex)}
        onSwiper={(e) => {setSwiper(e)}}
        slidesPerView={3}
        centeredSlides={false}
        spaceBetween={30}
        loop={true}
        autoplay={{
          delay: 5000, // 5초마다 자동 재생
          disableOnInteraction: false // 사용자 상호 작용 후에도 자동 재생 유지
        }}
      >
        {slides.map((slideContent, index) => (
          <SwiperSlide key={index} virtualIndex={index}>
            {slideContent}
          </SwiperSlide>
        ))}
      </Swiper>
      <div className='m-auto'>
        <button onClick={handleNext} className={ cardList.length <= 3 ? 'hidden' : '' }>
          <Image src={ChevronRight} className='w-[2.5rem]' alt='chevron-right'/>
        </button>
      </div>
    </div>
  )
}