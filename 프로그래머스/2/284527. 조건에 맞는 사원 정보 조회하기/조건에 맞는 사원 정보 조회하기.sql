with sum_score as (select emp_no, sum(score) score
from hr_grade
group by emp_no)

select ss.score, ss.emp_no, he.emp_name, he.position, he.emaiL
from sum_score ss, hr_employees he
where ss.emp_no = he.emp_no
order by score desc
limit 1;
