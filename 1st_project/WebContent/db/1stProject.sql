 -- 1) 테이블 드랍

DROP TABLE BOARD_COMMENT;
DROP SEQUENCE BOARD_SEQ;
DROP TABLE BOARD;
DROP TABLE FAVORITE;
DROP TABLE REVIEW;
DROP TABLE GAME;
DROP TABLE MEMBER;

 -- 2 ) 테이블 생성
 
 CREATE TABLE MEMBER(
    MID VARCHAR2 (36) PRIMARY KEY,
    MPW VARCHAR2 (36) NOT NULL,
    MEMAIL VARCHAR2 (50) NOT NULL UNIQUE,
    MPHONE VARCHAR2 (20) NOT NULL,
    MPHOTO VARCHAR2 (60),
    MQUEST NUMBER(1),
    MANSWER VARCHAR2 (60),
    MLEVEL NUMBER(1) DEFAULT 0    
 );
 
 SELECT * FROM MEMBER;
 
 CREATE TABLE GAME(
    GID VARCHAR2 (60) PRIMARY KEY,
    GNAME VARCHAR2 (30) NOT NULL,
    GPUB VARCHAR2 (60) NOT NULL,
    GPDATE DATE,
    GICON VARCHAR2 (60),
    GDESC CLOB,
    GHIT NUMBER(1) DEFAULT 0 NOT NULL    
 );
 
 SELECT * FROM GAME;
 
 CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
 CREATE TABLE BOARD(
     BNO NUMBER(8) PRIMARY KEY,
     BTITLE VARCHAR2 (120) NOT NULL,
     BCONTENT CLOB,
     BRDATE DATE DEFAULT SYSDATE,
     BIMG VARCHAR2 (120),
     BGROUP NUMBER(8) NOT NULL,
     BSTEP NUMBER(2) NOT NULL,
     BINDENT NUMBER(2) NOT NULL,
     GID VARCHAR2 (60),
     MID VARCHAR2 (36),
     FOREIGN KEY (GID) REFERENCES GAME(GID),
     FOREIGN KEY (MID) REFERENCES MEMBER(MID)
 );

SELECT * FROM BOARD;
CREATE SEQUENCE BOARD_COMMENT_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE BOARD_COMMENT (
    BCNO NUMBER(8) NOT NULL,
    BCTEXT VARCHAR2 (4000) NOT NULL,
    BCGROUP NUMBER(8) NOT NULL,
    BCSTEP NUMBER(2) NOT NULL,
    BCINDENT NUMBER(2) NOT NULL,
    BNO NUMBER(8),
    MID VARCHAR2 (30),
    FOREIGN KEY (BNO) REFERENCES BOARD(BNO),
    FOREIGN KEY (MID) REFERENCES MEMBER(MID)
);

SELECT * FROM BOARD_COMMENT;
CREATE SEQUENCE FAVORITE_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE FAVORITE (
    FID NUMBER(5) PRIMARY KEY,
    FRDATE DATE DEFAULT SYSDATE,
    GID VARCHAR2 (60) NOT NULL,
    MID VARCHAR2 (30) NOT NULL,
    FOREIGN KEY (GID) REFERENCES GAME(GID),
    FOREIGN KEY (MID) REFERENCES MEMBER(MID)
);
    
SELECT * FROM FAVORITE;    

CREATE SEQUENCE REVIEW_SEQ START WITH 1 INCREMENT BY 1 MAXVALUE 99999 NOCACHE NOCYCLE;
CREATE TABLE REVIEW (
    RID NUMBER(5) PRIMARY KEY,
    RSCORE NUMBER(1) NOT NULL,
    RTEXT CLOB NOT NULL,
    MID VARCHAR2 (30) NOT NULL,
    GID VARCHAR2 (60) NOT NULL,
    FOREIGN KEY (MID) REFERENCES MEMBER(MID),
    FOREIGN KEY (GID) REFERENCES GAME(GID)
);

SELECT * FROM REVIEW;