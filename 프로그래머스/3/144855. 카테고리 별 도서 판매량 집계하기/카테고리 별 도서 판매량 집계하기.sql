WITH JT AS (
    SELECT b.CATEGORY, SUM(bs.SALES) AS TOTAL_SALES FROM BOOK_SALES bs
    JOIN BOOK b ON b.BOOK_ID = bs.BOOK_ID
    AND YEAR(bs.SALES_DATE) = '2022'
    AND MONTH(bs.SALES_DATE) = '01'
    GROUP BY b.CATEGORY
)

SELECT *
FROM JT
ORDER BY CATEGORY ASC;