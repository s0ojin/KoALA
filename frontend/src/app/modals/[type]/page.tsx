import AddSentenceModal from '@/app/modals/_components/AddSentenceModal'
import BasicModal from '@/app/modals/_components/BasicModal'
import ConfirmCancelModal from '@/app/modals/_components/ConfirmCancelModal'
import DictationCategoryModal from '@/app/modals/_components/DictationCategoryModal'
import EditNicknameModal from '@/app/modals/_components/EditNicknameModal'

export default function Modal({ params }: { params: { type: string } }) {
  const renderModal = () => {
    switch (params.type) {
      case 'basic':
        return <BasicModal />
      case 'confirm-cancel':
        return (
          <ConfirmCancelModal
            content="정말 탈퇴할거임?"
            buttonLabel="탈퇴하기"
          />
        )
      case 'dictation-category':
        return <DictationCategoryModal />
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
