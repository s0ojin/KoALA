import Image from 'next/image'

export default function MainEucalyptusButton({
  eucalyptusCount = 0,
}: {
  eucalyptusCount: number
}) {
  return (
    <div className="inline-block relative w-auto">
      <button className="bg-[#FFF8DA] w-24 h-24 rounded-full shadow-lg cursor-pointer">
        <Image
          src="/images/eucalyptus.png"
          width={0}
          height={0}
          sizes="100%"
          className="w-full h-full rounded-full border border-gray-100 "
          alt="유칼립투스"
          draggable="false"
        />
      </button>
      <span className="select-none cursor-pointer absolute -right-2 top-0 bg-[#FF7A7A] text-white text-sm h-8 aspect-square rounded-full flex justify-center items-center font-semibold">
        {eucalyptusCount}
      </span>
    </div>
  )
}
