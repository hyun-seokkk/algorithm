-- 코드를 입력하세요
SELECT 
    food_type, 
    rest_id, 
    rest_name, 
    favorites 
from 
    rest_info T1
where 
    favorites = (
        select max(favorites) 
        from rest_info T2 
        where T1.food_type = T2.food_type
    )
group by food_type
order by food_type desc