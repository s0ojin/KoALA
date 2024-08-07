import SearchIcon from '/public/icons/search-normal.svg'

export default function SearchBar() {
  return (
    <form className="flex w-full h-full rounded-[4.5rem] bg-gray-100">
      <SearchIcon width={24} height={24} className="mx-[1rem] my-auto" />
      <input
        type="text"
        className="focus:outline-none bg-gray-100 rounded-r-[4.5rem] pr-[1.5rem] text-xl grow"
      ></input>
    </form>
  )
}
