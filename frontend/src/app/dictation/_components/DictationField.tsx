import { useState } from 'react'
import NextButton from '/public/icons/next-btn.svg'

export default function DictationField() {
  const [grid, setGrid] = useState(Array(42).fill(''))

  return (
    <div className="flex flex-col">
      <div className="overflow-hidden w-[1040px] py-[10px] bg-white border-t-[1px] border-b-[1px] border-primary-400">
        <div className="grid grid-cols-14 transform translate-x-[-40px]">
          {grid.map((value, index) => (
            <input
              key={index}
              className={`w-20 h-20  outline outline-1 outline-primary-400 text-4xl text-center ${index === 0 ? 'border-l-0' : ''} ${index === 0 || index === grid.length - 1 ? 'border-r-0' : ''}`}
              maxLength={1}
            />
          ))}
        </div>
      </div>
      <button className="self-end gap-3 cursor-pointer rounded-full text-primary-400">
        <NextButton width="70" height="70" />
      </button>
    </div>
  )
}
