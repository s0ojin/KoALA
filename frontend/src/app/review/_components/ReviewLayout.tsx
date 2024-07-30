import Image from "next/image"

interface ReviewLayoutProps {
  children: React.ReactNode
}

export default function ReviewLayout ({children}: ReviewLayoutProps) {
  return (
    <div>
      {children}
      <Image
        src='/images/cloud.svg'
        alt=''
        width={200}
        height={200}
        className='absolute left-2/3'
      />
      <Image
        src='/images/cloud.svg'
        alt=''
        width={400}
        height={400}
        className='absolute top-1/2 right-0 translate-x-20'
      />
      <Image
        src='/images/koala-sleep.png'
        alt=''
        width={150}
        height={150}
        className='absolute top-1/2 right-0 -translate-x-10'
      />
    </div>
  )
}