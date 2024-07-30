import Image from "next/image"

export default function Sentence () {
  return (
    <div className="flex items-center w-full min-h-[4rem] max-h-[8rem] bg-gray-200 rounded-[4.5rem] mb-[0.75rem] px-[1.25rem]">
      <p className="grow mr-[1rem] my-[1.25rem]">
        안녕? 나는 이주형이라고 해 안녕? 나는 이주형이라고 해 안녕? 나는 이주형이라고 해rrrrrrrrrrrrrrrrrrrrrrrrrfasdfasdfasdfsdafasdf
      </p>
      <Image
        src='/icons/play.svg'
        alt=''
        width={24}
        height={24}
      />
    </div>
  )
}