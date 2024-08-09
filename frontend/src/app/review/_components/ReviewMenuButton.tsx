'use client'

interface ButtonProps {
  children: React.ReactNode
}

export default function ReviewMenuButton({ children }: ButtonProps) {
  return (
    <button className="w-full px-10 py-4 bg-primary-400 text-white rounded-[4rem] mb-2.5 shadow-md active:bg-gray-300 whitespace-nowrap">
      {children}
    </button>
  )
}
