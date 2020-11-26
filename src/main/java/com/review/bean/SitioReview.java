package com.review.bean;

import java.io.Serializable;

import com.review.utils.Ordenable;

public class SitioReview implements Serializable, Ordenable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idSitioReview;
	private String nombre;
	
	public Integer getIdSitioReview() {
		return idSitioReview;
	}
	public void setIdSitioReview(Integer idSitioReview) {
		this.idSitioReview = idSitioReview;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "SitioReview [idSitioReview=" + idSitioReview + ", nombre=" + nombre + "]";
	}

	
	
}
