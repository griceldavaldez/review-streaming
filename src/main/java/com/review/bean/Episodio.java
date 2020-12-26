package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Episodio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idEpisodio;
	private int numeroEpisodio;
	private String descripcionEpisodio;
	
	public Long getIdEpisodio() {
		return idEpisodio;
	}
	public void setIdEpisodio(Long idEpisodio) {
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
