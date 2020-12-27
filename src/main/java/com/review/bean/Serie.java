package com.review.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idVideo")
public class Serie extends Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Temporada> temporadas;

	public Serie() {
		this.tipoVideo = TipoVideoEnum.SERIE;
	}
	
	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public String toString() {
		return "Serie [temporadas=" + temporadas + ", idVideo=" + idVideo + ", titulo=" + titulo + ", descripcion="
				+ descripcion + ", puntajes=" + puntajes + ", categoria=" + categoria + ", tipoVideo=" + tipoVideo + "]";
	}
	

	
	
}
