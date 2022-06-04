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

create table `DB2022_idol`(
	`idol_id` bigint not null auto_increment,
	`gp` varchar(45) not null,
    `member` varchar(45) not null,
    primary key(idol_id)
);

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

# 유저의 거래 내역
create table `DB2022_trade` (
	`trade_id` bigint auto_increment primary key,
    `product_id` bigint,
    `buyer_id` bigint default null,
    `buyer_name` varchar(45) default null,
	foreign key(product_id) references DB2022_product(id),
    foreign key(buyer_id) references DB2022_user(id),
    foreign key(buyer_name) references DB2022_user(name)
);

create table `DB2022_wishlist`(
    `user_id` bigint,
    `product_id` bigint,
    foreign key(user_id) references DB2022_user(id),
    foreign key(product_id) references DB2022_product(id)
);


# 인덱스 생성
create index idx_idol on db2022team01.db2022_idol
(gp, member);

create index idx_user on db2022team01.db2022_user
(name, password);

create index idx_category on db2022team01.db2022_product
(category);

create index idx_user_login on db2022team01.db2022_user
(login);

# 예시 데이터 삽입 이후 실행 할 것
# 뷰 생성
create view DB2022_idol_list as
select gp, member from db2022team01.db2022_idol;


create view DB2022_product_list as
select id, name, gp, member, category, seller, price, date
from DB2022_idol, DB2022_product where isSold = false and DB2022_idol.idol_id = DB2022_product.idol_id 
order by date;

create view DB2022_product_withidol as
select id, name, price, seller, category, date, DB2022_product.idol_id, gp, member
from DB2022_product, DB2022_idol where DB2022_idol.idol_id = DB2022_product.idol_id;



insert into DB2022_user(name, password)
values
	("선의", "1234"),
    ("지원", "4321");

INSERT INTO DB2022_idol(gp, member)
values
("세븐틴", "에스쿱스"),
("세븐틴", "정한"),
("세븐틴", "조슈아"),
("세븐틴", "준"),
("세븐틴", "호시")
;


insert into DB2022_wishlist(user_id, product_id)
value
(1, 3);


insert into DB2022_product(user_id, name, price, seller, category, idol_id, date)
values
(2, "포카", 40000, "지원", "포토카드", 1, "2017-01-01")
;


# 데이터
insert into DB2022_trade(product_id)
values
(1);

#user data
insert into DB2022_user(name, password) values ('dlrbals', '0000'), ("jy0115", "1234"), ("guswowogus", "1234"), 
('dlsgud', '1234'), ('qhqkd', '1234'), ('wndus54321', '1234'), ('reveal33', '1234'),  ('dkssud', '1234'), ('ejqhdlwm', '1234'), 
('bana55', '1234'), ('grp00', '1234'), ('xkfejql', '1234'), ('wndusaldks', '1234');

insert into DB2022_user(name, password)
values
    ("tmzlwm325", "1234"),
    ("bangchan", "1234"),
    ("leeknow", "1234"),
    ("changbin", "1234"),
    ("hyunjin", "1234"),
    ("han", "1234"),
    ("felix", "1234"),
    ("seungmin", "1234"),
    ("in", "1234"),
    ("qkdcks", "1234"),
    ("dlalsgh", "1234"),
    ("tjckdqls", "1234"),
    ("ghkdguswls", "1234"),
    ("gkswltjd", "1234"),
    ("dldydqhr", "1234"),
    ("rlatmdals", "1234"),
    ("didwjddls", "1234"),
    ("wolfchan", "1234"),
    ("leebit", "1234"),
    ("dwakki", "1234"),
    ("jiniret", "1234"),
    ("hanqukka", "1234"),
    ("bbokari", "1234"),
    ("puppym", "1234"),
    ("foxiny", "1234")
    ;

#idol data
insert into db2022_idol(gp, member) values
('더보이즈', '현재'), ('더보이즈', '주연'), ('더보이즈', '영훈'), ('더보이즈', '뉴'), ('더보이즈', '큐'), ('더보이즈', '선우'), 
('더보이즈', '학년'), ('더보이즈', '상연'), ('더보이즈', '케빈'), ('더보이즈', '제이콥'), ('더보이즈', '더보이즈');

INSERT INTO DB2022_idol(gp, member)
values
("스트레이키즈","방찬"),
("스트레이키즈","리노"),
("스트레이키즈","창빈"),
("스트레이키즈","현진"),
("스트레이키즈","한"),
("스트레이키즈","필릭스"),
("스트레이키즈","승민"),
("스트레이키즈","아이엔"),
("드림캐쳐","지유"),
("드림캐쳐","수아"),
("드림캐쳐","시연"),
("드림캐쳐","한동"),
("드림캐쳐","유현"),
("드림캐쳐","다미"),
("드림캐쳐","가현"),
("cix","BX"),
("cix","승훈"),
("cix","용희"),
("cix","진영"),
("cix","현석"),
("엔믹스","릴리"),
("엔믹스","해원"),
("엔믹스","지니"),
("엔믹스","배이"),
("엔믹스","설윤"),
("엔믹스","지우"),
("엔믹스","규진"),
("에이티즈","홍중"),
("에이티즈","성화"),
("에이티즈","윤호"),
("에이티즈","여상"),
("에이티즈","산"),
("에이티즈","민기"),
("에이티즈","우영"),
("에이티즈","종호"),
("우주소녀","설아"),
("우주소녀","보나"),
("우주소녀","엑시"),
("우주소녀","수빈"),
("우주소녀","루다"),
("우주소녀","다원"),
("우주소녀","은서"),
("우주소녀","여름"),
("우주소녀","다영"),
("우주소녀","연정"),
("엔플라잉","승협"),
("엔플라잉","차훈"),
("엔플라잉","재현"),
("엔플라잉","회승"),
("엔플라잉","동성")
;

#product data
insert into DB2022_product (user_id, name, price, seller, category, idol_id, isSold, date) values 
(3, '더보이즈 영훈 스릴라이드 미공포 양도', 3200, 'dlrbals', '포토카드', 8, FALSE, '2021-10-29'), 
(3, '더보이즈 현재 매버릭 모교교복 포카 양도', 50000, 'dlrbals', '포토카드', 6, FALSE, '2022-04-11'), 
(3, '더보이즈 주연 크리스마씨 굿즈 스티커 분철 양도', 2000, 'dlrbals', '기타', 7, FALSE, '2020-12-12'), 
(3, '더보이즈 주연 더스틸러 위드드라마 미공포 양도', 5500, 'dlrbals', '포토카드', 7, FALSE, '2020-09-29'),  
(3, '더보이즈 주연 더스틸러 마뮤테 미공포 양도', 1000, 'dlrbals', '포토카드', 7, FALSE, '2020-09-29'), 
(3, '더보이즈 주연 더스틸러 조은뮤직 미공포 양도', 8000, 'dlrbals', '포토카드', 7, FALSE, '2020-09-29'), 
(4, '더보이즈 현재 더스틸러 키스마크 앨범포카 양도', 15000, 'jy0115', '포토카드', 6, FALSE, '2020-09-29'), 
(5, '더보이즈 현재 블룸블룸 공방 포카 양도', 135000, 'guswowogus', '포토카드', 6, FALSE, '2021-04-13'),  
(5, '더보이즈 현재 디디디 디삼 앨범 랜덤 포카 양도', 75000, 'guswowogus', '포토카드', 6, FALSE, '2021-04-13'), 
(6, '더보이즈 현재 인형 달곰이 양도', 50000, 'dlsgud', '인형', 6, FALSE, '2022-02-02'), 
(7, '더보이즈 영훈 인형 뽀빵', 20000, 'qhqkd', '인형', 8, FALSE, '2022-04-03'), 
(6, '더보이즈 주연 15cm 마물쭈 판매', 18000, 'dlsgud', '인형', 7, TRUE, '2021-10-09'),
(8, '더보이즈 주연 15cm 마물쭈', 18000, 'wndus54321', '인형', 7, TRUE, '2021-10-01'), 
(9, '밀꼬미 더보이즈 현재 인형 폼 이동 판매', 16000, 'reveal33', '인형', 6, FALSE, '2021-11-21'), 
(9, '더보이즈 더비 3기 키트 풀셋 양도', 20000, 'reveal33', '공식키트', 16, FALSE, '2021-06-20'), 
(10, '더보이즈 현재 로투킹 와인잔 포카 판매', 40000, 'dkssud', '기타', 6, FALSE, '2021-06-11'), 
(10, '더보이즈 주연 인형 마물쭈 10, 15 일괄', 40000, 'dkssud', '인형', 7, TRUE, '2021-09-25'), 
(11, '더보이즈 인형 달곰쥬냥 일괄 양도', 90000, 'ejqhdlwm', '인형', 16, TRUE, '2022-01-16'),  
(11, '더보이즈 뉴 포카 일괄 양도', 30000, 'ejqhdlwm', '포토카드', 9, FALSE, '2022-03-29'), 
(11, '더보이즈 학년 케빈 제이콥 포카 일괄 양도', 5000, 'ejqhdlwm', '포토카드', 16, FALSE, '2022-03-29'), 
(11, '더보이즈 매버릭 미개봉 앨범 세트 양도', 1000, 'ejqhdlwm', '앨범', 16, FALSE, '2022-03-29'), 
(12, '더보이즈 2021 시즌그리팅 현재 분철 양도', 11000, 'bana55', '시즌그리팅', 6, FALSE, '2020-01-05'), 
(13, '더보이즈 영훈 라포티셀 포카', 6000, 'grp00', '포토카드', 8, TRUE, '2021-07-10'), 
(11, '더보이즈 뉴 포카 일괄 양도', 30000, 'ejqhdlwm', '포토카드', 9, FALSE, '2022-03-29'), 
(13, '더보이즈 현재 데이즈드 폴라 양도', 85000, 'grp00', '폴라로이드', 6, TRUE, '2021-11-20'), 
(11, '더보이즈 현재 엽서북 팔찌 일괄', 55000, 'ejqhdlwm', '기타',  6, TRUE, '2021-05-23'), 
(11, '더보이즈 현재 *디님 2022시그 양도', 21000, 'ejqhdlwm', '시즌그리팅', 6, TRUE, '2021-12-23'), 
(14, '더보이즈 데이즈드 잡지 양도 포카 포함', 10000, 'xkfejql', '잡지', 16, FALSE, '2021-06-21'), 
(14, '더보이즈 더비 4기 키트 양도 아이디카드 제외', 15000, 'xkfejql', '공식키트', 16, FALSE, '2022-05-10'), 
(15, '덥뮤다 더스틸러 현재영훈주연 미화당 포카 일괄', 28000, 'wndusaldks', '포토카드', 16, TRUE, '2020-10-10');
