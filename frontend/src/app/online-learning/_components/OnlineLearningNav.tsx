'use client'

import ChatIcon from '/public/icons/chat.svg'
import NoteIcon from '/public/icons/notebook.svg'
import ResourceIcon from '/public/icons/edit.svg'
import { useState } from 'react'

const tabs = [
  { id: 0, label: '강의노트', icon: <ResourceIcon /> },
  { id: 1, label: '수업자료', icon: <NoteIcon /> },
  { id: 2, label: '채팅', icon: <ChatIcon /> },
]

export default function OnlineLearningNav() {
  const [tabIndex, setTabIndex] = useState(0)
  return (
    <div className="fixed py-6 right-0 w-20 h-full bg-white flex flex-col items-center gap-2">
      {tabs.map((tab) => (
        <button
          onClick={() => setTabIndex(tab.id)}
          key={tab.id}
          className={`flex flex-col items-center gap-1 w-full py-2 text-primary-400 hover:font-medium ${tabIndex === tab.id && 'bg-primary-400 text-white'}`}
        >
          <div className="w-8">{tab.icon}</div>
          <p className="font-medium">{tab.label}</p>
        </button>
      ))}
    </div>
  )
}
