import ReviewArea from '@/app/review/_components/ReviewArea'
import ReviewLayout from '@/app/review/_components/ReviewLayout'
import ReviewMenuButtons from '@/app/review/_components/ReviewMenuButtons'

export default function ReviewMain() {
  return (
    <ReviewLayout>
      <div className="h-main-screen flex flex-col gap-4">
        <div className="w-[80%] h-full flex max-w-7xl gap-8 mx-auto">
          <ReviewArea />
          <ReviewMenuButtons />
        </div>
      </div>
    </ReviewLayout>
  )
}
