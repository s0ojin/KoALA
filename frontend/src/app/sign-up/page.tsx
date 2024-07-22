'use client'

import { useForm } from 'react-hook-form'
import Logo from '/public/images/logo.svg'
import Link from 'next/link'

export default function SignUp() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors, isValid },
  } = useForm({ mode: 'onChange' })

  const onSubmit = (data) => {
    console.log(data)
  }

  return (
    <div className="bg-white max-w-[600px] mx-auto mt-24 py-10 px-24 flex flex-col items-center rounded-[60px]">
      <h1 className="text-center py-10">
        <Logo />
        <p className="text-primary-400 text-2xl font-medium">회원가입</p>
      </h1>

      <form
        onSubmit={handleSubmit(onSubmit)}
        className="w-full flex flex-col gap-4 mt-4 mb-14"
      >
        <div className="relative">
          <input
            id="id"
            type="text"
            placeholder=" "
            {...register('id', { required: '아이디는 필수입력 필드입니다.' })}
            className="input peer"
          />
          <label htmlFor="id" className="input-label">
            아이디
          </label>
          <p className="error-message">
            {errors.id && String(errors.id.message)}
          </p>
        </div>

        <div className="relative">
          <input
            id="password"
            type="password"
            placeholder=" "
            {...register('password', {
              required: '비밀번호는 필수입력 필드입니다.',
            })}
            className="input peer"
          />
          <label htmlFor="password" className="input-label">
            비밀번호
          </label>
          <p className="error-message">
            {errors.password && String(errors.password.message)}
          </p>
        </div>

        <div className="relative">
          <input
            id="passwordConfirm"
            type="password"
            placeholder=" "
            {...register('passwordConfirm', {
              required: '비밀번호 확인은 필수입력 필드입니다.',
              validate: (value) =>
                value === watch('password') ||
                '비밀번호 확인이 일치하지 않습니다.',
            })}
            className="input peer"
          />
          <label htmlFor="passwordConfirm" className="input-label">
            비밀번호 확인
          </label>
          <p className="error-message">
            {errors.passwordConfirm && String(errors.passwordConfirm.message)}
          </p>
        </div>
        <button
          type="submit"
          className={`submit-btn mt-6 ${isValid ? 'bg-primary-400' : 'bg-gray-300'}`}
          disabled={!isValid}
        >
          회원가입
        </button>
      </form>
      <p className="text-sm text-gray-400">
        이미 회원이신가요?{' '}
        <Link
          href="/login"
          className="ml-1 font-medium text-gray-500 hover:text-gray-700"
        >
          로그인
        </Link>
      </p>
    </div>
  )
}