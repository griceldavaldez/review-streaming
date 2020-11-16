package com.review.bean;

import java.io.Serializable;

public class Categoria implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idCategoria;
	private String descripcionCategoria;
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}
	
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", descripcionCategoria=" + descripcionCategoria + "]";
	}

}
