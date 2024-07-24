import OnlineLearingPanel from '@/app/online-learning/_components/OnlineLearningPanel'
import OnlineLearningTabList from '@/app/online-learning/_components/OnlineLearningTabList'

export default function OnlineLearningRoom() {
  return (
    <div className="flex gap-20 items-center h-screen">
      <div className="w-full h-[80%] ml-20 bg-gray-400 rounded-[3rem] overflow-hidden">
        <img src="https://images.unsplash.com/photo-1544168190-79c17527004f?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" />
      </div>
      <OnlineLearningTabList />
      <OnlineLearningPanel />
    </div>
  )
}
