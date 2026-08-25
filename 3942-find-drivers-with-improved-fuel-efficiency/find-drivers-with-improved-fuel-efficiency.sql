# Write your MySQL query statement below


select d.driver_id, d.driver_name, round(t3.first_half_avg,2) as first_half_avg , round(t3.second_half_avg,2) as second_half_avg,
round((t3.second_half_avg - t3.first_half_avg), 2) as efficiency_improvement

from drivers d

inner join

(
select t1.driver_id, first_half_avg, second_half_avg 
from
(select driver_id, avg(distance_km/fuel_consumed) as first_half_avg 
from trips
where month(trip_date) >= 1 and month(trip_date) <= 6
group by driver_id) t1

inner join

(select driver_id, avg(distance_km/fuel_consumed) as second_half_avg 
from trips
where month(trip_date) >= 7 and month(trip_date) <= 12
group by driver_id ) t2

on t1.driver_id = t2.driver_id

) t3

on t3.driver_id = d.driver_id

where t3.second_half_avg - t3.first_half_avg > 0

order by t3.second_half_avg - t3.first_half_avg desc, d.driver_name asc;

