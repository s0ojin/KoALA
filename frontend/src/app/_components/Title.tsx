interface TitleProps {
  CourseTitle: String
  CourseDescription: String
}

export default function Title({ CourseTitle, CourseDescription }: TitleProps) {
  return (
    <header className="mt-28">
      <h1 className="text-center text-3xl text-gray-800 font-bold">
        {CourseTitle}
      </h1>
      <p className="text-center mt-2 text-xl text-gray-800 font-medium">
        {CourseDescription}
      </p>
    </header>
  )
}
