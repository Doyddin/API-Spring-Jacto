create table usuarios(
id_cadastros bigint not null primary key auto_increment,
nome varchar(80) not null,
email varchar(90) not null,
senha varchar(255) not null,
data_cadastro date not null,
nivel_acesso enum('ADMINISTRADOR', 'COLABORADOR') not null
);


