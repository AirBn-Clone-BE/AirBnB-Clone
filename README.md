# 항해99 clone coding BACKEND

Airbnb clone coding

- https://www.airbnb.co.kr/

# Github
Frontend - https://github.com/Eunjin09/airbnb<br/><br/>
Backend  - https://github.com/AirBn-Clone-BE/AirBnB-Clone

# 서버 배포

- http://code10.shop.s3-website.ap-northeast-2.amazonaws.com/

## 팀원

FrontEnd

변희재 : 로그인, 회원가입, 헤더, 수정페이지, 게시글 삭제 기능<br/>
김은진 : 전체 숙소 목록 조회, 숙소 등록  <br/>
이영주 : 상세 페이지, 댓글 삭제, 등록 

BackEnd

진용희: 숙소 등록, 숙소 수정, 숙소 삭제, 숙소 전체 조회 관련 API<br/>
박건영: 로그인, 회원가입 관련 API<br/>
권도훈: 숙소 상세 조회, 댓글 등록, 삭제 관련 API


## 프로젝트 기간

22.06.17 ~ 22.06.23

## 시연 영상 및 접속 링크


<b> 시연 영상 </b><br/>
https://youtu.be/-UsameyX4Ls
<br/>


<b> 접속 링크 </b><br/>
http://code10.shop.s3-website.ap-northeast-2.amazonaws.com/
<h2>💻 기술 스택 </h2>

#### Server 
  <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=AmazonAWS&logoColor=white">

#### Framework
  <img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"> <img src="https://img.shields.io/badge/Springboot-6DB33F?style=for-the-badge&logo=Springboot&logoColor=white"> <img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=black">
  
#### Language
  <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"> 
  
#### Database
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">
  
#### Tool
  <img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white"> <img src="https://img.shields.io/badge/Git-00000?style=for-the-badge&logo=Git&logoColor=F05032]"/> <img src="https://img.shields.io/badge/Github-181717?style=for-the-badge&logo=Github&logoColor=white]"/>
  
## Frontend Tech
- React<br/>
- Redux<br/>
- Axios<br/>
- kakao map API<br/>
- react-daum-postcode<br/>
- Firebase Storage<br/>
- Styled-Components<br/>
- Tool : Git, Notion, Figma


## Backend Tech

- Spring Boot<br/>
- JPA<br/>
- MySQL<br/>
- AWS<br/>
- JWt
- Spring Security<br/>

## 주요 기능

- 회원가입 및 로그인, 로그아웃 (jwt)<br/>
- 로그인을 통해 인증된 유저만 서비스 이용가능 (숙소 등록, 댓글 등록)<br/>
- 유저가 본인의 글(숙소, 댓글)만 삭제, 수정가능<br/>
- 숙소 전체 조회 시 좌측에 숙소, 우측에 숙소가 마킹된 지도 구현


## Trouble Shooting

진용희:<br/>
api설계한 것과 맞추지 않아서 프론트엔드분들과 작업을 하거나 다른분들께 검사를 받을 때 수정을 했음.<br/><br/>

수정 및 삭제를 할 때 작성자만 가능하게 하기<br/>
>미리 이 부분을 해결하신 도훈님에게 도움을 받음 토큰을 활용하여 현재의 유저네임과 토큰에 저장된 작성자의 유저네임을 가져오고<br/>
if문을 통해 둘이 같다면 작업이 가능하고 아니라면 BAD_REQUEST를 보내서 작업을 못하게함.<br/><br/>

프론트에서 보내주는 True, False 값 저장하는 방법 몰랐음<br/>
>boolean으로 받아서 저장하고 가지고 올 때에도 다른 스트링 값과는 다르게 get이 아닌 is사용<this.wifi  = requestDto.isWifi();><br/>

권도훈:<br/>
1. 본인이 작성한 댓글에 한에서만 삭제, 수정 가능(토큰 활용 Authentication에서 Name에 해당되는 값을 가져옴)<br/><br/>
2. Timestamped 사용시 실행파일에 @EnableJpaAuditing 어노테이션 추가<br/><br/>
3.수정할 목록 불러올때 뒤에 orElseThrow 붙혀주기<br/>


박건영: <br/>
1. jwt와 스프링 시큐리티를 함께 이용하여 시큐리티에서 요청 설정 부분에 댓글 작성 API (/api/comment/{houseId})를 User권한을 가진(로그인한사용자)만 가능하게 설정을 해두었었는데,
댓글작성과 댓글 조회 api가 동일하여 배포후 테스트에서 댓글 조회가 로그인한 유저만 보이는 에러를 발견하였고, API 명세를 수정하여 댓글 조회 API를 /api/allcomment/{houseId} 로 변경하여
User권한 설정에 포함되지 않게 만들어 해결하였음.<br/><br/>

2. 중복 로그인을 방지하기 위한 로직을 만들어보기 위해 로그인시 db에 저장된 로그인한 사용자의 refreshToken값을 기준으로 로그인 상태를 판별하여 있으면 이미로그인한 상태, 없으면 로그인 성공으로
처리가 되게 하였으나, 기존에 로그인 할 때 생성된 refreshToken 삭제가 따로 되지 않고 계속해서 쌓이고 있어 이를 해결하기 위해 logout postmapping을 만들어 로그아웃시 해당 유저의 refreshToken을 삭제하게
만들어 해결하였음. 
