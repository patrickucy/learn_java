select * from (
	select s.*, a.idcard_no, a.real_name, c.name, c.descr, rownum r from service s 
	inner join account a on s.account_id=a.id
	inner join cost c on s.cost_id= c.id 
	where 1=1
	and s.os_username=?
	and s.unix_host=?
	and a.idcard_no=?
	and s.status=?;
) where r<? and r>?