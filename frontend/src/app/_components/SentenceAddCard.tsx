import SentenceAddBtn from '/public/icons/plus-circle.svg'

export default function SentenceAddCard() {
  const handleAddSeuntence = () => {
    console.log('문장추가~')
  }

  return (
    <div className="w-full h-12 rounded-full bg-primary-400 text-white flex justify-between items-center px-4">
      <p>이 문장은 선생님이 강추하는 문장입니다.</p>
      <SentenceAddBtn
        onClick={handleAddSeuntence}
        className="w-8 cursor-pointer"
      />
    </div>
  )
}
