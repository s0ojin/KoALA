import { useForm } from 'react-hook-form'
import ChatSendBtn from '/public/icons/send.svg'

export default function OnlineLearningChatInput() {
  const {
    register,
    handleSubmit,
    formState: { isValid },
  } = useForm()
  const onSubmit = (data) => {
    console.log(
      'api연결 후 삭제될거지만 필요해서 console찍어놨어요 ㅠ이건 지우면 안되어요...',
      data
    )
  }
  return (
    <form
      onSubmit={handleSubmit(onSubmit)}
      className="flex justify-between w-full gap-1 p-5 h-32 rounded-3xl bg-gray-100"
    >
      <textarea
        {...register('chat', { required: true })}
        placeholder="메세지 보내기"
        className="bg-transparent w-full outline-none text-gray-900 resize-none"
      />
      <button
        type="submit"
        className={`text-gray-400 w-6 self-end ${isValid && 'text-primary-400'}`}
      >
        <ChatSendBtn />
      </button>
    </form>
  )
}
