# Write your MySQL query statement below


SELECT department, employee, salary
FROM (
    SELECT d.name AS department,
           e.name AS employee,
           e.salary,
           DENSE_RANK() OVER (
               PARTITION BY d.id
               ORDER BY e.salary DESC
           ) AS rnk
    FROM Employee e
    JOIN Department d
      ON e.departmentId = d.id
) AS m
WHERE rnk = 1;
