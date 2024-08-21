# 스윙 뮤직 플레이어 Swing Music Player 🎵
Java의 GUI Swing을 활용하여 개발한 음악 플레이리스트 애플리케이션입니다.

> 제작 기간 : 2024.03.26 - 2024.04.03 (8일)<br>
> 인원 : 1명 (개인 프로젝트)

💁🏻 [프로젝트 PPT - PDF로 바로보기](https://drive.google.com/file/d/1BXjX4GY70YWGvCdDoUAcnf8aPOYZXByA/view?usp=sharing)
<br>

📹 [발표 영상 - YouTube로 바로보기](https://youtu.be/GG5udTdIjs4)

<hr>

## 1️⃣ 사용 기술 스택
<div align="left">
<img src="https://img.shields.io/badge/Java8-007396?style=flat-square&logo=OpenJDK&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/Eclipse-FE7A16?style=flat-square&logo=Eclipse&logoColor=white">
</div>
<hr>

## 2️⃣ 주요 기능
<div align="center">

| **기능 구분** | **세부 기능** |
|:---------------:|---------------|
| **회원**   | - 회원가입 <br> - 로그인 <br> - 아이디 찾기 <br> - 비밀번호 찾기 |
| **검색** | - 곡/ 앨범 / 아티스트별로 조건에 따른 검색 |
| **플레이리스트** | - 나만의 플레이리스트 생성 및 수정 <br> - 나만의 플레이리스트에 트랙 추가 <br> - 나만의 플레이리스트에 커버 이미지 추가 <br> - 좋아요 기능으로 즐겨찾기 플레이리스트에 트랙 추가 |

</div>

<hr>

## 3️⃣ 기능별 화면 및 소개
### ✔ 메인 화면
- 로그인 전 : 둘러보기와 검색만 지원
- 로그인 후 : 둘러보기, 검색, 플레이리스트 및 라이브러리 관리 가능
- 로그인 후 로그인한 사용자의 이름 표기
  
| **로그인 전** | **로그인 후** |
|:---------------:|:---------------:|
| ![로그인전](https://github.com/user-attachments/assets/527f557f-8339-4360-9e37-15282f6825dc) | ![로그인후](https://github.com/user-attachments/assets/1211cf9e-d35f-47c7-b9bc-83639e7be59a) |

### ✔ 회원가입 | 로그인 | 아이디 찾기 | 비밀번호 찾기
#### 1. 회원가입
- matches()를 이용한 정규식 체크
- 아이디 중복 체크
- 이름 + 휴대폰번호 조합으로 동일한 계정이 있는지 중복체크

#### 2. 로그인
- 로그인 시 사용자 고유번호 확인하여 세선 처리

#### 3. 아이디 찾기 | 비밀번호 찾기
- 이름 + 휴대폰 번호 조합으로 아이디 찾기
- 아이디 + 이름 + 휴대폰 번호 조합으로 비밀번호 찾기

| **회원가입** | **로그인** |
|:---------------:|:---------------:|
| ![회원가입](https://github.com/user-attachments/assets/9b1593ae-9ff7-4e50-bf31-38e84ffcade0) | ![로그인](https://github.com/user-attachments/assets/f3ec56d0-2c17-4049-9f67-2b6f3a0dc5e0) |

| **아이디 찾기** | **비밀번호 찾기** |
|:---------------:|:---------------:|
| ![아이디찾기](https://github.com/user-attachments/assets/10ed72e7-2714-4bd0-be68-bc078c7cc2d7) | ![비밀번호찾기](https://github.com/user-attachments/assets/582aa15e-ec14-4119-b909-a2074bdbec54) |
