create table usuarios(
	id BIGINT NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	contrasena VARCHAR(300) NOT NULL,
	PRIMARY KEY (id)
);