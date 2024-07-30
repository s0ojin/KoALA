import Image from "next/image"

export default function SearchBar () {
  return (
    <form className="flex w-full h-full rounded-[4.5rem] bg-gray-100">
      <Image
        src="/icons/search-normal.svg"
        alt=''
        width={24}
        height={24}
        className="mx-[1.25rem]"
      />
      <input type="text" className="focus:outline-none bg-gray-100 rounded-r-[4.5rem] pr-[1.5rem] text-xl grow">
      
      </input>
    </form>
  )
}