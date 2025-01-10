WITH JT AS (
    SELECT d.ID, d.EMAIL, s.NAME, s.CATEGORY
    FROM DEVELOPERS d
    JOIN SKILLCODES s
    ON d.SKILL_CODE & s.CODE = s.CODE
)

SELECT
(CASE
    WHEN SUM(CASE WHEN NAME = 'Python' THEN 1 ELSE 0 END) > 0
        AND SUM(CASE WHEN CATEGORY = 'Front End' THEN 1 ELSE 0 END) > 0 THEN 'A'
    WHEN SUM(CASE WHEN NAME = 'C#' THEN 1 ELSE 0 END) > 0 THEN 'B'
    WHEN SUM(CASE WHEN CATEGORY = 'Front End' THEN 1 ELSE 0 END) THEN 'C'
    ELSE NULL
END) GRADE, ID, EMAIL
FROM JT
GROUP BY ID, EMAIL
HAVING GRADE IS NOT NULL
ORDER BY 1 ASC, 2 ASC;