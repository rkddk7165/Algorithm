select FLAVOR from (
select FLAVOR, SUM(TOTAL_ORDER) as total_sum
from
(
    select FLAVOR, TOTAL_ORDER
    from FIRST_HALF f

UNION ALL

    select FLAVOR, SUM(TOTAL_ORDER) as TOTAL_ORDER
    from JULY j
    group by FLAVOR
) d
    
group by FLAVOR
order by total_sum desc
    ) dddd
    limit 3