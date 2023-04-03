insert into student_mst values(1,'김춘식'),(2,'손흥민');
insert into subject_mst values(1,'컴퓨터구조'),(2,'데이터베이스'),(3,'인공지능');
insert into record_mst values(1,1,1,'95'),(2,2,1,'84'),(3,1,2,'89'),(4,2,2,'92'),(5,1,3,'100'),(6,2,3,'88');

select
	rm.record_id as 순번,
	sm.student_id as 학번,
    sm.student_name as 이름,
    um.subject_id as 과목번호,
    um.subject_name as 과목이름,
    rm.subject_score as 점수
from
	record_mst rm
    left outer join student_mst sm on (sm.student_id = rm.student_id)
    left outer join subject_mst um on (um.subject_id = rm.subject_id)
where
	rm.record_id < 5;
    
insert into 상품 values(1,'딸기사탕',50),(2,'누룽지사탕',100);

START TRANSACTION;

set autocommit = 0;

INSERT INTO `상품`

VALUES(0, '오렌지사탕', 20);

savepoint sp1;


UPDATE `상품`

SET

    `수량` = 200

WHERE

    `상품코드` = 2;

rollback to sp1;
DELETE

FROM

    `상품`

WHERE

    `상품코드` = 2;



COMMIT;

CREATE USER new_user@'%' identified  BY '비밀번호';
create resource group admin_group
TYPE = USER;
grant insert , delete ,select to new_user;


select

customer,

sum(amount) as total_sales,

        rank() over(order by sum(amount) desc) as sales_rank

from

sales

group by

customer

order by

    sales_rank desc;