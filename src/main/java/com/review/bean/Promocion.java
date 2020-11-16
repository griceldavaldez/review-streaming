package com.review.bean;

import java.io.Serializable;

public class Promocion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idPromocion;
	/**
	 * por ejemplo CUPON, DESCUENTO, ACCESO_PRE_ESTRENO
	 */
	private String tipoPromocion;
	private String descripcionPromocion;
	
	public Integer getIdPromocion() {
		return idPromocion;
	}
	public void setIdPromocion(Integer idPromocion) {
		this.idPromocion = idPromocion;
	}
	public String getTipoPromocion() {
		return tipoPromocion;
	}
	public void setTipoPromocion(String tipoPromocion) {
		this.tipoPromocion = tipoPromocion;
	}
	public String getDescripcionPromocion() {
		return descripcionPromocion;
	}
	public void setDescripcionPromocion(String descripcionPromocion) {
		this.descripcionPromocion = descripcionPromocion;
	}
	
	@Override
	public String toString() {
		return "Promocion [idPromocion=" + idPromocion + ", tipoPromocion=" + tipoPromocion + ", descripcionPromocion="
				+ descripcionPromocion + "]";
	}
	
	
}
