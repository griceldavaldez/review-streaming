package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.review.utils.interfaces.Ordenable;

@Entity
public class SitioReview implements Serializable, Ordenable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idSitioReview;
	
	private String nombre;
	
	private Double puntajeMaximo;

	public Long getIdSitioReview() {
		return idSitioReview;
	}

	public void setIdSitioReview(Long idSitioReview) {
		this.idSitioReview = idSitioReview;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPuntajeMaximo() {
		return puntajeMaximo;
	}

	public void setPuntajeMaximo(Double puntajeMaximo) {
		this.puntajeMaximo = puntajeMaximo;
	}

	@Override
	public String toString() {
		return "SitioReview [idSitioReview=" + idSitioReview + ", nombre=" + nombre + ", puntajeMaximo=" + puntajeMaximo
				+ "]";
	}
	
}
