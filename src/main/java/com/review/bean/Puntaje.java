package com.review.bean;

import java.io.Serializable;

public class Puntaje implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private SitioReview sitioReview;
	private Double puntaje;
	
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
		return "Puntaje [sitioReview=" + sitioReview + ", puntaje=" + puntaje + "]";
	}
	
}
