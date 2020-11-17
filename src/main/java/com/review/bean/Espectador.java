package com.review.bean;

import java.io.Serializable;

public class Espectador extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Boolean isPremium;
	
	public Espectador() {
		this.setTipoUsuario(TipoUsuarioEnum.ESPECTADOR);
	}

	public Boolean getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

	@Override
	public String toString() {
		return "Espectador [isPremium=" + isPremium + ", idUsuario=" + idUsuario + ", login=" + login + ", nombre="
				+ nombre + ", contrasenha=" + "******" + ", email=" + email + ", fechaRegistro=" + fechaRegistro
				+ ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}
}
