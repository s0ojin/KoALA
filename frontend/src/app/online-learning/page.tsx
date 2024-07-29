import Title from '@/app/online-learning/_components/Title'
// import Cards from "./_components/cards"
import CardSlide from './_components/carousel/CardSlide'
import Image from 'next/image'
import Header from '@/app/_components/Header'
import Cloud from '/public/images/cloud.svg'

export default function Main() {
  return (
    <>
      <div className='w-full h-full'>
        <Image src={Cloud} className="absolute top-[8rem] left-[9rem]"/>
        <Image src={Cloud} className='absolute top-[9rem] right-[1.5rem]'/>
      </div>
      <div className='relative m-auto'>
        {/* <Header/> */}
        <Title
          title="화상 수업"
          description="한국인 강사와 함께 한국어를 즐겁게 배워보아요!"
        />
        <CardSlide />
      </div>
    </>
  )
}
