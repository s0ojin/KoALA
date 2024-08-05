'use client'

import AddSentenceModal from '@/app/modals/_components/AddSentenceModal'
import BasicModal from '@/app/modals/_components/BasicModal'
import ConfirmCancelModal from '@/app/modals/_components/ConfirmCancelModal'
import DictationCategoryModal from '@/app/modals/_components/DictationCategoryModal'
import { ModalLayout } from '@/app/modals/_components/ModalLayout'
import { useParams } from 'next/navigation'

export default function ModalPage() {
  const { type } = useParams()

  const renderModal = () => {
    switch (type) {
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
    }
  }

  return <ModalLayout>{renderModal()}</ModalLayout>
}
