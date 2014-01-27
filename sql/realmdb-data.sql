source realmdb-schema.sql;

insert into users values('adminmail', 'Administrador',false, MD5('admin'));
insert into user_roles values ('adminmail', 'admin');

insert into users values('arnaumail', 'Arnau', false, MD5('arnau'));
insert into user_roles values ('arnaumail', 'registered');

insert into users values('joanmail', 'Joan',false, MD5('joan'));
insert into user_roles values ('joanmail', 'registered');

insert into users values('roxanamail', 'Roxana',false, MD5('roxana'));
insert into user_roles values ('roxanamail', 'registered');

insert into users values('josemail', 'Jose',true, MD5('jose'));
insert into user_roles values ('josemail', 'registered');