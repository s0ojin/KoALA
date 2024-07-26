'use client'

import { useState } from 'react'
import Logo from '/public/images/logo.svg'
import Image from 'next/image'

export default function Header() {
  const [isLogin, setIsLogin] = useState(true)

  return (
    <header className="h-20 px-9 flex w-full items-center justify-between">
      <p className="h-7">
        <Logo height="27" />
      </p>
      <div className="flex gap-6 items-center">
        {isLogin ? (
          <>
            <button className="text-base font-bold bg-primary-400 text-white py-2 px-11 rounded-full">
              나만의 문장 추가
            </button>
            <Image
              src="/images/dictation.png"
              width={0}
              height={0}
              sizes="100%"
              className="w-10 h-10 rounded-full border border-gray-100 cursor-pointer"
              alt="프로필"
            />
          </>
        ) : (
          <button className="text-base font-bold bg-primary-400 text-white py-2 px-11 rounded-full">
            로그인
          </button>
        )}
      </div>
    </header>
  )
}
