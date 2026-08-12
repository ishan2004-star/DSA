# Write your MySQL query statement below

select b.stock_name, (s.sell - b.buy) as capital_gain_loss
from 
(select stock_name, sum(price) as buy
from Stocks
where operation = 'buy'
group by stock_name) b
join 
(select stock_name, sum(price) as sell
from Stocks
where operation = 'sell'
group by stock_name) s
on b.stock_name = s.stock_name
