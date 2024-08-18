import { getToken } from '@/app/utils/cookie/getToken'
import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export async function middleware(req: NextRequest) {
  const token = getToken()
  const publicPaths = ['/', '/login', '/sign-up']
  const isPublicPath = publicPaths.includes(req.nextUrl.pathname)
  const isFile = req.nextUrl.pathname.match(/\.(.*)$/)

  if (isFile) {
    return NextResponse.next()
  }

  if (isPublicPath && token) {
    return NextResponse.redirect(new URL('/main', req.url))
  }

  if (!isPublicPath && !token) {
    return NextResponse.redirect(new URL('/login', req.url))
  }

  return NextResponse.next()
}
