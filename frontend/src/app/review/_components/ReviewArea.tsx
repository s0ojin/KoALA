import SearchBar from "@/app/review/_components/SearchBar"
import Filter from "@/app/review/_components/Filter"
import Sentence from "@/app/review/_components/Setence"

export default function ReviewArea () {
  return (
    <div className="absolute bg-white w-[65rem] h-full rounded-[4rem] ml-[4rem] px-[4.5rem] pt-[2rem]">
      <div className="relative flex w-full h-[4rem]">
        <Filter />
        <SearchBar />
      </div>
      <hr className="bg-gray-200 my-[1.5rem]"/>
      <div>
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
        <Sentence />
        <Sentence />
        <Sentence />
        <Sentence />
        <Sentence />
        <Sentence />
      </div>
    </div>
  )
}