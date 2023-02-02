/* 뷰 만들기 */
create view library_view as
SELECT
	row_number() over(order by 도서관명) as 도서관순번,
	도서관명
from
	library_mst
group by
	도서관명;
    
/* 파티션 사용 */
SELECT
	row_number() over(partition by 도서관명 order by 도서관명) as 도서관순번,
	도서관명
from
	library_mst;
-- group by
-- 	도서관명;

