CREATE TABLE STUDENT (번호 INT, 이름 VARCHAR(10), 학과코드 INT);


INSERT INTO STUDENT VALUES
    (1, '장원영', '101')
   ,(2, '안유진', '201')
;

SELECT  S.*
FROM    STUDENT S
WHERE   1 = 1
;

CREATE TABLE DEPT (학과코드 INT, 학과명 VARCHAR(20));

INSERT INTO DEPT VALUES
    (101, '')
   ,(102, '') 
;

SELECT  D.*
FROM    DEPT D
WHERE   1 = 1
;

SELECT  S.이름
       ,D.학과명
FROM    STUDENT S
       ,DEPT    D
WHERE   1 = 1
AND     S.학과코드 = D.학과코드
;


-- DML
    -- SELECT UPDATE DELETE INSERT
-- DCL
    -- GRANT REVOKE
-- DDL
    -- CREATE ALTER DROP
-- TCL 
    -- COMMIT ROLLBACK

SELECT  *
FROM    STUDENT
WHERE   1 = 1
;

INSERT INTO STUDENT VALUES (1, 2, 3, 4)
;

insert into dept(deptno,dname,loc) values
    (10 ,'ACCOUNTING'   ,'NEW YORK' )
   ,(20 ,'RESEARCH'     ,'DALLAS'   )
   ,(30 ,'SALES'        ,'CHICAGO'  )
   ,(40 ,'OPERATIONS'   ,'BOSTON'   )
;

create table emp(
     empno      int primary key auto_increment
    ,ename      varchar(10)     
    ,job        varchar(9)         
    ,mgr        int
    ,hiredate   timestamp
    ,sal        int
    ,comm       int
    ,deptno     int
);

SELECT  D.deptno
       ,D.dname
       ,E.empno
       ,E.ename
FROM    DEPT d
       ,EMP  e
WHERE   1 = 1
AND     d.deptno = e.deptno
;

-- emp 사원 dept 부서

-- 문제 1) 
SELECT  *
FROM    EMP2
WHERE   1 = 1
;
-- 문제 2
SELECT  ename
       ,sal
FROM    EMP
WHERE   1 = 1
;
-- 문제 3
SELECT  ename
       ,sal
FROM    EMP
WHERE   1 = 1
AND     deptno = 10
;
-- 문제 4
SELECT  ename
       ,sal
FROM    EMP
WHERE   1 = 1
AND     sal >= 3000
;
-- 문제 5
SELECT  ename
       ,hiredate
FROM    EMP
WHERE   1 = 1
AND     job = 'MANAGER'
;
-- 문제 6
SELECT  ename
       ,sal
FROM    EMP
WHERE   1 = 1
AND     sal BETWEEN 1000 AND 3000
ORDER BY 2
;
-- 문제 7
SELECT  ename
FROM    EMP
WHERE   1 = 1
AND     sal <= 2000 OR comm >= 500
;
-- 문제 8
SELECT  *
FROM    EMP
WHERE   1 = 1
AND     ename like 'A%'
;
-- 문제 9
SELECT  ename
       ,comm 
FROM    EMP
WHERE   1 = 1
AND     comm is not null
;
-- 문제 10
SELECT  *
FROM    EMP
WHERE   1 = 1
AND     job = 'SALESMAN'
;
-- 문제 11
SELECT  *
FROM    dept2
WHERE   1 = 1
;
-- 문제 12
SELECT  ROUND((sal*110)/100, 1) as ADDSAL
       ,(sal*110)/100 as ADDSAL2
       ,E.sal 
       ,E.*
FROM    EMP E
WHERE   1 = 1
; 
-- 문제 13
SELECT  hiredate
       ,ename
       ,E.*
FROM    EMP E
WHERE   1 = 1
ORDER BY hiredate asc
; 
-- 문제 14
SELECT  sal
       ,ename
       ,E.*
FROM    EMP E
WHERE   1 = 1
ORDER BY sal desc
; 

INSERT INTO dept2 VALUES('50','secret','SEOUL');

UPDATE dept2 SET dname='SECRET' WHERE deptno=50;
DELETE FROM emp2 WHERE sal=800;
SELECT  * FROM    EMP2 WHERE   1 = 1;
SELECT  * FROM    dept2 WHERE   1 = 1;
DELETE FROM emp2 WHERE deptno = 10;

UPDATE emp2 SET job='분석'WHERE empno = 7788;

drop table emp2;

-- 문제 3
UPDATE dept2 SET dname='세일즈' WHERE deptno=30;

-- 문제 4
UPDATE emp2 SET sal=3500 WHERE ename='WARD';
-- 문제 5
UPDATE emp2 SET ename='회장', sal=9000, comm=5000 WHERE empno=7839;
-- 문제 6
DELETE FROM emp2 WHERE SAL < 1000;