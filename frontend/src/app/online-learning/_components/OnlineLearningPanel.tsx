'use client'

import {
  tabList,
  TabId,
} from '@/app/online-learning/_components/OnlineLearningTabList'
import NotiIcon from '/public/icons/notification.svg'

interface OnlineLearningPanelProps {
  activeTab: TabId
  children: React.ReactNode
}

export default function OnlineLearningPanel({
  activeTab,
  children,
}: OnlineLearningPanelProps) {
  const activeTabInfo = tabList.find((tab) => tab.id === activeTab)

  return (
    <div className="bg-white w-[52rem] h-screen rounded-tl-[3rem] overflow-hidden shadow-lg mr-20">
      <div className="h-28 shadow-md p-6 flex flex-col justify-center gap-1">
        <h2 className="font-medium text-xl">{activeTabInfo?.label}</h2>
        <div className="flex items-center gap-1">
          <NotiIcon width="24" height="24" />
          <p className="mx-2">{activeTabInfo?.description}</p>
        </div>
      </div>
      {children}
    </div>
  )
}
