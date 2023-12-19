CREATE TABLE Produto (
                         id SERIAL PRIMARY KEY,
                         nome VARCHAR NOT NULL,
                         codigo NUMERIC NOT NULL,
                         descricao VARCHAR NOT NULL,
                         preco NUMERIC NOT NULL
)