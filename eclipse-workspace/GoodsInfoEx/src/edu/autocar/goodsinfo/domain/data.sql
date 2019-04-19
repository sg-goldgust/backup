
drop table goodsinfo;

create table goodsinfo (
	code char(5) not null,
	name varchar2(30) not null,
	price number not null,
	maker varchar2(20),
	primary key(code)
);

insert into goodsinfo (code, name, price, maker)
values ('10001', '디지털 TV' , 350000, 'LG');

insert into goodsinfo (code, name, price, maker)
values ('10002', '디지털 TV' , 350000, 'LG');

insert into goodsinfo (code, name, price, maker)
values ('10003', '디지털 TV' , 350000, 'LG');

insert into goodsinfo (code, name, price, maker)
values ('10004', '디지털 TV' , 350000, 'LG');

insert into goodsinfo (code, name, price, maker)
values ('10005', '디지털 TV' , 350000, 'LG');

select * from tourguide;
commit

drop table member;
create table member(
   user_Id varchar2(10) primary key,
   password varchar2(256),
   name varchar2(20char),
   email varchar2(64),
   phone varchar2(20),
   address varchar2(100char),
   reg_date date default sysdate,
   update_date date default sysdate
   );
   
insert into member
select lower(email), '1234' , last_name,
	lower(email)||'naver.com',
	replace(phone_number,'.','-'),
	null , hire_date , sysdate
from hr.employees;

grant select on employees to autocar;

drop table tourguide;

create table tourguide(
	tour_id varchar2(10) primary key,
	name varchar2(256),
	city varchar2(256),
	region varchar2(256),
	content	 varchar2(3000),
	site varchar2(256),
	homepage varchar2(256)
	);

create sequence tour_seq
	start with 1,
	increment by 1,
	maxvalue 10000;
	
	



