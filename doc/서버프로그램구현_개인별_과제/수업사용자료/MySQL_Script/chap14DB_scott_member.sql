-- DATABSE 생성
create database chap14 character set utf8;

-- 테이블을 옮겨준다. 만약 테이블이 여러 개이면 여러 번 반복.
-- rename table 옛데이테베이스명.table명  to  새데이테베이스명.table명;

--  DATABSE 삭제
-- drop database 지울db명;
drop database scott;

-- user생성 및 권한부여 p365
create user 'scott'@'localhost' identified by 'tiger';
grant  all	privileges on chap14.* to 'scott'@'localhost'; 

create user 'scott'@'%' identified by 'tiger';
grant  all	privileges on chap14.* to 'scott'@'%';



/* table 생성(p367참고)
CREATE TABLE user명.테이블명(
	컬럼명	데이터타입		제약조건,
    컬럼명	데이터타입		제약조건,
    ..
    컬럼명	데이터타입		제약조건
) engine=InnoDB  default  character set=utf8;
*/
-- engine=InnoDB  => 생성하는 테이블을 InnoDB저장엔진을 사용해서 생성한다
-- default  character set=utf8  => 테이블에서 사용될 characterset을 utf8로 사용

CREATE TABLE `chap14`.`member` (
  `MEMBERID` VARCHAR(10) NOT NULL,
  `PASSWORD` VARCHAR(10) NOT NULL,
  `NAME` VARCHAR(20) NOT NULL,
  `EMAIL` VARCHAR(80) NULL,
  PRIMARY KEY (`MEMBERID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

/*
-- 입력
INSERT INTO 테이블명[(컬럼명,컬럼명,..)]
VALUES(값,값,..); 
-- 조회
SELECT { * | 컬럼명 }
FROM   테이블명
[WHERE 조건]
[GROUP BY  그룹기준]
[HAVING    그룹조건]
[ORDER BY  정렬기준  방법]
-- 수정
UPDATE 테이블명
SET    컬럼명=새값
[WHERE 조건]
-- 삭제
DELETE  FROM 테이블명
[WHERE 조건]
*/


INSERT INTO `chap14`.`member`(memberid,password,name,email)
VALUES('hongid','1234','홍길동','hkd@qq.com'); 

INSERT INTO `chap14`.`member`
VALUES('leeid','1234','이순신','lsh@qq.com'); 


SELECT * FROM chap14.member;


CREATE TABLE `chap14`.`member_etc` (
  `MEMBERID` VARCHAR(10) NOT NULL  PRIMARY KEY,
  `BIRTHDAY` CHAR(8)
)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `chap14`.`member_etc`
VALUES('hongid','19780809');

INSERT INTO `chap14`.`member_etc`
VALUES('leeid','19770831');

commit;

SELECT a.memberid,a.password,a.name,a.email,
       b.BIRTHDAY
from  chap14.member as a, chap14.member_etc as b
WHERE a.memberid=b.memberid;





