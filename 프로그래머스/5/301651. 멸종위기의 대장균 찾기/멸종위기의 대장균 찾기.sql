WITH recursive jt AS (
    SELECT id, parent_id, 1 AS generation
    FROM ecoli_data
    WHERE parent_id IS NULL
    UNION ALL
    SELECT ne.id, ne.parent_id, jt.generation + 1
    FROM ecoli_data ne
    JOIN jt ON jt.id = ne.parent_id
),

njt AS (
    SELECT pe.id
    FROM ecoli_data pe
    LEFT JOIN ecoli_data ce ON pe.id = ce.parent_id
    WHERE ce.id IS NULL
)

SELECT COUNT(jt.generation) as COUNT, jt.generation AS GENERATION
FROM jt
JOIN njt ON jt.id = njt.id
GROUP BY jt.generation
ORDER BY jt.generation ASC;