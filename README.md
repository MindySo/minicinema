<h1 align="center">🎬 Minicinema</h1>
<p align="center"><strong>사용자 맞춤형 서비스를 제공하는 영화 커뮤니티</strong></p>

<p align="center">
  <img src="README_images/스크린샷 2024-09-26 161902.png" width="80%">
</p>

<hr/>

<h2>📌 프로젝트 개요</h2>

<table>
  <tr>
    <td><strong>개요</strong></td>
    <td>영화 데이터와 관련된 다양한 정보를 관리하고, 사용자 간의 소통을 지원하는 커뮤니티입니다. 다양한 검색 기능과 즐겨찾기, 댓글 기능으로 사용자 맞춤형 서비스를 제공합니다.</td>
  </tr>
  <tr>
    <td><strong>진행 기간</strong></td>
    <td>2024.09.09 ~ 2024.09.25</td>
  </tr>
  <tr>
    <td><strong>팀 구성</strong></td>
    <td>개인 프로젝트</td>
  </tr>
  <tr>
    <td><strong>기술 스택</strong></td>
    <td><code>Java17</code> <code>Python</code> <code>Spring Boot 3.3.1</code> <code>Spring Security</code> <code>JPA</code> <code>MyBatis</code> <code>MySQL</code> <code>MongoDB</code> <code>Thymeleaf</code> <code>Selenium</code> <code>AWS EC2/RDS</code></td>
  </tr>
  <tr>
    <td><strong>GitHub</strong></td>
    <td><a href="https://github.com/MindySo/minicinema">https://github.com/MindySo/minicinema</a></td>
  </tr>
  <tr>
    <td><strong>URL</strong></td>
    <td><a href="http://3.38.94.145:8080/">http://3.38.94.145:8080/</a></td>
  </tr>
</table>

<hr/>

<h2>🧱 System Architecture</h2>
<p>
  <img src="README_images/minicinema_systemarchitecture_notion(pdf)용.png" width="80%">
</p>

<h2>🧩 ERD</h2>
<p>
  <img src="README_images/MiniCinema_ERD_white_notion(pdf)용.png" width="80%">
</p>

<hr/>

<h2>⚙ 기술적 경험</h2>
<ul>
  <li><strong>JWT 기반 로그인/로그아웃 구현</strong></li>
  <li>MyBatis + JPA 혼합 사용</li>
  <li>jasypt로 DB정보 및 시크릿키 암호화</li>
  <li>MongoDB로 댓글 구현</li>
  <li>Selenium으로 KMDb 영화정보 크롤링</li>
  <li>AWS EC2, RDS로 배포 및 DB 관리</li>
</ul>

<hr/>

<h2>🔐 로그인 및 로그아웃</h2>
<p>
  <img src="README_images/minicinema_securityfilter.png" width="80%">
</p>
<p>
  <img src="README_images/jwttoken.png" width="60%">
</p>

<ul>
  <li>Access Token + Refresh Token 구조</li>
  <li>Access Token 만료 시 Refresh Token으로 재발급</li>
  <li>로그아웃 시 Refresh Token 무효화</li>
</ul>

<hr/>

<h2>🎞 영화 전체 조회 및 검색</h2>
<p>
  <img src="README_images/메인화면.png" width="80%">
</p>

<ul>
  <li>Spring Pageable로 페이징 구현</li>
  <li>MyBatis로 통합 검색 및 카테고리별 필터링 구현</li>
</ul>

<p>
  <img src="README_images/검색창.png" width="60%">
</p>
<p><em>▲ 카테고리별 검색 기능</em></p>

<hr/>

<h2>⭐ 즐겨찾기 및 댓글 기능</h2>
<p>
  <img src="README_images/디테일.png" width="80%">
</p>

<ul>
  <li>영화 즐겨찾기 추가/취소 (비동기)</li>
  <li>즐겨찾기 목록에서 전체조회 및 상세조회</li>
</ul>

<p>
  <img src="README_images/찜한영화.png" width="60%">
</p>
<p><em>▲ 즐겨찾기 목록 및 추천 영화</em></p>

<ul>
  <li>비슷한 장르의 영화 추천</li>
  <li>MongoDB + JPA를 활용한 댓글 CRUD</li>
</ul>
