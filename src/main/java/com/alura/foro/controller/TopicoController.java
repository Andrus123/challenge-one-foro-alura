package com.alura.foro.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.alura.foro.domain.topico.DatosActualizarTopico;
import com.alura.foro.domain.topico.DatosListadoTopico;
import com.alura.foro.domain.topico.DatosRegistroTopico;
import com.alura.foro.domain.topico.DatosRespuestaTopico;
import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.topico.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoRepository topicoRepository;

	@PostMapping
	public ResponseEntity<DatosRespuestaTopico> registrarTopico(
			@RequestBody @Valid DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
		Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
		DatosRespuestaTopico returnTopico = new DatosRespuestaTopico(topico);
		URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(url).body(returnTopico);
	}
	
	@GetMapping
	public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(Pageable paginacion) {
		return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DatosListadoTopico> buscarTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		var datosTopico = new DatosListadoTopico(topico);
		return ResponseEntity.ok(datosTopico);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DatosRespuestaTopico> actualizarTopicos(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
		Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
		topico.actualizarDatos(datosActualizarTopico);
		return ResponseEntity.ok(new DatosRespuestaTopico(topico));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> eliminarTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topicoRepository.delete(topico);
		return ResponseEntity.noContent().build();
	}
}
