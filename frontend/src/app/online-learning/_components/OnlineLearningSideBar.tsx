'use client'

import { ComponentType, useState } from 'react'
import OnlineLearningPanel from './OnlineLearningPanel'
import OnlineLearningTabList, { TabId } from './OnlineLearningTabList'
import { AnimatePresence } from 'framer-motion'
import OnlineLearningLectureNotePanel from './OnlineLearningLectureNotePanel'
import OnlineLearningHandoutPanel from './OnlineLearningHandoutPanel'
import OnlineLearningChatPanel from './OnlineLearningChatPanel'

const renderPanel = (activeTab: TabId): React.ReactNode => {
  switch (activeTab) {
    case 'lecture-note':
      return <OnlineLearningLectureNotePanel />
    case 'lecture-handout':
      return <OnlineLearningHandoutPanel />
    case 'lecture-chat':
      return <OnlineLearningChatPanel />
    default:
      return null
  }
}

export default function OnlineLearningSideBar() {
  const [activeTab, setActiveTab] = useState<TabId>('none')
  return (
    <div className="max-w-md h-screen overflow-clip">
      <OnlineLearningTabList
        activeTab={activeTab}
        setActiveTab={setActiveTab}
      />
      <AnimatePresence initial={false} mode={'wait'}>
        {activeTab !== 'none' && (
          <OnlineLearningPanel key={activeTab} activeTab={activeTab}>
            {renderPanel(activeTab)}
          </OnlineLearningPanel>
        )}
      </AnimatePresence>
    </div>
  )
}
