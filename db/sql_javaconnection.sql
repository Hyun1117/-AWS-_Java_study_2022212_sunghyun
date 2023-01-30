insert into user_mst
values(0, 'aaab','1234','김준일','aaab@gmail.com');

select * from user_mst;

insert into role_mst
value
	(0,'ROLE_ADMIN'),
	(0,'ROLE_MANGER'),
	(0,'ROLE_USER');
    
select * from role_mst;

insert into role_dtl
values 
	(0, 1, 1),
	(0, 2, 1),
	(0, 3, 1);

select * from role_dtl;

select
	um.user_name,
    um.password,
    um.email,
    um.name,
    rd.role_id,
    rm.role_name
    
from 
	user_mst um
    left outer join role_dtl rd on (rd.user_id = um.user_id)
    left outer join role_mst rm on (rm.role_id = rd.role_id);
    
select * from role_mst;
select * from role_dtl;
	