select MEMBER_ID, MEMBER_NAME, GENDER, date_format(date_of_birth, '%Y-%m-%d') DATE_OF_BIRTH
from member_profile
where tlno is not null
and date_format(date_of_birth, '%m') = '03'
and gender = 'w'
order by member_id asc;