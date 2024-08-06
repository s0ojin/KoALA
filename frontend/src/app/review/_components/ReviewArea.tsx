import ReviewAreaSearchBar from '@/app/review/_components/ReviewAreaSearchBar'
import ReviewAreaFilter from '@/app/review/_components/ReviewAreaFilter'
import ReviewAreaSentence from '@/app/review/_components/ReviewAreaSetence'

export default function ReviewArea() {
  return (
    <div className="h-full flex flex-col bg-white w-full rounded-t-3xl p-6 gap-4">
      <div className="flex w-full h-12">
        <ReviewAreaFilter />
        <ReviewAreaSearchBar />
      </div>
      <hr className="bg-gray-200" />
      <div className="w-full pr-4 overflow-auto flex flex-col gap-2">
        <ReviewAreaSentence />
        <ReviewAreaSentence />
        <ReviewAreaSentence />
        <ReviewAreaSentence />
        <ReviewAreaSentence />
        <ReviewAreaSentence />
        <ReviewAreaSentence />
        <ReviewAreaSentence />
      </div>
    </div>
  )
}
