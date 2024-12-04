select distinct d.id id, d.email email, d.first_name first_name, d.last_name last_name
from developers d
join skillcodes s
on s.name in ('C#', 'Python')
and d.skill_code & s.code = s.code
order by id asc;