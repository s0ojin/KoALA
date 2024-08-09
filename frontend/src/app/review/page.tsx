import ReviewArea from '@/app/review/_components/ReviewArea'
import ReviewLayout from '@/app/review/_components/ReviewLayout'
import ReviewMenuButtons from '@/app/review/_components/ReviewMenuButtons'
import { getReviewSentence } from '@/app/apis/review'

interface ReviewProps {
  searchParams: {
    keyword?: string
    topic?: '일상' | '행정' | '교육' | '사용자'
  }
}

export default async function ReviewMain({ searchParams }: ReviewProps) {
  
  console.log(searchParams)
  const topic = searchParams?.topic || null
  const keyword = searchParams?.keyword || null

  let sentenceList = null

  if (topic && keyword) {
    sentenceList = await getReviewSentence(
      `/reviews?keyword=${keyword}&topic=${topic}`
    )
  } else if (topic) {
    sentenceList = await getReviewSentence(`/reviews?topic=${topic}`)
  } else if (keyword) {
    sentenceList = await getReviewSentence(`/reviews?keyword=${keyword}`)
  } else {
    sentenceList = await getReviewSentence('/reviews')
  }
  
  return (
    <ReviewLayout>
      <div className="h-main-screen flex flex-col gap-4">
        <div className="w-[80%] h-full flex max-w-7xl gap-8 mx-auto">
          <ReviewArea topic={topic} keyword={keyword} sentenceList={sentenceList}/>
          <ReviewMenuButtons />
        </div>
      </div>
    </ReviewLayout>
  )
}
