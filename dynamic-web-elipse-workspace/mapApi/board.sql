



CREATE TABLE BOARD (
BOARD_ID NUMBER PRIMARY KEY,
TITLE VARCHAR2(256) NOT NULL,
WRITER VARCHAR2(50) NOT NULL,
PASSWORD VARCHAR2(20) NOT NULL,
READ_CNT NUMBER DEFAULT(0),
CONTENT CLOB,
REG_DATE DATE DEFAULT(SYSDATE),
UPDATE_DATE DATE DEFAULT(SYSDATE)
);

CREATE SEQUENCE BOARD_SEQ;


DROP TABLE MEMBER; 
CREATE TABLE MEMBER( 
USER_ID VARCHAR2(10 CHAR) PRIMARY KEY, 
PASSWORD VARCHAR2(256 CHAR), 
NAME VARCHAR2(20 CHAR), 
SALT VARCHAR2(16), 
USER_LEVEL VARCHAR2(20 CHAR), 
EMAIL VARCHAR2(40 CHAR), 
PHONE VARCHAR2(20 CHAR), 
ADDRESS VARCHAR2(200 CHAR), 
REG_DATE DATE DEFAULT sysdate, 
UPDATE_DATE DATE DEFAULT sysdate 
);

CREATE TABLE GALLERY(
gallery_id NUMBER PRIMARY KEY,
owner VARCHAR2(50),
password VARCHAR2(50),
title VARCHAR2(256 CHAR),
description VARCHAR2(512 CHAR),
read_cnt NUMBER DEFAULT 0,
reg_date DATE DEFAULT SYSDATE,
update_date DATE DEFAULT SYSDATE
);
CREATE SEQUENCE GALLERY_SEQ;

DROP TABLE IMAGE;
DROP SEQUENCE IMAGE_SEQ;

CREATE TABLE POSTIMAGE(
image_id NUMBER PRIMARY KEY,
gallery_id NUMBER REFERENCES BlogPost(post_id),
original_name VARCHAR2(128 CHAR),
file_size NUMBER,
mime_type VARCHAR(56),
reg_date DATE DEFAULT SYSDATE
);
CREATE SEQUENCE POSTIMAGE_SEQ;


CREATE TABLE IMAGE(
image_id NUMBER PRIMARY KEY,
gallery_id NUMBER REFERENCES GALLERY(gallery_id),
original_name VARCHAR2(128 CHAR),
file_size NUMBER,
mime_type VARCHAR(56),
reg_date DATE DEFAULT SYSDATE
);
CREATE SEQUENCE IMAGE_SEQ;

CREATE TABLE AVATA(
	user_id VARCHAR(20) PRIMARY KEY,
	image BLOB
);

DROP TABLE BLOG;
DROP TABLE BLOGPOST; 
DROP SEQUENCE BLOG_SEQ;
DROP SEQUENCE BLOGPOST_SEQ;

CREATE TABLE BLOG(
	blog_id NUMBER PRIMARY KEY,
	user_id VARCHAR2(50) REFERENCES MEMBER(user_id),
	title VARCHAR2(256 CHAR),
	description VARCHAR2(512 CHAR),
	good_cnt NUMBER,
	reg_date DATE DEFAULT SYSDATE
);

CREATE SEQUENCE BLOG_SEQ;


CREATE TABLE BlOGPOST(
	post_id NUMBER PRIMARY KEY,
	user_id VARCHAR2(50) REFERENCES MEMBER(user_id),
	title VARCHAR2(256 CHAR),
	content VARCHAR2(512 CHAR),
	read_cnt NUMBER,
	reg_date DATE DEFAULT SYSDATE,
	update_date DATE DEFAULT SYSDATE
);
CREATE SEQUENCE BLOGPOST_SEQ;


drop table blog;
drop sequence blog_seq;

create table blog(
blog_id number primary key,
user_id varchar2(10 char) references member(user_id),
title varchar2(256 char),
description varchar2(512 char),
good_cnt number default(0),
reg_date date default(sysdate)
);

create sequence blog_seq;

insert into	blog (blog_id, user_id, title, description, reg_date) 
			values(blog_SEQ.NEXTVAL, 'mundo', '제목1', '내용1', sysdate);
insert into	blog (blog_id, user_id, title, description, reg_date)  
			values(blog_SEQ.NEXTVAL, 'yasuo', '제목2', '내용2', sysdate);
insert into	blog (blog_id, user_id, title, description, reg_date) 
			values(blog_SEQ.NEXTVAL, 'sona', '제목3', '내용3', sysdate);
insert into	blog (blog_id, user_id, title, description, reg_date)  
			values(blog_SEQ.NEXTVAL, 'janna', '제목4', '내용4', sysdate);
      
select * from blog;

SELECT count(*)
		FROM blog;



drop table blogpost;
drop sequence blogpost_seq;

create table blogpost(
post_id number primary key,
user_id varchar2(10 char) references member(user_id),
title varchar2(256 char),
content clob,
read_cnt number default(0),
reg_date date default(sysdate),
update_date date default(sysdate)
);

create sequence blogpost_seq;

select * from blogpost;


insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'janna', '제목1', 'content1');
insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'janna', '제목2', 'content2');
insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'janna', '제목3', 'content3');
      
commit
drop table blog;
drop sequence blog_seq;

create table blog(
blog_id number primary key,
user_id varchar2(10 char) references member(user_id),
title varchar2(256 char),
description varchar2(512 char),
good_cnt number default(0),
reg_date date default(sysdate)
);
select * from member;

create sequence blog_seq;

insert into	blog (blog_id, user_id, title, description, reg_date) 
			values(blog_SEQ.NEXTVAL, 'goldgust4', '제목1', '내용1', sysdate);
insert into	blog (blog_id, user_id, title, description, reg_date)  
			values(blog_SEQ.NEXTVAL, 'goldgust3', '제목2', '내용2', sysdate);
insert into	blog (blog_id, user_id, title, description, reg_date) 
			values(blog_SEQ.NEXTVAL, 'goldgust2', '제목3', '내용3', sysdate);
insert into	blog (blog_id, user_id, title, description, reg_date)  
			values(blog_SEQ.NEXTVAL, 'goldgust', '제목4', '내용4', sysdate);
      
select * from blog;

SELECT count(*)
		FROM blog;

delete from blog
where blog_id = 11;
commit;

drop table blogpost;
drop sequence blogpost_seq;

create table blogpost(
post_id number primary key,
user_id varchar2(10 char) references member(user_id),
title varchar2(256 char),
content clob,
read_cnt number default(0),
reg_date date default(sysdate),
update_date date default(sysdate)
);

create sequence blogpost_seq;

select * from blogpost;


insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'goldgust4', '제목1', 'content1');
insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'goldgust4', '제목2', 'content2');
insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'goldgust4', '제목3', 'content3');
      
commit;

insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'test', '장어구이 집에서 푸짐하게~ 장어즙도 진해요', '대전은 어제부터 비가 오더니 오늘도 흐릿하네요. 비로 미세먼지 씻겻으면 좋겟어요~ 요즘 주말 농부 시작하면서 영 피곤하네요..');
insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'test', '제목2', 'content2');
insert into	blogpost (post_id, user_id, title, content) 
			values(blogpost_SEQ.NEXTVAL, 'test', '제목3', 'content3');
commit;
select * from blog;

