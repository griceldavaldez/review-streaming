package com.review.bean;

import java.io.Serializable;

public class Episodio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idEpisodio;
	private int numeroEpisodio;
	private String descripcionEpisodio;
	
	public Integer getIdEpisodio() {
		return idEpisodio;
	}
	public void setIdEpisodio(Integer idEpisodio) {
		this.idEpisodio = idEpisodio;
	}
	public int getNumeroEpisodio() {
		return numeroEpisodio;
	}
	public void setNumeroEpisodio(int numeroEpisodio) {
		this.numeroEpisodio = numeroEpisodio;
	}
	public String getDescripcionEpisodio() {
		return descripcionEpisodio;
	}
	public void setDescripcionEpisodio(String descripcionEpisodio) {
		this.descripcionEpisodio = descripcionEpisodio;
	}
	
	@Override
	public String toString() {
		return "Episodio [idEpisodio=" + idEpisodio + ", numeroEpisodio=" + numeroEpisodio + ", descripcionEpisodio="
				+ descripcionEpisodio + "]";
	}
	
	
}
