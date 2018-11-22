
drop database easypark;
create database easypark;

use easypark;
insert into tb_truck(id,cnpj,nome_fantasia,email,senha,latitude,longitude) values (1,'7564738749576','Siri Cascudo','testetruck@gmail.com','1234',-7.998534,-34.924024);
insert into tb_mesa(id,capacidade,qr_code,latitude,longitude) values (1,1,'uewhi8397ydh7',-7.998533,-34.924023);
insert into tb_categoria(id,nome) values (1,'Hamburger');
insert into tb_produto(id,nome,valor,id_categoria,id_truck) values (1,'Hamburger de Siri',20.00,1,1);
insert into tb_produto(id,nome,valor,id_categoria,id_truck) values (2,'Pão com queijo',12.00,1,1);