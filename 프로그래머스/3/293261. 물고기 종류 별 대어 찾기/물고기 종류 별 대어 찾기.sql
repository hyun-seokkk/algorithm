SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
INNER JOIN FISH_NAME_INFO B ON A.FISH_TYPE = B.FISH_TYPE
WHERE (B.FISH_TYPE, LENGTH) IN (SELECT A.FISH_TYPE, MAX(A.LENGTH)
                                FROM FISH_INFO A
                                GROUP BY A.FISH_TYPE)
ORDER BY A.ID