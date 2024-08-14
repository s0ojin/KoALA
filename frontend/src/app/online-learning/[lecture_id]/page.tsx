'use client'

import { useState } from 'react'
import OnlineLearningSideBar from '@/app/online-learning/_components/OnlineLearningSideBar'
import OnlineLearningVideoChat from '@/app/online-learning/_components/OnlineLearningVideoChat'

export default function OnlineLearningRoom() {
  const [isOpenSideBar, setIsOpenSideBar] = useState(false)
  return (
    <div className="flex items-center pr-20 h-main-screen">
      <div
        className={`${isOpenSideBar ? 'w-[calc(100vw-43rem)]' : 'w-[calc(100vw-25rem)] ml-40'}  ml-20 transition-all duration-300`}
      >
        <OnlineLearningVideoChat />
      </div>
      <OnlineLearningSideBar setIsOpenSideBar={setIsOpenSideBar} />
    </div>
  )
}
