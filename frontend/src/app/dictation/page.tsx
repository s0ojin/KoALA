'use client'

import DictationQuestion from '@/app/dictation/_components/DictationQuestion'
import DictationField from '@/app/dictation/_components/DictationField'
import DictationLayout from '@/app/dictation/_components/DictationLayout'

export default function Dictation() {
  return (
    <DictationLayout>
      <div className="pt-40 overflow-x-hidden h-main-screen flex justify-center items-center flex-col gap-28">
        <DictationQuestion />
        <DictationField />
      </div>
    </DictationLayout>
  )
}
