<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">

#  JustBook
Use SpringBoot, Mybatis, Redis, Mysql

## Introduction
책 판매 어플리케이션입니다. Front UI는 KAKO OVEN으로 자체 제작 하였습니다.

평소 저는 국내 책 판매 사이트를 이용하면서 책 이외에 마스크, 헤어드라이기 같은 상품들을 판매하는것을 보았습니다.

책 이외에 다른 상품들을 판매하는 문제 때문에 제가 원하는 책을 고르는데  느꼈고 단순 책만 판매하는 어플리케이션이 있으면 좋겠다는 생각이 들어 개발하였습니다.
1. 로그인을 이유로 회원가입을 할 수 있습니다.
2. 상품 구입을 이유로 로그인을 할 수 있습니다.
3. 궁금증 해소를 이유로 책을 구매순, 좋아요순으로 조회할 수 있습니다.
4. 사고 싶은 책을 빠르게 찾기 위해서 카테고리 별로 책을 확인할 수 있습니다.
5. 사고 싶은 책을 빠르게 찾기 위해서 검색을 할 수 있습니다.
6. 책을 배송받기 위해서 책을 결제할 수 있습니다.
7. 책에 대한 더 많은 정보를 확인하기 위해서 책의 상세정보 (목차, 상품 상세 정보, 저자 소개)를 확인할 수 있습니다.
8. 원하는 책만 결제하기 위해서 장바구니에 있는 책을 추가 수정 삭제 할 수 있습니다.
## Feature
- 회원가입
- 로그인
- 회원 정보 수정
- 회원 탈퇴
- 카테고리별 책 구매순, 좋아요 순 조회
- 장바구니
- 상품 결제
- 상품 검색
- 
## UI

<div style= "border: 1px solid black; border-radius: 10px;" >
  <!-- 로그인 -->
  <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190756-2fccd780-8ff3-11ea-9d98-9d388911cf5d.PNG">
    <!-- 로그인 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190745-2e9baa80-8ff3-11ea-9bb9-d3a88fc32935.PNG">
  <!-- 홈 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81192777-92bf6e00-8ff5-11ea-825a-8dc084838644.PNG">
 <!-- 카테고리 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81307818-07f57680-90bc-11ea-8571-058df13e376f.PNG">
  <!-- 인문학 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190752-2f344100-8ff3-11ea-896c-66a87b77c8a5.PNG">
  <!-- 장바구니 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190748-2e9baa80-8ff3-11ea-82f9-7c235515fb70.PNG">
  <!-- 도서 결제창 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81245494-16a64400-9050-11ea-9343-d5bcd88b0a67.PNG">
  <!-- 도서 상세 정보 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190738-2e031400-8ff3-11ea-8c88-0b1b33a6aa39.PNG">
    <!-- 검색 화면 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190734-2d6a7d80-8ff3-11ea-882b-c3a32eec6489.PNG">
  <!-- 검색 결과 화면 -->
    <img style="padding:10px;" width="300" src="https://user-images.githubusercontent.com/63249033/81190730-2cd1e700-8ff3-11ea-8198-8ffe20c22728.PNG">
</div>
