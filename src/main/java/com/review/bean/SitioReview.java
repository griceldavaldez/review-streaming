package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.review.utils.Ordenable;

@Entity
public class SitioReview implements Serializable, Ordenable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idSitioReview;
	
	private String nombre;
	
	public long getIdSitioReview() {
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
