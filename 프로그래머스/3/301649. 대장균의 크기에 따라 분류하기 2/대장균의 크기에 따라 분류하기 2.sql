with colony_level as (
    select id, ntile(4) over (order by size_of_colony desc) colony_level
    from ecoli_data
)

select e.id as id,
case
    when c.colony_level = 1 then 'CRITICAL'
    when c.colony_level = 2 then 'HIGH'
    when c.colony_level = 3 then 'MEDIUM'
    else 'LOW'
end as colony_name
from ecoli_data e, colony_level c
where e.id = c.id
order by e.id;