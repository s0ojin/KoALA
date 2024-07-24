// CardSlide.tsx

'use client'

import Image from 'next/image';
import Logo from '/public/images/logo.svg'
import { ReactElement, useEffect, useRef, useState } from 'react';
import SwiperCore from 'swiper';
import { Virtual, Navigation, Pagination, Autoplay, Scrollbar } from 'swiper/modules'
import { Swiper, SwiperSlide } from 'swiper/react'
import Card from '@/app/online-learning/_components/Card'
import CardFlip from '@/app/online-learning/_components/carousel/CardFlip';
// Import Swiper styles
import 'swiper/css'
import 'swiper/css/navigation'

const cardList = [
  { lecture: '안녕1',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
  },
  { lecture: '안녕2',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
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
  { lecture: '안녕5',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
  },
  { lecture: '안녕1',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
  },
  { lecture: '안녕1',
    teacher: '빡빡이 아저씨야.',
    description: '식당에 들어설 때부터 마주칠 수 있는 다양한 상황에서 나올 수 있는 대화를 다룹니다. <식당에 방문 했을 때 I> 수업을 먼저 수강해야합니다.',
    schedule: '월 수 금 15:00 ~ 17:00',
    pagelink: '/1'
  },

]

export default function CardSlide() {
  const [swiperRef, setSwiperRef] = useState(null)
  SwiperCore.use([Navigation])
  // const appendNumber = useRef(cardData.length)
  // const prependNumber = useRef(1)
  const [slides, setSlides] = useState(
    cardList.map((data, index) => <CardFlip key={index} {...data} />)
  )

  // function prepend ():void {
  //   setSlides([
  //     `Slide ${prependNumber.current - 2}`,
  //     `Slide ${prependNumber.current - 1}`,
  //     ...slides,
  //   ])
  //   prependNumber.current = prependNumber.current - 2
  //   swiperRef.slideTo(swiperRef.activeIndex + 2, 0)
  // }

  // const append = () => {
  //   setSlides([...slides, 'Slide ' + ++appendNumber.current])
  // }

  // const slideTo = (index) => {
  //   swiperRef.slideTo(index - 1, 0)
  // }

  return (
    <div className='mt-24 w-5/6 m-auto'>
      <Swiper
        modules={[Virtual, Navigation, Autoplay]}
        // onSwiper={setSwiperRef}
        slidesPerView={3}
        centeredSlides={true}
        spaceBetween={20}
        loop={true}
        navigation={true}
        autoplay={{
          delay: 5000, // 5초마다 자동 재생
          disableOnInteraction: false // 사용자 상호 작용 후에도 자동 재생 유지
        }}
        virtual
      >
        {slides.map((slideContent, index) => (
          <SwiperSlide key={slideContent} virtualIndex={index}>
            {slideContent}
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  )
}