'use client'

import ChatIcon from '/public/icons/chat.svg'
import NoteIcon from '/public/icons/notebook.svg'
import WriteIcon from '/public/icons/edit.svg'
import { useState } from 'react'

const tabs = [
  { id: 'lecture-note', label: '강의노트', icon: <WriteIcon /> },
  { id: 'lecture-handout', label: '수업자료', icon: <NoteIcon /> },
  { id: 'lecture-chat', label: '채팅', icon: <ChatIcon /> },
]

export default function OnlineLearningTabList() {
  const [tabIndex, setTabIndex] = useState(tabs[0].id)
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
