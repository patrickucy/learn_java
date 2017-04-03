select * from role_privilege;
select * from role;
select * from admin_info;
select * from admin_role;


-- 为了避免直接给admin_info做关联查询,导致不好分页,我们可以将关联查询加到子查询里面,,作为条件处理
select * from (
	select ai.*, rownum r from admin_info ai
	where 1=1
	-- 拼角色
	and id in(
		select admin_id from admin_role ar
		inner join role_info ri on ri.id = ar.role_id
		where ri.id = ?
	)
	-- 拼权限
	and id in(
		select admin_id from admin_role ar
		inner join role_info ri on ri.id = ar.role_id
		inner join role_privilege rp on ri.id = rp.role_id
		where rp.privilege_id = ?
	)
) where r < ? and r > ?