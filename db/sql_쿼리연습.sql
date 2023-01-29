select 
	*
from
	role_mst;
    
    
select
	*
from 
	user_mst as um
left outer join role_dtl rd on (rd.user_id = um.user_id)
left outer join role_mst rm on (rm.role_id = rd.role_id);

select
	*
from
	user_mst um
    left outer join role_dtl rd on (rd.user_id = um.user_id)
    left outer join role_mst rm on (rm.role_id = rd.role_id)
where
	um.username = "aaa";
