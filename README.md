# DogLover

<div align="center">
<img width="200" src="https://user-images.githubusercontent.com/13285280/222105778-ced212ab-280b-42a2-8436-ac76054e52f9.png">
</div>

안녕하세요. 'DogLover'의 Server 페이지입니다!

# 기술스택
- Server
  - Java 1.8
  - SpringBoot 2.7
  - JPA
  - Spring Data JPA
  - JWT
  - Junit 5
  - gradle
- Database
  - H2
- Git
- Swagger 2.9

# 필수 미션 및 추가 미션
- 필수 미션
  1) [*완료*] API 개발
  2) [*완료*] RDB(H2) 선택
  3) [*완료*] JPA로 Table 생성 후, /resources/data.sql 데이터 생성
  4) [*완료*] Java 1.8 버전 사용
- 추가 미션
  1) [*완료*] 사용자 Password 암호화
  2) 입력 데이터 유효성 검증
  3) 데이터 무결성, 조회 속도 향상 설계
  4) [*완료*] Swagger 적용
  5) UI 개발
  6) [*완료*] 추가기능 : JWT

# ERD
<div align="center">
<img src="https://user-images.githubusercontent.com/13285280/222106382-0eee7e02-45bd-4469-aaf3-f04c337f4c74.png">
</div>

# 구현 일지
- Entity 추가(User, Boardmap, Board, Reply) : `commit` [16371da](https://github.com/sunnynote/doglover/commit/16371da67d1faf8ccff9690c8fa40adc0213b5e7)
- JPA Auditing 사용하여 등록, 수정 시간 자동화 : `commit` [ceb146f](https://github.com/sunnynote/doglover/commit/ceb146f59282ec7cc23d36ae1188b36f4e23951a)
- 로그인을 위한 Spring Security 적용 : `commit` [39c8dc2](https://github.com/sunnynote/doglover/commit/39c8dc29704d6063b0fa8f18b7f49d4b0f4201e9)
- User
  - 회원가입, 로그인 API 구현 : `commit` [6f61b7c](https://github.com/sunnynote/doglover/commit/6f61b7c9e3742723b4688ddf6e355219533879d1)
  - 회원 정보 수정 API 구현 : `commit` [9c476f2](https://github.com/sunnynote/doglover/commit/9c476f2da3a3adb2093e04da30c483d181f3d7c4)
  - 회원 탈퇴 API 구현 : `commit` [553201b](https://github.com/sunnynote/doglover/commit/553201b471849d169f04f42d574a74e98dbebf4a)
- Boardmap
  - 게시판 추가 API 구현 : `commit` [06045bf](https://github.com/sunnynote/doglover/commit/06045bfcaf58131a92bb36d79431bbd84fb6fc30)
  - 게시판 삭제 API 구현 : `commit` [59ef84b](https://github.com/sunnynote/doglover/commit/59ef84b776c515514754b8882da04be34613e86b)
  - 게시판 전체 조회 API 구현 : `commit` [8a9cf01](https://github.com/sunnynote/doglover/commit/8a9cf014303d819fa914d3f46074f2ac8221039a)
  - 게시판 수정 API 구현 : `commit` [1156b63](https://github.com/sunnynote/doglover/commit/1156b636670abfb6d69f780c4f15f5b99597e223)
- Board
  - 게시물 추가 API 구현 : `commit` [137ba01](https://github.com/sunnynote/doglover/commit/137ba01f633c8b4fb50096de772f22cb41e3188b)
  - 게시물 전체 조회 API 구현 : `commit` [0e870a8](https://github.com/sunnynote/doglover/commit/0e870a8ea05da0f7016bd85b7c40a706aa98c4d3)
  - 게시물 개별 조회 API 구현 : `commit` [360a841](https://github.com/sunnynote/doglover/commit/360a841a73a56e401104ccc67279a690fd396827)
  - 게시물 수정 API 구현 : `commit` [ee13aca](https://github.com/sunnynote/doglover/commit/ee13acac64160f467d7dfa575ee50befcc0471b4)
  - 게시물 삭제 API 구현 : `commit` [765fd3e](https://github.com/sunnynote/doglover/commit/765fd3e3b3f05e58b02068fde7761ea249440130)
- Reply
  - 댓글 추가 API 구현 : `commit` [f93c743](https://github.com/sunnynote/doglover/commit/f93c743bc034aeb25b5915afbe7ca7539ffc6ac5)
  - 선택한 게시물의 댓글 개별 조회 API 구현 : `commit` [89eb9e5](https://github.com/sunnynote/doglover/commit/89eb9e558063b263805c4b8b6dd70f08a1c86822)
  - 댓글 삭제 API 구현 : `commit` [c55e2ad](https://github.com/sunnynote/doglover/commit/c55e2ad4e768ef822adfc53ef7c66e3d9f0e2a02)
- 테스트 코드 작성 : `commit` [d581984](https://github.com/sunnynote/doglover/commit/d581984fe5d428fc18ace6c2c62bfa3d931de102) / [6a79433](https://github.com/sunnynote/doglover/commit/6a7943366230a978851b77fc3db0701d045128a1) / [345c324](https://github.com/sunnynote/doglover/commit/345c324c1b95b5ae793f8445a296d011256f7a8a)

# 실행 화면


# 아쉬운 점
- UI 개발
- 테스트 코드 작성
- 권한 관리


# 마치며