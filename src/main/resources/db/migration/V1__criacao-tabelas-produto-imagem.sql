create table produto(
id bigint not null primary key auto_increment,
nome varchar(80) not null,
tipo_cultura varchar(40) not null,
tamanho_area int not null,
desc_produto longtext not null,
data_cadastro date not null,
status varchar(40) not null
);

create table imagens(
id bigint not null primary key auto_increment,
nome varchar(80) not null,
tipo varchar(60) not null,
dados_imagem mediumblob not null
);