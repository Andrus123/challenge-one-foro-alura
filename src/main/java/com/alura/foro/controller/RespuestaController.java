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

import com.alura.foro.domain.respuestas.DatosActualizarRespuesta;
import com.alura.foro.domain.respuestas.DatosListadoRespuesta;
import com.alura.foro.domain.respuestas.DatosRegistroRespuesta;
import com.alura.foro.domain.respuestas.DatosReturnRespuesta;
import com.alura.foro.domain.respuestas.Respuesta;
import com.alura.foro.domain.respuestas.RespuestaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {
	@Autowired
	private RespuestaRepository respuestaRepository;
	
	@PostMapping
	public ResponseEntity<DatosReturnRespuesta> registrarRespuesta(@RequestBody @Valid DatosRegistroRespuesta datosRegistroRespuesta,
			UriComponentsBuilder uriComponentsBuilder) {
		Respuesta respuesta = respuestaRepository.save(new Respuesta(datosRegistroRespuesta));
		DatosReturnRespuesta datosReturnRespuesta = new DatosReturnRespuesta(respuesta);
		URI url = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();
		return ResponseEntity.created(url).body(datosReturnRespuesta);
	}
	
	@GetMapping
	public ResponseEntity<Page<DatosListadoRespuesta>> listarRespuestas(Pageable paginacion) {
		return ResponseEntity.ok(respuestaRepository.findAll(paginacion).map(DatosListadoRespuesta::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DatosListadoRespuesta> obtenerRespuesta(@PathVariable Long id) {
		Respuesta respuesta = respuestaRepository.getReferenceById(id);
		var datosRespuesta = new DatosListadoRespuesta(respuesta);
		return ResponseEntity.ok(datosRespuesta);
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<DatosListadoRespuesta> actualizarRespuesta(@RequestBody @Valid DatosActualizarRespuesta datosActualizarRespuesta) {
		Respuesta respuesta = respuestaRepository.getReferenceById(datosActualizarRespuesta.id());
		respuesta.actualizarDatos(datosActualizarRespuesta);
		return ResponseEntity.ok(new DatosListadoRespuesta(respuesta));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id) {
		Respuesta respuesta = respuestaRepository.getReferenceById(id);
		respuestaRepository.delete(respuesta);
		return ResponseEntity.noContent().build();
	}
}
