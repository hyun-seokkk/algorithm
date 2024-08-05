-- 코드를 입력하세요
SELECT BOARD_ID, WRITER_ID, TITLE, PRICE,
case
    when status = "DONE"
    then "거래완료"
    when status = "RESERVED"
    then "예약중"
    when status = "SALE"
    then "판매중"
end as STATUS
from used_goods_board
WHERE CREATED_DATE LIKE "2022-10-05"
order by board_id desc