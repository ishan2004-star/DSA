# Write your MySQL query statement below

SELECT 
    e.employee_id,
    e.employee_name,
    e.department,
    t2.meeting_heavy_weeks

FROM employees e

INNER JOIN (

    SELECT 
        t1.employee_id,
        COUNT(*) AS meeting_heavy_weeks

    FROM (

        SELECT 
            employee_id,
            YEAR(meeting_date) AS meeting_year,
            WEEK(meeting_date, 1) AS meeting_week,
            SUM(duration_hours) AS duration

        FROM meetings

        GROUP BY 
            employee_id,
            YEAR(meeting_date),
            WEEK(meeting_date, 1)

        HAVING duration > 20

    ) t1

    GROUP BY t1.employee_id

    HAVING meeting_heavy_weeks >= 2

) t2

ON e.employee_id = t2.employee_id

ORDER BY 
    t2.meeting_heavy_weeks DESC,
    e.employee_name ASC;