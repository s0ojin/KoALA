import { getToken } from '@/app/utils/cookie/getToken'

interface CreateLectureNoteRequestBody {
  lecture_id: number
  note_title: string
  note_content: string
}

export const postCreateOpenViduSession = async (url: string) => {
  try {
    const accessToken = getToken()
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${accessToken}`,
      },
    })

    if (!response.ok) {
      console.log(response)
    }
    const data = await response.json()
    return { data: data.sesstion_id, status: response.status }
  } catch (error) {
    console.error('There was a problem with the fetch operation:', error)
  }
}

export const postCreateOpenViduConnection = async (url: string) => {
  try {
    const accessToken = getToken()
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${accessToken}`,
      },
    })

    if (!response.ok) {
      console.log(response)
    }
    const data = await response.json()
    return { data: data.token, status: response.status }
  } catch (error) {
    console.error('There was a problem with the fetch operation:', error)
  }
}

export const postCreateLectureNote = async (
  url: string,
  payload: CreateLectureNoteRequestBody
) => {
  try {
    const accessToken = getToken()
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${accessToken}`,
      },
      body: JSON.stringify(payload),
    })

    if (!response.ok) {
      console.log(response)
    }
    const data = await response.json()
    return { data: data, status: response.status }
  } catch (error) {
    console.error('There was a problem with the fetch operation:', error)
  }
}
