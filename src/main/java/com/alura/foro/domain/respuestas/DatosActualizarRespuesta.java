package com.alura.foro.domain.respuestas;

import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.usuario.Usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarRespuesta(
		@NotNull Long id,
		String mensaje,
		Topico topico,
		Usuario usuario,
		Boolean solucion
		) {}
