import Link from 'next/link'

export default function Home() {
  return (
    <h1>
      랜딩페이지 입니다!
      <Link
        href="/main"
        className="w-96 bg-primary-400 text-white p-4 rounded-full"
      >
        누르면 메인페이지로 이동합니다
      </Link>
    </h1>
  )
}