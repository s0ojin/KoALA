import Image from 'next/image'
import Link from 'next/link'

export default function Card ({...props}) {

  if (props.variant === 'Back') {
    return (
      <div className="relative w-full h-full rounded-tl-3xl overflow-hidden shadow-mg">
        <div className='absolute w-full h-full'>
          <img 
            className='h-full object-cover blur-2xl' 
            src="https://res.cloudinary.com/amazingtalker/image/upload/c_fill,f_auto,q_auto:best,w_800/pages/apply-to-teach/job-description/feature-price.jpg"
            alt=""
          />
          {/* <Image src={Photo} alt="Lecture Card" className='w-full h-full object-cover blur-2xl' layout='fill'/> */}
        </div>
        <div className='relative bg-white rounded-tl-3xl mt-5 mx-5 md:pt-2 lg:pt-8 px-6 h-full'>
          <p className="text-gray-700 font-bold md:text-lg lg:text-xl text-center lg:mb-[1.5rem] md:mb-[0.5rem] break-words">
            {props.lecture}
          </p>
          <div className='w-full aspect-square overflow-hidden mb-[0.5rem]'>
            <p className="text-gray-700 md:text-sm lg:text-base overflow-hidden break-words">
              {props.description}
            </p>
          </div>
          <div className='flex text-primary-900 md:text-xs lg:text-sm md:mb-[0.5rem] lg:mb-[1.25rem]'>
            <p className='mr-2.5 font-medium'>수업일정</p>
            <p>{props.schedule}</p>
          </div>
          <Link href={`online-learning/${props.pagelink}`} className='max-w-[14rem] min-w-[10rem]'>
            <button className='bg-primary-400 w-full aspect-[5/1] rounded-3xl text-white font-bold md:text-sm lg:text-base'>
              강의 입장하기
            </button>
          </Link>
        </div>
      </div>
    )
  } else {
    return (
      <div className="w-full h-full bg-white rounded-tr-3xl overflow-hidden shadow-lg">
        <div className="w-full aspect-square object-cover">
          {/* <Image src={Photo} alt="Lecture Card" className='w-full h-full'/> */}
          <img 
            className='w-full h-full' 
            src="https://res.cloudinary.com/amazingtalker/image/upload/c_fill,f_auto,q_auto:best,w_800/pages/apply-to-teach/job-description/feature-price.jpg"
            alt=""
          />
        </div>
        <div className='m-auto py-[1.25rem]'>
          <p className="text-primary-900 font-medium text-xl text-center mb-2 mx-5 break-words truncate">
            {props.lecture}
          </p>
          <p className="text-primary-900 text-base text-center font-regular">
            {props.teacher}
          </p>
        </div>
      </div>
    )
  }

}