'use client'

import Image from 'next/image'
import { useState } from 'react'
import Notification from '/public/icons/notification.svg'
import Repeat from '/public/icons/rotate.svg'
import SoundWave from '@/app/dictation/_components/DictationSoundWave'

export default function DictationQuestion() {
  const [isToggled, setIsToggled] = useState(false)

  const handleChangeToggle = (event: React.ChangeEvent<HTMLInputElement>) => {
    setIsToggled(event.target.checked)
  }

  return (
    <div className="w-full max-w-[800px] inline-flex flex-col gap-3 relative">
      <Image
        width={0}
        height={0}
        sizes="100%"
        className="w-40 absolute left-0 top-2 transform -translate-x-28"
        alt="구름"
        src="/images/cloud.svg"
      />

      <Image
        width={0}
        height={0}
        sizes="100%"
        className="w-48 absolute right-0 bottom-0 z-10 transform translate-x-20 translate-y-14"
        alt="구름"
        src="/images/cloud.svg"
      />
      <label className="flex cursor-pointer w-auto self-end mr-16 rounded-full z-10">
        <input
          type="checkbox"
          className="sr-only peer"
          checked={isToggled}
          onChange={handleChangeToggle}
        />
        <div
          className="inline-block self-end w-[90px] h-[42px] border-[2px] border-gray-300 relative bg-white peer-focus:outline-none 
          rounded-full peer peer-checked:after:translate-x-12
          rtl:peer-checked:after:-translate-x-full
          peer-checked:after:border-white 
          after:content-[''] after:absolute after:top-[3px] after:start-[3px]
          after:bg-gray-300 after:rounded-full 
          after:h-8 after:w-8 after:transition-all
          peer-checked:after:bg-primary-400
          peer-checked:border-primary-400 peer-checked:border-[2px]
          peer-checked:bg-white"
        ></div>
      </label>
      <div className="relative">
        <p className="absolute bottom-[80px] right-[50px]">
          <Image
            width={0}
            height={0}
            sizes="100%"
            className="w-[30rem] h-[30rem]"
            alt="로켓"
            src="/images/rocket.svg"
          />
        </p>
        <div className="h-full min-h-[160px] w-full inline-flex gap-5 items-center border-primary-400 border-[4px] rounded-full bg-white pl-[64px] pr-[51px]">
          <p>
            <Notification width="60" height="60" />
          </p>
          {isToggled ? (
            <p className="text-primary-700 text-3xl font-medium">
              선생님 저희 애는 친구를 때릴 애가 아닙니다.
            </p>
          ) : (
            <p className="m-auto">
              <SoundWave />
            </p>
          )}
          <button className="cursor-pointer z-10 text-primary-400">
            <Repeat />
          </button>
        </div>
      </div>
    </div>
  )
}
