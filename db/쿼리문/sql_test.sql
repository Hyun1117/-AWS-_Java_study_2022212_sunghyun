
select
	도서관명,
    도서명
from
	library_mst
where
	저작자 in (select
				author_id
			from 
				author_mst as am
			where
				am.author_name like '%김주%');
                

select
도서관명,
도서명
from 
library_mst
where
출판사 in (select
			publisher_id
		from
			publisher_mst pm
		where
			pm.publisher_name like '%H%');
            
select
	도서관명,
    도서명
from 
	library_mst lm
left outer join author_mst am on (am.author_id = lm.저작자)
where am.author_name like '%김주%';

