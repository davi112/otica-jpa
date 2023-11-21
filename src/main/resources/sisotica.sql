CREATE DATABASE sisotica;

use sisotica;


CREATE TABLE IF NOT EXISTS usuario(
    id_usuario INTEGER NOT NULL auto_increment,
    login varchar(100) NOT NULL,
    senha varchar(350) NOT NULL,
    PRIMARY KEY (id_usuario)
);


CREATE TABLE IF NOT EXISTS cliente (
    id INTEGER NOT NULL auto_increment, 
    nome varchar(50) NOT NULL, 
    cpf varchar(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone varchar(30) NOT NULL, 
    email varchar(30) NOT NULL, 
    data_cadastro DATE NOT NULL, 
    possui_receita boolean not null, 
    PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS funcionario(
    id INTEGER NOT NULL auto_increment, 
    nome varchar(50) NOT NULL, 
    cpf varchar(15) NOT NULL,
    data_nascimento DATE NOT NULL,
    telefone varchar(30) NOT NULL, 
    email varchar(30) NOT NULL, 
    salario DOUBLE NOT NULL, 
    data_admissao DATE NOT NULL,
    cargo INTEGER NOT NULL, 
    id_usuario INTEGER NOT NULL, 
    PRIMARY KEY (id), 
    FOREIGN KEY (id_usuario) REFERENCES usuario(id_usuario)
);


CREATE TABLE IF NOT EXISTS produto (
    id_produto INTEGER NOT NULL auto_increment, 
    nome varchar(50) NOT NULL, 
    descricao varchar(350) NOT NULL, 
    preco double, 
    categoria INTEGER NOT NULL, 
    PRIMARY KEY (id_produto)
);


CREATE TABLE IF NOT EXISTS receita (
    id_receita INTEGER NOT NULL auto_increment, 
    esfericoOD INTEGER, 
    esfericoOE INTEGER, 
    cilindricoOD INTEGER, 
    cilindricoOE INTEGER, 
    eixoOD Integer, eixoOE Integer, 
    adicao double, 
    distancia_pupilar double, 
    id_cliente INTEGER NOT NULL, 
    PRIMARY KEY (id_receita), 
    FOREIGN KEY (id_receita) REFERENCES cliente(id)
);

CREATE TABLE IF NOT EXISTS venda(
    id_venda INTEGER NOT NULL auto_increment, 
    valor double, 
    desconto double, 
    forma_pagamento INTEGER NOT NULL, 
    id_cliente INTEGER NOT NULL, 
    id_funcionario INTEGER NOT NULL, 
    PRIMARY KEY(id_venda), 
    FOREIGN KEY (id_cliente) 
    REFERENCES cliente(id), 
    FOREIGN KEY(id_funcionario) REFERENCES funcionario(id)
);
