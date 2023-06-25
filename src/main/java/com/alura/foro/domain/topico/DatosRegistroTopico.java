package com.alura.foro.domain.topico;


import com.alura.foro.domain.curso.DatosCurso;
import com.alura.foro.domain.usuario.DatosRegistroUsuario;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
		@NotBlank
		String titulo,
		@NotBlank
		String mensaje,
		@NotNull
		StatusTopico statustopico,
		@NotNull
		@Valid
		DatosRegistroUsuario usuario,
		@NotNull
		@Valid
		DatosCurso curso
		) {}
