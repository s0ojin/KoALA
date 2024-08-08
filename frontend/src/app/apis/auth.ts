interface SignUpRequestBody {
  login_id: string
  password: string
  name: string
  nickname: string
}

interface LoginRequestBody {
  login_id: string
  password: string
}

export const postSignUp = async (payload: SignUpRequestBody) => {
  try {
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/users`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(payload),
    })

    if (!response.ok) {
      console.log(response)
    }
    const data = await response.json()
    return { data, status: response.status }
  } catch (error) {
    console.error('There was a problem with the fetch operation:', error)
  }
}

export const postLogin = async (payload: LoginRequestBody) => {
  try {
    const response = await fetch(
      `${process.env.NEXT_PUBLIC_BASE_URL}/users/login`,
      {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(payload),
      }
    )

    if (!response.ok) {
      console.log(response)
    }
    const data = await response.json()
    localStorage.setItem('accessToken', data.access_token)
    localStorage.setItem('refreshToken', data.refresh_token)
    return { data, status: response.status }
  } catch (error) {
    console.error('There was a problem with the fetch operation:', error)
  }
}
