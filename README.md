# MongoSpring

Spring Boot + MongoDB 연동 프로젝트입니다.  
MongoDB의 `campus_food` 데이터베이스를 사용하는 간단한 서버 애플리케이션입니다.

---

## ⚙️ 환경 설정

`src/main/resources/application.properties` 파일:

spring.application.name=MongoSpring
server.port=8080
spring.data.mongodb.uri=mongodb://localhost:27017/campus_food
spring.data.mongodb.database=campus_food


---

## 🚀 실행 방법

1. **MongoDB 실행**
    - 로컬에서 MongoDB가 실행 중이어야 합니다.
    - 기본 포트는 27017이며, 데이터베이스 이름은 `campus_food`입니다.

2. **서버 실행**
    - 프로젝트 루트( `build.gradle` 이 있는 위치 )에서 다음 명령어 실행:

./gradlew bootRun   # macOS / Linux <br>
gradlew.bat bootRun # Windows

또는 IDE(IntelliJ, VS Code 등)에서  
`MongoSpringApplication` 클래스를 직접 실행합니다.

---

## 🌐 접속 확인

서버 실행 후 브라우저에서 아래 주소로 접속:

http://localhost:8080

---

## 🧩 개발 환경

- Java 17+
- Spring Boot 3.5.x
- MongoDB 7.x
- Gradle 8.x