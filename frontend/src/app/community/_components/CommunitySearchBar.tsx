'use client'

import Search from '/public/icons/search.svg'

export default function CommunitySearchBar() {
  const handleChangeSearchVal = (e: any) => {
    console.log(e.target.value)
  }
  return (
    <div className="w-96 items-center overflow-hidden rounded-full inline-flex bg-white border border-gray-400">
      <input
        onChange={handleChangeSearchVal}
        type="text"
        className="w-full py-2 px-5 outline-none "
      />
      <button className="pr-5">
        <Search />
      </button>
    </div>
  )
}
