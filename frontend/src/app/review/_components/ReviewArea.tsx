import ReviewAreaSearch from '@/app/review/_components/ReviewAreaSearch'
import ReviewAreaSentence from '@/app/review/_components/ReviewAreaSetence'
import { SentenceContent } from '@/app/apis/review'

interface ReviewContentProps {
  topic?: string | null
  keyword?: string | null
  sentenceList?: SentenceContent[]
}

export interface Category {
  id: string
  content: string
}

export const categoryList = [
  { id: '1', content: '전체' },
  { id: '2', content: '일상' },
  { id: '3', content: '행정' },
  { id: '4', content: '교육' },
  { id: '5', content: '사용자' },
]

export default async function ReviewArea({ topic, keyword, sentenceList }:ReviewContentProps) {
 
  return (
    <div className="h-full flex flex-col bg-white w-full rounded-t-3xl p-6 gap-4">
      <div className="flex w-full h-12">
        <ReviewAreaSearch topic={topic} keyword={keyword} />
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
