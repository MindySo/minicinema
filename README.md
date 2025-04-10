<aside>

![README_images스크린샷 2024-09-26 161902.png](README_images/스크린샷 2024-09-26 161902.png)

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

![minicinema_systemarchitecture_notion(pdf)용.png](README_images/minicinema_systemarchitecture_notion(pdf)용.png)

## ERD

![MiniCinema_ERD_white_notion(pdf)용.png](README_images/MiniCinema_ERD_white_notion(pdf)용.png)

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

![minicinema_securityfilter.png](README_images/minicinema_securityfilter.png)

- 로그인 시 **`JWT`** 방식으로 유효기간이 짧은 `Access Token`과 긴 `Refresh Token`을 함께 발급
    
    ![jwttoken.png](README_images/jwttoken.png)
    
- `Access Token`이 만료될 경우 `Refresh Token`의 유효성 검사 후 `Access Token` 재발급
- 로그아웃 시  `Refresh Token` 만료 처리

---

### **영화 전체 조회 및 검색 기능**

![메인화면.png](README_images/메인화면.png)

- **`Spring Pageable`** 을 사용하여 목록 페이징
- **`MyBatis`** 를 사용하여 통합검색 및 카테고리에 따른 검색어 조회 기능 구현
    
    ![  ▲  카테고리별 검색 기능](README_images/검색창.png)
    
      ▲  카테고리별 검색 기능
    
- 각 영화 선택 시 상세정보 조회 가능

---

### 영화 즐겨찾기 및 댓글 기능

![디테일.png](README_images/디테일.png)

- 영화 상세정보 페이지에서 비동기 방식으로 영화 즐겨찾기 선택 · 취소 구현
- 유저가 즐겨찾기한 영화는 즐겨찾기 목록에서 전체조회 및 상세조회 가능
    
    ![  ▲  즐겨찾기 목록](README_images/찜한영화.png)
    
      ▲  즐겨찾기 목록
    
- 해당 영화와 같은 장르의 영화를 조회하여 비슷한 영화로 추천
- **`MongoDB`** 와 **`JPA`**를 활용하여 댓글 CRUD 기능 구현
