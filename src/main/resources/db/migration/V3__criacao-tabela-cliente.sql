create table clientes(
id bigint not null primary key auto_increment,
nome varchar(90) not null,
telefone varchar(11) not null,
email varchar(120) not null,
produto_interesse varchar(100) not null
);