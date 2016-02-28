--�������ռ�
create tablespace bbs datafile 'e:/orcl/bbs.dbf' size 5m autoextend on;

--�޸��û�Ĭ�ϱ��ռ�
alter user system default tablespace bbs;

--�û���
create table bbsuser
(
  userid int,
  uname varchar2(32),
  upwd varchar2(32),
  usex int, -- 1:�� 2:Ů
  uemail varchar2(32),
  ubirthday date,
  --uclass int, --�û��ȼ�
  ustatement varchar2(255), --��ע��Ϣ
  uregdate date,
  --ustate int, --�û�״̬ 
  upoint int, --�û�����
  uhead varchar2(50), --�û��Զ���ͷ�� 
  address varchar(50),
  constraints pk_bbsuser_userid primary key(userid)
);
create sequence sq_bbsuser_userid
start with 1
increment by 1

select * from bbsuser
--���� 0:����� 1-~:������� 
create table bbsblock
(
 bid int,
 bname varchar2(255),
 prarentId  int,
 masterid int,
 constraints pk_bbsblock_bid primary key(bid),
 constraints fk_bbsblock_masterid foreign key(masterid) references bbsuser(userid)
);
create sequence sq_bbsblock_bid
start with 1
increment by 1

--������
create table bbstopics
(
 tid int,
 tbid int,
 tuserid int,
 ttitle varchar2(500),
 tcontent clob,
 tpublishtime date, --����ʱ��
 tlastedit date, --���༭ʱ��
 tclickcount int, --�����
 tflag int, -- 0:��ͨ�� 1��������
 constraints pk_bbstopic_tid primary key (tid),
 constraints fk_bbsblock_tbid foreign key(tbid) references bbsblock(bid),
 constraints fk_bbsblock_tuserid foreign key(tuserid) references bbsuser(userid)
);
create sequence sq_bbstopics_tid
start with 1
increment by 1

--������
create table bbsreplys
(
  rid int,
  rtid int,
  ruserid int,
  rcontent clob,
  rtime date,
  constraints pk_bbsreplys_rid primary key(rid),
  constraints fk_bbsreplys_rtid foreign key(rtid) references bbstopics(tid),
  constraints fk_bbsreplys_ruserid foreign key(ruserid) references bbsuser(userid)
);

create sequence sq_bbsreplys_rid
start with 1
increment by 1

select * from bbsuser;
select * from bbsblock;
select * from bbstopics;
select * from bbsreplys where rcontent="";
