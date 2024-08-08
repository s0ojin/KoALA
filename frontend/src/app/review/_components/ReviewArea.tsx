import ReviewAreaSearchBar from '@/app/review/_components/ReviewAreaSearchBar'
import ReviewAreaFilter from '@/app/review/_components/ReviewAreaFilter'
import ReviewAreaSentence from '@/app/review/_components/ReviewAreaSetence'
import { getReviewSentence } from '@/app/apis/review'
import { SentenceContent } from '@/app/apis/review'

interface ReviewProps {
  searchParams: {
    keyword?: string
    topic?: '일상' | '행정' | '교육' | '사용자'
  }
}

export interface Category {
  id: string
  content: string
}

export const categoryList = [
  { id: '1', content: '전체' },
  { id: '2', content: '일상' },
  { id: '3', content: '헹정' },
  { id: '4', content: '교육' },
  { id: '5', content: '사용자' },
]

export default async function ReviewArea({ searchParams }: ReviewProps) {
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
    <div className="h-full flex flex-col bg-white w-full rounded-t-3xl p-6 gap-4">
      <div className="flex w-full h-12">
        <ReviewAreaFilter />
        <ReviewAreaSearchBar />
      </div>
      <hr className="bg-gray-200" />
      <div className="w-full pr-4 overflow-auto flex flex-col gap-2">
        {sentenceList ? (
          sentenceList?.map((sentence: SentenceContent) => {
            return (
              <ReviewAreaSentence
                key={sentence.review_sentence_id}
                sentence={sentence}
              />
            )
          })
        ) : (
          <p className="text-center">아직 문장을 추가하지 않았어요!</p>
        )}
      </div>
    </div>
  )
}
