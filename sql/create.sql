# db 생성
create database DB2022Team01;
use DB2022Team01;

# db 유저 생성 + 권한 부여
# create user 'DB2022Team01'@localhost identified by 'DB2022Team01';
grant all privileges on DB2022Team01.* to 'DB2022Team01'@localhost;

# 테이블 생성
# 유저 테이블
create table `DB2022_user`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45) unique key,
    `password` varchar(45),
    `login` bool default false
);

# 아이돌 테이블
create table `DB2022_idol`(
	`idol_id` bigint not null auto_increment,
	`gp` varchar(45) not null,
    `member` varchar(45) not null,
    primary key(idol_id)
);

# 상품 테이블
create table `DB2022_product`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45),
    `user_id` BIGINT,
    `price` BIGINT,
    `seller` varchar(45),
    `category` varchar(255),
    `idol_id` bigint,
    `isSold` bool default false,
    `date` date,
    foreign key(user_id) references DB2022_user(id),
    foreign key(idol_id) references DB2022_idol(idol_id),
    foreign key(seller) references DB2022_user(name),
    check((category) in ('포토카드', '앨범', '인형', '시즌그리팅', '공식키트', '폴라로이드', '포스터', '잡지', '기타'))
);

# 유저의 거래 내역 테이블
create table `DB2022_trade` (
	`trade_id` bigint auto_increment primary key,
    `product_id` bigint,
    `buyer_id` bigint default null,
    `buyer_name` varchar(45) default null,
	foreign key(product_id) references DB2022_product(id),
    foreign key(buyer_id) references DB2022_user(id),
    foreign key(buyer_name) references DB2022_user(name)
);

# 위시리스트 테이블
create table `DB2022_wishlist`(
    `user_id` bigint,
    `product_id` bigint,
    foreign key(user_id) references DB2022_user(id),
    foreign key(product_id) references DB2022_product(id)
);


# 인덱스 생성

#DB2022_idol 테이블에서 IdolGroup, IdolMember가 일치하는 tuple을 찾아서 id를 빠르게 반환하기 위해 이용하는 인덱스
create index idx_idol on db2022team01.db2022_idol
(gp, member); 

#로그인한 유저의 name을 가져올 때 이용하는 인덱스
create index idx_user on db2022team01.db2022_user
(name, password);

#상품검색에 필요한 db2022_product 테이블을 불러올 때, 상품 종류 선택에 이용하는 인덱스
create index idx_category on db2022team01.db2022_product
(category);

#로그인한 유저의 id 번호를 가져올 때 이용하는 인덱스
create index idx_user_login on db2022team01.db2022_user
(login);