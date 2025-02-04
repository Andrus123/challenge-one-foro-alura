package com.alura.foro.domain.topico;

import java.util.Date;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "topicos")
@Entity(name = "Topico")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	@Column(name="fecha_creacion")
	private Date fechaCreacion = new Date();
	@Column(name="statustopico")
	@Enumerated(EnumType.STRING)
	StatusTopico statustopico;
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name="curso")
	private Curso curso;

	public Topico(DatosRegistroTopico datosRegistroTopico) {
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
		this.statustopico = datosRegistroTopico.statustopico();
		this.usuario = new Usuario(datosRegistroTopico.usuario());
		this.curso = new Curso(datosRegistroTopico.curso());
	}
	
	public Topico() {
	}
	
	public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {
		if(datosActualizarTopico.titulo() != null) {
			this.titulo = datosActualizarTopico.titulo();
		}
		if(datosActualizarTopico.mensaje() != null) {
			this.mensaje = datosActualizarTopico.mensaje();
		}
		if(datosActualizarTopico.statustopico() != null) {
			this.statustopico = datosActualizarTopico.statustopico();
		}
		if(datosActualizarTopico.usuario() != null) {
			this.usuario = datosActualizarTopico.usuario();
		}
		if(datosActualizarTopico.curso() != null) {
			this.curso = datosActualizarTopico.curso();
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
		Topico other = (Topico) obj;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatusTopico() {
		return statustopico;
	}

	public void setStatus(StatusTopico statustopico) {
		this.statustopico = statustopico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
