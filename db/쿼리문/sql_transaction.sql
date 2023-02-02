show variables like 'AUTOCOMMIT';
set autocommit = 0;

start transaction;

savepoint sp2;

insert into user_mst
values(0,'kkkkk','1234','김준일','kkkkk@gmail.com');

select * from user_mst;

rollback to sp2;

commit;

# DB 시험
# DDL 작성
# 쿼리문 작성
# 테이블 join
# 트랜잭션
# index주기