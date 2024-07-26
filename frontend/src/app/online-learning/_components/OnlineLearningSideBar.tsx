'use client'

import { useState } from 'react'
import OnlineLearningPanel from './OnlineLearningPanel'
import OnlineLearningTabList, { TabId } from './OnlineLearningTabList'
import { AnimatePresence } from 'framer-motion'

export default function OnlineLearningSideBar() {
  const [activeTab, setActiveTab] = useState<TabId>('lecture-chat')
  return (
    <div className="overflow-hidden">
      <OnlineLearningTabList
        activeTab={activeTab}
        setActiveTab={setActiveTab}
      />
      <AnimatePresence initial={false} mode={'wait'}>
        <OnlineLearningPanel key={activeTab} activeTab={activeTab}>
          <div>{activeTab === 'lecture-note' && <div>Note Content</div>}</div>
          <div>
            {activeTab === 'lecture-handout' && <div>Handout Content</div>}
          </div>
          <div>{activeTab === 'lecture-chat' && <div>Chat Content</div>}</div>
        </OnlineLearningPanel>
      </AnimatePresence>
    </div>
  )
}
