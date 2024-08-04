'use client'

import BasicModal from '@/app/modals/_components/BasicModal'
import { ModalLayout } from '@/app/modals/_components/ModalLayout'
import { useParams } from 'next/navigation'

export default function BasicModalPage() {
  const { type } = useParams()

  const renderModal = () => {
    switch (type) {
      case 'basic':
        return <BasicModal />
    }
  }

  return <ModalLayout>{renderModal()}</ModalLayout>
}
