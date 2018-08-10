use toeiconline;

alter table  userEntity add constraint fk_user_role foreign key (roleid) references roleEntity(roleid);