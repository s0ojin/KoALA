'use client'

import { useState } from 'react'

interface ButtonProps {
  children: React.ReactNode
}

export default function ReviewMenuButton({ children }:ButtonProps) {
  // const [ isClicked, setisClicked ] = useState<Boolean>(false)
  return <button className="w-[15rem] h-[5rem] bg-primary-400 text-white rounded-[4rem] mb-2.5 shadow-md active:bg-gray-300">{children}</button>
}
