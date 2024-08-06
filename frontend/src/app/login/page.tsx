'use client'

import AuthLayout from '@/app/_components/AuthLayout'
import Link from 'next/link'
import Logo from '/public/images/logo.svg'
import { useForm } from 'react-hook-form'

export default function Login() {
  const {
    register,
    handleSubmit,
    watch,
    formState: { errors, isValid },
  } = useForm({ mode: 'onChange' })

  const onSubmit = (data) => {
    console.log(
      'api연결 후 삭제될거지만 필요해서 console찍어놨어요 ㅠ이건 지우면 안되어요...',
      data
    )
  }

  return (
    <AuthLayout>
      <div className="relative bg-white w-full max-w-[600px] mx-auto py-10 px-24 flex flex-col items-center rounded-[60px]">
        <h1 className="py-10 flex flex-col items-center text-center">
          <Logo width="210" height="56" />
          <p className="text-primary-400 font-medium">
            한글을 한글답게
            <br /> 더 쉽게 한국어를 배워보세요^^
          </p>
        </h1>

        <form
          onSubmit={handleSubmit(onSubmit)}
          className="w-full flex flex-col gap-4 mt-4 mb-14"
        >
          <div className="relative">
            <input
              id="id"
              type="id"
              placeholder=" "
              {...register('id', {
                required: '아이디는 필수입력 필드입니다.',
              })}
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
          <button
            type="submit"
            className={`submit-btn mt-6 ${isValid ? 'bg-primary-400' : 'bg-gray-300'}`}
            disabled={!isValid}
          >
            로그인
          </button>
        </form>
        <p className="text-sm text-gray-400">
          아직 회원이 아니신가요?
          <Link
            href="/sign-up"
            className="ml-1 font-medium text-gray-500 hover:text-gray-700"
          >
            회원가입
          </Link>
        </p>
      </div>
    </AuthLayout>
  )
}
