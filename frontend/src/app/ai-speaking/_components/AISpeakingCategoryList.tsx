'use client'

import { useState } from 'react'

type CategoryId = 'school' | 'government-office' | 'etc' | 'wwww'

interface Category {
  id: CategoryId
  label: string
}

const CATEGORY_LIST: Category[] = [
  {
    id: 'school',
    label: '학교',
  },
  {
    id: 'government-office',
    label: '관공서',
  },
  {
    id: 'etc',
    label: '기타',
  },
  {
    id: 'wwww',
    label: '또뭐있낭',
  },
]

export default function AISpeakingCategoryList() {
  const [activeCategory, setActiveCategory] = useState('school')
  return (
    <ul className="flex gap-3 mt-8">
      {CATEGORY_LIST.map((category) => (
        <li key={category.id}>
          <button
            onClick={() => setActiveCategory(category.id)}
            className={`${activeCategory === category.id ? 'bg-primary-400' : 'bg-gray-300'} text-white py-2 px-6 rounded-full`}
          >
            {category.label}
          </button>
        </li>
      ))}
    </ul>
  )
}
