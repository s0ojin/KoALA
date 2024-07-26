export default function Title ({...props}) {
  return (
    <header className="mt-28">
      <h1 className="text-center text-3xl text-gray-800 font-bold">
      {props.title}
      </h1>
      <p className="text-center mt-2 text-xl text-gray-800 font-medium">
        {props.description}
      </p>
    </header>
  )
}