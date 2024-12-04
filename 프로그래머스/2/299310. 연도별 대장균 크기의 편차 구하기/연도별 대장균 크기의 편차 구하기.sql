select j.YEAR, (j.ms - e.size_of_colony) YEAR_DEV, e.ID
from ecoli_data e
join
(select year(differentiation_date) year, max(size_of_colony) ms from ecoli_data group by year) j
on year(e.differentiation_date) = j.year
order by YEAR asc, YEAR_DEV asc;