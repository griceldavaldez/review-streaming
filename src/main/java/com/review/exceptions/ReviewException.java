package com.review.exceptions;

import java.io.Serializable;

/*
 * Excepcion utilizada  por los servicios para indicar
 * problemas
 * 
 */

public class ReviewException extends Exception implements Serializable{

	private static final long serialVersionUID = 1L;

	private String mensaje;

	public ReviewException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "ReviewException [mensaje=" + mensaje + "]";
	}
}
