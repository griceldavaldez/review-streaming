package com.review.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class EspectadorPremium extends Espectador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ElementCollection
	private List<Promocion> promociones;
	
	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	@Override
	public String toString() {
		return "EspectadorPremium [promociones=" + promociones + ", isPremium=" + isPremium + ", idUsuario=" + idUsuario
				 + ", nombre=" + nombre + ", contrasenha=" + "******" + ", email=" + email
				+ ", fechaRegistro=" + fechaRegistro + ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}

}
