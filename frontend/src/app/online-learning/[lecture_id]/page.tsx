'use client'

import { useState } from 'react'
import OnlineLearningSideBar from '@/app/online-learning/_components/OnlineLearningSideBar'
import OnlineLearningVideoChat from '@/app/online-learning/_components/OnlineLearningVideoChat'

export default function OnlineLearningRoom({
  params,
}: {
  params: { lecture_id: string }
}) {
  const [isOpenSideBar, setIsOpenSideBar] = useState(false)
  return (
    <div className="flex items-center pr-20 h-main-screen">
      <div
        className={`${isOpenSideBar ? 'w-[calc(100vw-43rem)]' : 'w-[calc(100vw-15rem)]'} ml-20 transition-all duration-300`}
      >
        <OnlineLearningVideoChat lectureId={params.lecture_id} />
      </div>
      <OnlineLearningSideBar setIsOpenSideBar={setIsOpenSideBar} />
    </div>
  )
}
