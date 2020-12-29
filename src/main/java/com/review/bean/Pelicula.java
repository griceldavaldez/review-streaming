package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idVideo")
public class Pelicula extends Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer anhoEstreno;
	private String director;
	private Integer duracionMinutos;
	private String saga;
	
	public Pelicula() {
		this.tipoVideo = TipoVideoEnum.PELICULA;
	}
	
	public Integer getAnhoEstreno() {
		return anhoEstreno;
	}
	public void setAnhoEstreno(Integer anhoEstreno) {
		this.anhoEstreno = anhoEstreno;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public Integer getDuracionMinutos() {
		return duracionMinutos;
	}
	public void setDuracionMinutos(Integer duracionMinutos) {
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
				+ descripcion + ", puntajes=" + puntajes + ", categoria=" + categoria + ", tipoVideo=" + tipoVideo + "]";
	}
	
	

}
