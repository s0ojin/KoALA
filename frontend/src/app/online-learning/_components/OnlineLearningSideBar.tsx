'use client'

import { useState } from 'react'
import OnlineLearningPanel from './OnlineLearningPanel'
import OnlineLearningTabList, { TabId } from './OnlineLearningTabList'
import { AnimatePresence } from 'framer-motion'
import OnlineLearningLectureNotePanel from './OnlineLearningLectureNotePanel'
import ChatBubble from '@/app/_components/ChatBubble'
import OnlineLearningChatInput from './OnlineLearningChatInput'

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
            <>
              {activeTab === 'lecture-note' && (
                <OnlineLearningLectureNotePanel />
              )}
            </>
            <div>
              {activeTab === 'lecture-handout' && <div>Handout Content</div>}
            </div>
            <div>
              {activeTab === 'lecture-chat' && (
                <div>
                  <ChatBubble /> <OnlineLearningChatInput />
                </div>
              )}
            </div>
          </OnlineLearningPanel>
        )}
      </AnimatePresence>
    </div>
  )
}
