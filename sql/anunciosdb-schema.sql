drop database if exists anunciosdb;
create database anunciosdb CHARACTER SET utf8 COLLATE utf8_general_ci;

use anunciosdb;

create table users (
	email	varchar(40) not null primary key,
	name	varchar(20) not null,
	phone	int,
	ciudad	varchar(30) not null,
	calle	varchar(70) not null,
	numero	int not null,
	piso	int,
	puerta 	int,
	banned 	boolean not null,
	foto 	varchar(200)
);
 

create table anuncio (
	anuncioid				int not null auto_increment primary key,
	email					varchar(40) not null,
	subject					varchar(100) not null,	
	content					varchar(1000) not null,					
	estado					boolean not null,
	precio					int(10) not null,
	creation_timestamp		timestamp,
	atributo1				varchar(30) default 'Otros',
	atributo2				varchar(30)default 'Otros',
	atributo3 				varchar(30) default 'Otros',
	marca					varchar(30) default 'Otros',
	foreign key(email) references users(email) 
);


create table imagen (

	imagenid	int not null primary key auto_increment,
	anuncioid 	int not null,
	urlimagen	varchar(200) not null,
	foreign key(anuncioid) references anuncio(anuncioid) 
);

create table mensaje (
	mensajeid				int not null auto_increment primary key,
	emailorigen				varchar(40) not null,
	emaildestino			varchar(40) not null,	
	creation_timestamp		timestamp,
	anuncioid				int,
	subject					varchar(100),
	content					varchar(500),
	foreign key(emailorigen) references users(email),
	foreign key(emaildestino) references users(email),
	foreign key(anuncioid) references anuncio(anuncioid) 
);