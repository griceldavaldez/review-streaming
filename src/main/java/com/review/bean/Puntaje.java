package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Puntaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPuntaje;
	@ManyToOne
	private SitioReview sitioReview;
	private Double puntaje;
	
	public Long getIdPuntaje() {
		return idPuntaje;
	}
	public void setIdPuntaje(Long idPuntaje) {
		this.idPuntaje = idPuntaje;
	}
	public SitioReview getSitioReview() {
		return sitioReview;
	}
	public void setSitioReview(SitioReview sitioReview) {
		this.sitioReview = sitioReview;
	}
	public Double getPuntaje() {
		return puntaje;
	}
	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}
	@Override
	public String toString() {
		return "Puntaje [idPuntaje=" + idPuntaje + ", sitioReview=" + sitioReview + ", puntaje=" + puntaje + "]";
	}

	
	
}
