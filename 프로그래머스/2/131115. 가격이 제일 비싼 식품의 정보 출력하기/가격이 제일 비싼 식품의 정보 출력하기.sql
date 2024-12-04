select product_id, product_name, product_cd, category, price
from food_product f
join
(select max(price) max_price from food_product) j
on j.max_price = f.price;