import Image from 'next/image'

interface DictationProps {
  children: React.ReactNode
}

export default function DictationLayout({ children }: DictationProps) {
  return (
    <div className="relative w-full h-full min-h-screen flex items-center justify-center">
      {children}
      <Image
        width={0}
        height={0}
        sizes="100%"
        className="absolute w-[12%] top-[5%] right-[1%] -z-10"
        alt="구름"
        src="/images/cloud.svg"
      />
      <Image
        width={0}
        height={0}
        sizes="100%"
        className="absolute w-[15%] bottom-[10%] left-[1%] z-10 scale-x-[-1]"
        alt="구름"
        src="/images/cloud.svg"
      />
      <Image
        width={0}
        height={0}
        sizes="100%"
        className="absolute w-[12%] bottom-[1%] right-[15%] -z-10 scale-x-[-1]"
        alt="구름"
        src="/images/cloud.svg"
      />
      <Image
        width={0}
        height={0}
        sizes="100%"
        className="absolute w-[12%] top-[30%] left-[10%] -z-10 scale-x-[-1]"
        alt="우주인"
        src="/images/astronaut.png"
      />
    </div>
  )
}
