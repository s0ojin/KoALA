import Image from 'next/image'
import Photo from '/public/images/logo.svg'

export default function Card ({...props}) {
  return (
    <div className="bg-white max-w-80 rounded-[24px] overflow-hidden shadow-lg">
      <div className="w-full h-80">
        <Image src={Photo} alt="Lecture Card" className='w-full'/>
      </div>
      <div className="px-6 py-4">
        <div className="text-gray-700 font-bold text-xl text-center mb-2">
          {props.lecture}
        </div>
        <p className="text-gray-700 text-base text-center">
          {props.teacher}
        </p>
      </div>
    </div>
  )
}