import { ApiError } from '@/app/utils/customError'

const baseUrl = 'http://localhost:8080/api'
const token =
  'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiYXV0aCI6IlJPTEVfdXNlciIsInR5cGUiOiJhY2Nlc3MiLCJleHAiOjE3MjMwMzU5OTJ9.obCLvipxBGdvh00mp-TKIN9RwXo-6Bea3bBk3jVEWso'

interface SortOption {
  empty: boolean
  unsorted: boolean
  sorted: boolean
}

interface CommentContent {
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

interface GetPost {
  id: string
}

export const getPost = async (payload: GetPost) => {
  try {
    const response = await fetch(
      `${baseUrl}/boards/${payload.id}/comments?page=0&size=10`,
      {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`,
        },
      }
    )

    if (!response.ok) {
      throw new ApiError(
        response.status,
        `Network response was not ok: ${response.status} ${response.statusText}`
      )
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
