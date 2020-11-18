package com.review.bean;

import java.io.Serializable;

public class Pelicula extends Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int anhoEstreno;
	private String director;
	private int duracionMinutos;
	private String saga;
	
	public int getAnhoEstreno() {
		return anhoEstreno;
	}
	public void setAnhoEstreno(int anhoEstreno) {
		this.anhoEstreno = anhoEstreno;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getDuracionMinutos() {
		return duracionMinutos;
	}
	public void setDuracionMinutos(int duracionMinutos) {
		this.duracionMinutos = duracionMinutos;
	}
	public String getSaga() {
		return saga;
	}
	public void setSaga(String saga) {
		this.saga = saga;
	}
	
	@Override
	public String toString() {
		return "Pelicula [anhoEstreno=" + anhoEstreno + ", director=" + director + ", duracionMinutos="
				+ duracionMinutos + ", saga=" + saga + ", idVideo=" + idVideo + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", puntajes=" + puntajes + ", categoria=" + categoria + "]";
	}
	
	

}
