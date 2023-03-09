create table produto(
id bigint not null primary key auto_increment,
nome varchar(80) not null,
tipoCultura varchar(40) not null,
tamArea int not null,
descricao longtext not null,
dataCadastro date not null,
status varchar(40) not null
);

create table imagems(
id bigint not null primary key auto_increment,
nome varchar(80) not null,
tipo varchar(60) not null,
dadosImagem longtext not null
);