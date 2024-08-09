import ReviewMenuButton from '@/app/review/_components/ReviewMenuButton'

export default function ReviewMenuButtons() {
  return (
    <div className="flex flex-col self-end mb-4">
      <ReviewMenuButton>재생</ReviewMenuButton>
      <ReviewMenuButton>읽고 따라 말하기</ReviewMenuButton>
      <ReviewMenuButton>받아쓰기</ReviewMenuButton>
      <ReviewMenuButton>삭제하기</ReviewMenuButton>
    </div>
  )
}
