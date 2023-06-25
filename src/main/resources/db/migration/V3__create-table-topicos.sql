create table topicos(
	id BIGINT NOT NULL AUTO_INCREMENT,
	titulo varchar(255) NOT NULL,
	mensaje MEDIUMTEXT NOT NULL,
	fecha_creacion DATE NOT NULL,
	statustopico varchar(20) NOT NULL,
	usuario BIGINT NOT NULL,
	curso BIGINT NOT NULL,
	
	PRIMARY KEY (id),
	FOREIGN KEY(usuario) REFERENCES usuarios (id),
	FOREIGN KEY(curso) REFERENCES cursos (id)
);