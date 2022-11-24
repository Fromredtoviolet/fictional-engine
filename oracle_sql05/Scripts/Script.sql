/* 자동커밋 해제하고 수동커밋으로 전환함 */

SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = 100;

UPDATE EMPLOYEES 
SET MANAGER_ID = NULL /* 커밋을 안 하면 디비버에서는 NULL로 잘 바뀌어보이지만, 다른 세션에서는 적용이 안 된다는 걸 주의 */
WHERE EMPLOYEE_ID = 100;

ROLLBACK;

COMMIT; 

/* 
 * 커밋은 완전 저장의 개념이라, 커밋을 하고나면 그 이전으로 롤백할 수 없다. 
 * 롤백이 가능한 건 커밋하기 전 과정에서!
 * 
 * 하나의 데이터베이스(테이블) 가지고 여러 사용자가 작업을 하다보면,
 * 커밋을 하기 전까지는 다른 사용자가 인서트 업데이트 딜리트를 할 수 없다는걸 유의해야 한다.
 */