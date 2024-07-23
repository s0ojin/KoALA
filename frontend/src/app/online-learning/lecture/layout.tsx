import OnlineLearningNav from '@/app/online-learning/_components/OnlineLearningNav'

export default function OnlineLearningLayout({
  children,
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <div>
      <OnlineLearningNav />
      {children}
    </div>
  )
}
