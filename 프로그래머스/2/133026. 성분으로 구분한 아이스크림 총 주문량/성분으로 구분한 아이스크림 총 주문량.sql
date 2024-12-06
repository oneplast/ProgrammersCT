select j.ingredient_type, sum(f.total_order)
from first_half f
join
(
    select * from icecream_info
) j
on f.flavor = j.flavor
group by j.ingredient_type
order by f.total_order asc;