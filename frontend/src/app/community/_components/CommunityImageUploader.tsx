'use client'

import Image from 'next/image'
import Close from '/public/icons/close.svg'
import Add from '/public/icons/add.svg'
import { useState } from 'react'

interface ImageList {
  preview: string
  file: string
}

export default function CommunityImageUploader() {
  const [imageList, setImageList] = useState<ImageList[]>([])

  const handleChangeFile = (e: React.ChangeEvent<HTMLInputElement>) => {
    const file = e.target.files?.[0]
    if (file) {
      const preview = URL.createObjectURL(file)
      let nImageList = [...imageList]
      nImageList.push({
        preview,
        file: '',
      })
      setImageList(nImageList)
    }
  }

  const handleClickDeleteImageButton = (
    e: React.MouseEvent<HTMLButtonElement>,
    index: number
  ) => {
    e.preventDefault()
    let nImageList = [...imageList]
    nImageList.splice(index, 1)
    setImageList(nImageList)
  }

  return (
    <div className="flex gap-6">
      {imageList.map((image, index) => {
        return (
          <div key={index} className="relative inline-block">
            <button
              onClick={(e) => handleClickDeleteImageButton(e, index)}
              className="absolute -top-2 -right-2 shadow-lg bg-white rounded-full w-8 h-8 flex justify-center items-center"
            >
              <Close />
            </button>
            <Image
              src={image.preview}
              width={0}
              height={0}
              sizes="100%"
              className="w-24 h-24 aspect-square border rounded-lg"
              alt="image-preview"
              draggable={false}
            />
          </div>
        )
      })}
      {imageList.length < 5 ? (
        <div>
          <label
            htmlFor="file-upload"
            className="w-24 h-24 aspect-square border rounded-lg bg-gray-200 flex justify-center items-center cursor-pointer"
          >
            <Add />
          </label>
          <input
            id="file-upload"
            type="file"
            className="hidden"
            onChange={handleChangeFile}
          />
        </div>
      ) : null}
    </div>
  )
}
