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

interface PostList {
  totalElements: number
  totalPages: number
  pageable: {
    pageNumber: number
    pageSize: number
    sort: { sorted: boolean; unsorted: boolean; empty: boolean }
    offset: number
    paged: boolean
    unpaged: boolean
  }
  sort: { sorted: boolean; unsorted: boolean; empty: boolean }
  first: boolean
  last: boolean
  number: number
  numberOfElements: number
  size: number
  content: PostListContent[]
}

interface PostListContent {
  title: string
  content: string
  nickname: string
  hit: number
  thumbnail: string
  board_id: number
  comment_num: number
  created_at: string
}

export default async function Community({ searchParams }: CommunityProps) {
  const currnetPage = searchParams.page || '0'
  const tab = searchParams.tab || 'total-post'
  const search = searchParams.search
  let postList: PostList | null = null

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
      <div className="w-full h-full max-w-[65rem] bg-white rounded-t-[3.75rem] pt-6 pb-5 px-14 min-h-screen">
        <div className="pb-3 mb-5 pt-9 flex justify-between px-8">
          <TabList />
          <SearchBar />
        </div>
        <div>
          {postList && postList?.content?.length > 0 ? (
            postList?.content?.map((post: any) => (
              <ListElement key={post.id} post={post} />
            ))
          ) : (
            <div className="flex justify-center">
              <p>게시글 내용이 없습니다</p>
            </div>
          )}
        </div>
        <div>
          {postList ? (
            <Pagination
              totalPages={postList?.totalPages}
              type={search ? 'search' : 'tab'}
            />
          ) : null}
        </div>
      </div>
    </div>
  )
}
