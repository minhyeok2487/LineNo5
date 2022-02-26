# LineNo5
### 실행법 : Main클래스 -> gameServer -> Main 
### 현재 자신의 ip로 서버 열고 게임시작 가능(1인멀티)
### 2022_02_22 리팩토링 작업 진행중 싱글완료
### 2022_02_26 리팩토링 작업 진행중 멀티완료

# 2022_02_3까지 작업한 GUI
## 1. 메인화면
![01](https://user-images.githubusercontent.com/76654360/151514062-cec0e935-dec5-4767-bb2e-a54ebca71ad8.jpg)
  * 플레이버튼 클릭시 다음 화면으로 넘어감

## 2. 선택화면
![02](https://user-images.githubusercontent.com/76654360/151514145-558a90bb-3182-4ed4-b84e-18d69086f530.jpg)
  * 싱글 플레이 난이도 3개와 멀티 플레이 선택화면

## 3. 싱글 게임 화면(구현중)
![image](https://user-images.githubusercontent.com/76654360/152303822-9da3b317-9ef0-4c16-9904-4d91474b86a4.png)
![image](https://user-images.githubusercontent.com/76654360/152303862-5e74632e-2bcc-4cbb-8437-551f438eed5a.png)
  * 왼쪽 상단 재생 버튼 누르면 랜덤으로 음악재생 (2022_02_03 추가)
  * 힌트, 넥스트 버튼 작동(2022_02_03 추가)

    
# 2022_02_03 수정사항
 * 갑작스럽게 파이썬 pytube가 오류뜨면서 작동이 안됨 ('nonetype' object has no attribute 'span')
 * List.txt에 있는 링크를 따로 mp3형식으로 하나씩 저장 -> 파이썬으로 1초 5초 10초로 각각 폴더 나누어서 저장
 * 추후 음악 추가시, List.txt에 링크, 제목, 가수 적고 mp3파일을 따로 다운로드받은 후 파이썬 파일 실행하면 각각 폴더에 저장됨.
 * 싱글 게임 화면을 따로 프레임 생성

# 2022_02_04 수정사항
 * 힌트, 넥스트 버튼 누르고 다른 싱글게임 누르면 카운트 초기화
 * View패키지 정리
 * 멀티 게임 화면 구현
![image](https://user-images.githubusercontent.com/76654360/152489100-b98f89db-e4d1-40a6-92dd-1cb9252ccf93.png)


# 2022_02_07 수정사항
 * 싱글 - 힌트 버튼누르면 힌트 보임, 정답 카운트 추가, 타이머 추가
 * 싱글 - 다음버튼누르거나 정답을 맞추면 가운데 사진이 정답 사진으로 교체
 * 멀티 - 화면 UI 위치 수정
![image](https://user-images.githubusercontent.com/76654360/152748830-6c831a11-5955-4227-9986-3d1227f80b59.png)
![image](https://user-images.githubusercontent.com/76654360/152748892-fb37e5a8-f20a-490c-8226-8c3a7f81ef24.png)
![image](https://user-images.githubusercontent.com/76654360/152748973-1706abed-4d1c-4548-b4b4-539fa6a6ce34.png)

# 2022_02_08 수정사항
 * 임시 로그인 기능 추가(test아이디 하나있음)
 * 싱글 - 가운데 사진 정답사진 교체 삭제(이스터에그로 넣음)
 * 싱글 - 정답입력시 맞추면 넘어가고 점수 +1, 몰라서 다음 버튼 누르면 다음노래로 넘어감
 * 노래 중복되서 재생되는거 수정됨
 * "N초후 시작합니다" 따로 프레임 안만들고 메인프레임에 넣음

 [수정할 내용]
 1. 타이머 시간초 표시 추가
 2. 한번 했던 노래 중복으로 나오는거 수정
 3. 노래 맞췄을 때 맞췄다는걸 표현했으면 좋겠음
![image](https://user-images.githubusercontent.com/76654360/152946903-4fdb9b56-3a85-4b38-9d86-7194453d10e1.png)
![image](https://user-images.githubusercontent.com/76654360/152946295-6a46b3d9-0197-46cb-a105-b22cac618bf8.png)

# 2022_02_09 수정사항
 * 싱글 - 넥스트버튼 or 정답 맞출 때 힌트창 초기화
 * 싱글 - 오답 입력 시 힌트창 초기화
 * 노래 중복 제거
 * 타이머 종료되면 노래 게임 종료
 * "N초후 시작합니다" 옆 GIF 추가
 ![image](https://user-images.githubusercontent.com/76654360/153159567-52d4f95a-55bb-4364-945b-d59dd1ee9778.png)

# 2022_02_14 수정사항
 * 싱글 - 설정 버튼 누를 시 음량조절 패널 
![image](https://user-images.githubusercontent.com/76654360/153828838-e55e235c-5035-48cb-890b-30cf0da94768.png)

# 2022_02_15 수정사항
 * 싱글 - 결과 프레임 추가 및 오류 수정
 * 게임 실행 중 오른쪽 상단 종료 버튼 클릭시 타이머 계속 돌아가서 결과창이 출력됨 - 수정 완료
 * 싱글 결과 프레임 오른쪽 상단 종료 버튼 클릭시 파이널 프레임 배경음악 안꺼짐 - 수정 완료
 * 파이널 프레임 버튼 이미지 개선
 * 게임 재시작시 게임 볼륨이 계속해서 기본볼륨으로 시작됨 - 수정 완료
 ![image](https://user-images.githubusercontent.com/76654360/154022798-8d8fbb02-6461-4413-ae03-6591cbe1d941.png)

# 2022_02_16 멀티 프레임 통합 후 수정사항 예정
~~1. (멀티) 정답을 보내면 기존 재생되는 노래가 멈춰야되는데 멈추지 않음~~ 

   ~~-> 싱글에서 작업한것과 비슷하게 하면 될것같기도~~
   

2. (멀티) 모두 레디버튼 눌러서 시작하면 시작했다고 뜨게


   -> 추가하기
   
~~3. (멀티) 음량 조절 추가~~


   ~~-> 싱글에서 따오기~~
   
~~4. (멀티) 게임 시작 전 플레이 버튼은 필요없지않나?~~


   ~~-> 회색 파일하나 만들어서 조건문 추가하기~~
   
5. (멀티) 클라이언트 종료 후 다시 실행시 게임이 실행되지 않음


   -> 모름
   
~~6.  (멀티) 서버가 안열려있으면 멀티, 업데이트 눌렀을 때 서버가 안열려있다는 알림~~


~~8. (싱글, 멀티)정답 맞추면 정답 맞췄다고 표시~~


   ~~-> 멀티는 채팅창에 뜸 싱글만 추가하면 될듯~~

8. (메인) 서버 프레임 필요
9. (메인) 업데이트 기능 구현
