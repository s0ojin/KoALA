'use client'

import { deletePost } from '@/app/apis/community'
import CommunityPostKebabMenu from '@/app/community/_components/CommunityPostKebabMenu'
import { useRouter } from 'next/navigation'

export default function CommunityActionMenu({
  nickname,
  postId,
}: {
  nickname: string
  postId: string
}) {
  const router = useRouter()
  const handleClickDeleteButton = async () => {
    const data = await deletePost(`/boards/${postId}`)

    if (data.status === 200) {
      router.replace('/community')
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
