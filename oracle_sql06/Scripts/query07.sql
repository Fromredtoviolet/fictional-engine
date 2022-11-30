/*
 * 웹사이트에 사용할 회원 관리용 테이블을 생성하고 다음의 요구사항에 적합한 SQL문과 ORACLE 객체를 생성한다.
 *  - 일반 사용자는 웹사이트 이용을 위해 회원 가입을 진행해야 한다.
 *  - 회원 가입은 즉시 이루어지지 않으며, 관리자의 승낙을 통해서만 이루어져야 한다.
 *  - 회원 가입에 필요한 정보는 닉네임과 이메일만 있으면 된다. 
 *    (관리를 위해서 추가 정보가 필요하지만 사용자가 입력하는 정보는 닉네임과 이메일뿐)
 *  - 회원 가입을 요청한 사용자는 관리자의 승낙 이후 전달되는 메일 메시지 안의 암호를 통해 로그인 할 수 있다.
 *  - 최초 로그인을 시도하는 회원은 필수적으로 암호를 변경해야하며, 암호를 변경할 때는 회원이 사용할 암호만 있으면 된다.
 * 
 * 테이블은 총 3개를 생성하도록 한다.
 *  - 회원 테이블 : 회원으로 가입된 사용자의 정보가 기록되는 테이블
 *  - 회원 요청 테이블 : 회원 가입을 위해 가입 요청 정보가 기록되는 테이블
 *  - 접속 이력 테이블 : 로그인 및 로그아웃한 회원의 접속 시간을 기록하기 위한 테이블
 */

CREATE TABLE REQ_ACCOUNTS(
		ID NUMBER PRIMARY KEY
	  , NICKNAME VARCHAR2(35) UNIQUE
	  , EMAIL VARCHAR2(100) UNIQUE
	  , ISALLOW CHAR(1) DEFAULT('N') CHECK (ISALLOW IN ('N', 'Y'))
	  , REQDATE DATE DEFAULT(SYSDATE)
);

CREATE SEQUENCE SEQ_REQ_ACCOUNTS NOCACHE;

CREATE TABLE ACCOUNTS(
		ID NUMBER PRIMARY KEY
	  , NICKNAME VARCHAR2(35) UNIQUE
	  , EMAIL VARCHAR2(100) UNIQUE
	  , PASSWORD VARCHAR2(100) NOT NULL
	  , LOGINDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_ACCOUNTS NOCACHE;

CREATE TABLE ACCOUNTS_ACCESS_LOG(
		ID NUMBER PRIMARY KEY
	  , AID NUMBER REFERENCES ACCOUNTS(ID)
	  , LOGTYPE VARCHAR2(5) CHECK (LOGTYPE IN ('LOGIN', 'LOGOUT'))
	  , LOGDATE DATE DEFAULT(SYSDATE)
);
		
CREATE SEQUENCE SEQ_ACCOUNTS_ACCESS_LOG NOCACHE;

/*
 * 회원 가입을 위한 요청 SQL 구문
 */
INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
	   VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'yeng', 'yeng@gmail.com');

INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
	   VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'aaa', 'aaa@gmail.com');

INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
	   VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'bbb', 'bbb@gmail.com');

INSERT INTO REQ_ACCOUNTS(ID, NICKNAME, EMAIL) 
	   VALUES(SEQ_REQ_ACCOUNTS.NEXTVAL, 'ccc', 'ccc@gmail.com');

SELECT * FROM REQ_ACCOUNTS;  
	  
/*
 * 회원 가입 요청을 승낙하기 위한 SQL 구문
 */
UPDATE REQ_ACCOUNTS 
   SET ISALLOW = 'Y'
 WHERE ID = 1;

UPDATE REQ_ACCOUNTS 
   SET ISALLOW = 'Y'
 WHERE REQDATE BETWEEN TO_DATE('20221128') AND TO_DATE('20221201')
   AND ISALLOW = 'N';

INSERT INTO ACCOUNTS(
	SELECT SEQ_ACCOUNT.NEXTVAL
		 , NICKNAME
		 , EMAIL
		 , 'temppassword'
		 , SYSDATE 
	  FROM REQ_ACCOUNTS 
	 WHERE ISALLOW = 'Y'
);

SELECT * FROM ACCOUNTS;
