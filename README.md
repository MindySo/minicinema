<aside>

![스크린샷 2024-09-26 161902.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/cd97a3db-5c59-41f4-9323-e72588e737cc/c6139cee-37f5-4059-b7b6-6465d6d10c11.png)

# Minicinema

사용자 맞춤형 서비스를 제공하는 영화 커뮤니티

</aside>

| **개요** |  영화 데이터와 관련된 다양한 정보를 관리하고, 사용자 간의 소통을 지원하는 커뮤니티입니다. 주요 기능으로는 영화, 배우, 감독 등 다양한 분류와 검색어를 통해 효율적으로 영화를 검색하고 자세한 정보를 조회할 수 있습니다. 또한, 영화 정보 및 회원 정보를 기반으로 댓글 및 즐겨찾기 기능을 통해 사용자 맞춤형 서비스를 제공합니다. |
| --- | --- |
| **진행 기간** | 2024.09.09 ~ 2024.09.25 |
| **팀 구성** | 개인 프로젝트 |
| **기술 스택** | **`Java17`  `Python`  `Spring Boot 3.3.1`  `Spring Security`  `Spring Data JPA`  `Mybatis`  `MySql`  `MongoDB`  `Thymeleaf`  `Selenium`  `AWS RDS`  `AWS EC2`** |
| **GitHub** | [**https://github.com/MindySo/minicinema**](https://github.com/MindySo/minicinema) |
| URL | [**http://3.38.94.145:8080/**](http://3.38.94.145:8080/) |

## System Architecture

![minicinema_systemarchitecture_notion(pdf)용.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/1dadee61-bfaa-42a2-a54e-57db758c67e0/627350fc-d428-406b-9bd1-13ef39cd4b31.png)

## ERD

![MiniCinema_ERD_white_notion(pdf)용.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/1cf8d2a5-0b7b-4346-9ec7-7e2eebb40ec2/3c06d6e5-5256-4a8b-a14c-230b87388216.png)

## 기술적 경험

- **회원가입 및 Spring Security를 활용한 로그인·로그아웃 구현**
    - 로그인 시 **`JWT`** 토큰을 발급하여 유효성 검증, 로그아웃 시 만료 처리
    - `Access Token`과 `Refresh Token`을 함께 사용하여 보안 강화
- **MyBatis 와 JPA를 함께 사용**
    - 간단한 쿼리로 수행 가능한 기능은 **`JpaRepository`** 에서 제공하는 메서드를 사용
    - join, where 등이 포함된 복잡한 쿼리 수행 시 **`MyBatis`**를 통해 쿼리문과 직접 매핑하여 개발
- **jasypt를 사용한 애플리케이션 설정 암호화**
    - 애플리케이션 배포 시 DB정보 및 secret-key의 유출 방지를 위해 **`jasypt`**로 암호화
    - 암호화 된 값들은 `spring.profiles.active` 설정을 통해 파일을 따로 분리하여 관리
- **MongoDB를 사용하여 댓글 기능 구현**
- **Selenium을 이용한 정보 크롤링**
    - **`Selenium`**을 사용한 브라우저 동작 자동화로 KMDb에서 영화 정보 크롤링
- **AWS EC2를 통해 배포**
    - EC2에 키를 가지고 통신하여 **`Github`** clone 및 pull하여 배포와 차후 관리

## **개발 기능**

### 로그인 및 로그아웃 기능

![minicinema_securityfilter.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/ddbebabe-fd7a-4950-8d61-9e37978a6e46/minicinema_securityfilter.png)

- 로그인 시 **`JWT`** 방식으로 유효기간이 짧은 `Access Token`과 긴 `Refresh Token`을 함께 발급
    
    ![jwttoken.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/6e5e7733-f054-433a-8186-aa7e8c95d800/jwttoken.png)
    
- `Access Token`이 만료될 경우 `Refresh Token`의 유효성 검사 후 `Access Token` 재발급
- 로그아웃 시  `Refresh Token` 만료 처리

---

### **영화 전체 조회 및 검색 기능**

![메인화면.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/f18d137a-6493-46ef-b9b1-58d9ee191ed2/%EB%A9%94%EC%9D%B8%ED%99%94%EB%A9%B4.png)

- **`Spring Pageable`** 을 사용하여 목록 페이징
- **`MyBatis`** 를 사용하여 통합검색 및 카테고리에 따른 검색어 조회 기능 구현
    
    ![  ▲  카테고리별 검색 기능](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/d7d79567-ae1c-4269-b030-18a427e121e7/%EA%B2%80%EC%83%89%EC%B0%BD.png)
    
      ▲  카테고리별 검색 기능
    
- 각 영화 선택 시 상세정보 조회 가능

---

### 영화 즐겨찾기 및 댓글 기능

![디테일.png](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/53eb88d0-691a-4c07-ad99-0ac679538212/%EB%94%94%ED%85%8C%EC%9D%BC.png)

- 영화 상세정보 페이지에서 비동기 방식으로 영화 즐겨찾기 선택 · 취소 구현
- 유저가 즐겨찾기한 영화는 즐겨찾기 목록에서 전체조회 및 상세조회 가능
    
    ![  ▲  즐겨찾기 목록](https://prod-files-secure.s3.us-west-2.amazonaws.com/c774ab31-98fd-49f8-a0f1-7d8d073c57ef/48b2dd78-2d3b-49f5-aeac-8e6178dfa4d6/%EC%B0%9C%ED%95%9C%EC%98%81%ED%99%94.png)
    
      ▲  즐겨찾기 목록
    
- 해당 영화와 같은 장르의 영화를 조회하여 비슷한 영화로 추천
- **`MongoDB`** 와 **`JPA`**를 활용하여 댓글 CRUD 기능 구현