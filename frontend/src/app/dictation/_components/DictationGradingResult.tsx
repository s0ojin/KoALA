import Image from 'next/image'
import Correct from '/public/icons/correct.svg'
import Wrong from '/public/icons/wrong.svg'
import parse from 'html-react-parser'

interface GradingResultProps {
  result: {
    correct: boolean
    origin_text: string
    user_text: string
    result_tag: string
  }
  idx: number
}

export default function DictationGradingResult({
  result: { correct, origin_text, user_text, result_tag },
  idx,
}: GradingResultProps) {
  function extractTextAndClasses(htmlString: any) {
    const container = document.createElement('div')
    container.innerHTML = htmlString

    const result: any = []

    function traverseNode(node: any) {
      if (node.nodeType === Node.TEXT_NODE) {
        // Extract text nodes including spaces
        const text = node.nodeValue
        result.push(...text.split('').map((char: any) => char))
      } else if (node.nodeType === Node.ELEMENT_NODE) {
        const tagName = node.tagName.toLowerCase()
        if (tagName === 'span') {
          const className = node.classname
          // console.log('node1', node)

          // console.log(node.className)

          if (className) {
            result.push(className)
          }
        } else {
          // console.log('node2', node)
          // For other tags, add text content normally
          node.childNodes.forEach((childNode: any) => traverseNode(childNode))
        }
      }
    }

    traverseNode(container)

    return result
  }

  // console.log(result_tag)
  const data = extractTextAndClasses(result_tag)
  // console.log(data)

  // const transform = (node) => {
  //   if (node.type === 'tag') {
  //     if (node.attribs && node.attribs.class) {
  //       node.attribs.className = node.attribs.class
  //       delete node.attribs.class
  //     }
  //   }
  //   return node
  // }

  return (
    <div className="flex flex-col gap-6 relative w-full">
      <p className="absolute -left-10 -top-5">
        {correct ? <Correct /> : <Wrong />}
      </p>
      <div className="flex items-center gap-4 text-2xl font-normal">
        <p>{idx}.</p>
        <p>{origin_text}</p>
      </div>
      {/* <p>유저가 쓴 내용: {user_text}</p> */}
      {/* <div className="text-2xl">{parse(result_tag, { transform })}</div> */}

      <div className="px-8 w-full">
        <div className="relative w-full py-2 bg-white border-t border-b border-primary-400 px-3">
          <div className="grid grid-cols-12">
            {new Array(36).fill(0).map((_, index) => (
              <div
                key={index}
                className="aspect-square border border-primary-400 flex justify-center items-center text-4xl text-center"
              >
                <p className="text-xl">{user_text.charAt(index)}</p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  )
}
