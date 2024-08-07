'use client'

import MoveLeftButton from '/public/icons/arrow-left-no-line.svg'
import MoveRightButton from '/public/icons/arrow-right-no-line.svg'

export default function Pagination() {
  return (
    <div className="flex gap-7 py-5 mt-3 mb-10 justify-center items-center">
      <button className="cursor-pointer">
        <MoveLeftButton />
      </button>
      <div className="flex gap-2">
        {new Array(10).fill(0).map((_, index) => {
          return (
            <button
              key={index}
              className="text-gray-700 text-base font-normal w-7 h-7 hover:text-primary-400"
            >
              {index + 1}
            </button>
          )
        })}
      </div>
      <button className="cursor-pointer">
        <MoveRightButton />
      </button>
    </div>
  )
}
