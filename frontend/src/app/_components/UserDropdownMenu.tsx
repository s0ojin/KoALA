import Image from 'next/image'
import Link from 'next/link'
import LectureNoteIcon from '/public/icons/notebook.svg'
import ReportIcon from '/public/icons/graph.svg'
import LogoutIcon from '/public/icons/logout.svg'
import EditIcon from '/public/icons/edit-pencil.svg'

const USER_DROPDOWN_MENU_LIST = [
  { id: 'lecture-note', label: '강의노트', icon: <LectureNoteIcon /> },
  { id: 'report', label: '학습 리포트', icon: <ReportIcon /> },
  { id: 'logout', label: '로그아웃', icon: <LogoutIcon /> },
]

export default function UserDropdownMenu() {
  return (
    <div className="absolute p-6 pb-4 w-60 bg-white top-20 right-10 rounded-3xl text-primary-900 shadow-md">
      <header className="flex gap-3 items-center mb-4">
        <Image
          src="/images/koala-sleep.png"
          width={100}
          height={100}
          alt="profile"
          className="rounded-full w-12"
        />
        <div>
          <div className="flex items-center gap-2">
            <p>한국어마스터</p>
            <EditIcon className="w-4" />
          </div>
          <p className="text-primary-400 text-sm">Lv.4</p>
        </div>
      </header>
      <ul className="flex flex-col gap-2">
        {USER_DROPDOWN_MENU_LIST.map((item, idx) => (
          <>
            {idx === USER_DROPDOWN_MENU_LIST.length - 1 && <hr />}
            <li key={item.id} className="py-2">
              <Link
                href={`/${item.id}`}
                className="text-gray-700  flex gap-3 hover:text-gray-900"
              >
                <div className="w-6">{item.icon}</div>
                <p>{item.label}</p>
              </Link>
            </li>
          </>
        ))}
      </ul>
    </div>
  )
}
