drop database if exists realmdb;
create database realmdb;
 
use realmdb;
 
create table users (
	email	varchar(40) not null primary key,
	name	varchar(20) not null,
	userpass char(32) not null,
	phone	int,
	ciudad	varchar(60) not null,
	calle	varchar(70) not null,
	numero	int not null,
	piso	int,
	puerta int,
	banned varchar(3) not null,
	foto 	varchar(200)
);
 
create table user_roles (
	email	varchar(20) not null,
	rolename 	varchar(20) not null,
	foreign key(email) references users(email) on delete cascade,
	primary key (email, rolename)
);