'use client'

import {
  TabId,
  tabList,
} from '@/app/online-learning/_components/OnlineLearningTabList'
import NotiIcon from '/public/icons/notification.svg'

interface OnlineLearningPanelProps {
  children: React.ReactNode
  tabId: TabId
}

export default function OnlineLearningPanel({
  children,
  tabId,
}: OnlineLearningPanelProps) {
  const activeTab = tabList.find((tab) => tab.id == tabId)
  return (
    <div className="bg-white w-[60rem] h-screen rounded-tl-[3rem] overflow-hidden shadow-lg">
      <div className="h-28 shadow-md p-6 flex flex-col justify-center">
        <h2 className="font-medium text-xl">{activeTab?.label}</h2>
        <div className="flex items-center gap-1">
          <NotiIcon width="24" height="24" />
          <p>{activeTab?.description}</p>
        </div>
      </div>
      {children}
    </div>
  )
}
