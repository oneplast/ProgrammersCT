SELECT LEFT(PRODUCT_CODE, 2) AS CATEGORY, count(*) AS PRODUCTS
FROM PRODUCT
GROUP BY CATEGORY
ORDER BY CATEGORY ASC;