import Link from 'next/link'
import VideoIcon from '/public/icons/video-square.svg'
import Logo from '/public/images/logo.svg'

export default function OnlineLearningHeader() {
  return (
    <header className="fixed h-20 w-full z-50 px-9 flex items-center">
      <Link href="/online-learning">
        <h1 className="flex gap-2 text-primary-400">
          <VideoIcon className="w-6" />
          <Logo className="h-7" />
        </h1>
      </Link>
      <span className="p-3">|</span>
      <p className="text-primary-900 flex gap-2 items-end whitespace-nowrap">
        <span className="text-bold text-lg">{'한국어 문법 기초 가이드'}</span>
        <span className="leading-[1.65rem]">{'고동연'} 선생님</span>
      </p>
    </header>
  )
}
