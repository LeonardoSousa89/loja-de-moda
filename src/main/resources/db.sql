CREATE DATABASE moda;
DROP DATABASE moda;

\c moda

CREATE TABLE IF NOT EXISTS tendencia(
    id SERIAL,
    preco FLOAT(10),
    tipo VARCHAR(250),
	tamanho VARCHAR(250),
	cor VARCHAR(250),
    image_url VARCHAR(250)
);

DROP TABLE tendencia;

SELECT * FROM tendencia;

INSERT INTO tendencia VALUES(1, 22.3, 'camisa gola polo', 'M', 'azul', 'https://imagem-exemplo.com/vestido');

DELETE FROM tendencia;

