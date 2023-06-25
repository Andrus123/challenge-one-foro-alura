package com.alura.foro.domain.topico;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.usuario.Usuario;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopico(
		@NotNull
		Long id,
		String titulo,
		String mensaje,
		StatusTopico statustopico,
		Usuario usuario,
		Curso curso
		) {}
