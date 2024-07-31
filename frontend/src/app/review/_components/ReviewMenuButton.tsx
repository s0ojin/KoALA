'use client'

import { useState } from 'react'

interface ButtonProps {
  children: React.ReactNode
}

export default function ReviewMenuButton({ children }:ButtonProps) {
  // const [ isClicked, setisClicked ] = useState<Boolean>(false)
  return <button className="w-[15rem] h-[5rem] bg-gray-300 hover:bg-primary-400">{children}</button>
}
