CREATE TABLE T1(
	   ID NUMBER PRIMARY KEY
	 , NAME VARCHAR2(10)
	 , VDTYPE CHAR(1)
	 , CNT NUMBER
);

CREATE TABLE T2(
	   NAME VARCHAR2(10) PRIMARY KEY
	 , CNT NUMBER
);

CREATE SEQUENCE SEQ_T1 NOCACHE;

DECLARE
	VNAME VARCHAR2(10);
	VDTYPE CHAR(1);
	VCNT NUMBER;
	EXISTS_NAME NUMBER;
BEGIN
	VNAME := :이름;
	VDTYPE := :타입;
	VCNT := :수량;
	INSERT INTO T1 VALUES(SEQ_T1.NEXTVAL, VNAME, VDTYPE, VCNT);
	SELECT COUNT(*)
	  INTO EXISTS_NAME
	  FROM T2
	 WHERE NAME = VNAME;
	IF(EXISTS_NAME = 0) THEN
		INSERT INTO T2 VALUES(VNAME, VCNT);
	ELSE
		IF(VDTYPE = 'I') THEN
			UPDATE T2
		   	   SET CNT = CNT + VCNT
		 	 WHERE NAME = VNAME;
		ELSIF(VDTYPE = 'O') THEN
			UPDATE T2
		   	   SET CNT = CNT - VCNT
		 	 WHERE NAME = VNAME;
		ELSE
			DBMS_OUTPUT.PUT_LINE('롤백 합니다!');
			ROLLBACK;
		END IF;
	END IF;
	DBMS_OUTPUT.PUT_LINE('커밋 합니다!');
	COMMIT;
END;

SELECT * FROM T1;
SELECT * FROM T2;


/*
 * LOGIN 테이블 생성한다.
 * 	 USERNAME : 사용자 ID가 저장될 컬럼
 *   PASSWORD : 패스워드가 저장될 컬럼
 *   TRY_CNT : 시도횟수가 저장될 컬럼
 *   LOGIN_LOCK : 로그인 잠김 유무가 저장될 컬럼
 *   LOCK_DATE : 로그인이 잠긴 날짜가 저장될 컬럼
 * 
 * USERNAME과 PASSWORD를 입력받을 수 있는 PL/SQL 구문을 작성하여
 * 최대 입력 횟수 3번을 초과한 경우 더이상 로그인을 수행할 수 없도록
 * 만드는 PL/SQL을 작성하시오.
 * 
 * 추가 기능
 * 	 - 로그인이 잠긴 시점을 기록해 두었다가 5분의 시간이 지난 이후에는
 * 	   다시 로그인을 시도할 수 있도록 하세요.
 */

CREATE TABLE LOGIN(
	USERNAME VARCHAR2(25) PRIMARY KEY
  , PASSWORD VARCHAR2(25) NOT NULL
  , TRY_CNT NUMBER DEFAULT(0)
  , LOGIN_LOCK CHAR(4)
  , LOCK_DATE DATE
);

INSERT INTO LOGIN(USERNAME, PASSWORD) VALUES('test', 'test');

SELECT * FROM LOGIN;

DECLARE
    VUSERNAME VARCHAR2(25);
    VPASSWORD VARCHAR2(25);
    EXISTS_USER NUMBER;
    CUSERNAME VARCHAR(25);
    CPASSWORD VARCHAR2(25);
    RCNT NUMBER;
    CLOGIN_LOCK CHAR(4);
    CLOCK_DATE DATE;
BEGIN
    VUSERNAME := :계정명;
    VPASSWORD := :패스워드;
    
    SELECT COUNT(*)
      INTO EXISTS_USER
      FROM LOGIN
     WHERE USERNAME = VUSERNAME;
      
    IF(EXISTS_USER = 0) THEN
        /* 계정 정보가 없습니다. */
        DBMS_OUTPUT.PUT_LINE('계정 정보가 존재하지 않습니다.');
    ELSE
        /* 계정 정보가 있습니다. */
        SELECT USERNAME, PASSWORD, TRY_CNT, LOGIN_LOCK, LOCK_DATE
          INTO CUSERNAME, CPASSWORD, RCNT, CLOGIN_LOCK, CLOCK_DATE
          FROM LOGIN
         WHERE USERNAME = VUSERNAME;
        
        IF CLOGIN_LOCK = 'LOCK' AND SYSDATE < (CLOCK_DATE + INTERVAL '5' MINUTE) THEN
            DBMS_OUTPUT.PUT_LINE('계정이 잠겨있습니다. ' || (CLOCK_DATE + INTERVAL '5' MINUTE)
                || ' 이후에 다시 시도하세요.');
        ELSE
            IF(VPASSWORD = CPASSWORD) THEN
                /* 패스워드가 일치 합니다. */
                DBMS_OUTPUT.PUT_LINE('로그인에 성공하였습니다.');
            ELSE
                /* 패스워드가 일치하지 않습니다. */
                DBMS_OUTPUT.PUT_LINE('로그인에 실패하였습니다.');
            
                IF RCNT + 1 = 3 THEN
                    DBMS_OUTPUT.PUT_LINE('로그인 시도 3회 실패하였습니다. 계정이 5분간 잠김니다.');
                    UPDATE LOGIN
                       SET LOGIN_LOCK = 'LOCK'
                         , LOCK_DATE = SYSDATE
                     WHERE USERNAME = VUSERNAME;
                ELSE
                    DBMS_OUTPUT.PUT_LINE('남은 로그인 횟수: ' || TO_CHAR(3 - (RCNT + 1)) || '회 남았습니다.');
                    UPDATE LOGIN
                       SET TRY_CNT = TRY_CNT + 1
                     WHERE USERNAME = VUSERNAME;
                END IF;
            END IF;
        END IF;
    END IF;
END;
