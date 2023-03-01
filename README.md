# DogLover

<div align="center">
<img width="400" src="https://user-images.githubusercontent.com/13285280/222105778-ced212ab-280b-42a2-8436-ac76054e52f9.png">
</div>

안녕하세요. 'DogLover'의 Server 페이지입니다!<br>
애견을 좋아하는 사람이라면 모두 환영합니다!
- 사용자는 회원가입을 할 수 있습니다.
- 사용자는 로그인을 할 수 있습니다.
- 로그인 한 사용자는 게시판을 추가, 수정, 삭제할 수 있습니다.
- 로그인 한 사용자는 게시판에 게시물을 추가, 수정, 삭제할 수 있습니다.
- 로그인 한 사용자는 모든 게시물에 댓글을 추가할 수 있습니다.


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
### 개발 기간 : 2023.02.26 ~ 2023.03.01
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
Server 실행 후 `Postman, H2`로 API 작동 확인

- 초기 Database

|  Table   |  Database 상태                                                                                                                  |
|:--------:|-------------------------------------------------------------------------------------------------------------------------------|
|   User   | <img width="600" src="https://user-images.githubusercontent.com/13285280/222120352-a94b6e38-3177-40d7-be4b-04913dd140c0.png"> |
| Boardmap | <img width="600" src="https://user-images.githubusercontent.com/13285280/222120539-ed027589-3fcb-417f-baf1-92f2281a9c11.png"> |
|  Board   | <img width="600" src="https://user-images.githubusercontent.com/13285280/222120749-5985e975-20d7-4028-ab09-b2d2bc1bdf29.png"> |
|  Reply   | <img width="600" src="https://user-images.githubusercontent.com/13285280/222120835-493e355f-10fa-4e74-b1f7-e69e01d7a155.png"> |

- User

|      API       | Postman으로 실행                                                                                                                                                                       | API 실행 후 H2 Database 상태                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
|:--------------:|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|     `회원가입`     | <img width="400" src="https://user-images.githubusercontent.com/13285280/222121427-2d1aaed9-7911-4259-9339-b45ccacdf5a0.png">                                                      | <img width="500" src="https://user-images.githubusercontent.com/13285280/222121749-dbfa129f-541e-45eb-9582-859c537c7f96.png">                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|     `로그인`      | <img width="400" src="https://user-images.githubusercontent.com/13285280/222139900-d6acf23d-a64c-4ac7-9021-921b2d5ae23f.png">                                                      | 로그인에 성공하면 token 반환<br><img width="500" src="https://user-images.githubusercontent.com/13285280/222140033-d0d89971-236a-4fc1-b74a-4abf728530b3.png">                                                                                                                                                                                                                                                                                                                                                                                                                                  |
|    `정보 수정`     | nickname을 `doglover`로 변경<br/><img width="400" src="https://user-images.githubusercontent.com/13285280/222125319-2d2f6561-3a64-40d9-a267-dc17c44d07c9.png">                         | <img width="500" src="https://user-images.githubusercontent.com/13285280/222129582-5bf692c8-a343-4880-b534-1e45829e6367.png">                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
|    `회원 탈퇴`     | 모든 API 실행 후 마지막에 탈퇴 API 실행<br>USER_NO=1로 로그인 후 탈퇴<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222138323-2793bd0f-efde-4a20-8bdb-bbedfe69361c.png"> | USER_NO=1 삭제<br><img width="500" src="https://user-images.githubusercontent.com/13285280/222138590-a15ae0f8-e210-457a-a75e-04e94fa2c301.png"><br>연관된 BOARDMAP, BOARD, REPLY 모두 삭제<br><img width="500" src="https://user-images.githubusercontent.com/13285280/222138734-d5eae1fe-a67d-4745-93d0-ad1a948132f8.png"><br><img width="500" src="https://user-images.githubusercontent.com/13285280/222138899-2403e174-8601-4447-b5bf-feee4c05e10d.png"><br><img width="500" src="https://user-images.githubusercontent.com/13285280/222138947-3a8d1cf3-1482-4985-8441-61dd66bc13cc.png"> |


- Boardmap

|       API       | Postman으로 실행                                                                                                                                              | API 실행 후 H2 or Postman Response                                                                                                                                                                                                                                                                                                   |
|:---------------:|-----------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|    `게시판 추가`     | <img width="400" src="https://user-images.githubusercontent.com/13285280/222126751-fabe6697-8a0b-41db-babe-34fde0bd9975.png">                             | <img width="500" src="https://user-images.githubusercontent.com/13285280/222126969-84adfafb-bfdc-4105-a749-44fa16f91b6c.png">                                                                                                                                                                                                     |
| `게시판 전체 목록 조회` | <img width="400" src="https://user-images.githubusercontent.com/13285280/222127878-563a5b39-792e-4f6a-97f2-242815d7f02e.png">                             | Postman Response<br> <img width="500" src="https://user-images.githubusercontent.com/13285280/222128253-2ddbb54a-c311-41b9-a5c0-d7735a5747cd.png">                                                                                                                                                                                |
|    `게시판 수정`     | BOARDMAP_NO=6의 게시판 제목 수정<br> <img width="400" src="https://user-images.githubusercontent.com/13285280/222129400-f9c500b1-1d81-4301-b9c0-6c76186c7d51.png"> | <img width="500" src="https://user-images.githubusercontent.com/13285280/222129148-7da18419-8a75-4dca-977d-442bedc890f4.png">                                                                                                                                                                                                     |
|    `게시판 삭제`     | BOARDMAP_NO=4 게시판 삭제<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222137454-3639c820-2d9c-4656-adfc-5fbf060cce25.png">     | BOARDMAP_NO=4 삭제<br><img width="500" src="https://user-images.githubusercontent.com/13285280/222137701-cc6386f2-e360-4b7e-9015-f96447d8c3c2.png"><br>BOARDMAP_NO=4에 작성된 BOARD_NO=6 삭제<br><img width="500" alt="image" src="https://user-images.githubusercontent.com/13285280/222138101-f4875f5a-72c5-419b-bdfc-9be246b9c710.png"> |

- Board

|      API       | Postman으로 실행                                                                                                                                                           | API 실행 후 H2 or Postman Response                                                                                                                                                                                                                                                                                                                                                  |
|:--------------:|------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|    `게시물 추가`    | BOARDMAP_NO=6에 게시물 추가<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222130608-ee4890c3-baf8-47e2-aaa3-456f70b93ce7.png">                 | <img width="500" src="https://user-images.githubusercontent.com/13285280/222130837-5eddaac9-055b-4c73-97b3-e290fe774d68.png">                                                                                                                                                                                                                                                    |
|    `게시물 수정`    | BOARDMAP_NO=6의 BOARD_NO=8의 게시물 수정<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222131148-9a2d8379-f09c-4fb8-b2d9-4067954b4a11.png">     | <img width="500" alt="image" src="https://user-images.githubusercontent.com/13285280/222131425-9e49d898-33cb-4738-bfae-67bd081a3861.png">                                                                                                                                                                                                                                        |
| `게시물 전체 조회`   | BOARDMAP_NO=2 게시판의 게시물 조회<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222131658-c5c81930-7088-41cb-9f6f-cd722ced6fc8.png">             | <img width="500" src="https://user-images.githubusercontent.com/13285280/222132384-e4208b93-c2a0-48f3-a7d7-102c094f74e2.png">                                                                                                                                                                                                                                                    |
|  `게시물 개별 조회`  | BOARDMAP_NO=2 게시판의 BOARD_NO=7 게시물 조회<br><img width="400" alt="image" src="https://user-images.githubusercontent.com/13285280/222132518-325eceef-bca8-42f0-9a31-f24381b7046c.png"> | <img width="500" src="https://user-images.githubusercontent.com/13285280/222132671-a352ae30-8e58-4ca5-82b2-d8835f564942.png">                                                                                                                                                                                                                                   |
|    `게시물 삭제`    | BOARDMAP_NO=5 게시판의 BOARD_NO=3 게시물 삭제<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222135731-1d174234-9cc8-4e2c-97c1-550afb182298.png"> | BOARD_NO=3 삭제<br><img width="500" src="https://user-images.githubusercontent.com/13285280/222135832-2b242ab0-24ba-4652-9591-c434bbf8efc7.png"> <br>BOARD_NO=3에 작성된 REPLY_NO=6,7,9 삭제<br>(REPLY_NO=8은 아래 REPLY_DELETE API에서 먼저 삭제됨) <br><img width="500" alt="image" src="https://user-images.githubusercontent.com/13285280/222136311-bc4b3527-4c5f-4197-bdb6-fd5d999af934.png"> |


- Reply

|   API   | Postman으로 실행                                                                                                                                                              | API 실행 후 H2 or Postman Response                                                                                                                       |
|:-------:|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `댓글 추가` | BOARD_NO=1의 게시물에 댓글 추가<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222133578-ec385d84-6241-4d05-8b24-fd4e00090286.png">                   | <img width="500" src="https://user-images.githubusercontent.com/13285280/222134024-49fdbb0a-a494-4c41-8033-ccfd1a114dae.png">                         |
| `댓글 조회` | BOARD_NO=1의 댓글 조회<br><img width="400" src="https://user-images.githubusercontent.com/13285280/222134469-c7f80ea3-7b40-4eb2-bf4a-dee56bb4a37f.png">                        | <img width="500" src="https://user-images.githubusercontent.com/13285280/222134852-e54ae2ca-1898-45c2-8819-935b20782f79.png">                         |
| `댓글 삭제` | BOARD_NO=1의 REPLY_NO=8 댓글 삭제<br><img width="400" alt="image" src="https://user-images.githubusercontent.com/13285280/222135087-ea6a4309-99a3-4710-96d8-f5f65ac69ba2.png"> | REPLY_NO=8 댓글이 삭제되었음<br><img width="500" src="https://user-images.githubusercontent.com/13285280/222135051-a86ac7fd-12e5-444c-928d-473996c7a37f.png"> |


# 아쉬운 점
- UI 개발 : 동작하는 UI가 없고, Server의 기능만 작동
- 권한 관리 : JWT로 로그인한 사용자의 정보를 가져오지만, 권한 설정이 완료 되지 않음
- 입력 데이터 검증 : 이메일 중복 확인 등 유효성 검증 필요

# 마치며
- Database 설계를 시작으로 API 구현까지 완료 
- 저번 프로젝트에 적용했던 JWT에 대한 복습
- Commit, Branch 관리를 통해 Git에 대한 이해도 향상
- 프로젝트에 직접 Swagger 적용하여 Swagger에 대한 이해도 향상
  <br><img width="500" src="https://user-images.githubusercontent.com/13285280/222142774-a13b177e-b99f-42ae-8b8d-98d09358410b.png">
