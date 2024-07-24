import Image from 'next/image'
import Link from 'next/link'
import Photo from '/public/images/logo.svg'

export default function Card ({...props}) {

  if (props.variant === 'Back') {
    return (
      <div className="relative bg-white w-full h-full rounded-tl-3xl overflow-hidden shadow-mg">
        <div className='absolute w-full h-full'>
          <img 
            className='w-full h-full object-cover blur-2xl' 
            src="https://res.cloudinary.com/amazingtalker/image/upload/c_fill,f_auto,q_auto:best,w_800/pages/apply-to-teach/job-description/feature-price.jpg"
            alt=""
          />
          {/* <Image src={Photo} alt="Lecture Card" className='w-full h-full object-cover blur-2xl' layout='fill'/> */}
        </div>
        <div className='absolute bg-white h-full rounded-tl-3xl mt-5 mx-5 pt-8 px-8'>
          <div className="text-gray-700 font-bold text-xl text-center mb-[1.5rem]">
            {props.lecture}
          </div>
          <div>
            <p className="text-gray-700 text-base h-[11rem]">
              {props.description}
            </p>
          </div>
          <div className='flex text-primary-900 text-sm mb-[1.25rem]'>
                <p className='mr-2.5 font-medium'>수업일정</p>
                <p>{props.schedule}</p>
          </div>
          <Link href={`online-learning/${props.pagelink}`} className='m-auto'>
            <button className='bg-primary-400 w-[14rem] h-[2.5rem] rounded-3xl text-white font-bold'>
              강의 입장하기
            </button>
          </Link>
        </div>
      </div>
    )
  } else {
    return (
      <div className="bg-white rounded-tr-3xl overflow-hidden shadow-lg">
        <div className="w-full h-80">
          {/* <Image src={Photo} alt="Lecture Card" className='w-full h-full'/> */}
          <img 
            className='w-full h-full' 
            src="https://res.cloudinary.com/amazingtalker/image/upload/c_fill,f_auto,q_auto:best,w_800/pages/apply-to-teach/job-description/feature-price.jpg"
            alt=""
          />
        </div>
        <div className="px-6 py-4">
          <div className="text-primary-900 font-medium text-xl text-center mb-2">
            {props.lecture}
          </div>
          <p className="text-primary-900 text-base text-center font-regular">
            {props.teacher}
          </p>
        </div>
      </div>
    )
  }

}