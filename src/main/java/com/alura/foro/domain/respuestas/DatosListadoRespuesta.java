package com.alura.foro.domain.respuestas;

import java.util.Date;

import com.alura.foro.domain.topico.DatosListadoTopico;

public record DatosListadoRespuesta(String mensaje, DatosListadoTopico topico, Date fechaCreacion,
		String usuario, Boolean solucion) {
	public DatosListadoRespuesta(Respuesta respuesta) {
		this(respuesta.getMensaje(), new DatosListadoTopico(respuesta.getTopico()), respuesta.getfechaCreacion(),
				respuesta.getUsuario().getNombre(), respuesta.getSolucion());
	}
}
