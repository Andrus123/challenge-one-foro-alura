package com.alura.foro.domain.usuario;

public record DatosListadoUsuarios(String nombre, String email, String contrasena) {
	public DatosListadoUsuarios(Usuario usuario) {
		this(usuario.getNombre(), usuario.getEmail(), usuario.getContrasena());
	}
}
