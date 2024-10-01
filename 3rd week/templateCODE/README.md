## ✨ 3rd assignment : 스프링 프로젝트 고도화 + 프로그래머스 SQL 10문제

## 컨벤션
### Member 디렉토리 구조
```angular2html
📂member
    ├─📂controller
    │      MemberController.java
    │
    ├─📂dto
    │  ├─📂request
    │  │      MemberRequest.java
    │  │
    │  └─📂response
    │         MemberResponse.java
    ├─📂entity
    │      Member.java
    │
    ├─📂mapper
    │      MemberMapper.java
    │
    ├─📂repository
    │      MemberRepository.java
    │      MemberMemoryRepository.java
    │
    └─📂service
            MemberService.java
```

### 1. 도메인 중심 패키지 구조
  - 기존의 레이어 구조가 아닌 도메인 구조로 패키지 세팅
  - 직관적이고, 의존성을 줄여 코드의 유지보수를 용이하게 할 수 있음

### 2. 응답 형태 규격화
 - 기존의 JSON, List, Long 형태로 응답되던 코드
 - SuccessResponse와 ErrorResponse로 통일

### 3. 에러 핸들링
- 프론트와 협업 또는 코드의 유지보수를 용이하게 하기 위한 에러코드 정의

### 4. Repository 추상화
- 별도의 DB를 사용하고 있지 않은 현재의 Repository
- DB가 추가될 경우, 많은 코드를 변경해야 함
- Repository/MemoryRepository로 분리