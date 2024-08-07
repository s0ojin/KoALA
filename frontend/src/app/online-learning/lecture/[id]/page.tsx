'use client'

import { useState } from 'react'
import OnlineLearningSideBar from '../../_components/OnlineLearningSideBar'

export default function OnlineLearningRoom() {
  const [isOpenSideBar, setIsOpenSideBar] = useState(false)

  return (
    <div className="flex items-center pr-20 h-main-screen">
      <div
        className={`${isOpenSideBar ? 'w-[calc(100vw-43rem)]' : 'w-[calc(100vw-15rem)]'} ml-20 h-[90%] bg-gray-400 rounded-[3rem] overflow-hidden transition-all duration-300`}
      >
        <img
          className="object-cover"
          src="https://images.unsplash.com/photo-1544168190-79c17527004f?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        />
      </div>
      <OnlineLearningSideBar setIsOpenSideBar={setIsOpenSideBar} />
    </div>
  )
}
