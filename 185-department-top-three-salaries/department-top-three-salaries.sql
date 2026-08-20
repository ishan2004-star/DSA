# Write your MySQL query statement below

select t.department as Department, t.name as Employee, t.salary as Salary
from 
(select e.name as name,e.salary as salary, d.name as department,dense_rank() over(partition by departmentId order by e.salary desc) as rnk
from Employee e
left join Department d
on e.departmentId = d.id ) t

where t.rnk < 4;

