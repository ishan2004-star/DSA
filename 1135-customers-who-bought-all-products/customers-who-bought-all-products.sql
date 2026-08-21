# Write your MySQL query statement below

select r.customer_id 
from 
(select distinct customer_id, product_key from Customer c) r
group by r.customer_id
having count(r.customer_id) = (select count(*) from Product)

