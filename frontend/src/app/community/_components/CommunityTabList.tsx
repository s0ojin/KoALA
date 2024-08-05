'use client'

import { useState } from 'react'

interface Tab {
  id: String
  label: string
}

export type TabId = 'total-post' | 'popular-post' | 'lecture-chat' | 'my-post'

export const tabList: Tab[] = [
  {
    id: 'total-post',
    label: '전체',
  },
  {
    id: 'popular-post',
    label: '인기글',
  },
  {
    id: 'my-post',
    label: '내가 쓴 글',
  },
]

export default function CommunityTabList() {
  const [selected, setSelected] = useState<string>(`total-post`)

  return (
    <ul className="inline-flex gap-6 items-end">
      {tabList.map((tab) => {
        return (
          <li
            key={tab.label}
            className={`hover:text-primary-400 cursor-pointer ${selected === tab.id ? 'text-primary-400 border-b-2' : 'text-gray-400'} text-lg font-medium px-2 border-primary-400`}
            onClick={() => setSelected(tab.id as string)}
          >
            {tab.label}
          </li>
        )
      })}
    </ul>
  )
}
