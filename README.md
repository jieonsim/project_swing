# 스윙 뮤직 플레이어 Swing Music Player 🎵
Java의 GUI Swing을 활용하여 개발한 음악 플레이리스트 애플리케이션입니다.<br>
음악 검색 및 나만의 플레이리스트 관리를 포함하여 다양한 음악 관련 기능을 제공합니다.

> 제작 기간 : 2024.03.26 - 2024.04.03 (8일)<br>
> 인원 : 1명 (개인 프로젝트)

💁🏻 [프로젝트 PPT - PDF로 바로보기](https://drive.google.com/file/d/1ji1Y0Lgr6wbg9w3NAPSZfyW6pGXSzo3u/view?usp=sharing)
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
| **Browse** | - 장르별로 등록되어있는 곡을 볼 수 있음 |
| **Search** | - 곡/ 앨범 / 아티스트별로 조건에 따른 검색 |
| **Playlists** | - 나만의 플레이리스트 생성 및 수정 <br> - 나만의 플레이리스트에 트랙 추가 <br> - 나만의 플레이리스트에 커버 이미지 추가 <br> - 좋아요 기능으로 즐겨찾기 플레이리스트에 트랙 추가 |
| **Library** | - 즐겨찾기와 나의 플레이리스트에 추가한 모든 트랙의 아티스트, 앨범, 곡별로 확인할 수 있음  |

</div>

<hr>

## 3️⃣ ERD

<div align="center">
  <img src="https://github.com/user-attachments/assets/185c96f5-d7d2-46a8-9c86-970583e23897" alt="스윙뮤직플레이어 ERD" width="70%">
</div>

<hr>

## 4️⃣ 기능별 화면 및 소개
### ✔ 메인 화면
- 로그인 전 : 둘러보기와 검색만 지원
- 로그인 후 : 둘러보기, 검색, 플레이리스트 및 라이브러리 관리 가능
- 로그인 후 로그인한 사용자의 이름 표기
  
| **로그인 전** | **로그인 후** |
|:---------------:|:---------------:|
| ![로그인전](https://github.com/user-attachments/assets/527f557f-8339-4360-9e37-15282f6825dc) | ![로그인후](https://github.com/user-attachments/assets/d68b1953-4f53-4967-808a-e6c7917ce331) |

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


### ✔ Browse
- Browse 메뉴 클릭 시 6개의 장르 버튼이 보임
- 장르 버튼 클릭 시 각 장르별 트랙리스트 확인 가능
- 로그인 후에는 트랙리스트에서 플레이리스트에 트랙 추가 가능

| **Browse 메뉴** | **Browse > 각 장르별 화면** |
|:---------------:|:---------------:|
| ![browse](https://github.com/user-attachments/assets/e10e2bc9-6710-42f7-a159-85000456ddb2) | ![각 장르별 화면](https://github.com/user-attachments/assets/6f67829e-d1ec-430b-9542-4b66d73676f5) |

### ✔ Search
- Search 메뉴 클릭 시 등록된 모든 트랙을 볼 수 있음
- 노래 제목, 아티스트 이름, 앨범명, 발매일로 조건 검색 가능
- 로그인 후에는 검색 후 플레이리스트에서 트랙 추가 가능

<div align="center">
  <img src="https://github.com/user-attachments/assets/8be4d721-efa0-40df-8233-af9507007d81" alt="search" width="70%">
</div>

### ✔ Playlists
- 회원가입 시 즐겨찾기 플레이리스트(Favorite Songs)는 자동으로 생성됨
- 나만의 플레이리스트(My playlist)는 New Playlist 버튼 클릭 후 생성 가능
- 나만의 플레이리스트 생성 후 플레이리스트 이름 설정 및 커버 이미지 업로드 가능

| **커버이미지 업로드 시도** | **커버이미지 업로드 성공** |
|:---------------:|:---------------:|
| ![커버이미지 업로드 시도](https://github.com/user-attachments/assets/f3afc908-9ed3-451e-920e-0a07e92d9b1f) | ![커버이미지 업로드 성공](https://github.com/user-attachments/assets/be429513-6a92-4856-b136-66c045d9389a) |

- Browse와 Search 트랙리스트에서 트랙 선택 후 하트 아이콘 클릭 시 Favorite Songs에 트랙 추가됨 / 음표 아이콘 클릭 시 My Playlist에 트랙이 추가됨
- My Playlist or Favorite Songs에서 트랙 선택 후 휴지통 아이콘 클릭 시 삭제됨
- My Playlist or Favorite Songs에서 노래 제목, 아티스트 이름 조건으로 검색 가능

| **플레이리스트에 트랙 추가** | **플레이리스트에서 트랙 삭제** |
|:---------------:|:---------------:|
| ![플레이리스트에 트랙 추가](https://github.com/user-attachments/assets/15312082-e355-4934-96ee-7a2e60bd5fe6) | ![플레이리스트에서 트랙 삭제](https://github.com/user-attachments/assets/3ac1c248-83b2-447d-ac01-fcd6153a2552) |

### ✔ Library
- 즐겨찾기와 나의 플레이리스트에 추가한 모든 트랙의 아티스트, 앨범, 곡별로 확인할 수 있음

<div align="center">
  <img src="https://github.com/user-attachments/assets/89e69630-9116-4745-a324-f5d3c97ff6dc" alt="Library" width="70%">
</div>
