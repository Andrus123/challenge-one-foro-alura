create table respuestas(
	id BIGINT NOT NULL AUTO_INCREMENT,
	mensaje MEDIUMTEXT NOT NULL,
	topico BIGINT NOT NULL,
	fecha_creacion DATE NOT NULL,
	usuario BIGINT NOT NULL,
	solucion TINYINT NOT NULL,
	
	PRIMARY KEY(id),
	FOREIGN KEY(topico) REFERENCES topicos(id),
	FOREIGN KEY(usuario) REFERENCES usuarios(id)
)