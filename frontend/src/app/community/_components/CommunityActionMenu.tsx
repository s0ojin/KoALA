'use client'

import CommunityPostKebabMenu from '@/app/community/_components/CommunityPostKebabMenu'

export default function CommunityActionMenu() {
  const handleClickDeleteButton = () => {
    console.log('게시글 삭제 버튼을 눌렀습니다')
  }

  return (
    <div>
      <CommunityPostKebabMenu
        size={{ width: 24, height: 24 }}
        onClick={handleClickDeleteButton}
      />
    </div>
  )
}
