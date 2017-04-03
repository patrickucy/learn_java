-- show 2 records per page
select * from(
select c.*,rownum r from cost c where rownum <5
) where r > 2;