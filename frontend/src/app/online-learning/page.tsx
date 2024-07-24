import Header from './_components/header'
// import Cards from "./_components/cards"
import CardSlide from './_components/carousel/CardSlide'
import CardFlip from './_components/carousel/CardFlip'

export default function Main() {
  return (
    <>
      <Header
        title="화상 수업"
        description="한국인 강사와 함께 한국어를 즐겁게 배워보아요!"
      ></Header>
      <CardSlide />
    </>
  )
}
