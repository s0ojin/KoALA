import OnlineLearningSideBar from '../../_components/OnlineLearningSideBar'

export default function OnlineLearningRoom() {
  return (
    <div className="items-center pr-20 h-main-screen">
      <div className="max-w-[calc(100vw-5rem)] mx-20 h-[90%] bg-gray-400 rounded-[3rem] overflow-hidden">
        <img
          className="object-cover"
          src="https://images.unsplash.com/photo-1544168190-79c17527004f?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
        />
      </div>
      <OnlineLearningSideBar />
    </div>
  )
}
