interface ButtonProps {
  children: React.ReactNode
}

export default function ReviewMenuButton({ children }: ButtonProps) {
  return (
    <button className="w-[15rem] h-[5rem] bg-primary-400 text-white rounded-[4rem] mb-2.5 shadow-md active:bg-gray-300">
      {children}
    </button>
  )
}
