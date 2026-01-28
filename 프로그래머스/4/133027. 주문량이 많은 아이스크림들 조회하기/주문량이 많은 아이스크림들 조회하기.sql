select fh.FLAVOR
from FIRST_HALF fh
left join
(
    select FLAVOR, SUM(TOTAL_ORDER) as s
    from JULY 
    group by FLAVOR
) j
on fh.FLAVOR = j.FLAVOR
order by (fh. TOTAL_ORDER + j.s) desc
limit 3