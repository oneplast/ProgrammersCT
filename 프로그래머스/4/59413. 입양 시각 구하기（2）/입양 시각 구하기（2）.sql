WITH RECURSIVE JT AS (
    SELECT 0 AS HOUR
    UNION ALL
    SELECT HOUR + 1
    FROM JT
    WHERE HOUR < 23
)

SELECT jt.HOUR AS HOUR, COUNT(a.ANIMAL_ID) AS COUNT
FROM JT jt
LEFT JOIN ANIMAL_OUTS a ON jt.HOUR = HOUR(a.DATETIME)
GROUP BY jt.HOUR
ORDER BY jt.HOUR ASC;