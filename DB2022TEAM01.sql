# db 생성
create database DB2022Team01;
use DB2022Team01;

# db 유저 생성 + 권한 부여
# create user 'DB2022Team01'@localhost identified by 'DB2022Team01';
grant all privileges on DB2022Team01.* to 'DB2022Team01'@localhost;

# 테이블 생성
create table `DB2022_user`(
	`id` BIGINT not null auto_increment primary key,
    `name` varchar(45) unique key,
    `password` varchar(45),
    `login` bool default false
);

select * from DB2022_user;

select * from DB2022_product;

select * from DB2022_idol, DB2022_product where isSold = false and DB2022_idol.idol_id = DB2022_product.idol_id;

# 두개 묶어서 primary key -> ?
# group 변수명때문에 오류 났던 것 같음 -> gp로 수정
create table `DB2022_idol`(
	`idol_id` bigint not null auto_increment,
	`gp` varchar(45) not null,
    `member` varchar(45) not null,
    primary key(idol_id)
);

select * from DB2022_idol, DB2022_product where isSold = false and DB2022_idol.idol_id = DB2022_product.idol_id;


insert into DB2022_user(name, password)
values
	("선의", "1234"),
    ("지원", "4321");

select * from DB2022_idol;

INSERT INTO DB2022_idol(gp, member)
values
("세븐틴", "에스쿱스"),
("세븐틴", "정한"),
("세븐틴", "조슈아"),
("세븐틴", "준"),
("세븐틴", "호시")
;



# 상품
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


insert into DB2022_product(user_id, name, price, seller, category, idol_id, date)
values
(2, "포카", 40000, "지원", "포토카드", 1, "2017-01-01")
;

select * from DB2022_product;
select * from DB2022_idol;

# 유저의 거래 내역
create table `DB2022_trade` (
	`trade_id` bigint auto_increment primary key,
    `product_id` bigint,
    `buyer_id` bigint default null,
	foreign key(product_id) references DB2022_product(id),
    foreign key(buyer_id) references DB2022_user(id)
);

# 프로덕트를 등록할 때 trade에도 등록되어야 함
# 매수 시에 buyer_id가 추가된다
# gui에는 buyer_id와 product에서 user_id가 로그인 된 id를 데려오기
select * from DB2022_product;
select * from DB2022_trade;



select distinct trade_id, name, user_id, price, seller, buyer_id, date, isSold, category
from DB2022_product, DB2022_trade
where DB2022_product.user_id = 1 or DB2022_trade.buyer_id = 1;

# 가라데이터
insert into DB2022_trade(product_id)
values
(3),
(4);



create table `DB2022_wishlist`(
    `user_id` bigint,
    `product_id` bigint,
    foreign key(user_id) references DB2022_user(id),
    foreign key(product_id) references DB2022_product(id)
);

insert into DB2022_wishlist(user_id, product_id)
value
(1, 3);