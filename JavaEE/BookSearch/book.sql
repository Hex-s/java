/*用户表信息*/
--用户表
create table bookuser
(
 userid int,
 uname varchar2(32),
 upwd varchar2(32),
 constraints pk_bookuser_userid primary key(userid)
)
--用户序列
create sequence sq_bookuser_userid
start with 1
increment by 1
--出入数据
insert into bookuser values(sq_bookuser_userid.nextval,'tom','0000');
insert into bookuser values(sq_bookuser_userid.nextval,'jary','0000');

/*作者信息*/
--作者表
create table bookwriter
(
 writerid int,
 wname varchar2(32),
 constraints pk_bookwriter_writerid primary key(writerid)
)
--作者序列
create sequence sq_bookwriter_writerid
start with 1
increment by 1
--插入数据
insert into bookwriter values(sq_bookwriter_writerid.nextval,'shirly');
insert into bookwriter values(sq_bookwriter_writerid.nextval,'marry');
insert into bookwriter values(sq_bookwriter_writerid.nextval,'lily');

/*出版社信息*/
--出版社表
create table bookpublish
(
 publishid int,
 pname varchar2(32),
 constraints pk_bookpublish_publishid primary key(publishid)
)
--出版社序列
create sequence sq_bookpublish_publishid
start with 1
increment by 1
--插入数据
insert into bookpublish values(sq_bookpublish_publishid.nextval,'清华出版社');
insert into bookpublish values(sq_bookpublish_publishid.nextval,'电子工业出版社');
insert into bookpublish values(sq_bookpublish_publishid.nextval,'西安工业出版社');
/*类别信息*/
--类别表
create table bookvarity
(
 vid int,
 vname varchar2(32),
 constraints pk_bookvarity_vid primary key(vid)
)
--类别序列
create sequence sq_bookvarity_vid
start with 1
increment by 1
--插入数据
insert into bookvarity values(sq_bookvarity_vid.nextval,'java');
insert into bookvarity values(sq_bookvarity_vid.nextval,'html');
insert into bookvarity values(sq_bookvarity_vid.nextval,'oracle');
insert into bookvarity values(sq_bookvarity_vid.nextval,'js');

/*图书信息*/
--图书表
create table books
(
 bookid int,
 bookname varchar2(50),
 bwriterid int, --作者
 bpublishid int,--出版社
 bpic varchar2(50),--图片
 bvarity int, --类别
 binfo varchar2(250), -- 简介
 constraints pk_books_boookid primary key(bookid),
 constraints fk_books_bwriterid foreign key(bwriterid) references bookwriter(writerid),
 constraints fk_books_bvarity foreign key(bvarity) references bookvarity(vid),
 constraints fk_books_bpublishid foreign key(bpublishid) references bookpublish(publishid)
)
--图书序列
create sequence sq_books_boookid
start with 1
increment by 1

drop table books;
drop sequence sq_books_boookid;
--插入数据
insert into books values(sq_books_boookid.nextval,'快乐学习JAVA',1,1,'class-book1.jpg',1,'快乐学习JAVA书籍简介快乐学习JAVA书籍简介');
insert into books values(sq_books_boookid.nextval,'如何精通JAVA',2,2,'class-book2.jpg',1,'如何精通JAVA书籍简介如何精通JAVA书籍简介');
insert into books values(sq_books_boookid.nextval,'快乐学习HTML',3,3,'class-book3.jpg',2,'快乐学习HTML书籍简介快乐学习HTML书籍简介');
insert into books values(sq_books_boookid.nextval,'如何精通HTML',1,1,'class-book4.jpg',2,'如何精通HTML书籍简介如何精通HTML书籍简介');
insert into books values(sq_books_boookid.nextval,'快乐学习ORACLE',2,2,'class-book5.jpg',3,'快乐学习ORACLE书籍简介快乐学习ORACLE书籍简介');
insert into books values(sq_books_boookid.nextval,'如何精通ORACLE',3,3,'class-book6.jpg',3,'如何精通ORACLE书籍简介如何精通ORACLE书籍简介');
insert into books values(sq_books_boookid.nextval,'快乐学习JS',1,3,'class-book7.jpg',4,'快乐学习JS书籍简介快乐学习JS书籍简介');
insert into books values(sq_books_boookid.nextval,'如何精通JS',2,2,'class-book8.jpg',4,'如何精通JS书籍简介如何精通JS书籍简介');


/*用户收藏书籍信息*/
create table bookcollect
(
 collectid int,
 cuserid int,
 cbookid int,
 ctime date,
 constraints pk_bookcollect_collectid primary key(collectid),
 constraints fk_bookcollect_cuserid foreign key(cuserid) references bookuser(userid),
 constraints fk_bookcollect_cbookid foreign key(cbookid) references books(bookid)
);
--收藏书籍列
create sequence sq_bookcollect_collectid
start with 1
increment by 1

drop table bookcollect;
drop sequence sq_bookcollect_collectid

select * from bookuser;
select * from bookwriter;
select * from bookpublish;
select * from bookvarity;
select * from books;
select * from bookcollect;

commit;