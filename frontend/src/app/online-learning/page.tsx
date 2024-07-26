import Title from '@/app/online-learning/_components/Title'
// import Cards from "./_components/cards"
import CardSlide from './_components/carousel/CardSlide'
import Cloud from '/public/images/cloud.svg'

export default function Main() {
  return (
    <>
      <Title
        title="화상 수업"
        description="한국인 강사와 함께 한국어를 즐겁게 배워보아요!"
      ></Title>
      <CardSlide />
    </>
  )
}
