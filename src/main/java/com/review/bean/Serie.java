package com.review.bean;

import java.io.Serializable;
import java.util.List;

public class Serie extends Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Temporada> temporadas;

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	@Override
	public String toString() {
		return "Serie [temporadas=" + temporadas + "]";
	}
	
	
}
