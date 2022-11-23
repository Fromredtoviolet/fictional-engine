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
 
