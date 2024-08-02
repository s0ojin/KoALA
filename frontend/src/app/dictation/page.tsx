'use client'

import DictationQuestion from '@/app/dictation/_components/DictationQuestion'
import DictationField from '@/app/dictation/_components/DictationField'
import DictationLayout from '@/app/dictation/_components/DictationLayout'

export default function Dictation() {
  return (
    <DictationLayout>
      <div className="inline-flex flex-col items-center gap-28 w-auto">
        <DictationQuestion />
        <DictationField />
      </div>
    </DictationLayout>
  )
}
