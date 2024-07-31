import Header from '@/app/_components/Header'
import Title from '@/app/_components/Title'
import ReviewArea from '@/app/review/_components/ReviewArea'
import ReviewLayout from '@/app/review/_components/ReviewLayout'
import ReviewMenuButtons from '@/app/review/_components/ReviewMenuButtons'
import Image from 'next/image'

export default function Review() {
  return (
    <ReviewLayout>
      <Header />
      <Title
        CourseTitle={'복습하기'}
        CourseDescription={'반복학습으로 실력 Up!'}
      />
      <div className="flex mt-[1.25rem]">
        <ReviewArea />
        <ReviewMenuButtons />
      </div>
    </ReviewLayout>
  )
}
