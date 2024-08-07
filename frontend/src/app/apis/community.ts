import { ApiError } from '@/app/utils/customError'

const baseUrl = 'http://localhost:8080/api'
const token =
  'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiYXV0aCI6IlJPTEVfdXNlciIsInR5cGUiOiJhY2Nlc3MiLCJleHAiOjE3MjMwNzI2MjZ9.w-LhcXwd5efd42vMbB7ETj7B5kOsopdjJUmTBhTpv_c'
interface SortOption {
  empty: boolean
  unsorted: boolean
  sorted: boolean
}

export interface CommentContent {
  commentId: number
  content: string
  createdAt: string
  nickname: string
}

export interface CommunityComment {
  content: CommentContent[]
  empty: boolean
  first: boolean
  last: boolean
  number: number
  numberOfElements: number
  pageable: {
    offset: number
    pageNumber: number
    pageSize: number
    paged: boolean
    sort: SortOption
    unpaged: boolean
  }
  size: number
  sort: SortOption
  totalElements: number
  totalPages: number
}

interface Post {
  boardId: number
  title: string
  content: string
  nickname: string
  commentNum: number
  likeCount: number
  viewCount: number
  createdAt: string
  comments: CommunityComment
  boardImages: string[]
}

export const getPost = async (url: string): Promise<any> => {
  try {
    const response = await fetch(`${baseUrl}${url}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
    })

    if (!response.ok) {
      throw new ApiError(
        response.status,
        `Network response was not ok: ${response.status} ${response.statusText}`
      )
    }

    const data = await response.json()
    return data
  } catch (error: any) {
    console.error(error)
    throw error
  }
}

interface PostPostComment {
  comment_content: string
}

export const postPostComment = async (
  boardId: string,
  payload: PostPostComment
) => {
  try {
    const response = await fetch(`${baseUrl}/boards/${boardId}/comments`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
      body: JSON.stringify(payload),
    })

    if (!response.ok) {
      if (response.status === 400) {
        throw new ApiError(
          response.status,
          `Network response was not ok: ${response.status} ${response.statusText}`
        )
      }
    }

    const data = await response.json()
    return { data, error: null }
  } catch (error: any) {
    console.error(error)
    return {
      data: null,
      error: {
        message: error,
        status: error.status,
      },
    }
  }
}

export const postPost = async (url: string, data: FormData) => {
  console.log(data)
  const response = await fetch(`${baseUrl}${url}`, {
    method: 'POST',
    headers: {
      Authorization: `Bearer ${token}`,
    },
    body: data,
  })

  console.log(response)
}
