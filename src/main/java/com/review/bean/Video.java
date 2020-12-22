package com.review.bean;

import java.io.Serializable;
import java.util.List;

import com.review.utils.Ordenable;
import com.review.utils.Validable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Video implements Serializable, Ordenable, Validable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long idVideo;
	
	protected String titulo;
	protected String descripcion;
	protected List<Puntaje> puntajes;
	protected Categoria categoria;
	
	public void setIdVideo(Integer idVideo) {
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
	
	public String getNombre() {
		return titulo;
	}
	public long getIdVideo() {
		return idVideo;
	}
}
