WITH JT AS (
    SELECT EMP_NO, AVG(SCORE) avg
    FROM HR_GRADE
    GROUP BY EMP_NO
)

SELECT e.EMP_NO, e.EMP_NAME,
(CASE
    WHEN jt.avg >= 96 then 'S'
    WHEN jt.avg >= 90 then 'A'
    WHEN jt.avg >= 80 then 'B'
    ELSE 'C'
END) GRADE,
(CASE
    WHEN jt.avg >= 96 then e.SAL * 0.2
    WHEN jt.avg >= 90 then e.SAL * 0.15
    WHEN jt.avg >= 80 then e.SAL * 0.1
    ELSE 0
END) BONUS
FROM HR_EMPLOYEES e
JOIN JT jt ON jt.EMP_NO = e.EMP_NO
ORDER BY e.EMP_NO ASC;