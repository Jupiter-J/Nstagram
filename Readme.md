
# N스타그램
---
## 기술스택
<img src="https://img.shields.io/badge/SpringBoot-badge&logoColor=white"> <img src="https://img.shields.io/badge/JPA-E34F26?badge&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-FCC624?badge&logoColor=black"> <img src="https://img.shields.io/badge/SpringSecurity-4FC08D?badge&logoColor=white">



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

---
## ERD
1. 인스타그램에서 구독(팔로우) 기능
   * 유저 A는 여러명의 유저를 구독할 수 있다
   * 유저 A는 여러명의 유저로부터 구독을 받을 수 있다
   * 구독 기능은 다대다 관계로 ManyToMany 이다
2. 이미지 등록 관계
   * 유저는 여러개의 사진을 등록 할 수 있다. OneToMany
   * 이미지는 한명의 유저로부터 올려진다 ManyToOne
   * 이미지와 유저는 양방향 관계이다 


