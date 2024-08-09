'use client'
import ReviewAreaSearch from '@/app/review/_components/ReviewAreaSearch'
import ReviewAreaSentence from '@/app/review/_components/ReviewAreaSetence'
import ReviewMenuButton from '@/app/review/_components/ReviewMenuButton'
import { SentenceContent } from '@/app/apis/review'
import { deleteReviewSentence, postReviewSentenceSave } from '@/app/apis/review'
import { useState } from 'react'
import { useRouter } from 'next/navigation'

interface ReviewContentProps {
  token: string | null
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

export default function ReviewArea({
  token,
  topic,
  keyword,
  sentenceList,
}: ReviewContentProps) {
  const [selectedSentences, setSentences] = useState<number[]>([])
  const router = useRouter()
  let copySentences: number[] = []
  const handleSentenceList = (review_sentence_id: number) => {
    copySentences = [...selectedSentences]
    if (selectedSentences.includes(review_sentence_id)) {
      const idx = copySentences.indexOf(review_sentence_id)
      copySentences.splice(idx, 1)
    } else {
      copySentences.push(review_sentence_id)
    }
    setSentences(selectedSentences => copySentences)
  }

  const handleSetenceDelete = () => {
    // postReviewSentenceSave('/reviews',2,token)
    if (selectedSentences.length) {
      selectedSentences.map(async (review_sentence_id) => {
        await deleteReviewSentence('/reviews', review_sentence_id, token)
      })
    setSentences(selectedSentences => [])
    router.push('/review')
    }
  }

  return (
    <>
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
                  isSelected={selectedSentences.includes(
                    sentence.review_sentence_id
                  )}
                  OnSentenceSelect={handleSentenceList}
                />
              )
            })
          ) : (
            <p className="text-center">아직 문장을 추가하지 않았어요!</p>
          )}
        </div>
      </div>
      <div className="flex flex-col self-end mb-4">
        <ReviewMenuButton content="재생" />
        <ReviewMenuButton content="읽고 따라 말하기" />
        <ReviewMenuButton content="받아쓰기" />
        <ReviewMenuButton onClick={handleSetenceDelete} content="삭제하기" />
      </div>
    </>
  )
}
