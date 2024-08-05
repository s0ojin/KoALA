import TabList from '@/app/community/_components/CommunityTabList'
import ListElement from '@/app/community/_components/CommunityListElement'
import SearchBar from '@/app/community/_components/CommunitySearchBar'
import Pagination from '@/app/community/_components/Pagination'

export default function Community() {
  return (
    <div className="flex flex-col items-center gap-5">
      <h1 className="text-primary-900 text-3xl font-medium ">커뮤니티</h1>
      <div className="w-full h-full max-w-[65rem] bg-white rounded-t-[3.75rem] pt-6 pb-5 px-14">
        <div className="pb-3 mb-5 pt-9 flex justify-between px-8">
          <TabList />
          <SearchBar />
        </div>
        <div>
          {new Array(8).fill(0).map((_) => {
            return <ListElement />
          })}
        </div>
        <div>
          <Pagination />
        </div>
      </div>
    </div>
  )
}
