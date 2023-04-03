select
	 um.user_id,
	 um.username,
	 um.password,
	 um.name,
	 um.email,
	 ud.gender,
	 ud.birthday,
	 ud.address
from
	user_mst um
	left outer join user_dtl ud on(ud.user_id = um.user_id)
 where
	um.username = "aaa";
    
insert into user_mst values('0','fasdasdasdxfxfx',"1234","jsh","hhgg0asdasd017@gmail.com");

select
 *
from
user_mst