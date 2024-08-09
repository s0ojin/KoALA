import { ApiError } from '@/app/utils/customError'

const baseUrl = 'https://ko-ala.site/api'
const token =
  'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0amRndXMxMjM0IiwiYXV0aCI6IlJPTEVfdXNlciIsInR5cGUiOiJhY2Nlc3MiLCJleHAiOjE3MjMxNzU2MDN9.ygZqVmBT1Bzon0_8rn771wKHWZypUKsZMoh7YN8MDpY'

export interface SentenceContent {
  review_sentence_id: number
  sentence_id: number
  topic_category: string
  sentence_text: string
}

export const getReviewSentence = async (url: string): Promise<any> => {
  try {
    console.log(`${baseUrl}${url}`)
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

export const postReviewSentenceSave = async (
  url: string,
  sentenceId: number
): Promise<any> => {
  try {
    const response = await fetch(`${baseUrl}${url}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
      body: JSON.stringify({
        sentence_id: sentenceId,
      }),
    })
    if (!response.ok) {
      throw new ApiError(
        response.status,
        `Network response was not ok: ${response.status} ${response.statusText}`
      )
    }
  } catch (error: any) {
    console.error(error)
    throw error
  }
}
