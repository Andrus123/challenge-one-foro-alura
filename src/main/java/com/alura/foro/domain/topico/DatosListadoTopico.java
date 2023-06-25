package com.alura.foro.domain.topico;

import java.util.Date;

public record DatosListadoTopico(String titulo, String mensaje, Date fechaCreacion, String estado,
		String usuario, String curso) {
	public DatosListadoTopico(Topico topico) {
		this(topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(), topico.getStatusTopico().toString(),
				topico.getUsuario().getNombre(), topico.getCurso().getNombre());
	}
}
