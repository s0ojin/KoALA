'use client'

import DictationQuestion from '@/app/dictation/_components/DictationQuestion'
import DictationField from '@/app/dictation/_components/DictationField'
import Cloud from '/public/images/cloud.svg'

export default function Dictation() {
  return (
    <div className="w-full h-full min-h-screen flex items-center justify-center">
      <p className="absolute top-[152px] right-[47px]">
        <Cloud />
      </p>

      <div className="inline-flex flex-col items-center gap-28 w-auto">
        <DictationQuestion />
        <DictationField />
      </div>
    </div>
  )
}
