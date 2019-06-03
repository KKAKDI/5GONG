-- 회원
CREATE TABLE MEMBER (
	M_EMAIL   VARCHAR2(40) NOT NULL, -- 이메일
	M_NICK    VARCHAR2(30) NOT NULL, -- 닉네임
	M_GRANT   CHAR(2)      NULL,     -- 권한
	M_NAME    VARCHAR2(12) NULL,     -- 이름
	M_BANK    VARCHAR2(30) NULL,     -- 주거래은행
	M_ACCOUNT NUMBER       NULL,     -- 계좌번호
	M_PHONE   NUMBER       NULL,     -- 핸드폰번호
	M_AMOUNT  NUMBER       NULL,     -- 보유금액
	M_TRUST   NUMBER(3)    NULL,     -- 신뢰도
	M_REGDATE DATE	       NOT NULL  -- 회원등록날짜
);
ALTER TABLE MEMBER ADD CONSTRAINT PK_MEMBER PRIMARY KEY (M_EMAIL, M_NICK);

-- 상품
CREATE TABLE PRODUCT (
    PD_NO       NUMBER          NOT NULL,       --거래번호
    PD_EMAIL    VARCHAR2(40)    NULL,           --이메일
    PD_NICK     VARCHAR2(30)    NULL,           --닉네임
    PD_STATUS   CHAR(2)         NULL,           --진행상태
    PD_BUYER    VARCHAR2(30)    NULL,           --구매자
    PD_NAME     VARCHAR2(100)   NULL,           --상품명
    PD_PRICE    NUMBER          NULL,           --상품가격
    PD_SUBJECT  VARCHAR2(100)   NULL,           --상품제목
    PD_CONTENT  VARCHAR2(4000)  NULL,           --상품내용
    PD_REGDATE  DATE            NOT NULL        --상품등록날짜
);
ALTER TABLE PRODUCT ADD CONSTRAINT PK_PRODUCT PRIMARY KEY (PD_NO);
ALTER TABLE PRODUCT	ADD	CONSTRAINT FK_MEMBER_TO_PRODUCT FOREIGN KEY (PD_NICK, PD_EMAIL) REFERENCES MEMBER (M_NICK, M_EMAIL) ON DELETE CASCADE;

-- 새소식
CREATE TABLE NEWS (
	N_NO        NUMBER         NOT NULL, -- 소식번호
	N_EMAIL     VARCHAR2(40)   NULL,     -- 이메일
	N_NICK      VARCHAR2(30)   NULL,     -- 닉네임
	N_SUBJECT   VARCHAR2(100)  NULL,     -- 제목
	N_CONTENT   VARCHAR2(3000) NULL,     -- 내용
	N_VIEW      NUMBER         NULL,     -- 조회수
	N_WRITEDATE DATE           NOT NULL, -- 작성날짜
	N_DIVISION  CHAR(2)        NOT NULL  -- 구분
);
ALTER TABLE NEWS ADD CONSTRAINT PK_NEWS	PRIMARY KEY (N_NO);
ALTER TABLE NEWS ADD CONSTRAINT FK_MEMBER_TO_NEWS FOREIGN KEY (N_EMAIL,	N_NICK)	REFERENCES MEMBER (M_EMAIL,	M_NICK) ON DELETE CASCADE;

-- 신고목록
CREATE TABLE REPORT (
	R_NO		NUMBER         NOT NULL, -- 신고번호
	R_SUBJECT	VARCHAR2(100)  NULL,     -- 제목
	R_CONTENT	VARCHAR2(3000) NULL,     -- 내용
	R_FILE		VARCHAR2(300)  NULL,     -- 첨부파일
	R_EMAIL		VARCHAR2(40)   NULL,     -- 이메일
	R_NICK		VARCHAR2(30)   NULL,     -- 닉네임
	R_WRITEDATE	DATE	       NULL	 -- 작성날짜
);
ALTER TABLE REPORT ADD CONSTRAINT PK_REPORT PRIMARY KEY (R_NO);
ALTER TABLE REPORT ADD CONSTRAINT FK_MEMBER_TO_REPORT FOREIGN KEY (R_EMAIL, R_NICK)	REFERENCES MEMBER (M_EMAIL, M_NICK) ON DELETE CASCADE;

-- 자유게시판
CREATE TABLE BOARD (
	B_NO        NUMBER         NOT NULL, -- 글번호
	M_EMAIL     VARCHAR2(40)   NULL,     -- 이메일
	M_NICK      VARCHAR2(30)   NULL,     -- 닉네임
    B_SUBJECT   VARCHAR2(100)  NULL,     -- 제목
	B_CONTENT   VARCHAR2(3000) NULL,     -- 내용
	B_IMG       VARCHAR2(300)  NULL,     -- 이미지
	B_IMG_COPY  VARCHAR2(300)  NULL,     -- 이미지사본
	B_VIEW      NUMBER         NULL,     -- 조회수
	B_LIKE      NUMBER         NULL,     -- 추천수
	B_WRITEDATE DATE           NULL      -- 작성날짜
);
ALTER TABLE BOARD ADD CONSTRAINT PK_BOARD PRIMARY KEY (B_NO);
ALTER TABLE BOARD ADD CONSTRAINT FK_MEMBER_TO_BOARD	FOREIGN KEY (M_EMAIL, M_NICK) REFERENCES MEMBER (M_EMAIL, M_NICK)  ON DELETE CASCADE;

-- 자게댓글
CREATE TABLE B_REPLY (
	BR_NO        NUMBER         NOT NULL, -- 댓글번호
	B_NO         NUMBER         NULL,     -- 글번호
    M_EMAIL      VARCHAR2(40)   NOT NULL, -- 이메일
	M_NICK       VARCHAR2(30)   NOT NULL, -- 닉네임
	BR_CONTENT   VARCHAR2(3000) NULL,     -- 내용
	BR_WRITEDATE DATE           NULL,     -- 작성날짜
	BR_IMG       VARCHAR2(300)  NULL,     -- 이미지
	BR_IMG_COPY  VARCHAR2(300)  NULL,     -- 이미지사본
	BR_LIKE      NUMBER         NULL,     -- 추천수
	BR_DISLIKE   NUMBER         NULL      -- 비추천수
);
ALTER TABLE B_REPLY	ADD	CONSTRAINT PK_B_REPLY PRIMARY KEY (BR_NO);
ALTER TABLE B_REPLY	ADD	CONSTRAINT FK_BOARD_TO_B_REPLY FOREIGN KEY (B_NO) REFERENCES BOARD (B_NO)  ON DELETE CASCADE;
ALTER TABLE B_REPLY ADD CONSTRAINT FK_MEMBER_TO_B_REPLY FOREIGN KEY (M_EMAIL, M_NICK) REFERENCES MEMBER (M_EMAIL, M_NICK)  ON DELETE CASCADE;


-- 상품댓글
CREATE TABLE P_REPLY (
	PR_NO        NUMBER         NOT NULL, -- 댓글번호
	PD_NO        NUMBER         NULL,     -- 거래번호
	M_EMAIL      VARCHAR2(40)   NULL,     -- 이메일
	M_NICK       VARCHAR2(30)   NULL,     -- 닉네임
	PR_COMMENT   VARCHAR2(3000) NULL,     -- 내용
	PR_WRITEDATE DATE           NOT NULL  -- 작성날짜
);
ALTER TABLE P_REPLY	ADD	CONSTRAINT PK_P_REPLY PRIMARY KEY (PR_NO);
ALTER TABLE P_REPLY	ADD	CONSTRAINT FK_PRODUCT_TO_P_REPLY FOREIGN KEY (PD_NO) REFERENCES PRODUCT (PD_NO)  ON DELETE CASCADE;
ALTER TABLE P_REPLY	ADD	CONSTRAINT FK_PRODUCT_TO_MEMBER FOREIGN KEY (M_EMAIL, M_NICK) REFERENCES MEMBER (M_EMAIL, M_NICK)  ON DELETE CASCADE;


-- 결제
CREATE TABLE PAYMENT (
	PM_NO        NUMBER       NOT NULL, -- 결제번호
	PD_NO        NUMBER       NOT NULL, -- 거래번호
	PM_SELLER    VARCHAR2(30) NULL,     -- 판매자
	PM_S_ACCOUNT NUMBER       NULL,     -- 판매자계좌
	PM_BUYER     VARCHAR2(30) NULL,     -- 구매자
	PM_B_ACCOUNT NUMBER       NULL,     -- 구매자계좌
	PM_S_AMOUNT  NUMBER       NULL,     -- 판매금액
	PM_B_AMOUNT  NUMBER       NULL,      -- 구매금액
	PM_REGDATE   DATE	  NOT NULL  -- 결제등록날짜
);
ALTER TABLE PAYMENT	ADD	CONSTRAINT PK_PAYMENT PRIMARY KEY (PM_NO, PD_NO);
ALTER TABLE PAYMENT	ADD	CONSTRAINT FK_PRODUCT_TO_PAYMENT FOREIGN KEY (PD_NO) REFERENCES PRODUCT (PD_NO)  ON DELETE CASCADE;



-- 거래기록
CREATE TABLE HISTORY (
	H_NO          NUMBER       NOT NULL, -- 내역번호
	H_SELLER      VARCHAR2(30) NULL,     -- 판매자
	H_S_ACCOUNT   NUMBER       NULL,     -- 판매자계좌
	H_BUYER       VARCHAR2(30) NULL,     -- 구매자
	H_B_ACCOUNT   NUMBER       NULL,     -- 구매자계좌
	H_DEAL_AMOUNT NUMBER       NULL,     -- 거래금액
	H_DEALDATE    DATE         NULL      -- 거래일시
);
ALTER TABLE HISTORY ADD	CONSTRAINT PK_HISTORY PRIMARY KEY (H_NO);

CREATE SEQUENCE PRODUCT_PD_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE NEWS_N_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE REPORT_R_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE BOARD_B_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE B_REPLY_BR_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE P_REPLY_PR_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE PAYMENT_PM_NO
INCREMENT BY 1
START WITH 1
nocache;

CREATE SEQUENCE HISTORY_H_NO
INCREMENT BY 1
START WITH 1
nocache;

