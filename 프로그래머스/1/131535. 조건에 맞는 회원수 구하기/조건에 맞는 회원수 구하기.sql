select count(*)
from user_info
where date_format(joined, '%Y') = '2021'
and age >= 20
and age <= 29;