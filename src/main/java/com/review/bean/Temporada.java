package com.review.bean;

import java.io.Serializable;
import java.util.List;

public class Temporada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Episodio> episodios;
	private int numeroTemporada;
	private String descripcionTemporada;
	
	public List<Episodio> getEpisodios() {
		return episodios;
	}
	public void setEpisodios(List<Episodio> episodios) {
		this.episodios = episodios;
	}
	public int getNumeroTemporada() {
		return numeroTemporada;
	}
	public void setNumeroTemporada(int numeroTemporada) {
		this.numeroTemporada = numeroTemporada;
	}
	public String getDescripcionTemporada() {
		return descripcionTemporada;
	}
	public void setDescripcionTemporada(String descripcionTemporada) {
		this.descripcionTemporada = descripcionTemporada;
	}
	
	@Override
	public String toString() {
		return "Temporada [episodios=" + episodios + ", numeroTemporada=" + numeroTemporada + ", descripcionTemporada="
				+ descripcionTemporada + "]";
	}
	
	
	
}
