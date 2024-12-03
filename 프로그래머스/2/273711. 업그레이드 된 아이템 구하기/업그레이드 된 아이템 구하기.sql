select i.item_id, i.item_name, i.rarity
from (
    select t.item_id
    from item_tree t
    join item_info i
    on i.item_id = t.parent_item_id
    and i.rarity = 'RARE'
) qr
join item_info i
on qr.item_id = i.item_id
order by i.item_id desc;