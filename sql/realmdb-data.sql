source realmdb-schema.sql;

insert into users values('adminmail', 'Administrador',false, MD5('admin'));
insert into user_roles values ('adminmail', 'admin');

insert into users values('arnau@virtualtrade.com', 'Arnau', false, MD5('arnau'));
insert into user_roles values ('arnau@virtualtrade.com', 'registered');

insert into users values('joan@virtualtrade.com', 'Joan',false, MD5('joan'));
insert into user_roles values ('joan@virtualtrade.com', 'registered');

insert into users values('roxana@virtualtrade.com', 'Roxana',false, MD5('roxana'));
insert into user_roles values ('roxana@virtualtrade.com', 'registered');

insert into users values('jose@virtualtrade.com', 'Jose',true, MD5('jose'));
insert into user_roles values ('jose@virtualtrade.com', 'registered');

insert into users values('alicia@virtualtrade.com', 'Alicia',true, MD5('alicia'));
insert into user_roles values ('alicia@virtualtrade.com', 'registered');

insert into users values('blas@virtualtrade.com', 'Blas',true, MD5('blas'));
insert into user_roles values ('blas@virtualtrade.com', 'registered');

insert into users values('pedro@virtualtrade.com', 'Pedro',true, MD5('pedro'));
insert into user_roles values ('pedro@virtualtrade.com', 'registered');

insert into users values('maria@virtualtrade.com', 'Maria',true, MD5('maria'));
insert into user_roles values ('maria@virtualtrade.com', 'registered');

insert into users values('ester@virtualtrade.com', 'Ester',true, MD5('ester'));
insert into user_roles values ('ester@virtualtrade.com', 'registered');

insert into users values('ana@virtualtrade.com', 'Ana',true, MD5('ana'));
insert into user_roles values ('ana@virtualtrade.com', 'registered');