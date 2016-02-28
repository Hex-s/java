/*�û�����Ϣ*/
--�û���
create table bookuser
(
 userid int,
 uname varchar2(32),
 upwd varchar2(32),
 constraints pk_bookuser_userid primary key(userid)
)
--�û�����
create sequence sq_bookuser_userid
start with 1
increment by 1
--��������
insert into bookuser values(sq_bookuser_userid.nextval,'tom','0000');
insert into bookuser values(sq_bookuser_userid.nextval,'jary','0000');

/*������Ϣ*/
--���߱�
create table bookwriter
(
 writerid int,
 wname varchar2(32),
 constraints pk_bookwriter_writerid primary key(writerid)
)
--��������
create sequence sq_bookwriter_writerid
start with 1
increment by 1
--��������
insert into bookwriter values(sq_bookwriter_writerid.nextval,'shirly');
insert into bookwriter values(sq_bookwriter_writerid.nextval,'marry');
insert into bookwriter values(sq_bookwriter_writerid.nextval,'lily');

/*��������Ϣ*/
--�������
create table bookpublish
(
 publishid int,
 pname varchar2(32),
 constraints pk_bookpublish_publishid primary key(publishid)
)
--����������
create sequence sq_bookpublish_publishid
start with 1
increment by 1
--��������
insert into bookpublish values(sq_bookpublish_publishid.nextval,'�廪������');
insert into bookpublish values(sq_bookpublish_publishid.nextval,'���ӹ�ҵ������');
insert into bookpublish values(sq_bookpublish_publishid.nextval,'������ҵ������');
/*�����Ϣ*/
--����
create table bookvarity
(
 vid int,
 vname varchar2(32),
 constraints pk_bookvarity_vid primary key(vid)
)
--�������
create sequence sq_bookvarity_vid
start with 1
increment by 1
--��������
insert into bookvarity values(sq_bookvarity_vid.nextval,'java');
insert into bookvarity values(sq_bookvarity_vid.nextval,'html');
insert into bookvarity values(sq_bookvarity_vid.nextval,'oracle');
insert into bookvarity values(sq_bookvarity_vid.nextval,'js');

/*ͼ����Ϣ*/
--ͼ���
create table books
(
 bookid int,
 bookname varchar2(50),
 bwriterid int, --����
 bpublishid int,--������
 bpic varchar2(50),--ͼƬ
 bvarity int, --���
 binfo varchar2(250), -- ���
 constraints pk_books_boookid primary key(bookid),
 constraints fk_books_bwriterid foreign key(bwriterid) references bookwriter(writerid),
 constraints fk_books_bvarity foreign key(bvarity) references bookvarity(vid),
 constraints fk_books_bpublishid foreign key(bpublishid) references bookpublish(publishid)
)
--ͼ������
create sequence sq_books_boookid
start with 1
increment by 1

drop table books;
drop sequence sq_books_boookid;
--��������
insert into books values(sq_books_boookid.nextval,'����ѧϰJAVA',1,1,'class-book1.jpg',1,'����ѧϰJAVA�鼮������ѧϰJAVA�鼮���');
insert into books values(sq_books_boookid.nextval,'��ξ�ͨJAVA',2,2,'class-book2.jpg',1,'��ξ�ͨJAVA�鼮�����ξ�ͨJAVA�鼮���');
insert into books values(sq_books_boookid.nextval,'����ѧϰHTML',3,3,'class-book3.jpg',2,'����ѧϰHTML�鼮������ѧϰHTML�鼮���');
insert into books values(sq_books_boookid.nextval,'��ξ�ͨHTML',1,1,'class-book4.jpg',2,'��ξ�ͨHTML�鼮�����ξ�ͨHTML�鼮���');
insert into books values(sq_books_boookid.nextval,'����ѧϰORACLE',2,2,'class-book5.jpg',3,'����ѧϰORACLE�鼮������ѧϰORACLE�鼮���');
insert into books values(sq_books_boookid.nextval,'��ξ�ͨORACLE',3,3,'class-book6.jpg',3,'��ξ�ͨORACLE�鼮�����ξ�ͨORACLE�鼮���');
insert into books values(sq_books_boookid.nextval,'����ѧϰJS',1,3,'class-book7.jpg',4,'����ѧϰJS�鼮������ѧϰJS�鼮���');
insert into books values(sq_books_boookid.nextval,'��ξ�ͨJS',2,2,'class-book8.jpg',4,'��ξ�ͨJS�鼮�����ξ�ͨJS�鼮���');


/*�û��ղ��鼮��Ϣ*/
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
--�ղ��鼮��
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