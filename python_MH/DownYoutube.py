from pytube import YouTube
import glob
import os
import pandas as pd
from pydub import AudioSegment
import math

# 경로 설정
base_dir = 'C:/Users/Minhyeok/Desktop/Git/LineNo5/python_MH/audio/'
os.chdir(base_dir)

# 리스트 불러와서 가공하기 쉽게 데이터 프레임으로 생성
data = pd.read_csv('List.txt', sep = "\t",engine='python', encoding = "UTF-8")
sample_df = pd.DataFrame(data=data)
for number in range(len(sample_df)):
    par = sample_df.iloc[number, 0] # 유튜브 전용 인스턴스 생성
    yt = YouTube(par)
    yt.title = str(number) # 파일 이름을 노래 제목으로 지정
    yt.streams.filter(only_audio=True).all() # 유튜브 정보 가져오기
    yt.streams.filter(only_audio=True).first().download() # mp4 형식으로 유튜브 영상 다운
    mp4_file = base_dir + "{}.mp4".format(str(number)) # mp4 파일 선택
    wav_file = base_dir + "{}.wav".format(str(number)) # wav 파일 만들기
    cmd = "ffmpeg -i {} -vn {}".format(mp4_file, wav_file) # mp4를 wav로 변환
    os.system(cmd) # 실행
    os.remove(mp4_file) # mp4 파일 제거
    song = AudioSegment.from_wav("{}.wav".format(str(number))) # wav 파일 선택
    five_seconds = 5 * 1000 # 5초
    first_5_seconds = song[:five_seconds] # 앞부분 5초 자르기
    first_5_seconds.export("{}.wav".format(str(number)), format="wav") # wav파일 다시저장



