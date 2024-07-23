'use client'
import React, { useRef, useState, useEffect } from 'react'
import { Virtual, Navigation, Pagination, Autoplay } from 'swiper/modules'
import { Swiper, SwiperSlide } from 'swiper/react'

// Import Swiper styles
import 'swiper/css'
import 'swiper/css/pagination'
import 'swiper/css/navigation'
import Card from '@/app/online-learning/_components/Card'

export default function CardSlide() {
  const cardData = [
    { lecture: '안녕1', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕2', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕3', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕3', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕3', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕3', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕3', teacher: '빡빡이 아저씨야.' },
    { lecture: '안녕3', teacher: '빡빡이 아저씨야.' },
  ]
  const [swiperRef, setSwiperRef] = useState(null)
  // const appendNumber = useRef(cardData.length)
  // const prependNumber = useRef(1)
  const [slides, setSlides] = useState(
    cardData.map((data, index) => <Card key={index} {...data} />)
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
    <div className='mt-24'>
      <Swiper
        className='m-auto w-5/6'
        modules={[Virtual, Navigation, Pagination, Autoplay]}
        onSwiper={setSwiperRef}
        slidesPerView={3}
        centeredSlides={true}
        spaceBetween={20}
        loop={true}
        // pagination={{
        //   type: 'fraction',
        // }}
        navigation={true}
        autoplay={{
          delay: 3000, // 3초마다 자동 재생
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
