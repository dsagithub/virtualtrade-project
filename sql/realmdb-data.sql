source realmdb-schema.sql;

insert into users values('adminmail', 'Administrador', MD5('admin'));
insert into user_roles values ('adminmail', 'admin');

insert into users values('arnaumail', 'Arnau', MD5('arnau'));
insert into user_roles values ('arnaumail', 'registered');

insert into users values('joanmail', 'Joan', MD5('joan'));
insert into user_roles values ('joanmail', 'registered');

insert into users values('roxanamail', 'Roxana', MD5('roxana'));
insert into user_roles values ('roxanamail', 'registered');

insert into users values('josemail', 'Jose', MD5('jose'));
insert into user_roles values ('josemail', 'registered');