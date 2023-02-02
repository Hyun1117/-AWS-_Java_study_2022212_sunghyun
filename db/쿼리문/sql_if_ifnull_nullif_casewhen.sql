SELECT 
	순번,
    도서관명,
    구분,
    도서명,
    저작자,
    출판사,
    발행연도,
    case
		when 발행연도 is null then '2050'
        when 발행연도 = ''then '2090'
		else 발행연도
	end as 발행연도1,
    if(ifnull(발행연도,'') = '','2023',발행연도) as 발행연도2,
    nullif(발행연도, '') as 발행연도3,
    if(청구기호 = '','기호없음',청구기호) as 청구기호
    
FROM 
	library_mst
where
	#발행연도 like '201_';
    #발행연도 is not null;
    not 발행연도 = '';
    
update library_mst
set
	발행연도 = ''
where
	발행연도 = '2009';