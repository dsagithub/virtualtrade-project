drop database if exists realmdb;
create database realmdb;
 
use realmdb;
 
create table users (
	email	varchar(40) not null primary key,
	name	varchar(20) not null,
	userpass char(32) not null

);
 
create table user_roles (
	email	varchar(40) not null,
	rolename 	varchar(20) not null,
	foreign key(email) references users(email) on delete cascade,
	primary key (email, rolename)
);