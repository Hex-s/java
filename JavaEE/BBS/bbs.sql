--创建表空间
create tablespace bbs datafile 'e:/orcl/bbs.dbf' size 5m autoextend on;

--修改用户默认表空间
alter user system default tablespace bbs;

--用户表
create table bbsuser
(
  userid int,
  uname varchar2(32),
  upwd varchar2(32),
  usex int, -- 1:男 2:女
  uemail varchar2(32),
  ubirthday date,
  --uclass int, --用户等级
  ustatement varchar2(255), --备注信息
  uregdate date,
  --ustate int, --用户状态 
  upoint int, --用户积分
  uhead varchar2(50), --用户自定义头像 
  address varchar(50),
  constraints pk_bbsuser_userid primary key(userid)
);
create sequence sq_bbsuser_userid
start with 1
increment by 1

select * from bbsuser
--版块表 0:父版块 1-~:父版块编号 
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

--主贴表
create table bbstopics
(
 tid int,
 tbid int,
 tuserid int,
 ttitle varchar2(500),
 tcontent clob,
 tpublishtime date, --发表时间
 tlastedit date, --最后编辑时间
 tclickcount int, --点击数
 tflag int, -- 0:普通帖 1：精华帖
 constraints pk_bbstopic_tid primary key (tid),
 constraints fk_bbsblock_tbid foreign key(tbid) references bbsblock(bid),
 constraints fk_bbsblock_tuserid foreign key(tuserid) references bbsuser(userid)
);
create sequence sq_bbstopics_tid
start with 1
increment by 1

--回帖表
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

