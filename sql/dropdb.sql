#DROP
use db2022team01;

# 스키마의 순서에 맞춰 drop query 실행
# foreign key가 product에 있는 테이블 먼저 삭제
DROP TABLE db2022_wishlist;
DROP TABLE db2022_trade;
# 참조하는 테이블들이 삭제되었고, foreign key가 user에 있는 테이블인 product 삭제
DROP TABLE db2022_product;
# 더이상 foreign key가 없으므로 user와 idol 테이블을 삭제
DROP TABLE db2022_user;
DROP TABLE db2022_idol;

# 데이터베이스도 drop
DROP DATABASE db2022team01;