package com.review.bean;

import java.io.Serializable;
import java.util.List;


public class CuradorDeContenido extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Categoria> catergoriasAModerar;
	
	public CuradorDeContenido() {
		this.setTipoUsuario(TipoUsuarioEnum.CURADOR);
	}

	public List<Categoria> getCatergoriasAModerar() {
		return catergoriasAModerar;
	}

	public void setCatergoriasAModerar(List<Categoria> catergoriasAModerar) {
		this.catergoriasAModerar = catergoriasAModerar;
	}

	@Override
	public String toString() {
		return "CuradorDeContenido [catergoriasAModerar=" + catergoriasAModerar + ", idUsuario=" + idUsuario
				+ ", nombre=" + nombre + ", contrasenha=" + "******" + ", email=" + email
				+ ", fechaRegistro=" + fechaRegistro + ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}

}
