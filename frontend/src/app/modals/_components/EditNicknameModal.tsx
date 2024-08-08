import { SubmitHandler, useForm } from 'react-hook-form'
import { patchEditUser } from '@/app/apis/auth'

interface EditNicknameFormValue {
  nickname: string
  password: string
}

export default function EditNicknameModal() {
  const {
    register,
    handleSubmit,
    formState: { isValid },
  } = useForm<EditNicknameFormValue>()

  const onSubmit: SubmitHandler<EditNicknameFormValue> = async (data) => {
    const payload = {
      nickname: data.nickname,
      password: data.password,
    }
    const res = await patchEditUser('/users/login', payload)
    console.log(res)
  }
  return (
    <div className="w-80 max-h-80 bg-white rounded-3xl flex flex-col justify-between items-center gap-10 px-8 py-10">
      <form
        onSubmit={handleSubmit(onSubmit)}
        className="w-full flex flex-col gap-2 px-4"
      >
        <input
          {...register('nickname', { required: true })}
          type="text"
          placeholder="새 닉네임"
          className="w-full rounded-full border outline-none px-4 py-2 text-sm"
        />
        <input
          {...register('password', { required: true })}
          type="password"
          placeholder="비밀번호"
          className="w-full rounded-full border outline-none px-4 py-2 text-sm"
        />
        <button
          type="submit"
          className={`submit-btn mt-6 text-base h-10 ${isValid ? 'bg-primary-400' : 'bg-gray-300'}`}
        >
          수정하기
        </button>
      </form>
    </div>
  )
}
