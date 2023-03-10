alter table imagens add column id_produto bigint not null;
alter table imagens add constraint FK_fotosProduto foreign key (id_produto) references produto(id);