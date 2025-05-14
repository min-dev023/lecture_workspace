
-- 16P

-- 1. 아래의 조건으로 테이블을 생성하세요
-- table명: member / id 컬럼 : 한글, 영문 20자 수용크기
-- pwd 컬럼 : 암호화 해시값용 64자 수용크기 / email 영문 25자 수용 크기

    CREATE TABLE member (
        num int,
        id varchar(20),
        pwd varchar(64),
        email varchar(25),
        primary key(num)
    );

    INSERT INTO member VALUES
        (1, 'admin', 'admin', 'admin@gmail.com'),
        (2, 'user2', 'user2', 'user2@gmail.com'),
        (3, 'user3', 'user3', 'user3@gmail.com'),
        (4, 'user4', 'user4', 'user4@gmail.com')
    ;

    SELECT  *
    FROM    member
    WHERE   1 = 1
    ;

    SELECT  * FROM member WHERE   1 = 1;

-- 2. 아래의 조건으로 member 테이블 구조 변경하기
    -- 1) name 컬럼 추가
    ALTER TABLE member ADD COLUMN name varchar(20);

    -- 2) 테이블명 membership으로 변경
    ALTER TABLE member RENAME membership;

    -- 3) 컬럼명 변경 pwd -> pass
    ALTER TABLE membership CHANGE COLUMN pwd pass VARCHAR(64);
    -- 4) 컬럼 크기 변경 email 크기를 20으로
    ALTER TABLE membership MODIFY COLUMN email VARCHAR(20);


-- 3. 테이블 제거하기

    DROP TABLE membership;

-- 10P

-- 1. 업무가 SALESMAN, CLERK 사원
SELECT  ename, job, sal
FROM    emp
WHERE   1 = 1
AND     JOB IN ('SALESMAN', 'CLERK')
;

-- 2. 급여가 200이상 3000 이하 급여기준 내림차순
SELECT  ename, sal
FROM    emp
WHERE   1 = 1
AND     SAL BETWEEN 2000 AND 3000
ORDER BY SAL DESC
;

-- 3. 이름 k가 들어가는 직원, 입사일 빠른 순
SELECT  ename, sal
FROM    emp
WHERE   1 = 1
AND     ename LIKE ('%K%')
ORDER BY hiredate ASC
;

-- 4. 커미션 하지 않은 사원 , 급여가 높은 순
SELECT  ename, sal, comm
FROM    emp
WHERE   1 = 1
AND     comm IS NULL
ORDER BY sal DESC
;

-- 5. 급여가 높은 상위 3명
SELECT  ename, sal
FROM    emp
WHERE   1 = 1
ORDER BY sal DESC
LIMIT 3
;

-- 6. 급여가 낮은 순 정렬, 상위 2명 제외, 3번째부터 출력
SELECT  ename, sal, deptno
FROM    emp
WHERE   1 = 1
ORDER BY sal ASC
OFFSET 
;

-- 7. 급여 1500 이상 2000 이하가 아닌 사원, 급여 기준 오름차순
SELECT  ename, sal
FROM    emp
WHERE   1 = 1
AND     sal NOT BETWEEN 1500 and 2000
ORDER BY sal ASC
;

-- 8. 부서번호 기준 오름차순, 그 정렬 내에서 급여 높은 순 정렬
SELECT  *
FROM    emp
WHERE   1 = 1
ORDER BY deptno ASC, sal DESC
;




SELECT * FROM 테이블명 LIMIT 10; 
-- 처음 부터 10개만 출력하기 (1 ~ 10)

SELECT * FROM 테이블명 LIMIT 100, 10; 
-- 100번째부터 그 후 10개 출력하기 (101 ~ 110)

SELECT * FROM 테이블명 ORDERS LIMIT 20 OFFSET 5; 
-- 5번째 행 부터 25행 까지 출력 (6 ~ 25)

-- limit 5, 20 과 같다고 보면 된다.
SELECT * FROM 테이블명 ORDERS LIMIT 5, 20