-- 테이블 생성
CREATE table shoping (
ordno int ,
orddate datetime,
prodname char(5),
saleprice int
);

-- 고객 테이블
CREATE table customers (
	custid varchar(16) primary key, -- 가변데이터생성 ,  중복데이터 막음
	name varchar(10),
	age int,
	grade varchar(10),
	job varchar(10),
	points int
);

-- 제품 테이블
CREATE table products(
	prodno char(4) primary key,
	prdname varchar(10),
	stock int,
	price int,
	prdmaker char(10)
);

-- 주문 테이블
CREATE table orders(
	ordno int primary key,
	custid varchar(16), -- 고객 테이블 pk
	prodno char(4), -- 제품 테이블 pk
	qty int,
	addr varchar(20),
	orddate datetime
);

-- 외래키 설정
-- foreign key (컬럼명)
-- references 테이블명(컬럼명);
-- 주문 - 고객 테이블간 관계 설정
-- 주문 - 상품 테이블간 관계 설정 오더3
-- 고객 - 상품 둘다 외래키 설정 오더4
CREATE table orders2( -- 주문/ 고객 외래키 설정
	ordno int primary key,
	custid varchar(16), -- 고객 테이블 pk
	prodno char(4), -- 제품 테이블 pk
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (custid)
	references customers (custid)
);

CREATE table orders3( -- 주문/상품 외래키 설정
	ordno int primary key,	
	custid varchar(16), -- 고객 테이블 pk
	prodno char(4), -- 제품 테이블 pk
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (prodno) references products (prodno)
);

CREATE  table orders4( -- 주문 / 상품,고객 외래키 설정
	ordno int primary key,
	custid varchar(16), -- 고객 테이블 pk
	prodno char(4), -- 제품 테이블 pk
	qty int,
	addr varchar(20),
	orddate datetime,
	foreign key (custid) references customers (custid),
	foreign key (prodno) references products (prodno)
);


-- 단 외래키를 설정할 때에는 
-- 테이블 생성순서에 주의해야 함!
-- 고객 -> 상품 -> 주문