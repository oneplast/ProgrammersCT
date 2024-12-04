select e.id id, ifnull(j.cnt, 0) child_count
from ecoli_data e
left join (
    select parent_id id, count(parent_id) cnt
    from ecoli_data parent
    group by parent_id
) j
on j.id = e.id