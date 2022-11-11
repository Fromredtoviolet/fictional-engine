
/*
 * 함수
 *   - 문자 함수 : 문자열에서 일부 문자열만 잘라내거나, 공백제거, 대소문자변환, 일부내용변경
 * 				등의 기능을 제공
 *   - 숫자 함수 : 소수점 처리에 대한 기능 제공
 *   - 날짜 함수 : 시스템날짜 생성 및 날짜에서 년, 월, 일 등의 정보를 추출하기 위한 기능 제공
 *   - 형변환 함수 : 문자 데이터를 숫자 데이터로 또는 그 반대로 변환하거나  
 * 				  문자 데이터를 날짜 데이터로 변환 또는 그 반대로 변환하기 위한 기능 제공
 *   - 그룹 함수 : Record Set 을 이용하여 전체 레코드 수, 최대값, 최소값 등의 정보를
 * 				얻을 수 있는 기능을 제공
 * 문자 함수, 숫자 함수, 날짜 함수, 형변환 함수는 '단일 함수'이다.
 *   단일 함수 : 레코드 하나에 결과값 하나가 나오는 함수
 *   그룹 함수 : 레코드 여러개(그룹)에 결과값 하나가 나오는 함수
 */

/*
 * 문자 함수 (단일 함수)
 */
SELECT EMAIL
	 , LENGTH(EMAIL) AS 문자열길이
  FROM EMPLOYEES;
  
SELECT JOB_ID
	 , INSTR(JOB_ID, '_') AS 문자위치
  FROM EMPLOYEES;
  
SELECT JOB_ID
	 , SUBSTR(JOB_ID, 1, 2)  AS 잘라내기1
	 , SUBSTR(JOB_ID, 4) AS 잘라내기2
  FROM EMPLOYEES;
  
SELECT FIRST_NAME || ' ' || LAST_NAME AS 이름
	 , UPPER(FIRST_NAME || ' ' || LAST_NAME) AS 대문자이름
	 , LOWER(FIRST_NAME || ' ' || LAST_NAME) AS 소문자이름
	 , INITCAP(FIRST_NAME || ' ' || LAST_NAME) AS 첫번째문자만대문자
	 , CONCAT(FIRST_NAME, LAST_NAME) AS 결합
  FROM EMPLOYEES;
  
SELECT EMAIL
	 , RPAD(EMAIL, 20) AS 오른쪽에여백추가1
	 , LPAD(EMAIL, 20) AS 왼쪽에여백추가1
	 , RPAD(EMAIL, 20, '*') AS 오른쪽에여백추가2
	 , LPAD(EMAIL, 20, '*') AS 왼쪽에여백추가2
  FROM EMPLOYEES;
 
SELECT TRIM(EMAIL || '    ') AS 이메일1
	 , TRIM('    ' || EMAIL) AS 이메일2
	 , EMAIL || '@emp.co.kr' AS 원본이메일형식
	 , RTRIM(EMAIL || '@emp.co.kr', '@emp.co.kr') AS 도메인제거
	 , LTRIM(EMAIL || '@emp.co.kr', EMAIL) AS 계정명제거
  FROM EMPLOYEES;
 
SELECT PHONE_NUMBER
	 , REPLACE(PHONE_NUMBER, '.', '-') AS 전화번호
  FROM EMPLOYEES;

-- SUBSTR 함수와 그 외 추가 문자 함수 이용하여 계정, 도메인을 분리하시오.
-- LTRIM, RTRIM을 사용하지 않는다.
SELECT EMAIL || '@emp.co.kr' AS 원본이메일형식
	 , SUBSTR(EMAIL || '@emp.co.kr', 1, (INSTR(EMAIL || '@emp.co.kr', '@')-1))  AS 계정만분리
	 , SUBSTR(EMAIL || '@emp.co.kr', INSTR(EMAIL || '@emp.co.kr', '@')) AS 도메인만분리
  FROM EMPLOYEES;

/*
 * 숫자 함수 (단일 함수)  
 */
SELECT ABS(-10) AS 절대값
	 , MOD(10, 7) AS 나머지
	 , ROUND(12.345, 1) AS 반올림
	 , ROUND(12.356, 1) AS 반올림2
	 , ROUND(12.345, 2) AS 반올림3
	 , ROUND(12.356, 2) AS 반올림4
	 , FLOOR(12.345) AS 버림1
	 , TRUNC(12.345, 1) AS 버림2
	 , TRUNC(12.345, 2) AS 버림3
	 , CEIL(12.345) AS 올림
  FROM DUAL;
 -- DUAL은 그냥 오라클이 제공하는 테스트용 더미 테이블
 
/*
 * 날짜 함수
 */
SELECT SYSDATE AS 현재시스템날짜
	 , SYSTIMESTAMP AS 현재시스템타임스탬프
  FROM DUAL;
 
SELECT EXTRACT(YEAR FROM SYSDATE) AS 년도
	 , EXTRACT(MONTH FROM SYSDATE) AS 월
	 , EXTRACT(DAY FROM SYSDATE) AS 일
	 , EXTRACT(HOUR FROM SYSTIMESTAMP) AS 시
	 , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS 분
	 , EXTRACT(SECOND FROM SYSTIMESTAMP) AS 초
  FROM DUAL;
 
SELECT ADD_MONTHS(SYSDATE, 1) AS "1개월 뒤"
	 , ADD_MONTHS(SYSDATE, 2) AS "2개월 뒤"
  FROM DUAL;
 
SELECT LAST_DAY(SYSDATE)
	 , LAST_DAY(ADD_MONTHS(SYSDATE, 1))
	 , LAST_DAY(ADD_MONTHS(SYSDATE, 2))
  FROM DUAL; 
 
SELECT NEXT_DAY(SYSDATE, 1) AS "다음 일요일"
	 , NEXT_DAY(SYSDATE, 2) AS "다음 월요일"
	 , NEXT_DAY(SYSDATE, 3) AS "다음 화요일"
	 , NEXT_DAY(SYSDATE, 4) AS "다음 수요일"
	 , NEXT_DAY(SYSDATE, 5) AS "다음 목요일"
	 , NEXT_DAY(SYSDATE, 6) AS "다음 금요일"
	 , NEXT_DAY(SYSDATE, 7) AS "다음 토요일"
  FROM DUAL; 
 
SELECT MONTHS_BETWEEN(SYSDATE, ADD_MONTHS(SYSDATE, 5)) AS 개월차
  FROM DUAL; 
-- 앞 날짜에서 뒤 날짜를 빼서 개월 차를 구한다
 
SELECT SYSDATE AS 현재날짜
	 , SYSDATE + INTERVAL '10' DAY AS "10일 뒤"
	 , SYSDATE - INTERVAL '10' DAY AS "10일 전"
	 , SYSDATE + INTERVAL '10' MONTH AS "10개월 뒤"
	 , SYSDATE - INTERVAL '10' MONTH AS "10개월 전"
	 , SYSDATE + INTERVAL '10' YEAR AS "10년 뒤"
	 , SYSDATE - INTERVAL '10' YEAR AS "10년 전"
  FROM DUAL;
-- MONTH와 달리 ADD_DAYS는 없으므로 "며칠 뒤" 같은 표현은 연산을 해야 함
 
SELECT SYSDATE + INTERVAL '10' HOUR AS "10시간 뒤"
	 , SYSDATE - INTERVAL '10' HOUR AS "10시간 전"
	 , SYSDATE + INTERVAL '10' MINUTE AS "10분 뒤"
	 , SYSDATE - INTERVAL '10' MINUTE AS "10분 전"
	 , SYSDATE + INTERVAL '10' SECOND AS "10초 뒤"
	 , SYSDATE - INTERVAL '10' SECOND AS "10초 전"
  FROM DUAL;
 
/*
 * 형변환 함수
 * 	TO_CHAR(숫자 또는 날짜) : 문자로 변환
 * 	TO_NUMBER(문자) : 숫자로 변환
 *  TO_DATE(숫자 또는 문자) : 날짜로 변환
 */
SELECT '1234' AS 문자타입
	 , 1234 AS 숫자타입
	 , SYSDATE AS 날짜타입
  FROM DUAL;

SELECT TO_CHAR(1234)
	 , TO_CHAR(12.34)
	 , TO_CHAR(SYSDATE)
  FROM DUAL;

SELECT TO_CHAR(123456, '999,999,999') AS A
	 , TO_CHAR(123456, '000,000,000') AS B
	 , TO_CHAR(123456.789, '999,999,999.99999') AS C
	 , TO_CHAR(123456.789, '000,000,000.00000') AS D
  FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'YYYYMMDD') AS A
	 , TO_CHAR(SYSDATE, 'YYYY/MM/DD') AS B
	 , TO_CHAR(SYSDATE, 'YYYY-MM-DD') AS C
	 , TO_CHAR(SYSDATE, 'YYYY.MM.DD') AS D
	 , TO_CHAR(SYSDATE, 'YYYY"년" MM"월" DD"일"') AS E
  FROM DUAL;
 
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') AS A
	 , TO_CHAR(SYSDATE, 'HH24:MI:SS') AS B
	 , TO_CHAR(SYSDATE, 'HH24"시" MI"분" SS"초"') AS C
  FROM DUAL;
 
SELECT TO_NUMBER('1234') AS A  
	 , TO_NUMBER('12.34') AS B
	 , TO_NUMBER('1,000', '999,999') AS C
  FROM DUAL;
 
SELECT TO_DATE(20221111) AS A
	 , TO_DATE('20221111') AS B
	 , TO_DATE('2022/11/11') AS C
	 , TO_DATE('2022-11-11') AS D
	 , TO_DATE('2022.11.11') AS E
	 , TO_DATE('2022년 11월 11일', 'YYYY"년" MM"월" DD"일"') AS F
  FROM DUAL;

 
/*
 * NVL 함수 : NULL 데이터를 다른 값으로 변환할 때 사용
 */
SELECT 10 * 2 AS 계산결과1
	 , NVL(NULL,10) * 2 AS 계산결과2
	 , 10 * NVL(NULL, 2) AS 계산결과3
  FROM DUAL;
 
SELECT SALARY
	 , COMMISSION_PCT
	 , SALARY * NVL(COMMISSION_PCT, 0)
  FROM EMPLOYEES;

 
/*
 * DECODE 함수 : 값에 따라 사용할 값을 변경할 때 사용
 * 				SWITCH문과 비슷한 역할 수행
 */
SELECT REGION_ID 
	 , DECODE(REGION_ID, 1, '유럽', 2, '아메리카', 3, '아시아', 4, '중동아시아 및 아프리카', '호주') 
	 , REGION_NAME 
  FROM REGIONS;


/*
 * CASE WHEN ... THEN ... END
 * (IF문과 비슷한 역할 수행)
 * CASE 컬럼이 생기고, 여기에 WHEN식이 THEN으로 반환되며 END로 함수를 종료한다.
 */
SELECT EMPLOYEE_ID
	 , FIRST_NAME
	 , CASE WHEN SALARY >= 2000 AND SALARY < 5000 THEN '낮은급여'
	 	    WHEN SALARY >= 5000 AND SALARY < 9000 THEN '중간급여'
			WHEN SALARY >= 9000 AND SALARY < 15000 THEN '높은급여'
			WHEN SALARY >= 15000 THEN '매우높은급여'
			ELSE '논외급여'
		END AS 급여구분
  FROM EMPLOYEES;
 

/*
 * EMPLOYEES 테이블에서 COMMISSION_PCT 가 있는 경우
 * "커미션구분" 컬럼에 '있음'으로 출력될 수 있도록 하시오.
 * COMMISSION_PCT가 NULL인 경우는 '없음'으로 출력되어야 합니다.
 */
SELECT DECODE(COMMISSION_PCT, NULL, '없음', '있음') AS "커미션구분"
FROM EMPLOYEES; 

/* 
 * EMPLOYEES 테이블의 직원이름, 이메일, 전화번호, 고용일을 조회 한다.
 *     - 직원이름은 성과 이름을 하나의 컬럼으로 만들어야 한다.
 *     - 이메일 뒤에는 @employees.co.kr 을 붙여야 한다.
 *     - 전화번호의 구분자는 . 대신 - 이 사용되도록 한다.
 *     - 고용일은 xxxx년 xx월 xx일 형식으로 출력되게 한다.
 */
SELECT FIRST_NAME || LAST_NAME AS 직원이름
	 , EMAIL || '@employees.co.kr' AS 이메일
	 , REPLACE(PHONE_NUMBER, '.', '-') AS 전화번호
	 , TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') AS 고용일
FROM EMPLOYEES;

/*
 * EMPLOYEES 테이블에서 직원이름, 급여, 연봉을 조회 한다.
 *     - 연봉은 급여에 12 개월을 곱하는 것으로 한다.
 *     - 천단위 구분이 나오도록 한다.
 */
SELECT FIRST_NAME || LAST_NAME AS 직원이름
	 , TO_CHAR(SALARY, '999,999,999') AS 급여
	 , TO_CHAR(SALARY * 12, '999,999,999') AS 연봉
FROM EMPLOYEES;

/*
 * EMPLOYEES 테이블에서 전화번호가 011 로 시작하는 직원의 성과 이름, 사원번호,
 * 전화번호를 조회 한다.
 *     - 성과 이름은 하나의 컬럼으로 만들어 출력되게 한다.
 *     - 전화번호에서 011 과 마지막 번호를 제외한 나머지 번호는 * 문자로 숨김처리 한다.
 */
SELECT FIRST_NAME || LAST_NAME AS 직원이름
	 , EMPLOYEE_ID AS 사원번호
	 , REPLACE(PHONE_NUMBER, SUBSTR(PHONE_NUMBER, 5, 7), '******') AS 전화번호
FROM EMPLOYEES
WHERE PHONE_NUMBER LIKE '011%';

/*
 * EMPLOYEES 테이블에서 2000년도에 고용된 직원을 조회한다.
 *     - 성과 이름은 하나의 컬럼으로 만들어 출력되게 한다.
 *     - 고용일은 xxxx년 xx월 xx일 형식으로 출력되게 한다.
 */
SELECT FIRST_NAME || LAST_NAME AS 직원이름
	 , TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') AS 고용일
FROM EMPLOYEES
WHERE HIRE_DATE BETWEEN '2000-01-01' AND '2000-12-31';
-- WHERE EXTRACT(YEAR FROM HIRE_DATE) = 2000 으로도 표현 가능

/*
 * EMPLOYEES 테이블에서 HIRE_DATE 를 기준으로 1999년 12월 31일 까지의 근무개월 수가
 * 60 개월 이상인 직원을 조회한다.
 *     - 성과 이름은 하나의 컬럼으로 만들어 출력되게 한다.
 *     - 고용일은 xxxx년 xx월 xx일 형식으로 출력되게 한다.
 *     - 근무개월 수도 출력되게 한다.
 */
SELECT FIRST_NAME || LAST_NAME AS 직원이름
	 , TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') AS 고용일
	 , FLOOR(MONTHS_BETWEEN(TO_DATE(19991231), HIRE_DATE)) AS "근무개월 수"
FROM EMPLOYEES
WHERE MONTHS_BETWEEN(TO_DATE(19991231), HIRE_DATE) >= 60;


/*
 * 그룹 함수
 * 	COUNT(컬럼명 또는 *) : 조회된 Record Set의 Record 수를 반환(NULL은 제외)
 * 	MAX(컬럼명) : 조회된 Record Set에서 지정한 컬럼명의 값들 중 가장 큰 값을 반환
 * 	MIN(컬럼명) : 조회된 Record Set에서 지정한 컬럼명의 값들 중 가장 작은 값을 반환
 *  AVG(컬럼명) : 조회된 Record Set에서 지정한 컬럼명의 값들의 평균을 반환
 *  SUM(컬럼명) : 조회된 Record Set에서 지정한 컬럼명의 값들의 총합을 반환
 */
SELECT COUNT(*) FROM EMPLOYEES;
SELECT COUNT(COMMISSION_PCT) FROM EMPLOYEES;

SELECT MAX(EMPLOYEE_ID), MIN(EMPLOYEE_ID) FROM EMPLOYEES;
SELECT MAX(FIRST_NAME), MIN(FIRST_NAME) FROM EMPLOYEES;
SELECT MAX(HIRE_DATE), MIN(HIRE_DATE) FROM EMPLOYEES;

SELECT SUM(SALARY), AVG(SALARY) FROM EMPLOYEES;

 
 
