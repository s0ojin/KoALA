import Header from '@/app/_components/Header'
import Title from '@/app/_components/Title'
import ReviewArea from '@/app/review/_components/ReviewArea'
import ReviewLayout from '@/app/review/_components/ReviewLayout'
import ReviewMenuButtons from '@/app/review/_components/ReviewMenuButtons'

export default function ReviewMain() {
  return (
    <ReviewLayout>
      <div className="mt-12">
        <Title
          CourseTitle={'복습하기'}
          CourseDescription={'반복학습으로 실력 Up!'}
        />
      </div>
      <div className="flex mt-5">
        <ReviewArea />
        <ReviewMenuButtons />
      </div>
    </ReviewLayout>
  )
}
