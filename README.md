# MongoSpring

Spring Boot + MongoDB 연동 프로젝트입니다.  
MongoDB의 `campus_food` 데이터베이스를 사용하는 간단한 서버 애플리케이션입니다.

---

## 📁 프로젝트 구조

```
MongoSpring/
├── src/
│   ├── main/
│   │   ├── java/com/study/MongoSpring/
│   │   │   ├── MongoSpringApplication.java      # Spring Boot 애플리케이션 진입점 (main 함수)
│   │   │   │
│   │   │   ├── controller/
│   │   │   │   ├── MainRestController.java      # REST API (데이터 조회·추가·삭제) 처리 컨트롤러
│   │   │   │   └── ViewController.java          # 뷰 전용 컨트롤러 — "/" 요청 시 main.html 반환
│   │   │   │
│   │   │   ├── document/
│   │   │   │   └── Table1Document.java          # MongoDB 컬렉션(table1)의 문서(Document) 모델 클래스
│   │   │   │
│   │   │   ├── repository/
│   │   │   │   └── Table1Repository.java        # MongoRepository 인터페이스를 상속한 기본 Repository 클래스
│   │   │   │
│   │   │   └── config/
│   │   │       └── SwaggerConfig.java           # Swagger(OpenAPI 3) 설정 클래스
│   │   │
│   │   └── resources/
│   │       ├── application.properties           # 서버 포트 및 MongoDB 연결 설정
│   │       │
│   │       └── templates/
│   │           └── main.html                    # Thymeleaf 템플릿 — MongoDB 데이터 목록 출력용 HTML 뷰
│   │
│   └── test/                                   # 테스트 코드 디렉터리 (필요 시 단위 테스트 작성)
│
├── build.gradle                                # Gradle 기반 빌드 및 의존성 설정 파일
│
└── README.txt                                  # 프로젝트 개요, 실행 방법, API 및 Swagger 문서 정보
```

---

## ⚙️ 환경 설정

`src/main/resources/application.properties` 파일:

spring.application.name=MongoSpring <br>
server.port=8080
spring.data.mongodb.uri=mongodb://localhost:27017/campus_food

### # Swagger UI 관련 설정
springdoc.api-docs.path=/v3/api-docs <br>
springdoc.swagger-ui.path=/swagger-ui.html

---

## 🚀 실행 방법

1. **MongoDB 실행**
    - 로컬에서 MongoDB가 실행 중이어야 합니다.
    - 기본 포트는 27017이며, 데이터베이스 이름은 `campus_food`입니다.

2. **서버 실행**
    - 프로젝트 루트( `build.gradle` 이 있는 위치 )에서 다음 명령어 실행:

./gradlew bootRun  &nbsp;&nbsp;&nbsp;&nbsp; # macOS / Linux <br>
gradlew.bat bootRun &nbsp;# Windows

또는 IDE(IntelliJ, VS Code 등)에서  
`MongoSpringApplication` 클래스를 직접 실행합니다.

---

## 🌐 접속 확인 - HTML 뷰 (Thymeleaf)

서버 실행 후 브라우저에서 아래 주소로 접속: <br>
http://localhost:8080

예시 화면:

|_id|userId|name|
|:---|:---|:---|
|68e13075859ab1cce4f88779 | user001 | 홍길동 |
| 68e13088859ab1cce4f88891 | user002 | 이영희 |


---

## 📘 Swagger API 문서

Swagger(OpenAPI 3.0) 기반 자동화 API 문서 제공

접속 주소: <br>
http://localhost:8080/swagger-ui/index.html

설정 파일 위치: <br>
src/main/java/com/study/MongoSpring/config/SwaggerConfig.java

---

## 🧩 개발 환경

- Java 17+
- Spring Boot 3.5.x
- MongoDB 7.x
- Gradle 8.x
- Swagger UI (springdoc-openapi 2.8.x)
- Thymeleaf 템플릿 엔진

---

## ✅ 실행 후 확인 요약

| 주소                                               |설명|
|:-------------------------------------------------|:---|
| http://localhost:8080/              |HTML 뷰 페이지|
| http://localhost:8080/api/table1                 |전체 데이터 JSON 조회|
| http://localhost:8080/api/table1/by-user/user001 |단일 데이터(userId) 조회|
| http://localhost:8080/swagger-ui/index.html      |Swagger 문서 페이지|