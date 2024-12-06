select cr.car_type car_type, count(cr.car_type) cars
from car_rental_company_car cr
where cr.options like '%열선시트%'
or cr.options like '%통풍시트%'
or cr.options like '%가죽시트%'
group by car_type
order by car_type asc;