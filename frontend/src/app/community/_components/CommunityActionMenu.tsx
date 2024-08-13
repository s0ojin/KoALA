'use client'

import { deletePost } from '@/app/apis/community'
import CommunityPostKebabMenu from '@/app/community/_components/CommunityPostKebabMenu'

export default function CommunityActionMenu({
  nickname,
  postId,
}: {
  nickname: string
  postId: string
}) {
  const handleClickDeleteButton = async () => {
    const data = await deletePost(`/boards/${postId}`)

    if (data.status === 200) {
      alert('게시글 삭제 버튼을 클릭했습니다')
    }
  }

  return (
    <div>
      <CommunityPostKebabMenu
        size={{ width: 24, height: 24 }}
        onClick={handleClickDeleteButton}
        nickname={nickname}
      />
    </div>
  )
}
