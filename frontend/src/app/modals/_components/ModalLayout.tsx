'use client'

import { useRouter } from 'next/navigation'

export function ModalLayout({ children }: { children: React.ReactNode }) {
  const router = useRouter()

  return (
    <div
      onClick={() => router.back()}
      className="fixed top-0 w-screen h-screen cursor-pointer bg-[rgba(0,0,0,0.3)] z-[100] flex justify-center items-center"
    >
      <div onClick={(e) => e.stopPropagation()}>{children}</div>
    </div>
  )
}
