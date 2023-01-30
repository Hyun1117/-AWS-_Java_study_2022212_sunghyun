select
    *
from
	libray_mst
where
	도서명 like '%나를%';/*like를 in과같이 쓸려면 or 을 써야함*/
    
/*===================<<select insert>>=====================*/
insert into author_mst 
	(author_name)
select distinct
	저작자
from 
	libray_mst
order by
	저작자;
select * from author_mst;

insert into
	publisher_mst
    (publisher_name)
select distinct
	출판사
from
	libray_mst
order by
	출판사;
select * from publisher_mst;

/*===================<<select update>>=====================*/
update libray_mst as lm
set lm.저작자 = (select
				author_id
			from
				author_mst as am
			where
				lm.저작자	= am.author_name);
            
select * from libray_mst;

update libray_mst, author_mst
set 저작자 = author_id
where 저작자 = author_name;

update libray_mst as lm
set lm.저작자 = (select
				publisher_id
                from
                publisher_mst as pm
                where lm.저작자 = pm.publisher_name);

update libray_mst, publisher_mst
set 출판사 = publisher_id
where 출판사 = publisher_name;

select 
	*
from
	libray_mst lm
    left outer join author_mst am on (am.author_id = lm.저작자)
    left outer join publisher_mst pm on(pm.publisher_id = lm.출판사);
select * from libray_mst;

/*=======================================================*/
select * from author_mst;

select * from libray_mst;

set profiling = 1;
set profiling_histroy_size = 30;

select
	도서관명,
    도서명
from
    libray_mst

where 
	저작자 in ( select
				author_id
                from
                author_mst am
                where
				am.author_name like '%김주%'
                or author_name like '%김민%');
select
	도서관명,
    도서명
from
	libray_mst lm
    left outer join author_mst am on(am.author_id = lm.저작자)
where
	am.author_name like '%김주%';
/*union 쿼리문을 합친다.*/
								
								
