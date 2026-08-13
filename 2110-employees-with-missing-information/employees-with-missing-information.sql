# Write your MySQL query statement below

select m.employee_id
from
(select employee_id 
from Employees
union
select employee_id
from salaries) as m
left join 
Employees as e
on m.employee_id = e.Employee_id
left join 
Salaries as s
on s.employee_id = m.employee_id
where name is null or salary is null
order by employee_id;




