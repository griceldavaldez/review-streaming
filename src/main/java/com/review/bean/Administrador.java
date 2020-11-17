package com.review.bean;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrador() {
		this.setTipoUsuario(TipoUsuarioEnum.ADMINISTRADOR);
	}

	@Override
	public String toString() {
		return "Administrador [idUsuario=" + idUsuario + ", login=" + login + ", nombre=" + nombre + ", contrasenha="
				+ "******" + ", email=" + email + ", fechaRegistro=" + fechaRegistro + ", fechaVencimiento="
				+ fechaVencimiento + ", estado=" + estado + ", tipoUsuario=" + tipoUsuario + "]";
	}
}
