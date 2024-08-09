import ReviewArea from '@/app/review/_components/ReviewArea'
import ReviewLayout from '@/app/review/_components/ReviewLayout'
import { getReviewSentence } from '@/app/apis/review'
import { getToken } from '@/app/utils/cookie/getToken'

interface ReviewProps {
  searchParams: {
    keyword?: string
    topic?: '일상' | '행정' | '교육' | '사용자'
  }
}

export default async function ReviewMain({ searchParams }: ReviewProps) {
  const topic = searchParams?.topic || null
  const keyword = searchParams?.keyword || null
  const token = await getToken()

  let sentenceList = null

  if (topic && keyword) {
    sentenceList = await getReviewSentence(
      `/reviews?keyword=${keyword}&topic=${topic}`, token
    )
  } else if (topic) {
    sentenceList = await getReviewSentence(`/reviews?topic=${topic}`, token)
  } else if (keyword) {
    sentenceList = await getReviewSentence(`/reviews?keyword=${keyword}`, token)
  } else {
    sentenceList = await getReviewSentence('/reviews', token)
  }
  
  return (
    <ReviewLayout>
      <div className="h-main-screen flex flex-col gap-4">
        <div className="w-[80%] h-full flex max-w-7xl gap-8 mx-auto">
          <ReviewArea token={token} topic={topic} keyword={keyword} sentenceList={sentenceList}/>
        </div>
      </div>
    </ReviewLayout>
  )
}
