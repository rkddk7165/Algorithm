-- 코드를 입력하세요
SELECT ROUND(avg(DAILY_FEE)) as AVERAGE_FEE
from CAR_RENTAL_COMPANY_CAR as c
where c.CAR_TYPE = "SUV"
group by c.CAR_TYPE