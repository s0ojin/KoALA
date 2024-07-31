import AISpeakingBackgroundLayout from './_components/AISpeakingBackgroundLayout'
import AISpeakingSlider from './_components/AISpeakingSlider'

export default function AISpeakingMain() {
  return (
    <AISpeakingBackgroundLayout>
      <div className="h-screen">
        <AISpeakingSlider />
      </div>
    </AISpeakingBackgroundLayout>
  )
}
