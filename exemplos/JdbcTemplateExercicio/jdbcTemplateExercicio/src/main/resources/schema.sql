CREATE TABLE PESSOA (
   id 		INTEGER PRIMARY KEY,
   nome 	VARCHAR(50) NOT NULL,
   email	VARCHAR(50) NOT NULL,
   cpfOuCnpj VARCHAR(50) NOT NULL,
   tipo VARCHAR(1) NOT NULL
);

CREATE TABLE ENDERECO (
    id INTEGER PRIMARY KEY,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    complemento VARCHAR(100) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    id_pessoa INTEGER NOT NULL,
    FOREIGN KEY (id_pessoa) REFERENCES PESSOA(id)
);