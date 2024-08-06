import Image from 'next/image'

export default function ReportRankingBoard() {
  return (
    <div className="relative w-full h-full bg-white rounded-2xl shadow-md">
      <div className="w-full h-1/2 bg-primary-50 rounded-t-2xl p-4">
        <p className="text-xl text-primary-400 mb-2.5">랭킹</p>
        <div className="w-[10rem] h-[10rem] bg-white rounded-full p-6 mx-auto">
          <Image
            src="/images/koala-front.png"
            alt="Koala"
            width={100}
            height={100}
            className="w-full h-auto"
          />
        </div>
      </div>
      <div className="absolute flex top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2 w-1/2 aspect-[3.5] bg-gradient-to-b from-yellow-300 to-yellow-500 rounded-full">
        <p className="m-auto text-center text-white text-xl">10,000위</p>
      </div>
      <div className="mt-9 px-3">
        <div className="inline-flex p-4 w-full">
          <div className="flex w-5 h-5 bg-gray-100 rounded-full my-auto border border-solid border-gray-200 mr-4">
            <p className="m-auto text-sm text-gray-500">1</p>
          </div>
          <div className="w-10 h-10 border border-solid border-gray-100 rounded-full mr-2">
            <Image
              src="/images/koala-front.png"
              alt="Koala"
              width={100}
              height={100}
              className="w-full h-auto rounded-full m-auto"
            />
          </div>
          <div className="flex flex-col justify-between">
            <p className="text-sm">코알라</p>
            <p className="text-gray-400 text-xs">코알라코알라코알라</p>
          </div>
        </div>
        <div className="inline-flex p-4 w-full">
          <div className="flex w-5 h-5 bg-gray-100 rounded-full my-auto border border-solid border-gray-200 mr-4">
            <p className="m-auto text-sm text-gray-500">2</p>
          </div>
          <div className="w-10 h-10 border border-solid border-gray-100 rounded-full mr-2">
            <Image
              src="/images/koala-front.png"
              alt="Koala"
              width={100}
              height={100}
              className="w-full h-auto rounded-full m-auto"
            />
          </div>
          <div className="flex flex-col justify-between">
            <p className="text-sm">코알라</p>
            <p className="text-gray-400 text-xs">코알라코알라코알라</p>
          </div>
        </div>
        <div className="inline-flex p-4 w-full">
          <div className="flex w-5 h-5 bg-gray-100 rounded-full my-auto border border-solid border-gray-200 mr-4">
            <p className="m-auto text-sm text-gray-500">3</p>
          </div>
          <div className="w-10 h-10 border border-solid border-gray-100 rounded-full mr-2">
            <Image
              src="/images/koala-front.png"
              alt="Koala"
              width={100}
              height={100}
              className="w-full h-auto rounded-full m-auto"
            />
          </div>
          <div className="flex flex-col justify-between">
            <p className="text-sm">코알라</p>
            <p className="text-gray-400 text-xs">코알라코알라코알라</p>
          </div>
        </div>
      </div>
    </div>
  )
}
