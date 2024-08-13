import { ApiError } from '@/app/utils/customError'

export const getWebSpeech = (text:string, onStartCallback: () => void, onEndCallback: () => void) => {
  let voices:SpeechSynthesisVoice[] = [];

  const setVoiceList = () => {
    voices = window.speechSynthesis.getVoices();
  };

  setVoiceList();

  if (window.speechSynthesis.onvoiceschanged !== undefined) {
    window.speechSynthesis.onvoiceschanged = setVoiceList;
  }

  const speech = (txt:string) => {
    const lang = "ko-KR";
    const utterThis = new SpeechSynthesisUtterance(txt);
    utterThis.lang = lang;
    const kor_voice = voices.find(
      (elem) => elem.lang === lang || elem.lang === lang.replace("-", "_")
    );
    if (kor_voice) {
      utterThis.voice = kor_voice;
    } else {
      return;
    }
    utterThis.onstart = onStartCallback
    utterThis.onend = onEndCallback
    window.speechSynthesis.speak(utterThis);
  };

  speech(text);
};

export function stopWebSpeech() {
    window.speechSynthesis.cancel()
}