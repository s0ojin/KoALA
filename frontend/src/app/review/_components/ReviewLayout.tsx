import Image from 'next/image'

interface ReviewLayoutProps {
  children: React.ReactNode
}

export default function ReviewLayout({ children }: ReviewLayoutProps) {
  return (
    <div className="w-full h-auto min-h-main-height overflow-hidden">
      {children}
      <Image
        src="/images/cloud.svg"
        alt="cloud"
        width={0}
        height={0}
        sizes="100%"
        priority
        className="w-[12%] absolute right-[24%] top-[8%] -z-20"
      />
      <Image
        src="/images/cloud.svg"
        alt="cloud"
        width={0}
        height={0}
        sizes="100%"
        priority
        className="w-[20%] h-auto absolute top-[68%] right-[0%] translate-x-20 -z-20"
      />
      <Image
        src="/images/koala-sleep.png"
        alt="cloud"
        width={0}
        height={0}
        sizes="100%"
        priority
        className="w-[11%] absolute top-[65%] right-[0%] -z-10"
      />
    </div>
  )
}
