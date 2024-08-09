import { ApiError } from '@/app/utils/customError'

export interface SentenceContent {
  review_sentence_id: number
  sentence_id: number
  topic_category: string
  sentence_text: string
}

export const getReviewSentence = async (
  url: string,
  token: string | null
): Promise<any> => {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
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
  sentenceId: number,
  token: string | null
): Promise<any> => {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
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