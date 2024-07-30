import Image from 'next/image'
import Header from '@/app/_components/Header'
import MainLayout from '@/app/main/_components/MainLayout'
import EducationCardList from '@/app/main/_components/MainEducationCardList'
import MainKoalaLevel from '@/app/main/_components/MainKoalaLevel'
import EucalyptusButton from '@/app/main/_components/MainEucalyptusButton'

export default function Main() {
  return (
    <MainLayout>
      <div className="w-full h-auto min-h-main-height overflow-hidden relative select-none z-10 flex flex-col items-center">
        <Header />
        <div className="relative w-screen h-full min-h-main-height flex max-w-[93.75rem]">
          <div className=" w-2/5 h-1/2 min-h-[32rem] self-end ml-12 mb-8 relative flex items-end justify-center">
            <div className="absolute top-0 left-0">
              <EucalyptusButton eucalyptusCount={10} />
            </div>
            <div className="flex flex-col items-center w-full">
              <Image
                src="/images/koala-sleep.png"
                width={0}
                height={0}
                sizes="100%"
                className="w-[21.875rem] h-[21.875rem]"
                alt="코알라"
                draggable="false"
              />
              <MainKoalaLevel percent={50} />
            </div>
          </div>

          <div className="absolute right-0 top-1/3">
            <EducationCardList />
          </div>
        </div>
        <div className=" w-full h-full absolute top-[90%] left-24 -z-50">
          <Image
            src="/images/ground.png"
            width={0}
            height={0}
            sizes="100%"
            className="scale-[2] w-full"
            alt="바탕바닥"
            draggable="false"
          />
        </div>
      </div>
    </MainLayout>
  )
}
