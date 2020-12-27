package com.review.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.review.utils.interfaces.Ordenable;
import com.review.utils.interfaces.Validable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Video implements Serializable, Ordenable, Validable {

	private static final long serialVersionUID = 1L;
	
	public enum TipoVideoEnum{
		SERIE, PELICULA
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long idVideo;
	
	protected String titulo;
	protected String descripcion;
	@OneToMany(cascade = CascadeType.PERSIST)
	protected List<Puntaje> puntajes;
	@ManyToOne
	protected Categoria categoria;
	@Enumerated(EnumType.STRING)
	protected TipoVideoEnum tipoVideo;
	
	public Long getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(Long idVideo) {
		this.idVideo = idVideo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<Puntaje> getPuntajes() {
		return puntajes;
	}
	public void setPuntajes(List<Puntaje> puntajes) {
		this.puntajes = puntajes;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public TipoVideoEnum getTipoVideo() {
		return tipoVideo;
	}
	public void setTipoVideo(TipoVideoEnum tipoVideo) {
		this.tipoVideo = tipoVideo;
	}
	@Override
	public String getNombre() {
		return this.titulo;
	}
	

}
