\l

CREATE DATABASE moda;
DROP DATABASE moda;

\c moda

\dt

CREATE TABLE IF NOT EXISTS tendencia(
    id SERIAL,
    preco FLOAT(10),
    peca VARCHAR(250),
    categoria VARCHAR(250),
    descricao VARCHAR(250),
	tamanho VARCHAR(250),
	cor VARCHAR(250),
    image_url VARCHAR(250)
);

DROP TABLE tendencia;

SELECT * FROM tendencia;

INSERT INTO tendencia VALUES(1, 1027.89, 'vestido',  'moda femnina', 'vestido de linho', 'M', 'lilás', 'https://firebasestorage.googleapis.com/v0/b/loja-de-moda-4fa2b.appspot.com/o/moda%2Fvestido_lilas.jpg?alt=media&token=062d8ecd-1590-42e8-b4e6-e4e03ad59b3d');

DELETE FROM tendencia;

\q


 /* 
 NOTA DE OBSERVAÇÃO [metodo de busca]:
 
 @RequestParam(value = "size",  required = false, defaultValue = "12") int size

	O objeto size gera um efeito colateral inesperado,
	sua chamada deve estar a 1 valor acima do lenght do array de busca,
	ou ele retorna um erro
		
Ex: se Array.lenght=3
		
	o parametro deve iniciar com o valor acima deste lenght e contado apartir
	do valor 1

EX: ?size=4 

	caso contrário ele retorna um erro: 
		java.lang.IllegalArgumentException: Page size must not be less than one!
	
	ou um erro:
		syntax error near where 
*/
		