select warehouse_id, warehouse_name, address, ifnull(freezer_yn, 'N') freezer_yn
from food_warehouse
where warehouse_name like '%경기%'
order by warehouse_id asc;