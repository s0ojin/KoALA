'use server'
import * as textToSpeech from '@google-cloud/text-to-speech'
import fs from "fs";
import util from "util";

const option = {
  keyFilename: "secret.json",
};

export async function getSpeech(inputText: string) {
  const client = new textToSpeech.TextToSpeechClient(option);
  const request: textToSpeech.protos.google.cloud.texttospeech.v1.ISynthesizeSpeechRequest =
    {
      input: { text: inputText },
      voice: { languageCode: "en-US", ssmlGender: "NEUTRAL" },
      audioConfig: { audioEncoding: "MP3" },
    };

  const [response] = await client.synthesizeSpeech(request);
  return response.audioContent
}

const requestAudioFile = async (inputText: string, setAudioCallback:(audio:AudioBufferSourceNode) => void) => {

  const client = new textToSpeech.TextToSpeechClient(option);
  const request: textToSpeech.protos.google.cloud.texttospeech.v1.ISynthesizeSpeechRequest =
    {
      input: { text: inputText },
      voice: { languageCode: "en-US", ssmlGender: "NEUTRAL" },
      audioConfig: { audioEncoding: "MP3" },
    };

  const [response] = await client.synthesizeSpeech(request);
  
  
  const audioContext = getAudioContext();

  const audioBuffer = await audioContext.decodeAudioData(response.audioContent);

  //create audio source
  const source = audioContext.createBufferSource();
  source.buffer = audioBuffer;
  source.connect(audioContext.destination);
  source.start();
  console.log("source : ", source);
  setAudioSource(source);
}

const getAudioContext = () => {
  AudioContext = window.AudioContext
  const audioContent = new AudioContext()
  return audioContent
}