create database if not exists banco_trabalho;

use banco_trabalho;

create table if not exists Restaurante(
	idRestaurante int auto_increment not null,
	nome varchar(200) not null,
    cnpj varchar(20),
    primary key (idRestaurante)
);


create table if not exists Cardapio(
	idCardapio int auto_increment not null,
    tipo varchar(200) not null,
    idRest int,
    primary key (idCardapio),
	foreign key (idRest) references Restaurante(idRestaurante)
);

create table if not exists Prato(
	idPrato int auto_increment not null,
    nome varchar(200) not null,
    preço float,
    idCard int,
    primary key (idPrato),
	foreign key (idCard) references Cardapio(idCardapio)
);


