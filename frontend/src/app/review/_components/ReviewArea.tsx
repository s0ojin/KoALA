import SearchBar from "@/app/review/_components/SearchBar"
import Filter from "@/app/review/_components/Filter"
import Sentence from "@/app/review/_components/Setence"

export default function ReviewArea () {
  return (
    <div className="flex flex-col bg-white w-[65rem] h-[48rem] rounded-[4rem] ml-[4rem] pl-[4rem] py-8">
      <div className="pr-[4rem] max-h-[7rem]">
        <div className="flex w-full h-12">
          <Filter />
          <SearchBar />
        </div>
        <hr className="bg-gray-200 my-[1.5rem] "/>
      </div>
      <div className="pr-8 h-[85%]">
        <div className="w-full h-full pr-7 overflow-auto">
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
          <Sentence />
        </div>
      </div>
      </div>
  )
}