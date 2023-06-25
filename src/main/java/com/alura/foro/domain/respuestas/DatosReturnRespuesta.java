package com.alura.foro.domain.respuestas;

public record DatosReturnRespuesta(Long id, String mensaje, String topico, String usuario) {
	public DatosReturnRespuesta(Respuesta respuesta) {
		this(respuesta.getId(), respuesta.getMensaje(), respuesta.getTopico().getTitulo(),
				respuesta.getUsuario().getNombre());
	}
}
