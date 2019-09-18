CREATE TABLE artefato(
		id          SERIAL PRIMARY KEY NOT NULL, -- chave primária
		nome        VARCHAR(30) NOT NULL,
		quantidade  INT NOT NULL,
		tipo        VARCHAR(30) NOT NULL,
		urlImagem   VARCHAR(30) NOT NULL,
		descricao   VARCHAR(30) NOT NULL

		);