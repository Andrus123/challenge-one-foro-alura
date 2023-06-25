package com.alura.foro.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro.domain.usuario.DatosListadoUsuarios;
import com.alura.foro.domain.usuario.DatosRegistroUsuario;
import com.alura.foro.domain.usuario.DatosReturnUsuario;
import com.alura.foro.domain.usuario.Usuario;
import com.alura.foro.domain.usuario.UsuarioRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<DatosReturnUsuario> registrarUsuario(
			@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario, UriComponentsBuilder uriComponentsBuilder) {
		Usuario usuario = usuarioRepository.save(new Usuario(datosRegistroUsuario));
		DatosReturnUsuario returnUsuario = new DatosReturnUsuario(usuario);
		URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(url).body(returnUsuario);
	}
	
	@GetMapping
	public ResponseEntity<Page<DatosListadoUsuarios>> listadoUsuario(Pageable paginacion) {
		return ResponseEntity.ok(usuarioRepository.findAll(paginacion).map(DatosListadoUsuarios::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DatosListadoUsuarios> buscarUsuario(@PathVariable Long id) {
		Usuario usuario = usuarioRepository.getReferenceById(id);
		var datosUsuario = new DatosListadoUsuarios(usuario);
		return ResponseEntity.ok(datosUsuario);
	}
}
