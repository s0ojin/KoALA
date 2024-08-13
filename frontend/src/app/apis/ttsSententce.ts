import { ApiError } from '@/app/utils/customError'
import { getSpeech } from '@/app/apis/googleSentence';

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

export const getGoogleSpeech = async (text:string) => {
  const response = await getSpeech(text)
  const parsedres = await JSON.parse(response)
  const buff = await Buffer.from(parsedres.blob,'base64')
  const arraybuff = await buff.buffer.slice(buff.byteOffset, buff.byteOffset + buff.byteLength)
  return arraybuff
}