/*
 * SYNONYM(동의어) 객체
 *  - 테이블에 별칭을 부여하여 간단한 이름으로 사용할 수 있도록 하는 기능
 * 
 * 비공개 동의어
 *  - 객체에 대한 접근 권한을 부여 받은 사용자가 정의한 동의어
 *  - 사용자명에 해당하는 스키마를 통해서만 사용할 수 있다.
 * 
 * 공개 동의어
 *  - DBA가 정의한 동의어로 접근 권한을 부여받은 모든 사용자가 접근하여 사용할 수 있다.
 *  - 사용자명에 해당하는 스키마를 사용하지 않아도 된다.
 */

-- 여기서부터 순서대로 실행해보면 동의어 설정을 할 수 있다.

/* 관리자 계정에서 작업해야 함 */
CREATE USER user1 IDENTIFIED BY user1;
CREATE USER user2 IDENTIFIED BY user2;

/* USER1 계정에서 동의어 테스트를 진행하기 위해 동의어 생성 권한 부여 */
GRANT CONNECT, RESOURCE, CREATE SYNONYM TO user1;
GRANT CONNECT, RESOURCE TO user2;

ALTER USER user1 quota 10M ON USERS;
ALTER USER user2 quota 10M ON USERS;

/* USER1 계정에서 생성(비공개 동의어용 테스트 테이블) */
CREATE TABLE SAMPLE(
	   ID NUMBER PRIMARY KEY
	 , NAME VARCHAR2(50)
);
INSERT INTO SAMPLE VALUES(1, 'sample');
INSERT INTO SAMPLE VALUES(2, 'table');
INSERT INTO SAMPLE VALUES(3, 'data');

/* USER1 계정에서 생성(공개 동의어용 테스트 테이블) */
CREATE TABLE PUBLIC_SAMPLE(
	   ID NUMBER PRIMARY KEY
	 , NAME VARCHAR2(50)
);
INSERT INTO PUBLIC_SAMPLE VALUES(1, 'sample');
INSERT INTO PUBLIC_SAMPLE VALUES(2, 'table');
INSERT INTO PUBLIC_SAMPLE VALUES(3, 'data');

/* USER1에서 비공개 동의어 생성 후 사용(SAMPLE이 테이블명, SAM이 동의어)*/
CREATE SYNONYM SAM FOR SAMPLE;
SELECT * FROM SAM; /* 단순 테이블명 줄이기 */

/* 관리자 계정 및 USER2 계정에서 다음의 SQL문 실행 */
SELECT * FROM USER1.SAMPLE;			/* 관리자 계정은 실행되지만 USER2 계정은 안됨*/
SELECT * FROM USER1.PUBLIC_SAMPLE;  /* 관리자 계정은 실행되지만 USER2 계정은 안됨*/

/* USER1에서 USER2에게 SAMPLE 테이블에 대한 SELECT 권한 부여 */
GRANT SELECT ON SAMPLE TO USER2;
REVOKE SELECT ON SAMPLE FROM USER2;
-- REVOKE는 권한 빼앗기

/* 권한 부여 완료되면 USER2에서 다시 다음의 조회 쿼리 실행 */
SELECT * FROM USER1.SAMPLE; /* 권한을 부여하면 접근 가능해짐 */
SELECT * FROM USER1.SAM;    /* 비공개 동의어도 사용자명에 해당하는 스키마 정보로 사용 가능*/


/* 공개 동의어 (반드시 관리자 계정으로 접속해서 만들어야 함) */
CREATE PUBLIC SYNONYM PSAM FOR USER1.PUBLIC_SAMPLE;

/* USER2 계정으로 다음의 조회 쿼리 실행*/
SELECT * FROM PSAM; /* 조회 권한이 없어서 이대로는 실행 안 됨*/

/* USER1에서 조회 권한 부여 */
GRANT SELECT ON PUBLIC_SAMPLE TO USER2;

/* 다시 USER2로 다음의 조회 쿼리 실행하면 정상 실행됨 */
SELECT * FROM PSAM;


/* 동의어 생성 확인 */
SELECT * FROM USER_SYNONYMS; /* 접속한 계정에 대한 것만 볼 수 있음 */
SELECT * FROM ALL_SYNONYMS;  /* 모든 계정에 대해 볼 수 있음 */
SELECT * FROM DBA_SYNONYMS;  /* 관리자 계정만 */



