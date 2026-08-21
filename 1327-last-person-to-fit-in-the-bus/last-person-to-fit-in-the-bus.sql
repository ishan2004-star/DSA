# Write your MySQL query statement below


select person_name
from
(select person_name, sum(weight) over(order by turn asc) as w from Queue) q
where w <= 1000
order by w desc
limit 1;