'use client'

import { useRouter, useSearchParams } from 'next/navigation'
import MoveLeftButton from '/public/icons/arrow-left-no-line.svg'
import MoveRightButton from '/public/icons/arrow-right-no-line.svg'

interface CommunityPaginationProps {
  totalPages: number
}

export default function CommunityPostPagination({
  totalPages = 0,
}: CommunityPaginationProps) {
  const router = useRouter()
  const searchParams = useSearchParams()
  const selectedPage = Number(searchParams.get('page')) | 0
  const tabId = searchParams.get('tab') || 'total-post'

  const handleClickPrevBtn = () => {
    if (selectedPage <= 0) return
    router.replace(`/community?page=${selectedPage - 1}&tab=${tabId}`)
  }

  const handleClickNumBtn = (index: number) => {
    router.replace(`/community?page=${index}&tab=${tabId}`)
  }

  const handleClickNextBtn = () => {
    if (selectedPage + 1 >= totalPages) return
    router.replace(`/community?page=${selectedPage + 1}&tab=${tabId}`)
  }

  return (
    <div className="flex gap-7 py-5 mt-3 mb-10 justify-center items-center">
      {selectedPage !== 0 ? (
        <button onClick={handleClickPrevBtn} className="cursor-pointer">
          <MoveLeftButton />
        </button>
      ) : null}

      <div className="flex gap-2">
        {new Array(totalPages).fill(0).map((_, index) => {
          return (
            <button
              onClick={() => handleClickNumBtn(index)}
              key={index}
              className={`text-gray-700 text-base font-normal w-7 h-7 ${selectedPage === index ? 'bg-primary-400 text-white rounded-full' : 'bg-none hover:text-primary-400'}`}
            >
              {index + 1}
            </button>
          )
        })}
      </div>
      {selectedPage + 1 !== totalPages ? (
        <button onClick={handleClickNextBtn} className="cursor-pointer">
          <MoveRightButton />
        </button>
      ) : null}
    </div>
  )
}
