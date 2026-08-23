# Write your MySQL query statement below


select distinct user_id,(
    select round(avg(activity_duration), 2) from userActivity a
    where activity_type = 'free_trial' and a.user_id = u.user_id 
) as trial_avg_duration ,
(
    select round(avg(activity_duration), 2) from userActivity b
    where activity_type = 'paid' and b.user_id = u.user_id
)  as paid_avg_duration
from UserActivity u
where activity_type = 'free_trial' and
user_id in (
        select user_id from UserActivity where activity_type = 'paid'         
)
order by user_id asc;