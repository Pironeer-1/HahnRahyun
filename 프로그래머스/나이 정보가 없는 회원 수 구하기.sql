-- count(AGE)는 AGE 컬럼 중 null 값을 제외하고 찾기 때문에 결과 값이 0
SELECT COUNT(*) AS USERS
FROM USER_INFO
WHERE AGE IS NULL;