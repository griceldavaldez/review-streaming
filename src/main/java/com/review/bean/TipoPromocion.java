package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoPromocion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idTipoPromocion;
	private String descripcionTipoPromocion;
	
	public Long getIdTipoPromocion() {
		return idTipoPromocion;
	}
	public void setIdTipoPromocion(Long idTipoPromocion) {
		this.idTipoPromocion = idTipoPromocion;
	}
	public String getDescripcionTipoPromocion() {
		return descripcionTipoPromocion;
	}
	public void setDescripcionTipoPromocion(String descripcionTipoPromocion) {
		this.descripcionTipoPromocion = descripcionTipoPromocion;
	}
	@Override
	public String toString() {
		return "TipoPromocion [idTipoPromocion=" + idTipoPromocion + ", descripcionTipoPromocion="
				+ descripcionTipoPromocion + "]";
	}
	
	

}
