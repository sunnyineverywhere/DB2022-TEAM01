# db 생성
create database DB2022Team01;
use DB2022Team01;

# db 유저 생성 + 권한 부여
create user 'DB2022Team01'@localhost identified by 'DB2022Team01';
grant all privileges on DB2022Team01.* to 'DB2022Team01'@localhost;

# 테이블 생성
create table `user`(
	`id` BIGINT primary key,
    `name` varchar(45) unique key,
    `password` varchar(45)
);

create table `idol`(
	`group` varchar(45),
    `member` varchar(45) primary key,
    `quantity` BIGINT
);

create table `product`(
	`id` BIGINT primary key,
    `name` varchar(45),
    `price` BIGINT,
    `seller` varchar(45),
    `category` varchar(45),
    `isSold` bool,
    `date` date,
    foreign key(seller) references user(name)
);

create table `trade` (
	`id` bigint primary key,
    `product_id` bigint,
    `name` varchar(45),
    `price` bigint,
    `seller` varchar(45),
    `buyer` varchar(45),
	foreign key(product_id) references product(id),
    foreign key(seller) references user(name),
    foreign key(buyer) references user(name)
);

create table `wishlist`(
	`id` bigint primary key,
    `user_name` varchar(45),
    `product_id` bigint,
    `product_name` varchar(45),
    `product_category` varchar(45),
	`product_price` bigint,
    foreign key(user_name) references user(name),
    foreign key(product_id) references product(id)
);