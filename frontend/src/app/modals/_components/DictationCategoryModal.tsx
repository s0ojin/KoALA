import Link from 'next/link'
import Icon from '/public/images/logo.svg'
import CloseBtn from '/public/icons/cancel-btn.svg'

const DICTATION_CATEGORY = [
  {
    id: 'daily',
    label: '일상',
    icon: <Icon />,
  },
  {
    id: 'administration',
    label: '행정',
    icon: <Icon />,
  },
  {
    id: 'education',
    label: '교육',
    icon: <Icon />,
  },
  {
    id: 'custom',
    label: '내가 등록한 문장',
    icon: <Icon />,
  },
]
export default function DictationCategoryModal() {
  return (
    <div className="relative w-[60rem] bg-white rounded-3xl p-12">
      <CloseBtn className="absolute w-6 right-8 top-8" />
      <p className="text-gray-900 text-2xl ml-4 mb-4">
        받아쓰기 주제를 선택해주세요.
      </p>
      <div className="grid grid-cols-2 gap-4">
        {DICTATION_CATEGORY.map((category) => (
          <Link
            href={`/dictation/?category=${category.id}`}
            key={category.id}
            className="flex flex-col justify-center items-center py-16 rounded-3xl border-4 border-primary-400"
          >
            <div className="w-40">{category.icon}</div>
            <p>{category.label}</p>
          </Link>
        ))}
      </div>
    </div>
  )
}
