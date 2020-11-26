package com.review.bean;

import java.io.Serializable;

import com.review.utils.Notificable;

public class Espectador extends Usuario implements Serializable, Notificable {

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
		return "Espectador [isPremium=" + isPremium + ", idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", contrasenha=" + "******" + ", email=" + email + ", fechaRegistro=" + fechaRegistro
				+ ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}


}