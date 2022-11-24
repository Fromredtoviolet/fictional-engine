/*
 * VIEW 객체
 * 	- SELECT 문의 실행 결과를 저장한 가상 테이블
 *  - 테이블과 다르게 실제 데이터를 저장하고 있지는 않으나 실제 테이블을 사용하는 것과 동일하게 사용 가능
 *  - **복잡한 SELECT 구문을 VIEW로 만들어 간단하게 사용할 수 있다.** (주기능!)
 */
-- V_EMP라는 이름의 뷰가 없으면 CREATE하고, 있으면 REPLACE(수정)해라.
CREATE OR REPLACE VIEW V_EMP
AS
SELECT EMPLOYEE_ID AS EMP_ID
	 , FIRST_NAME || ' ' || LAST_NAME AS EMP_NAME
	 , EMAIL || '@emp.co.kr' as EMAIL
	 , SALARY
	 , MANAGER_ID
	 , DEPARTMENT_ID
  FROM EMPLOYEES
 WHERE MANAGER_ID BETWEEN 200 AND 220
  WITH CHECK OPTION;
 -- WITH READ ONLY : VIEW를 읽기 전용으로만 쓰겠다는 선언
 -- CREATE FORCE VIEW를 하면, 예를 들어 FROM EMP라는 없는 테이블을 쓴다해도 일단 뷰를 생성한다.
 -- WITH CHECK OPTION : WHERE절의 조건을 위반하는지 체크한다.
 
SELECT * FROM V_EMP;

/*
 * VIEW를 사용하여 INSERT, UPDATE, DELETE 작업을 할 수 있지만
 * 다음의 경우에는 사용할 수 없다. (이건 주기능이 아닌 부가기능일뿐..)
 *  1. VIEW에 포함되지 않은 컬럼을 사용하는 경우
 *  2. VIEW에 포함되지 않은 컬럼 중에 NOT NULL 제약조건이 있는 경우
 *  3. 산술 표현식으로 정의된 경우
 *  4. 그룹함수나 GROUT BY 절이 포함된 경우
 *  5. DISTINCT 키워드가 있는 경우
 *  6. JOIN을 사용하여 여러 테이블이 결합된 경우
 */

UPDATE V_EMP 
   SET MANAGER_ID = 211
 WHERE DEPARTMENT_ID = 120;




/* 
 * 뷰 연습삼아 문제 재활용하기~~~~~~
 * 100 번 사원이 공지를 열람한다는 가정하에 100 번 사원이 소속된 부서의 공지와 전체 공지가
 * 보일수 있는 SELECT 쿼리문을 작성하세요.
 */
   
CREATE OR REPLACE VIEW V_NOTICE
AS
SELECT NVL(E.EMPLOYEE_ID, 0) AS EMP_ID 
	 , N.ID
     , N.TITLE
     , N.CONTENT
     , N.WRITE_DATE
     , N.DEPT_ID
     , NVL((SELECT DEPARTMENT_NAME_KR FROM DEPARTMENTS D WHERE D.DEPARTMENT_ID = N.DEPT_ID), '전체') AS DEPT_NAME
   FROM NOTICE N
  LEFT OUTER JOIN EMPLOYEES E
    ON N.DEPT_ID = E.DEPARTMENT_ID;

SELECT * FROM V_NOTICE
 WHERE EMP_ID = 100
    OR DEPT_ID = 0;
   
   
   
/*
 * EMPLOYEES 테이블에서 JOB_ID는 JOBS 테이블의 JOB_TITLE이 조회되고
 * DEPARTMENT_ID는 DEPARTMENTS 테이블의 DEPARTMENT_NAME이 조회되고
 * MANAGER_ID는 EMPLOYEES 테이블의 FIRST_NAME, LAST_NAME이 결합된 이름으로 조회되는
 * VIEW를 생성해보세요.(나머지 컬럼은 그대로 조회하게 합니다.)
 */ 
CREATE OR REPLACE VIEW V_EMPLOYEES
AS
SELECT E1.EMPLOYEE_ID
	 , E1.FIRST_NAME
	 , E1.LAST_NAME
	 , E1.EMAIL
	 , E1.PHONE_NUMBER
	 , E1.HIRE_DATE
	 , J.JOB_TITLE
	 , E1.SALARY 
	 , E1.COMMISSION_PCT
	 , E2.FIRST_NAME || ' ' || E2.LAST_NAME AS MANAGER_NAME
	 , D.DEPARTMENT_NAME
FROM EMPLOYEES E1
JOIN JOBS J
ON E1.JOB_ID = J.JOB_ID 
JOIN EMPLOYEES E2
ON E1.MANAGER_ID = E2.EMPLOYEE_ID
JOIN DEPARTMENTS D
ON E1.DEPARTMENT_ID = D.DEPARTMENT_ID;

SELECT * FROM V_EMPLOYEES;










