package com.review.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Temporada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTemporada;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Episodio> episodios;
	private int numeroTemporada;
	private String descripcionTemporada;
	
	public Long getIdTemporada() {
		return idTemporada;
	}
	public void setIdTemporada(Long idTemporada) {
		this.idTemporada = idTemporada;
	}
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
		return "Temporada [idTemporada=" + idTemporada + ", episodios=" + episodios + ", numeroTemporada="
				+ numeroTemporada + ", descripcionTemporada=" + descripcionTemporada + "]";
	}
		
}
