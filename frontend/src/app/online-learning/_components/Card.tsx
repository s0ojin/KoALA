'use client'

import Image from 'next/image'
import Link from 'next/link'
import Photo from '/public/images/logo.svg'
import { useState } from 'react'

export default function Card ({...props}) {

  if (props.variant === 'Back') {
    return (
      <div className="bg-white rounded-tl-3xl overflow-hidden shadow-mg">
        {/* <Image src={Photo} alt="Lecture Card" className='w-full ' fill/> */}
        <div className='bg-gray-100 rounded-tl-3xl mt-5 mx-5 pt-8 px-8'>
          <div className="text-gray-700 font-bold text-xl text-center mb-2">
            {props.lecture}
          </div>
          <div>
            <p className="text-gray-700 text-base">
              {props.description}
            </p>
          </div>
          <div className='flex text-primary-900 text-sm'>
                <p className='mr-2.5 font-medium'>수업일정</p>
                <p>{props.schedule}</p>
          </div>
          <Link href={`online-learning/${props.pagelink}`} className='m-auto'>
            <button className='bg-primary-400 max-w-56 max-h-10 rounded-3xl text-white font-bold'>
              강의 입장하기
            </button>
          </Link>
        </div>
      </div>
    )
  } else {
    return (
      <div className="bg-white rounded-tr-3xl overflow-hidden shadow-lg">
        <div className="w-full h-80">
          <Image src={Photo} alt="Lecture Card" className='w-full'/>
        </div>
        <div className="px-6 py-4">
          <div className="text-gray-700 font-bold text-xl text-center mb-2">
            {props.lecture}
          </div>
          <p className="text-gray-700 text-base text-center">
            {props.teacher}
          </p>
        </div>
      </div>
    )
  }

}