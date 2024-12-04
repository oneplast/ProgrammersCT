select i.item_id item_id, i.item_name item_name
from item_info i
join (
    select item_id id
    from item_tree
    where parent_item_id is null
) j
on j.id = i.item_id;