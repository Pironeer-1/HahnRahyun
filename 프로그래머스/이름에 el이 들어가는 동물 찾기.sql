-- 1. WHERE AND 2. ORDER BY 조건 안 읽음

SELECT ANIMAL_ID, NAME FROM ANIMAL_INS WHERE  ANIMAL_TYPE = "Dog" AND NAME LIKE "%EL%" ORDER BY NAME;