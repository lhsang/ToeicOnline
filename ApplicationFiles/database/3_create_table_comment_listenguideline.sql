use toeiconline;
create table listenguideline(
  listenguidelineid bigint not null primary key auto_increment,
  title varchar(512) null,
  image varchar(255) null,
  content text null ,
  createdate timestamp null,
  modifieddate timestamp null
);

create table comment (
  commentid bigint not null primary key auto_increment,
  content text null,
  userid bigint null,
  listenguidelineid bigint null,
  createdate timestamp null
);