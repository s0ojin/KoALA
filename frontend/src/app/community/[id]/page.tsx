import BackBtn from '/public/icons/next-btn.svg'
import View from '/public/icons/view.svg'
import Comment from '/public/icons/comment.svg'
import CommunityLayout from '@/app/community/_components/CommunityLayout'
import CommunityCarousel from '@/app/community/_components/CommunityCarousel'
import CommnunityComment from '@/app/community/_components/CommunityComment'
import CommunityActionMenu from '@/app/community/_components/CommunityActionMenu'
import { getConvertedTime } from '@/app/utils/getConvertedTime'

const dummy = {
  boardId: 1,
  title: '점심 메뉴',
  content:
    '미안하다 이거 보여주려고 어그로끌었다.. 장터국밥 훈제오리김치볶음밥 싸움수준 ㄹㅇ실화냐? ',
  nickname: '싸피짱',
  commentNum: 2,
  likeCount: 0,
  viewCount: 15,
  createdAt: '2024-07-30T09:05:03',
  comments: [
    {
      commentId: 1,
      content: '댓글test1',
      nickname: '싸피짱',
      createdAt: '2024-07-30T10:54:22',
    },
    {
      commentId: 2,
      content: '댓글test2',
      nickname: '싸피짱',
      createdAt: '2024-07-30T10:54:44',
    },
  ],
}

export default function CommunityDetail() {
  return (
    <CommunityLayout>
      <div className="mt-32 mb-16">
        <div className="flex justify-end px-8 mb-3">
          <button className="bg-gray-500 text-white py-2 px-12 rounded-full">
            목록
          </button>
        </div>

        <div className="pt-16 pb-14 bg-white max-w-[65rem] w-full px-11 rounded-[3.75rem] mb-5 relative">
          <button className="absolute top-7 left-7 scale-x-[-1]">
            <BackBtn fill={'#77a3ef'} className="w-10" />
          </button>
          <div className=" flex flex-col px-12 border-b-2 border-gray-300">
            <h3 className="text-2xl font-normal py-3 whitespace-nowrap">
              {dummy.title}
            </h3>
            <div className="flex justify-between py-5 bg-white whitespace-nowrap gap-5">
              <p className="text-base text-gray-700">{dummy.nickname}</p>
              <div className="flex gap-6 items-center">
                <div className="flex items-center gap-1">
                  <View width={16} height={16} />
                  <p className="text-gray-700 text-xs">
                    조회 {dummy.viewCount}
                  </p>
                </div>
                <div className="flex items-center gap-1">
                  <Comment width={16} height={16} />
                  <p className="text-gray-700 text-xs">
                    댓글 {dummy.commentNum}
                  </p>
                </div>
                <p className="text-gray-700 text-xs">
                  {getConvertedTime(dummy.createdAt)}
                </p>
                <CommunityActionMenu />
              </div>
            </div>
          </div>

          <div className="px-12 relative mb-24">
            <CommunityCarousel />
            <p>{dummy.content} </p>
          </div>

          <CommnunityComment commentList={dummy.comments} />
        </div>

        <div className="flex justify-between px-8">
          <button className="bg-primary-400 text-white py-2 px-10 rounded-full">
            글쓰기
          </button>
          <button className="bg-gray-500 text-white py-2 px-10 rounded-full">
            목록
          </button>
        </div>
      </div>
    </CommunityLayout>
  )
}
