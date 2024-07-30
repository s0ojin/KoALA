import Header from '@/app/_components/Header'
import ReviewArea from '@/app/review/_components/ReviewArea'
import ReviewLayout from '@/app/review/_components/ReviewLayout'
import Image from 'next/image'

export default function Review() {
  return(
    <ReviewLayout>
      <Header />
      <div className='mt-[4rem]'>
        <p className='text-center font-medium text-3xl'>
          복습하기
        </p>
      </div>
      <div className='flex mt-[1.25rem]'>
        <ReviewArea />
      </div>
    </ReviewLayout>
  )
}