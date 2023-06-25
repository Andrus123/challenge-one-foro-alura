package com.alura.foro.domain.topico;

import java.util.Date;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, 
		Date fechaCreacion, String StatusTopico, String usuario, String curso) {
	public DatosRespuestaTopico(Topico topico) {
		this(topico.getId(),topico.getTitulo(),topico.getMensaje(),
				topico.getfechaCreacion(),topico.getStatusTopico().toString(),topico.getUsuario().getNombre()
				,topico.getCurso().getNombre());
	}
}
