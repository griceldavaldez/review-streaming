package com.review.bean;

import java.io.Serializable;
import java.util.List;

import com.review.utils.Ordenable;
import com.review.utils.Validable;

public abstract class Video implements Serializable, Ordenable, Validable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Integer idVideo;
	protected String titulo;
	protected String descripcion;
	protected List<Puntaje> puntajes;
	protected Categoria categoria;
	
	public Integer getIdVideo() {
		return idVideo;
	}
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
}
