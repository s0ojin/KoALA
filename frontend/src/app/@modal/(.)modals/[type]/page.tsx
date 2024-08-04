'use client'

import AddSentenceModal from '@/app/modals/_components/AddSentenceModal'
import BasicModal from '@/app/modals/_components/BasicModal'
import DictationCategoryModal from '@/app/modals/_components/DictationCategoryModal'
import { ModalLayout } from '@/app/modals/_components/ModalLayout'
import { useParams } from 'next/navigation'

export default function BasicModalPage() {
  const { type } = useParams()

  const renderModal = () => {
    switch (type) {
      case 'basic':
        return <BasicModal />
      case 'dictation-category':
        return <DictationCategoryModal />
      case 'add-sentence':
        return <AddSentenceModal />
    }
  }

  return <ModalLayout>{renderModal()}</ModalLayout>
}
