user role and sales per incentive


# 순서
## 요구사항 파악
- 업체 등록
 - admin 권한 사용자만 등록
- 업체 조회
 - admin 사용자는 견적 정보도 같이 볼수 있음
- user 별 판매에 따른 incentive 차등 계산
- user 판매 정보 저장
a
## 화면 설계
 - 로그인
 - 업체조회
 - 업체 등록
 

## 환경 구축
 - 클라우드 환경
 - 50명 내외의 사용자가 조회/등록

 ### 웹서버 셋팅
  - Java / Based Spring Boot / Mysql / JQuery / Bootstrap


## DB 셋팅
 - user
 - role
  - commission (%)
 - vendor
  - sales price
 -