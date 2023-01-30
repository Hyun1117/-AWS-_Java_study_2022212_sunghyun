/*==================<< selete >>==================*/

select * from student_mst;

/*전체 컬럼 조회(test code를 할 때 사용)*/
select
	*
from
	student_mst;
    
/*지정 컬럼 조회(유지보수를 위해 전체컬럼을 조회하더라도 다 적어주는게 좋다)*/
select
	student_id,
    student_name
from
	student_mst;
    
/*임시 컬럼 추가*/
select
	1 as num,
    '김준일' as name;
select
	student_id,
    student_name,
    '김준일' as instructor_name
from
	student_mst;
    
/*  컬럼명을 임시로 바꾸는 방법(java랑 sql이랑 표기법이 다르기 때문에 중요)
	as(alias)알리아스
	as는 생략가능하다 하지만 컬럼명은 생략을 안하고 보통 테이블명에서 생략함
*/
/* 정석    
select
	sm.student_id as studentId
from
	student_mst sm
*/
select
	student_id as studentId
from
	student_mst sm;

/* 조회 조건 where */
select
	*
from
	student_mst
where
	mentor_id = 1;

 /*서브 쿼리(서브쿼리를 쓰면 항상 ()를 해줘야한다.),서브쿼리를 쓸려면 타당한 이유가 필요하다*/
select
	*
from
	student_mst
where
	mentor_id = (select   /*서브 쿼리(서브쿼리를 쓰면 항상 ()를 해줘야한다.),서브쿼리를 쓸려면 타당한 이유가 필요하다*/
					mentor_id
				from 
					mentor_mst
				where
					mentor_name = '문자영');

select 
	student_id,
    student_name,
    mentor_id,
    (select 
		mentor_name
    from 
		mentor_mst
    where
		mentor_id = student_mst.mentor_id) as mentor_name
from
	student_mst;

/* 그룹으로 묶어서 조회(연산을 통한 통계 처리를 할 때 쓴다.) */

select
	count(mentor_id),
    min(student_id),
    max(student_id),
    avg(student_id),
    sum(student_id),
	mentor_id
from
	student_mst
group by
	mentor_id;

/* 중복 제거 */
select distinct
	mentor_id
from
	student_mst;

/* 그룹으로 묶어서 조회한 결과에 조건주는 방법 */

select
	count(mentor_id) as mentor_count,
    min(student_id),
    max(student_id),
    avg(student_id),
    sum(student_id),
	mentor_id
from
	student_mst
group by
	mentor_id
having
	mentor_count = 5;
    
/* 정렬(default값은 오름차순 정렬) */
select
	*
from
	student_mst
order by
	mentor_id ,
    student_id desc;/*내리차순 정렬*/
    
/* 전 체 조합 실습 */
select
	count(*) as student_count,
    mentor_id
from
	student_mst
where
	student_id > 2
group by
	mentor_id
having
	student_count = 1
order by
	mentor_id desc;