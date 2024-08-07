export const postSignUp = async (): Promise<any> => {
  try {
    const payload = {
      login_id: 'dddd',
      password: '비밀번호',
      name: '이주형',
      nickname: '주업튀',
    }
    const response = await fetch(`${process.env.NEXT_PUBLIC_BASE_URL}/users`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(payload),
    })

    if (!response.ok) {
      console.log(response.status)
      throw new Error('Network response was not ok ' + response.statusText)
    }
    const data = await response.json()
    return data
  } catch (error) {
    console.error('There was a problem with the fetch operation:', error)
    throw error
  }
}
