--범렬
DROP TABLE MEMBER CASCADE CONSTRAINTS;
DROP TABLE POST_SANCTIONS CASCADE CONSTRAINTS;
DROP TABLE FOLLOW CASCADE CONSTRAINTS;

CREATE TABLE MEMBER (
   MEM_NO           NUMBER           PRIMARY KEY
   ,MEM_NAME       VARCHAR(20)       NOT NULL   
   ,MEM_ID           VARCHAR(20)       UNIQUE              NOT NULL   
   ,MEM_PWD       VARCHAR(100)    NOT NULL   
   ,MEM_NICK       VARCHAR(8)       UNIQUE              NOT NULL   
   ,MEM_PHONE_NUM   CHAR(13)       NOT NULL   
   ,MEM_EMAIL       VARCHAR(30)       NOT NULL   
   ,QUIT_YN       CHAR(1)           DEFAULT 'N'         CHECK(QUIT_YN IN('Y','N'))    NULL
   ,ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE       NULL
   ,UPDATE_DATE   TIMESTAMP       NULL
);

CREATE TABLE POST_SANCTIONS (
   P_SANC_NO   NUMBER       NOT NULL   
   ,P_BLA_NO   NUMBER       NOT NULL   
   ,BAN_DAY   NUMBER       NULL   
   ,SANC_DATE   TIMESTAMP   DEFAULT SYSDATE       NULL   
);

CREATE TABLE FOLLOW (
   MEM_NO      NUMBER      NOT NULL 
   ,BLOG_NO      NUMBER      NOT NULL 
    ,CONSTRAINT FOLLOW_PK PRIMARY KEY(MEM_NO, BLOG_NO)
);


DROP SEQUENCE SEQ_MEMBER;
DROP SEQUENCE SEQ_POST_SANCTIONS;

CREATE SEQUENCE SEQ_MEMBER MINVALUE 1 NOCYCLE NOCACHE;
CREATE SEQUENCE SEQ_POST_SANCTIONS MINVALUE 1 NOCYCLE NOCACHE;

COMMENT ON COLUMN "MEMBER"."MEM_NO" IS '회원번호';

COMMENT ON COLUMN "MEMBER"."MEM_NAME" IS '회원이름';

COMMENT ON COLUMN "MEMBER"."MEM_ID" IS '아이디';

COMMENT ON COLUMN "MEMBER"."MEM_PWD" IS '비밀번호';

COMMENT ON COLUMN "MEMBER"."MEM_NICK" IS '닉네임';

COMMENT ON COLUMN "MEMBER"."MEM_PHONE_NUM" IS '전화번호';

COMMENT ON COLUMN "MEMBER"."MEM_EMAIL" IS '이메일';

COMMENT ON COLUMN "MEMBER"."QUIT_YN" IS '회원탈퇴여부';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '가입일자';

COMMENT ON COLUMN "MEMBER"."UPDATE_DATE" IS '수정일자';

COMMENT ON COLUMN "POST_SANCTIONS"."P_SANC_NO" IS '포스트 제재 이력 번호';

COMMENT ON COLUMN "POST_SANCTIONS"."P_BLA_NO" IS '포스트 신고 이력 번호';

COMMENT ON COLUMN "POST_SANCTIONS"."BAN_DAY" IS '로그인 정지 일수';

COMMENT ON COLUMN "POST_SANCTIONS"."SANC_DATE" IS '로그인 정지 날짜';

COMMENT ON COLUMN "FOLLOW"."MEM_NO" IS '구독 신청자';

COMMENT ON COLUMN "FOLLOW"."BLOG_NO" IS '구독 승인자';


------------------------------------------------------------------------------------------
--지연
-- DROP TABLE
DROP TABLE BLOG CASCADE CONSTRAINTS;
DROP TABLE VISITORS CASCADE CONSTRAINTS;
DROP TABLE MYBLOG_CATEGORY CASCADE CONSTRAINTS;

-- BLOG
CREATE TABLE BLOG (
   BLOG_NO                  NUMBER            NOT NULL        PRIMARY KEY
   , MEM_NO                 NUMBER            NOT NULL -- 외래키
   , OPEN_YN                CHAR(1)           DEFAULT 'Y'   NULL
   , LAYOUT                 CHAR(1)           DEFAULT '1'   NULL
   , SKIN                   CHAR(1)           DEFAULT '1'   NULL
   , CLOCK_YN               CHAR(1)           DEFAULT 'N'   NULL
   , MAP_YN                 CHAR(1)           DEFAULT 'N'   NULL
   , R_COMMENTS_YN          CHAR(1)           DEFAULT 'N'   NULL
   , FOLLOW_BLOG_YN         CHAR(1)           DEFAULT 'N'   NULL
   , VISITORS_CNT_YN        CHAR(1)           DEFAULT 'N'   NULL
   , BLOG_IMG               VARCHAR2(500)      NULL
   , R_COMMENTS             CHAR(1)           DEFAULT '1'   NULL
   , VISIT_CNT              NUMBER            DEFAULT 0   NULL
   , BLOG_MAIN              VARCHAR2(2000)    NULL
   , REP_YN	                CHAR(1)	          DEFAULT 'N'     NULL
   , BLOG_TITLE         	VARCHAR2(100)	  NULL
   , BLOG_URL	            VARCHAR2(500)	  NOT NULL
);

COMMENT ON COLUMN BLOG.BLOG_NO IS '블로그 번호"PK"';
COMMENT ON COLUMN BLOG.MEM_NO IS '회원번호';
COMMENT ON COLUMN BLOG.OPEN_YN IS '블로그 공개여부';
COMMENT ON COLUMN BLOG.LAYOUT IS '선택한 레이아웃(구조)';
COMMENT ON COLUMN BLOG.SKIN IS '선택한 스킨(색/폰트)';
COMMENT ON COLUMN BLOG.CLOCK_YN IS '시계 노출여부(위젯)';
COMMENT ON COLUMN BLOG.MAP_YN IS '지도 노출여부(위젯)';
COMMENT ON COLUMN BLOG.R_COMMENTS_YN IS '최근댓글(5) 노출여부(위젯)';
COMMENT ON COLUMN BLOG.FOLLOW_BLOG_YN IS '구독블로그 노출여부(위젯)';
COMMENT ON COLUMN BLOG.VISITORS_CNT_YN IS '방문자수 노출여부(위젯)';
COMMENT ON COLUMN BLOG.BLOG_IMG IS '블로그 프로필 사진';
COMMENT ON COLUMN BLOG.R_COMMENTS IS '최근댓글 노출개수';
COMMENT ON COLUMN BLOG.VISIT_CNT IS '방문자수';
COMMENT ON COLUMN BLOG.BLOG_MAIN IS '블로그 메인내용';
COMMENT ON COLUMN BLOG.REP_YN IS '대표블로그 설정';
COMMENT ON COLUMN BLOG.BLOG_TITLE IS '블로그제목';
COMMENT ON COLUMN BLOG.BLOG_URL IS '블로그url';

-- VISITOR
CREATE TABLE VISITORS (
   VISITORS_NO               NUMBER          NOT NULL        PRIMARY KEY
   , BLOG_NO               NUMBER          NOT NULL -- 외래키
   , VISITORS_MEM_NO       NUMBER          NOT NULL -- 외래키
   , VISIT_DATE           TIMESTAMP       DEFAULT SYSDATE   NULL
);

COMMENT ON COLUMN VISITORS.VISITORS_NO IS '방문자수 번호"PK"';
COMMENT ON COLUMN VISITORS.BLOG_NO IS '블로그 번호';
COMMENT ON COLUMN VISITORS.VISITORS_MEM_NO IS '방문자 회원번호';
COMMENT ON COLUMN VISITORS.VISIT_DATE IS '날짜';

-- MYBLOG_CATEGORY
CREATE TABLE MYBLOG_CATEGORY (
   GROUP_NO           NUMBER          NOT NULL        PRIMARY KEY
   , BLOG_NO           NUMBER          NOT NULL -- 외래키
   , GROUP_NAME       VARCHAR(20)       DEFAULT 'NEW'   NULL
   , GROUP_ORDER             NUMBER           NOT NULL
   , DEL_YN             CHAR(1)         DEFAULT 'N'     NULL
);
COMMENT ON COLUMN MYBLOG_CATEGORY.GROUP_NO IS '블로그 카테고리 그룹 번호 "PK"';
COMMENT ON COLUMN MYBLOG_CATEGORY.BLOG_NO IS '블로그 번호';
COMMENT ON COLUMN MYBLOG_CATEGORY.GROUP_NAME IS '카테고리 그룹 이름';
COMMENT ON COLUMN MYBLOG_CATEGORY.GROUP_ORDER IS '카테고리 그룹 순서';
COMMENT ON COLUMN MYBLOG_CATEGORY.DEL_YN IS '카테고리 그룹 삭제여부';

-- DROP SEQUENCE
DROP SEQUENCE SEQ_BLOG_NO;
DROP SEQUENCE SEQ_VISITORS_NO;
DROP SEQUENCE SEQ_GROUP_NO;

-- 시퀀스
CREATE SEQUENCE SEQ_BLOG_NO MINVALUE 1 NOCYCLE NOCACHE;
CREATE SEQUENCE SEQ_VISITORS_NO MINVALUE 1 NOCYCLE NOCACHE;
CREATE SEQUENCE SEQ_GROUP_NO MINVALUE 1 NOCYCLE NOCACHE;


---------------------------------------------------------------------------------------------------------------------------------------------------
--덕기
DROP TABLE ADMIN CASCADE CONSTRAINTS;  
CREATE TABLE ADMIN (
   ADMIN_NO       NUMBER           PRIMARY KEY
   ,ADMIN_ID       VARCHAR2(20)   NOT NULL                   
   ,ADMIN_PWD       VARCHAR2(20)   NOT NULL                   
   ,ADMIN_NAME       VARCHAR2(20)                          
   ,QUIT_YN       CHAR(1)           DEFAULT 'N'           
    ,ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE       
);
---------------------코멘트--------------------
COMMENT ON COLUMN "ADMIN"."ADMIN_NO" IS '관리자 번호 "PK"';
COMMENT ON COLUMN "ADMIN"."ADMIN_ID" IS '관리자 아이디';
COMMENT ON COLUMN "ADMIN"."ADMIN_PWD" IS '비밀번호';
COMMENT ON COLUMN "ADMIN"."ADMIN_NAME" IS '관리자명';
COMMENT ON COLUMN "ADMIN"."QUIT_YN" IS '탈퇴여부';
COMMENT ON COLUMN "ADMIN"."ENROLL_DATE" IS '가입일자';

---------------------시퀀스--------------------
--ADMIN
DROP SEQUENCE SEQ_ADMIN;
CREATE SEQUENCE SEQ_ADMIN NOCYCLE NOCACHE;
--SEQ_ADMIN.NEXTVAL;





DROP TABLE NOTICE CASCADE CONSTRAINTS;  
CREATE TABLE NOTICE (
   NOTICE_NO       NUMBER          PRIMARY KEY
   ,ADMIN_NO       NUMBER          NOT NULL
   ,TITLE           VARCHAR2(100)
   ,CONTENT       VARCHAR2(2000)
   ,INQUIRY       NUMBER           DEFAULT 0
   ,ENROLL_DATE   TIMESTAMP       DEFAULT SYSDATE
   ,UPDATE_DATE   TIMESTAMP      DEFAULT SYSDATE
   ,FIXED_YN       CHAR(1)           DEFAULT 'N'
   ,DEL_YN           CHAR(1)           DEFAULT 'Y'
);

---------------------코멘트--------------------
COMMENT ON COLUMN "NOTICE"."NOTICE_NO" IS '공지글번호"PK"';
COMMENT ON COLUMN "NOTICE"."ADMIN_NO" IS '작성한 관리자 번호';
COMMENT ON COLUMN "NOTICE"."TITLE" IS '공지사항 제목';
COMMENT ON COLUMN "NOTICE"."CONTENT" IS '공지사항 내용';
COMMENT ON COLUMN "NOTICE"."INQUIRY" IS '조회수';
COMMENT ON COLUMN "NOTICE"."ENROLL_DATE" IS '작성일';
COMMENT ON COLUMN "NOTICE"."UPDATE_DATE" IS '수정일';
COMMENT ON COLUMN "NOTICE"."FIXED_YN" IS '상단 고정 여부';
COMMENT ON COLUMN "NOTICE"."DEL_YN" IS '글 공개 여부';

---------------------시퀀스--------------------
--NOTICE
DROP SEQUENCE SEQ_NOTICE;
CREATE SEQUENCE SEQ_NOTICE MINVALUE 1 NOCYCLE NOCACHE;
--SEQ_NOTICE.NEXTVAL;



DROP TABLE CUSTOMER_CENTER CASCADE CONSTRAINTS;  
CREATE TABLE CUSTOMER_CENTER (
   Q_NO               NUMBER          PRIMARY KEY
   ,ADMIN_NO           NUMBER
   ,MEM_NO               NUMBER
   ,Q_TIT               VARCHAR2(100)
   ,Q_CON               VARCHAR2(2000)
   ,Q_WRITE_DATE       TIMESTAMP       DEFAULT SYSDATE
   ,ANSEWR               VARCHAR2(4000)
   ,ANSEWR_DATE       TIMESTAMP
   ,UPDATE_DATE       TIMESTAMP
   ,DEL_YN               CHAR(1)           DEFAULT 'N'
   ,QUESTION_CATEGORY   CHAR(4)          NOT NULL
);

---------------------코멘트--------------------
COMMENT ON COLUMN "CUSTOMER_CENTER"."Q_NO" IS '문의글 번호"PK"';
COMMENT ON COLUMN "CUSTOMER_CENTER"."ADMIN_NO" IS '답변 관리자 번호';
COMMENT ON COLUMN "CUSTOMER_CENTER"."MEM_NO" IS '글 작성자 번호';
COMMENT ON COLUMN "CUSTOMER_CENTER"."Q_TIT" IS '문의글 제목';
COMMENT ON COLUMN "CUSTOMER_CENTER"."Q_CON" IS '문의글 내용';
COMMENT ON COLUMN "CUSTOMER_CENTER"."Q_WRITE_DATE" IS '작성일';
COMMENT ON COLUMN "CUSTOMER_CENTER"."ANSEWR" IS '답변 내용';
COMMENT ON COLUMN "CUSTOMER_CENTER"."ANSEWR_DATE" IS '답변 작성일';
COMMENT ON COLUMN "CUSTOMER_CENTER"."UPDATE_DATE" IS '답변 수정일';
COMMENT ON COLUMN "CUSTOMER_CENTER"."DEL_YN" IS '글 공개 여부(삭제여부)';
COMMENT ON COLUMN "CUSTOMER_CENTER"."QUESTION_CATEGORY" IS '문의글 구분(문의/기능신고)';

---------------------시퀀스--------------------
--NOTICE
DROP SEQUENCE SEQ_CUSTOMER_CENTER;
CREATE SEQUENCE SEQ_CUSTOMER_CENTER MINVALUE 1 NOCYCLE NOCACHE;

------------------------------------------------------------------------------------------
--광희
DROP TABLE ALARM CASCADE CONSTRAINTS; 

CREATE TABLE ALARM (
   ALARM_NO           NUMBER          NOT NULL,
   RECEIVER_NO           NUMBER          NOT NULL,
   POST_NO               NUMBER          NULL,
   SENDER_NO           NUMBER          NOT NULL,
   ALARM_TYPE           CHAR(10)      NOT NULL,
   ALARM_DATE           TIMESTAMP       DEFAULT SYSDATE       NULL,
   ACTIVE_YN           CHAR(1)           DEFAULT 'N'           NULL
);

COMMENT ON COLUMN ALARM.ALARM_NO IS '알람번호"PK"';

COMMENT ON COLUMN ALARM.RECEIVER_NO IS '알람 받는 사람';

COMMENT ON COLUMN ALARM.POST_NO IS '포스트넘버';

COMMENT ON COLUMN ALARM.SENDER_NO IS '알람보낸사람';

COMMENT ON COLUMN ALARM.ALARM_TYPE IS '알람구분';

COMMENT ON COLUMN ALARM.ALARM_DATE IS '알람 생성 시간';

COMMENT ON COLUMN ALARM.ACTIVE_YN IS '읽음여부';

DROP TABLE REPLY CASCADE CONSTRAINTS;  

CREATE TABLE REPLY (
   REPLY_NO       NUMBER          NOT NULL      PRIMARY KEY,
   POST_NO           NUMBER          NOT NULL,
   REPLY_MEM       NUMBER          NOT NULL,
   PARENTS_NO       NUMBER          NULL,
   CON               VARCHAR(4000)   NOT NULL,
   WRITE_DATE       TIMESTAMP       DEFAULT SYSDATE       NULL,
   UPDATE_DATE      TIMESTAMP       DEFAULT SYSDATE         NULL,
   DEL_YN           CHAR(1)           DEFAULT 'N'       NULL
);

COMMENT ON COLUMN REPLY.REPLY_NO IS '댓글 번호"PK"';

COMMENT ON COLUMN REPLY.POST_NO IS '포스트번호';

COMMENT ON COLUMN REPLY.REPLY_MEM IS '작성자 번호';

COMMENT ON COLUMN REPLY.PARENTS_NO IS '부모댓글';

COMMENT ON COLUMN REPLY.CON IS '내용';

COMMENT ON COLUMN REPLY.WRITE_DATE IS '작성일자';

COMMENT ON COLUMN REPLY.UPDATE_DATE IS '수정일자';

COMMENT ON COLUMN REPLY.DEL_YN IS '삭제여부';

DROP TABLE REPLY_BLAME CASCADE CONSTRAINTS;

CREATE TABLE REPLY_BLAME (
   R_BLA_NO       NUMBER          NOT NULL  PRIMARY KEY,            -- 신고 번호
   R_NO           NUMBER          NOT NULL,                          -- 댓글 번호
   R_BLAMER_NO    NUMBER          NOT NULL,                          -- 신고자
   R_WRITER_NO    NUMBER          NOT NULL,                          -- 작성자
   R_BLA_CON      VARCHAR2(100)   NOT NULL,                          -- 댓글 내용/포스트 제목
   R_BLA_DATE     TIMESTAMP       DEFAULT SYSDATE       NULL,       -- 신고 일자
   R_BLA_LIST     NUMBER          NOT NULL,                          -- 신고 구분
   R_BLA_DETAIL_REASON      VARCHAR2(100)NOT NULL,
   R_SANC_YN      CHAR(1)         DEFAULT 'N'           NULL,       -- 제재 여부
   R_ANS_DATE     TIMESTAMP       DEFAULT SYSDATE         NULL,     -- 답변 일자
   R_BLA_DETAIL   VARCHAR2(1000)   NULL,                            -- 처리 일자
   R_DEL_YN       CHAR(1)         DEFAULT 'N'         NULL         -- 삭제 여부
);


COMMENT ON COLUMN REPLY_BLAME.R_BLA_NO IS '댓글 신고 이력 번호';

COMMENT ON COLUMN REPLY_BLAME.R_NO IS '신고한 댓글 번호';

COMMENT ON COLUMN REPLY_BLAME.R_BLAMER_NO IS '신고자 번호';

COMMENT ON COLUMN REPLY_BLAME.R_WRITER_NO IS '작성자 번호';

COMMENT ON COLUMN REPLY_BLAME.R_BLA_CON IS '신고한 댓글 내용';

COMMENT ON COLUMN REPLY_BLAME.R_BLA_DATE IS '댓글 신고일';

COMMENT ON COLUMN REPLY_BLAME.R_BLA_LIST IS '신고 사유 번호';

COMMENT ON COLUMN REPLY_BLAME.R_BLA_DETAIL_REASON IS '신고 세부 내용';

COMMENT ON COLUMN REPLY_BLAME.R_SANC_YN IS '제재 처리 여부';

COMMENT ON COLUMN REPLY_BLAME.R_ANS_DATE IS '답변 일자';

COMMENT ON COLUMN REPLY_BLAME.R_BLA_DETAIL IS '신고 상세 내용';

COMMENT ON COLUMN REPLY_BLAME.R_DEL_YN IS '삭제 여부';


DROP SEQUENCE SEQ_REPLY_BLAME;
CREATE SEQUENCE SEQ_REPLY_BLAME MINVALUE 1 NOCYCLE NOCACHE;

COMMIT;






----------------------------------------------------------------------------------------------------------
--옥진
-- 포스트

-- 테이블 삭제
DROP TABLE POST CASCADE CONSTRAINTS;

-- 테이블 생성
CREATE TABLE POST (
   POST_NO               NUMBER                              NOT NULL       PRIMARY KEY
   , BLOG_NO           NUMBER                              NOT NULL
   , CATEGORY_NO       NUMBER                              NOT NULL
   , GROUP_NO           NUMBER                              NOT NULL
   , TITLE             VARCHAR2(200)                      NOT NULL
   , CONTENT           VARCHAR2(4000)                      NOT NULL
   , OPEN               CHAR(1)           DEFAULT 'Y'           NULL
   , INQUIRY           NUMBER           DEFAULT 0           NULL
   , ENROLL_DATE       TIMESTAMP       DEFAULT SYSDATE       NULL
   , MODIFY_DATE       TIMESTAMP       DEFAULT SYSDATE       NULL
   , DEL_YN           CHAR(1)           DEFAULT 'N'           NULL
    , POST_IMG           VARCHAR2(200)                      NULL
);

-- 시퀀스 삭제

DROP SEQUENCE SEQ_POST_NO;


-- 시퀀스 생성
CREATE SEQUENCE SEQ_POST_NO MINVALUE 1 NOCYCLE NOCACHE;



-----------------------------------------------------------------------------
-- 카테고리

-- 테이블 삭제
DROP TABLE CATEGORY_LIST CASCADE CONSTRAINTS;

-- 테이블 생성
CREATE TABLE CATEGORY_LIST (
   CATEGORY_NO           NUMBER          NOT NULL       PRIMARY KEY
   ,CATEGORY_NAME       VARCHAR2(100)   NOT NULL
);

-- 시퀀스 삭제
DROP SEQUENCE SEQ_CATEGORY_LIST_NO;

-- 시퀀스 생성
CREATE SEQUENCE SEQ_CATEGORY_LIST_NO MINVALUE 1 NOCYCLE NOCACHE;

-----------------------------------------------------------------------------
-- 공감

-- 테이블 삭제
DROP TABLE HEART CASCADE CONSTRAINTS;

-- 테이블 생성
CREATE TABLE HEART (
   POST_NO               NUMBER      NOT NULL
   , MEM_NO           NUMBER      NOT NULL
   , CONSTRAINT HEART_PK PRIMARY KEY(POST_NO, MEM_NO)
);


-- 시퀀스 삭제
DROP SEQUENCE SEQ_HEART_NO;

-- 시퀀스 생성
CREATE SEQUENCE SEQ_HEART_NO MINVALUE 1 NOCYCLE NOCACHE;


-----------------------------------------------------------------------------

-- 코멘트
COMMENT ON COLUMN "POST"."POST_NO" IS '포스트넘버"PK"';

COMMENT ON COLUMN "POST"."BLOG_NO" IS '블로그 번호';

COMMENT ON COLUMN "POST"."CATEGORY_NO" IS '카테고리 번호';

COMMENT ON COLUMN "POST"."GROUP_NO" IS '블로그에서 포스트 그룹으로 묶기';

COMMENT ON COLUMN "POST"."TITLE" IS '제목';

COMMENT ON COLUMN "POST"."CONTENT" IS '내용';

COMMENT ON COLUMN "POST"."OPEN" IS '공개여부';

COMMENT ON COLUMN "POST"."INQUIRY" IS '조회수';

COMMENT ON COLUMN "POST"."ENROLL_DATE" IS '등록일자';

COMMENT ON COLUMN "POST"."MODIFY_DATE" IS '수정일자';

COMMENT ON COLUMN "POST"."DEL_YN" IS '삭제여부';

COMMENT ON COLUMN "POST"."POST_IMG" IS '대표이미지';


COMMENT ON COLUMN "CATEGORY_LIST"."CATEGORY_NO" IS '포스팅  카테고리 번호 "PK"';

COMMENT ON COLUMN "CATEGORY_LIST"."CATEGORY_NAME" IS '카테고리 이름';


COMMENT ON COLUMN "HEART"."POST_NO" IS '공감 포스터 번호 "CK"';

COMMENT ON COLUMN "HEART"."MEM_NO" IS '공감 누른 회원 번호 "CK"';

---------------------------------------------------------------------------------
--예지
--BLAME_REASON
DROP TABLE BLAME_REASON CASCADE CONSTRAINTS;

CREATE TABLE "BLAME_REASON" (
	"BLA_LIST"	NUMBER		NOT NULL PRIMARY KEY,
	"BLA_REASON"	VARCHAR2(100)		NULL
);

COMMENT ON COLUMN "BLAME_REASON"."BLA_LIST" IS '신고 사유 번호 "PK"';

COMMENT ON COLUMN "BLAME_REASON"."BLA_REASON" IS '신고 사유';


DROP SEQUENCE SEQ_BLAME_REASON;
CREATE SEQUENCE SEQ_BLAME_REASON MINVALUE 1 NOCYCLE NOCACHE;

--------------------------------------------------------------------------------------------------------------
--REPLY_SANCTIONS

DROP TABLE REPLY_SANCTIONS CASCADE CONSTRAINTS;

CREATE TABLE "REPLY_SANCTIONS" (
	"R_SANC_NO"	NUMBER		NOT NULL    PRIMARY KEY,
	"R_BLA_NO"	NUMBER		NOT NULL--외래키
	,"BAN_DAY"	NUMBER		NULL,
	"SANC_DATE"	TIMESTAMP	DEFAULT SYSDATE	NULL
);

COMMENT ON COLUMN "REPLY_SANCTIONS"."R_SANC_NO" IS '댓글 제재 이력 번호 "PK''';

COMMENT ON COLUMN "REPLY_SANCTIONS"."R_BLA_NO" IS '댓글 신고 이력 번호';

COMMENT ON COLUMN "REPLY_SANCTIONS"."BAN_DAY" IS '로그인 정지 일수';

COMMENT ON COLUMN "REPLY_SANCTIONS"."SANC_DATE" IS '제재 진행 일자';


DROP SEQUENCE SEQ_REPLY_SANCTIONS;
CREATE SEQUENCE SEQ_REPLY_SANCTIONS MINVALUE 1 NOCYCLE NOCACHE;
-------------------------------------------------------------------------------------------------------------------

--POST_BLAME
DROP TABLE POST_BLAME CASCADE CONSTRAINTS;

CREATE TABLE "POST_BLAME" (

   P_BLA_NO       NUMBER          NOT NULL  PRIMARY KEY,            -- 신고 번호
   P_NO           NUMBER          NOT NULL,                          -- 포스트 번호
   P_BLAMER_NO    NUMBER          NOT NULL,                          -- 신고자
   P_WRITER_NO    NUMBER          NOT NULL,                          -- 작성자
   P_BLA_TIT      VARCHAR2(100)   NOT NULL,                          -- 포스트 제목
   P_BLA_DATE     TIMESTAMP       DEFAULT SYSDATE       NULL,       -- 신고 일자
   P_BLA_LIST     NUMBER          NOT NULL,                          -- 신고 구분
   P_BLA_DETAIL_REASON      VARCHAR2(100)       NOT NULL,           --신고 세부 내용
   P_SANC_YN      CHAR(1)         DEFAULT 'N'           NULL,       -- 제재 여부
   P_ANS_DATE     TIMESTAMP       DEFAULT SYSDATE         NULL,     -- 답변 일자
   P_BLA_DETAIL   VARCHAR2(1000)   NULL,                            -- 처리 일자
   P_DEL_YN       CHAR(1)         DEFAULT 'N'         NULL         -- 삭제 여부

);

COMMENT ON COLUMN POST_BLAME.P_BLA_NO IS '댓글 신고 이력 번호';

COMMENT ON COLUMN POST_BLAME.P_NO IS '신고한 댓글 번호';

COMMENT ON COLUMN POST_BLAME.P_BLAMER_NO IS '신고자 번호';

COMMENT ON COLUMN POST_BLAME.P_WRITER_NO IS '작성자 번호';

COMMENT ON COLUMN POST_BLAME.P_BLA_TIT IS '신고한 댓글 내용';

COMMENT ON COLUMN POST_BLAME.P_BLA_DATE IS '댓글 신고일';

COMMENT ON COLUMN POST_BLAME.P_BLA_LIST IS '신고 사유 번호';

COMMENT ON COLUMN POST_BLAME.P_BLA_DETAIL_REASON IS '신고 세부 내용';

COMMENT ON COLUMN POST_BLAME.P_SANC_YN IS '제재 처리 여부';

COMMENT ON COLUMN POST_BLAME.P_ANS_DATE IS '답변 일자';

COMMENT ON COLUMN POST_BLAME.P_BLA_DETAIL IS '신고 상세 내용';

COMMENT ON COLUMN POST_BLAME.P_DEL_YN IS '삭제 여부';


DROP SEQUENCE SEQ_POST_BLAME;
CREATE SEQUENCE SEQ_POST_BLAME MINVALUE 1 NOCYCLE NOCACHE;
-------------------------------------
-----------------------------------------------------------------------------------------
--외래키
--ALTER FOREIGN KEY

--ALTER TABLE "POST" ADD CONSTRAINT "PK_POST" PRIMARY KEY (
--	"POST_NO"
--);

--ALTER TABLE "NOTICE" ADD CONSTRAINT "PK_NOTICE" PRIMARY KEY (
--	"NOTICE_NO"
--);

--ALTER TABLE "MEMBER" ADD CONSTRAINT "PK_MEMBER" PRIMARY KEY (
--	"MEM_NO"
--);

--ALTER TABLE "FOLLOW_LIST" ADD CONSTRAINT "PK_FOLLOW_LIST" PRIMARY KEY (
--	"FOLLOWING_MEM",
--	"FOLLOW_MEM"
--);

--ALTER TABLE "CUSTOMER_CENTER" ADD CONSTRAINT "PK_CUSTOMER_CENTER" PRIMARY KEY (
--	"Q_NO"
--);

--ALTER TABLE "REPLY" ADD CONSTRAINT "PK_REPLY" PRIMARY KEY (
--	"REPLY_NO"
--);

--ALTER TABLE "ADMIN" ADD CONSTRAINT "PK_ADMIN" PRIMARY KEY (
--	"ADMIN_NO"
--);

--ALTER TABLE "CATEGORY_LIST" ADD CONSTRAINT "PK_CATEGORY_LIST" PRIMARY KEY (
--	"CATEGORY_NO"
--);

--ALTER TABLE "ALARM" ADD CONSTRAINT "PK_ALARM" PRIMARY KEY (
--	"ALARM_NO"
--);

--ALTER TABLE "BLOG" ADD CONSTRAINT "PK_BLOG" PRIMARY KEY (
--	"BLOG_NO"
--);

--ALTER TABLE "REPLY_BLAME" ADD CONSTRAINT "PK_REPLY_BLAME" PRIMARY KEY (
--	"R_BLA_NO"
--);

--ALTER TABLE "REPLY_SANCTIONS" ADD CONSTRAINT "PK_REPLY_SANCTIONS" PRIMARY KEY (
--	"R_SANC_NO"
--);

--ALTER TABLE "MYBLOG_CATEGORY" ADD CONSTRAINT "PK_MYBLOG_CATEGORY" PRIMARY KEY (
--	"GROUP_NO"
--);

--ALTER TABLE "HEART" ADD CONSTRAINT "PK_HEART" PRIMARY KEY (
--	"POST_NO",
--	"MEM_NO"
--);

--ALTER TABLE "POST_BLAME" ADD CONSTRAINT "PK_POST_BLAME" PRIMARY KEY (
--	"P_BLA_NO"
--);

--ALTER TABLE "BLAME_REASON" ADD CONSTRAINT "PK_BLAME_REASON" PRIMARY KEY (
--	"BLA_LIST"
--);

ALTER TABLE "POST_SANCTIONS" ADD CONSTRAINT "PK_POST_SANCTIONS" PRIMARY KEY (
	"P_SANC_NO"
);

--ALTER TABLE "VISITORS" ADD CONSTRAINT "PK_VISITORS" PRIMARY KEY (
--	"VISITORS_NO"
--);

ALTER TABLE "POST" ADD CONSTRAINT "FK_BLOG_TO_POST_1" FOREIGN KEY (
	"BLOG_NO"
)
REFERENCES "BLOG" (
	"BLOG_NO"
);

ALTER TABLE "POST" ADD CONSTRAINT "FK_CATEGORY_LIST_TO_POST_1" FOREIGN KEY (
	"CATEGORY_NO"
)
REFERENCES "CATEGORY_LIST" (
	"CATEGORY_NO"
);

ALTER TABLE "POST" ADD CONSTRAINT "FK_MYBLOG_CATEGORY_TO_POST_1" FOREIGN KEY (
	"GROUP_NO"
)
REFERENCES "MYBLOG_CATEGORY" (
	"GROUP_NO"
);

ALTER TABLE "NOTICE" ADD CONSTRAINT "FK_ADMIN_TO_NOTICE_1" FOREIGN KEY (
	"ADMIN_NO"
)
REFERENCES "ADMIN" (
	"ADMIN_NO"
);

ALTER TABLE FOLLOW
ADD CONSTRAINT FK_MEM_NO
FOREIGN KEY (MEM_NO)
REFERENCES MEMBER(MEM_NO);

ALTER TABLE FOLLOW
ADD CONSTRAINT FK_BLOG_NO
FOREIGN KEY (BLOG_NO)
REFERENCES MEMBER(MEM_NO);


ALTER TABLE "CUSTOMER_CENTER" ADD CONSTRAINT "FK_ADMIN_TO_CUSTOMER_CENTER_1" FOREIGN KEY (
	"ADMIN_NO"
)
REFERENCES "ADMIN" (
	"ADMIN_NO"
);

ALTER TABLE "CUSTOMER_CENTER" ADD CONSTRAINT "FK_MEMBER_TO_CUSTOMER_CENTER_1" FOREIGN KEY (
	"MEM_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_POST_TO_REPLY_1" FOREIGN KEY (
	"POST_NO"
)
REFERENCES "POST" (
	"POST_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_MEMBER_TO_REPLY_1" FOREIGN KEY (
	"REPLY_MEM"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "REPLY" ADD CONSTRAINT "FK_REPLY_TO_REPLY_1" FOREIGN KEY (
	"PARENTS_NO"
)
REFERENCES "REPLY" (
	"REPLY_NO"
);

ALTER TABLE "ALARM" ADD CONSTRAINT "FK_MEMBER_TO_ALARM_1" FOREIGN KEY (
	"RECEIVER_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "ALARM" ADD CONSTRAINT "FK_POST_TO_ALARM_1" FOREIGN KEY (
	"POST_NO"
)
REFERENCES "POST" (
	"POST_NO"
);

ALTER TABLE "BLOG" ADD CONSTRAINT "FK_MEMBER_TO_BLOG_1" FOREIGN KEY (
	"MEM_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "REPLY_BLAME" ADD CONSTRAINT "FK_MEMBER_TO_REPLY_BLAME_1" FOREIGN KEY (
	"R_BLAMER_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "REPLY_BLAME" ADD CONSTRAINT "FK_REPLY_TO_REPLY_BLAME_1" FOREIGN KEY (
	"R_NO"
)
REFERENCES "REPLY" (
	"REPLY_NO"
);

ALTER TABLE "REPLY_BLAME" ADD CONSTRAINT "FK_BLAME_REASON_TO_REPLY_BLAME_1" FOREIGN KEY (
	"R_BLA_LIST"
)
REFERENCES "BLAME_REASON" (
	"BLA_LIST"
);

ALTER TABLE "REPLY_SANCTIONS" ADD CONSTRAINT "FK_REPLY_BLAME_TO_REPLY_SANCTIONS_1" FOREIGN KEY (
	"R_BLA_NO"
)
REFERENCES "REPLY_BLAME" (
	"R_BLA_NO"
);

ALTER TABLE "MYBLOG_CATEGORY" ADD CONSTRAINT "FK_BLOG_TO_MYBLOG_CATEGORY_1" FOREIGN KEY (
	"BLOG_NO"
)
REFERENCES "BLOG" (
	"BLOG_NO"
);

ALTER TABLE "HEART" ADD CONSTRAINT "FK_POST_TO_HEART_1" FOREIGN KEY (
	"POST_NO"
)
REFERENCES "POST" (
	"POST_NO"
);

ALTER TABLE "HEART" ADD CONSTRAINT "FK_MEMBER_TO_HEART_1" FOREIGN KEY (
	"MEM_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "POST_BLAME" ADD CONSTRAINT "FK_MEMBER_TO_POST_BLAME_1" FOREIGN KEY (
	"P_BLAMER_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

ALTER TABLE "POST_BLAME" ADD CONSTRAINT "FK_POST_TO_POST_BLAME_1" FOREIGN KEY (
	"P_NO"
)
REFERENCES "POST" (
	"POST_NO"
);

ALTER TABLE "POST_BLAME" ADD CONSTRAINT "FK_BLAME_REASON_TO_POST_BLAME_1" FOREIGN KEY (
	"P_BLA_LIST"
)
REFERENCES "BLAME_REASON" (
	"BLA_LIST"
);

ALTER TABLE "POST_SANCTIONS" ADD CONSTRAINT "FK_POST_BLAME_TO_POST_SANCTIONS_1" FOREIGN KEY (
	"P_BLA_NO"
)
REFERENCES "POST_BLAME" (
	"P_BLA_NO"
);

ALTER TABLE "VISITORS" ADD CONSTRAINT "FK_BLOG_TO_VISITORS_1" FOREIGN KEY (
	"BLOG_NO"
)
REFERENCES "BLOG" (
	"BLOG_NO"
);

ALTER TABLE "VISITORS" ADD CONSTRAINT "FK_MEMBER_TO_VISITORS_1" FOREIGN KEY (
	"VISITORS_MEM_NO"
)
REFERENCES "MEMBER" (
	"MEM_NO"
);

COMMIT;