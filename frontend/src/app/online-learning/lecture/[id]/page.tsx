import OnlineLearningSideBar from '../../_components/OnlineLearningSideBar'

export default function OnlineLearningRoom() {
  return (
    <div className="flex items-center h-screen pr-20">
      <div className="w-full h-[80%] mx-20 bg-gray-400 rounded-[3rem] overflow-hidden transition-flex-grow ">
        <img src="https://images.unsplash.com/photo-1544168190-79c17527004f?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" />
      </div>
      <OnlineLearningSideBar />
    </div>
  )
}
