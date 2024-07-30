import Image from "next/image"

export default function Filter () {
  return (
    <button className="w-[15rem] h-full bg-primary-400 rounded-[4rem] mr-[1rem]">
      <div className="flex p-[0.5rem]">
        <Image
          src='/images/koala-sleep.png'
          alt=''
          width={40}
          height={40}
        />
        <p className="text-white text-2xl m-auto">
          슈퍼 마켓
        </p>
      </div>
    </button>
  )
}