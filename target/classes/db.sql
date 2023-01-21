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

INSERT INTO tendencia VALUES(1, 1027.89, 'Vestido de Linho lilás', 'M', 'lilás', 'https://firebasestorage.googleapis.com/v0/b/loja-de-moda-4fa2b.appspot.com/o/moda%2Fvestido_lilas.jpg?alt=media&token=062d8ecd-1590-42e8-b4e6-e4e03ad59b3d');

DELETE FROM tendencia;

