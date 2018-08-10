use toeiconline;

create table userEntity(
	userid bigint not null primary key auto_increment,
    name varchar(255) null,
    password varchar(255) null,
    fullname varchar(255) null,
    createdate timestamp null,
    roleid bigint
);

create table roleEntity(
	roleid bigint not null primary key,
    name varchar(100) null
);
