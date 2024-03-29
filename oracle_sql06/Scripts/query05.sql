/*
 * TRIGGER 객체
 *  - PL/SQL 구문을 사용하여 생성할 수 있는 객체
 *  - 테이블 또는 뷰에 INSERT, UPDATE, DELETE 문에 의한 변경이 발생할 경우
 *    자동으로 실행할 내용을 정의하여 실행하게 하는 객체
 *  - 변경 전/후를 구분하여 자동으로 실행할 내용을 정의할 수 있다.
 */
CREATE TABLE TEST1(
		ID NUMBER
	  , NAME VARCHAR2(10)
);

CREATE TABLE TEST2(
		ID NUMBER
	  , NAME VARCHAR2(10)
);

CREATE OR REPLACE TRIGGER TRI_SAMPLE1
AFTER INSERT ON TEST1 FOR EACH ROW
BEGIN 
	INSERT INTO TEST2 VALUES(:NEW.ID, :NEW.NAME);
END;

INSERT INTO TEST1 VALUES(2, 'B');
INSERT INTO TEST1(
	SELECT 4, 'D' FROM DUAL 
	UNION ALL
	SELECT 5, 'E' FROM DUAL 
	UNION ALL
	SELECT 6, 'F' FROM DUAL
);

CREATE OR REPLACE TRIGGER TRI_SAMPLE2
BEFORE UPDATE OF NAME ON TEST1 FOR EACH ROW /* 값이 들어갈땐 행 트리거 */
BEGIN 							/* FOR EACH ROW 없으면 문장 트리거 */					
	UPDATE TEST2
	   SET NAME = :NEW.NAME
	 WHERE ID = :NEW.ID;
	DBMS_OUTPUT.PUT_LINE('UPDATE 트리거 발생!');
	END;

UPDATE TEST1
   SET ID = ID * 10
 WHERE ID = 1;

UPDATE TEST1
   SET NAME = 'b'
 WHERE ID = 2; 

SELECT * FROM TEST2;

SELECT * FROM USER_ERRORS;


CREATE OR REPLACE TRIGGER TRI_ADD_EMPLOYEE
BEFORE INSERT ON EMPLOYEES FOR EACH ROW 
BEGIN 
	UPDATE DEPARTMENTS 
	   SET TOTAL = TOTAL + 1
	 WHERE DEPARTMENT_ID = :NEW.DEPARTMENT_ID;
END;

INSERT INTO EMPLOYEES VALUES(208, '홍', '길동', 'GILL', NULL, SYSDATE, 'IT_PROG', 4000, NULL, NULL, 60);


CREATE OR REPLACE TRIGGER TRI_DEL_EMPLOYEE
BEFORE DELETE ON EMPLOYEES FOR EACH ROW 
BEGIN 
	UPDATE DEPARTMENTS 
	   SET TOTAL = TOTAL - 1
	 WHERE DEPARTMENT_ID = :OLD.DEPARTMENT_ID;
	DBMS_OUTPUT.PUT.LINE(:NEW.FIRST_NAME || :NEW.LAST_NAME || :NEW.DEPARTMENT_ID);
	DBMS_OUTPUT.PUT.LINE(:OLD.FIRST_NAME || :OLD.LAST_NAME || :OLD.DEPARTMENT_ID);
END;

DELETE FROM EMPLOYEES WHERE EMPLOYEE_ID = 208;



CREATE OR REPLACE TRIGGER TRI_MOD_EMPLOYEE
AFTER UPDATE OF DEPARTMENT_ID ON EMPLOYEES FOR EACH ROW 
BEGIN 
	UPDATE DEPARTMENTS 
	SET TOTAL = TOTAL + 1
	WHERE DEPARTMENT_ID = :NEW.DEPARTMENT_ID;

	UPDATE DEPARTMENTS 
	SET TOTAL = TOTAL - 1
	WHERE DEPARTMENT_ID = :OLD.DEPARTMENT_ID;

	DBMS_OUTPUT.PUT_LINE(:NEW.FIRST_NAME || :NEW.LAST_NAME || :NEW.DEPARTMENT_ID);
	DBMS_OUTPUT.PUT_LINE(:OLD.FIRST_NAME || :OLD.LAST_NAME || :OLD.DEPARTMENT_ID);
END;

UPDATE EMPLOYEES SET DEPARTMENT_ID = 60 WHERE EMPLOYEE_ID = 208;

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 208;
SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID IN (60, 70);

SELECT * FROM USER_ERRORS;