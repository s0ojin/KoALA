import AddSentenceModal from '@/app/modals/_components/AddSentenceModal'
import BasicModal from '@/app/modals/_components/BasicModal'
import ConfirmCancelModal from '@/app/modals/_components/ConfirmCancelModal'
import DictationModal from '@/app/modals/_components/DictationModal'
import EditNicknameModal from '@/app/modals/_components/EditNicknameModal'

export default function Modal({ params }: { params: { type: string } }) {
  const renderModal = () => {
    switch (params.type) {
      case 'basic':
        return (
          <BasicModal
            imageSrc="/images/astronaut.png"
            content="커뮤니티에서는 '한글'만 써주세요"
            hightlight="한글"
          />
        )
      case 'confirm-cancel':
        return (
          <ConfirmCancelModal
            content="정말 탈퇴할거임?"
            buttonLabel="탈퇴하기"
          />
        )
      case 'dictation-category':
        return <DictationModal />
      case 'add-sentence':
        return <AddSentenceModal />
      case 'edit-nickname':
        return <EditNicknameModal />
    }
  }

  return (
    <div className="flex h-main-screen justify-center items-center">
      {renderModal()}
    </div>
  )
}
