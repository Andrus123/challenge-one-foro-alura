package com.alura.foro.domain.respuestas;

import java.util.Date;

import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "respuestas")
@Entity(name = "Respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;
	@ManyToOne
	@JoinColumn(name = "topico")
	Topico topico;
	@Column(name="fecha_creacion")
	private Date fechaCreacion = new Date();
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	private Boolean solucion = false;
	
	public Respuesta() {
		
	}
	
	public Respuesta(DatosRegistroRespuesta datosRegistroRespuesta) {
		this.mensaje = datosRegistroRespuesta.mensaje();
		this.topico = datosRegistroRespuesta.topico();
		this.usuario = datosRegistroRespuesta.usuario();
	}
	
	public void actualizarDatos(DatosActualizarRespuesta datosActualizarRespuesta) {
		if(datosActualizarRespuesta.mensaje() != null) {
			this.mensaje = datosActualizarRespuesta.mensaje();
		}
		if(datosActualizarRespuesta.topico() != null) {
			this.topico = datosActualizarRespuesta.topico();
		}
		if(datosActualizarRespuesta.usuario() != null) {
			this.usuario = datosActualizarRespuesta.usuario();
		}
		if(datosActualizarRespuesta.solucion() != null) {
			this.solucion = datosActualizarRespuesta.solucion();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Respuesta other = (Respuesta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Topico getTopico() {
		return topico;
	}

	public void setTopico(Topico topico) {
		this.topico = topico;
	}

	public Date getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Boolean getSolucion() {
		return solucion;
	}

	public void setSolucion(Boolean solucion) {
		this.solucion = solucion;
	}

}
