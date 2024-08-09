'use client'

import MainKoalaLevel from './MainKoalaLevel'
import MainKoalaNameEditor from './MainKoalaNameEditor'
import Image from 'next/image'
import useSWR from 'swr'
import { KoalaInfo, fetchKoalaInfo } from '@/app/apis/koala'

export default function MainKoala() {
  const { data: koalaInfo, error } = useSWR<KoalaInfo>(
    '/koalas',
    fetchKoalaInfo
  )

  return (
    <>
      {koalaInfo ? (
        <div className="flex flex-col items-center w-full relative">
          <MainKoalaNameEditor koalaName={koalaInfo?.koala_name} />
          <Image
            src="/images/koala-sleep.png"
            width={0}
            height={0}
            sizes="100%"
            className="w-[22rem] h-[22rem] mt-20"
            alt="koala"
            draggable="false"
          />
          <MainKoalaLevel
            percent={koalaInfo?.koala_exp}
            level={koalaInfo.koala_level}
          />
        </div>
      ) : null}
    </>
  )
}
