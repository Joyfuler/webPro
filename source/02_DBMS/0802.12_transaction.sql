-- [XII] 트랜젝션 명령어 : COMMIT(트랜젝션 반영), ROLLBACK(트랜젝션 취소), SAVEPOINT (트랜젝션 분할)
SELECT * FROM DEPT01;
DROP TABLE DEPT01;
CREATE TABLE DEPT01
AS SELECT * FROM DEPT;
DELETE FROM DEPT01 WHERE DEPTNO=20;
DELETE FROM DEPT01 WHERE DEPTNO=30;
ROLLBACK;

---- 새로운 트랜젝션이 시작.
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO=40;
COMMIT;
---- 새로운 트랜젝션 시작.
SELECT * FROM DEPT01;
DELETE FROM DEPT01 WHERE DEPTNO = 30;
SAVEPOINT C1; -- DEPTNO30을 삭제하고 10,20만 남은 세계선
DELETE FROM DEPT01 WHERE DEPTNO = 20;
SAVEPOINT C2; -- DEPTNO가 10만 남은 세계선
DELETE FROM DEPT01;
SELECT * FROM DEPT01;
ROLLBACK TO C2;
ROLLBACK TO C1;
-- SAVEPOINT로 ROLLBACK하면 그 아래에 있던 명령어가 모두 삭제됨.
-- 따라서 C1지점으로 ROLLBACK하는 경우 그 아래에 있는 C2지점과 명령어들이 모두 삭제되며 ROLLBACK TO C2도 불가능해짐.
-- 아래에서 윗쪽으로 롤백은 되지만 반대는 안된단다
-- 따라서 데이터를 변경한 후 저장을 하려면 꼭 COMMIT을 하라는 말!
