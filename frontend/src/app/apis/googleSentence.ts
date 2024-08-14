'use server'
import * as textToSpeech from '@google-cloud/text-to-speech'
import fs from 'fs'
import util from 'util'

const option = {
  keyFilename: process.env.NEXT_GOOGLE_API_PATH,
}

export const getSpeech = async (inputText: string) => {
  const client = new textToSpeech.TextToSpeechClient(option)
  const request: textToSpeech.protos.google.cloud.texttospeech.v1.ISynthesizeSpeechRequest =
    {
      input: { text: inputText },
      voice: {
        languageCode: 'ko-KR',
        ssmlGender: 'MALE',
        name: 'ko-KR-Standard-D',
      },
      audioConfig: { audioEncoding: 'MP3' },
    }

  const [response] = await client.synthesizeSpeech(request)
  const audioContent = response.audioContent
  if (audioContent) {
    const base64Audio = Buffer.from(audioContent).toString('base64')
    return JSON.stringify({ blob: base64Audio })
  } else {
    throw new Error('Audio Content is undefined')
  }
}
