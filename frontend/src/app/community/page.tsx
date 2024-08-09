import TabList from '@/app/community/_components/CommunityTabList'
import ListElement from '@/app/community/_components/CommunityListElement'
import SearchBar from '@/app/community/_components/CommunitySearchBar'
import Pagination from '@/app/community/_components/CommunityPostPagination'
import { getPostList } from '../apis/community'

interface CommunityProps {
  searchParams: {
    page?: string
    tab?: string
    search?: string
  }
}

export default async function Community({ searchParams }: CommunityProps) {
  const currnetPage = searchParams.page || '0'
  const tab = searchParams.tab || 'total-post'
  const search = searchParams.search
  let postList = null

  if (tab === 'total-post') {
    postList = await getPostList(`/boards?page=${currnetPage}&size=10`)
  } else if (tab === 'popular-post') {
    postList = await getPostList(
      `/boards/sorted-by-hit?page=${currnetPage}&size=10`
    )
  } else if (tab === 'my-post') {
    postList = await getPostList(
      `/boards/my-content?page=${currnetPage}&size=10`
    )
  }

  if (search) {
    postList = await getPostList(
      `/boards/search?keyword=${search}&page=${currnetPage}&size=10`
    )
  }

  return (
    <div className="flex flex-col items-center gap-5">
      <h1 className="text-primary-900 text-3xl font-medium">커뮤니티</h1>
      <div className="w-full h-full max-w-[65rem] bg-white rounded-t-[3.75rem] pt-6 pb-5 px-14">
        <div className="pb-3 mb-5 pt-9 flex justify-between px-8">
          <TabList />
          <SearchBar />
        </div>
        <div>
          {postList?.content?.length > 0 ? (
            postList?.content?.map((post: any) => (
              <ListElement key={post.id} post={post} />
            ))
          ) : (
            <p>No posts available.</p>
          )}
        </div>
        <div>
          <Pagination
            totalPages={postList?.totalPages}
            type={search ? 'search' : 'tab'}
          />
        </div>
      </div>
    </div>
  )
}
