import ReviewMenuButton from '@/app/review/_components/ReviewMenuButton'

export default function ReviewMenuButtons() {
  return (
    <div className="ml-[2rem] mt-3 h-full flex flex-col">
      <ReviewMenuButton>재생</ReviewMenuButton>
      <ReviewMenuButton>읽고 따라 말하기</ReviewMenuButton>
      <ReviewMenuButton>받아쓰기</ReviewMenuButton>
      <ReviewMenuButton>삭제하기</ReviewMenuButton>
    </div>
  )
}
