import Image from 'next/image'
import Link from 'next/link'
import { CardDataProps } from '@/app/online-learning/_components/carousel/OnlineLearningLectureCardSlide'

interface CardProps extends CardDataProps {
  cardVariant: string
}

export default function OnlineLearningLectureCard({ ...cardData }: CardProps) {
  const {
    cardVariant,
    cardLectureTitle,
    cardLectureDescription,
    cardLectureTeacher,
    cardLectureSchedule,
    cardLectureSessionID,
  } = cardData

  if (cardVariant === 'Back') {
    return (
      <div className="relative w-full h-full rounded-tl-3xl overflow-hidden shadow-mg">
        <div className="absolute w-full h-full">
          <img
            className="h-full object-cover blur-2xl"
            src="https://res.cloudinary.com/amazingtalker/image/upload/c_fill,f_auto,q_auto:best,w_800/pages/apply-to-teach/job-description/feature-price.jpg"
            alt="Lecture Card"
          />
          {/* <Image
            src=""
            alt="Lecture Card"
            width={0}
            height={0}
            className="w-full h-full object-cover blur-2xl"
          /> */}
        </div>
        <div className="relative bg-white rounded-tl-3xl h-full mt-5 mx-5 px-6 md:pt-2 lg:pt-6">
          <p className="text-gray-700 font-bold break-words text-center md:truncate md:text-lg md:mb-[0.5rem] lg:text-xl lg:mb-[1rem]">
            {cardLectureTitle}
          </p>
          <div className="w-full aspect-square overflow-hidden mb-[0.5rem]">
            <p className="text-gray-700 overflow-hidden break-words md:text-sm lg:text-base">
              {cardLectureDescription}
            </p>
          </div>
          <div className="flex text-primary-900 md:text-xs lg:text-sm md:mb-[0.5rem] lg:mb-[1.25rem]">
            <p className="mr-2.5 font-medium">수업일정</p>
            <p>{cardLectureSchedule}</p>
          </div>
          <Link
            href={`online-learning/lecture/${cardLectureSessionID}`}
            className="max-w-[14rem] min-w-[10rem]"
          >
            <button className="bg-primary-400 w-full aspect-[5/1] rounded-3xl text-white font-bold md:text-sm lg:text-base">
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
          <img
            className="w-full h-full"
            src="https://res.cloudinary.com/amazingtalker/image/upload/c_fill,f_auto,q_auto:best,w_800/pages/apply-to-teach/job-description/feature-price.jpg"
            alt="Lecture Card"
          />
          {/* <Image
              src=""
              alt="Lecture Card"
              width={0}
              height={0}
              className="w-full h-full"
            /> */}
        </div>
        <div className="m-auto py-[1.25rem]">
          <p className="text-primary-900 font-medium text-xl text-center mb-2 mx-5 break-words truncate">
            {cardLectureTitle}
          </p>
          <p className="text-primary-900 text-base text-center font-regular">
            {cardLectureTeacher}
          </p>
        </div>
      </div>
    )
  }
}
