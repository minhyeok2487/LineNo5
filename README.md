# LineNo5

## Server Package
  * Server.java 
  
    : 서버 실행시 python_MH폴더에 있는 랜덤 파일 하나 보낼준비
  * Client.java
  
    : 클라이언트 실행 시 서버에서 파일 하나 받음
      재생 프레임이 나오고 재생 버튼을 누르면 받은 파일재생
  * Receiver.java

    : 파일 수신 구현 클래스
  * FileSender.java

    : 파일 송신 구현 클래스
  * MusicOne.java

    : 음악 재생 클래스
  * Player.java

    : 클라이언트 프레임창
    
    
## Youtube Package
  * ReadTxt.java 

    : 정보가 저장된 txt파일을 불러와서 리스트로 저장
  * Wav.java

    : 음악 재생 클래스(연습)
  * WavPlayer.java

    : 음악 재생, 멈춤, 리셋 구현 클래스(연습)
  * YoutubeFrame.java

    : 음악 재생 프레임창(연습)

### 개선사항
  * 서버에서 음악파일 중복없이 랜덤으로 N개 클라이언트에 보내기
  * 클라이언트 닫으면 받아온 음악파일들 삭제
  * 음악 파일 1초 3초 나눠서 저장되게 구현

    
