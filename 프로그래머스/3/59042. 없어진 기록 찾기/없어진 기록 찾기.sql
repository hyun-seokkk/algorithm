-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
from animal_outs o 
left outer join animal_ins i
on o.ANIMAL_ID = i.ANIMAL_ID
where i.ANIMAL_ID is null
order by ANIMAL_ID;