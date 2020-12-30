package com.review.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Promocion implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPromocion;
	
	
	/**
	 * por ejemplo CUPON, DESCUENTO, ACCESO_PRE_ESTRENO
	 */
	
	private String tipoPromocion;
	
	private String descripcionPromocion;
	

	
	public Long getIdPromocion() {
		return idPromocion;
	}



	public void setIdPromocion(Long idPromocion) {
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
