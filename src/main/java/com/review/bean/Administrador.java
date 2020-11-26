package com.review.bean;

import java.io.Serializable;

import com.review.utils.Notificable;

public class Administrador extends Usuario implements Serializable, Notificable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador() {
		this.setTipoUsuario(TipoUsuarioEnum.ADMINISTRADOR);
	}

	@Override
	public String toString() {
		return "Administrador [idUsuario=" + idUsuario + ", nombre=" + nombre + ", contrasenha=" + "******"
				+ ", email=" + email + ", fechaRegistro=" + fechaRegistro + ", fechaVencimiento=" + fechaVencimiento
				+ ", estado=" + estado + ", tipoUsuario=" + tipoUsuario + "]";
	}
	
}
