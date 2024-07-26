'use client'

import { useState } from 'react'
import OnlineLearningPanel from './OnlineLearningPanel'
import OnlineLearningTabList, { TabId } from './OnlineLearningTabList'

export default function OnlineLearningSideBar() {
  const [activeTab, setActiveTab] = useState<TabId>('lecture-chat')
  return (
    <>
      <OnlineLearningTabList
        activeTab={activeTab}
        setActiveTab={setActiveTab}
      />
      <OnlineLearningPanel activeTab={activeTab}>
        <div>{activeTab === 'lecture-note' && <div>Note Content</div>}</div>
        <div>
          {activeTab === 'lecture-handout' && <div>Handout Content</div>}
        </div>
        <div>{activeTab === 'lecture-chat' && <div>Chat Content</div>}</div>
      </OnlineLearningPanel>
    </>
  )
}
