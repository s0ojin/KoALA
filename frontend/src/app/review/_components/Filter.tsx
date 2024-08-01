'use client'

import FilterIcon from '/public/icons/filter-square.svg'
import { useState } from 'react'

export default function Filter() {
  const [isClicked, setClicked] = useState<Boolean>(false)

  const handleSelect = () => {
    setClicked((isClicked) => !isClicked)
  }

  return (
    <>
      <button
        onClick={handleSelect}
        className="w-[11rem] h-full bg-primary-400 rounded-[4rem] mr-[1rem] hover:bg-primary-800 inline-flex items-center dark:bg-primary-600 dark:hover:bg-primary-700"
      >
        <div className="flex m-auto px-[1rem]">
          <FilterIcon width={24} height={24} />
          <p className="text-white text-lg m-auto">슈퍼 마켓</p>
        </div>
      </button>
      {/* <div
        className={`absolute w-[11rem] z-50 bg-white divide-y divide-gray-100 rounded-lg shadow-md dark:bg-gray-700 ${isClicked ? '' : 'hidden'}`}
      >
        <ul className="py-2 text-sm text-gray-700 dark:text-gray-200 text-center">
          <li>
            <a
              href="#"
              className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
            >
              교육
            </a>
          </li>
          <li>
            <a
              href="#"
              className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
            >
              행정
            </a>
          </li>
          <li>
            <a
              href="#"
              className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
            >
              일상
            </a>
          </li>
          <li>
            <a
              href="#"
              className="block px-4 py-2 hover:bg-gray-100 dark:hover:bg-gray-600 dark:hover:text-white"
            >
              사용자
            </a>
          </li>
        </ul>
      </div> */}
    </>
  )
}
