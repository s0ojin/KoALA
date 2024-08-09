const token =
  'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ0ZXN0IiwiYXV0aCI6IlJPTEVfdXNlciIsInR5cGUiOiJhY2Nlc3MiLCJleHAiOjE3MjMxODYwNDB9.baX0sCzkK08KSjIy4lkKXdTYoVjo3luwuYPUBCKhsco'

export interface KoalaInfo {
  koala_exp: number
  koala_id: number
  koala_level: number
  koala_name: string
  koala_type: number
}

export const fetchKoalaInfo = async (url: string) => {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
    })

    if (!response.ok) {
      throw new Error('failed')
    }

    return response.json()
  } catch (e) {
    console.log(e)
  }
}

interface EditKoalaName {
  koala_name: string
}

export const editKoalaName = async (url: string, data: EditKoalaName) => {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
      method: 'PATCH',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
      body: JSON.stringify(data),
    })

    if (!response.ok) {
      throw new Error('Login failed')
    }

    const result = await response.json()

    return {
      status: response.status,
      ok: response.ok,
      result,
    }
  } catch (e) {
    console.log(e)
  }
}

export const feedKoala = async (url: string) => {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}${url}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': `Bearer ${token}`,
      },
    })

    if (!response.ok) {
      throw new Error('failed')
    }

    const result = await response.json()

    return {
      status: response.status,
      ok: response.ok,
      result,
    }
  } catch (e) {
    console.log(e)
  }
}
