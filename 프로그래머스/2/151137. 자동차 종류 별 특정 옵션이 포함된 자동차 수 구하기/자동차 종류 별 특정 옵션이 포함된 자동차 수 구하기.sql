SELECT t.CAR_TYPE as CAR_TYPE, COUNT(*) as CARS
from
(SELECT *
from CAR_RENTAL_COMPANY_CAR
where OPTIONS like '%열선시트%' or OPTIONS like '%가죽시트%' or OPTIONS like '%통풍시트%') as t
GROUP BY t.CAR_TYPE
order by t.car_type asc 