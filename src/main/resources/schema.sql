CREATE
EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE cliente
(
    id    UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    cpf   VARCHAR(11) UNIQUE,
    nome  VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
);


CREATE TABLE produto
(
    id         SERIAL PRIMARY KEY,
    nome       VARCHAR(100)   NOT NULL,
    descricao  VARCHAR(500)   NOT NULL,
    categoria  INT            NOT NULL,
    quantidade INT            NOT NULL,
    valor      DECIMAL(10, 2) NOT NULL
);

CREATE TABLE pedido
(
    id         SERIAL PRIMARY KEY,
    cliente_id UUID REFERENCES cliente (id),
    status     VARCHAR(20) NOT NULL
);

CREATE TABLE item_pedido
(
    id             SERIAL PRIMARY KEY,
    pedido_id      INT REFERENCES pedido (id),
    produto_id     INT REFERENCES produto (id),
    quantidade     INT            NOT NULL,
    preco_unitario DECIMAL(10, 2) NOT NULL
);

-- Adicione mais tabelas e relacionamentos conforme necessário
