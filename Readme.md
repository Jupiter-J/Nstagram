
# N스타그램
---
## 기술스택
<img src="https://img.shields.io/badge/SpringBoot-badge&logoColor=white"> <img src="https://img.shields.io/badge/JPA-E34F26?badge&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-FCC624?badge&logoColor=black"> <img src="https://img.shields.io/badge/SpringSecurity-4FC08D?badge&logoColor=white"> <img src="https://img.shields.io/badge/RDS-003545?&logo&logoColor=white">




## 개발환경
* backend
  * java11
  * gradle (war)
  * spring-boot 2.5.3
* frontend
  * jsp
  * CSS
  * JavaScript

## 이론정리
* [CSRF 토큰이란?](https://velog.io/@jupiter-j/CSRF%ED%86%A0%ED%81%B0%EC%9D%B4%EB%9E%80)
* [UUID란?](https://velog.io/@jupiter-j/UUID%EB%9E%80-Universally-unique-identifier)
* [인스타그램 구독(팔로우) 쿼리공부 ]()


## 🧭 개발일지
### 2022-04-07 진행상황
* 개발 환경 세팅
* 스프링 시큐리티 초기 설정
### 2022-04-08 진행상황
* 스프링 시큐리티 403에러 [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-%EC%8A%A4%ED%94%84%EB%A7%81-%EC%8B%9C%ED%81%90%EB%A6%AC%ED%8B%B0-%EC%97%90%EB%9F%AC-403-404)
* 회원가입 구현 
* 롬복 log.info 주소값 반환 에러 [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%ACLombok-%EB%A1%AC%EB%B3%B5-log.info-%EC%A3%BC%EC%86%8C%EA%B0%92-%EB%B0%98%ED%99%98-%EC%97%90%EB%9F%AC)
### 2022-04-10 진행상황
* h2, mysql 데이터베이스 dialect 연결 에러 [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-%EB%8D%B0%EC%9D%B4%ED%84%B0%EB%B2%A0%EC%9D%B4%EC%8A%A4-table-doesnt-exist)
* 회원가입 제약조건 추가 (중복 username 방지, 제한 글자)
* 로그인 구현
* 회원정보 수정 구현
* 회원정보 수정 예외처리
### 2022-04-11 진행상황
* 구독(팔로우) 기능 구현
### 2022-04-12 진행상황
* 프로필 페이지 구현
* 이미지 등록 + 예외처리
* 이미지 렌더링
### 2022-04-13 진행상황
* 페이지 이동시 noSession 에러 [상세내용](https://velog.io/@jupiter-j/%EC%97%90%EB%9F%AC-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8-no-Session) 
* 업데이트한 게시물의 총 갯수 반영 구현
### 2022-04-14 진행상황
* 구독(팔로우) 서비스 API DB 에러 [상세내용](https://velog.io/@jupiter-j/DB-%EC%97%90%EB%9F%AC-Unknown-column-fromUserId-in-field-list) 
### 2022-04-15 진행상황
* 구독 수 증가값 반영 기능 (js, jsp)
* 구독 여부 확인 기능 (js, jsp)
* 구독자 정보 쿼리 

---
## 구현한 기능
1. [회원가입 & 로그인](#회원가입-&-로그인)
2. [사진 등록](#사진-등록)
3. [회원정보 변경](#회원정보-변경)
4. [다른 유저의 페이지 접속시 기능 변경](#다른-유저의-페이지-접속시-기능-변경)
5. [구독(팔로우) 기능 1](#구독(팔로우)-기능-1)
6. [구독(팔로우) 기능 2](#구독(팔로우)-기능-2)

<br/><br/>
### 회원가입 & 로그인
* 회원가입시 동일한 유저네임을 넣을 경우 에러 반환 

![login](https://user-images.githubusercontent.com/73453283/163678589-5701d4f7-767e-43b8-a147-145b2f0c2d72.gif)

<br/><br/>
### 사진 등록
* 이미지를 넣지 않을 경우 에러 반환
* 이미지는 UUID를 통해 고유 식별자 부여 
* 이미지 추가시 게시물 수 증가  

![upload](https://user-images.githubusercontent.com/73453283/163678622-7d60cab2-bc5c-4b89-a410-8a5a02706ae3.gif)
 
![image](https://user-images.githubusercontent.com/73453283/163676465-f876e503-76a2-44c9-a36b-4bd3b9ae45fb.png)

<br/><br/>
### 회원정보 변경
![edit](https://user-images.githubusercontent.com/73453283/163678644-367d942b-e5f7-42a0-826d-4698de8abf5b.gif)

<br/><br/>
### 다른 유저의 페이지 접속시 기능 변경
1. id = 1 Nstarsss 로그인한 유저
2. id = 2 new 다른 유저
3. 로그인한 유저가 id=2 유저의 페이지로 이동하였을 경우, 유저네임 옆의 기능이 바뀜
4. 로그인한 유저의 페이지 [사진등록]
5. 다른 유저의 페이지 [구독하기]
* user / { userid } 로 다른 유저의 페이지 이동 가능
* user / { userid } 에서 DB에 등록된 유저가 아니면 에러

![trans](https://user-images.githubusercontent.com/73453283/163678657-b5fa801b-1dfd-4c9b-aec6-2c62598c0364.gif)

<br/><br/>
### 구독 (팔로우) 기능 1
1. 로그인한 유저 id=1가 id=2 페이지에서 구독
2. 구독 정보 수 증가
3. 구독 정보 리스트에서 구독 취소 가능

![follow](https://user-images.githubusercontent.com/73453283/163678676-8e0b1cfb-e11b-413d-9c92-cb332b99ad52.gif)

<br/><br/>
### 구독 (팔로우) 기능 2
1. id=1 Nstarsss, id=2 new , id=3 love
2. 로그인한 유저 id=1가 id=2 유저의 페이지에서 구독 리스트를 확인
3. 만약 로그인한 유저를 구독한 상태면 [구독하기]가 뜨지 않는다
4. id=2가 구독한 리스트를 보고 id=3 구독 가능 
* 네이티브 쿼리와  qlrm를 사용하여 구현 

![subscribe](https://user-images.githubusercontent.com/73453283/163678690-f5696fca-fadc-415e-a472-ee3f9aced764.gif)
![image](https://user-images.githubusercontent.com/73453283/163678077-d89e1142-480b-4119-a17f-b44f78fda176.png)



<br/><br/>
## ERD 명세 
1. 인스타그램에서 구독(팔로우) 기능
   * 유저 A는 여러명의 유저를 구독할 수 있다
   * 유저 A는 여러명의 유저로부터 구독을 받을 수 있다
   * 구독 기능은 다대다 관계로 ManyToMany 이다
2. 이미지 등록 관계
   * 유저는 여러개의 사진을 등록 할 수 있다. OneToMany
   * 이미지는 한명의 유저로부터 올려진다 ManyToOne
   * 이미지와 유저는 양방향 관계이다 


