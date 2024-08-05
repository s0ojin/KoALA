import CommunityTabList from './_components/CommunityTabList'
import Element from './_components/Element'
import CommunitySearchBar from './_components/CommunitySearchBar'
import Pagination from './_components/Pagination'

export default function Community() {
  return (
    <div className="flex flex-col items-center gap-5 mt-20">
      <div className="flex w-full justify-center">
        <h1 className="text-primary-900 text-3xl font-medium">커뮤니티</h1>
      </div>
      <div className="max-w-[65rem] w-full bg-white rounded-t-[3.75rem] pt-6 pb-5 px-14">
        <div className="pb-3 mb-5 pt-9 flex justify-between px-8">
          <CommunityTabList />
          <CommunitySearchBar />
        </div>
        <div>
          {new Array(8).fill(0).map((_, index) => {
            return <Element />
          })}
        </div>
        <div>
          <Pagination />
        </div>
      </div>
    </div>
  )
}
