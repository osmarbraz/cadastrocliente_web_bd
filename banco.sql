#criar o database chamado cliente
create database if not exists cliente;

#entrar no database cliente
use cliente;

#remove as tabelas para recriá-las
drop table if exists CLIENTE;

#cria a tabela de cliente
CREATE TABLE CLIENTE (
	CLIENTEID  INTEGER NOT NULL AUTO_INCREMENT,    
	NOME       VARCHAR(100) NOT NULL,     
	CPF        VARCHAR(11) NOT NULL,
	PRIMARY KEY(CLIENTEID)    
);


#lista a tabela criada
show tables;
