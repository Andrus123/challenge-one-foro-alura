package com.alura.foro.domain.usuario;

public record DatosReturnUsuario(Long id,
		String nombre,
		String email,
		String contrasena) {
	public DatosReturnUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNombre()
				,usuario.getEmail(),usuario.getContrasena());
	}
}
