-- 코드를 입력하세요
SELECT count(*) as USERS
from user_info
where JOINED between '20210101' and '20211231'
and age between 20 and 29