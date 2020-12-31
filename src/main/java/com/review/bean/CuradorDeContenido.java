package com.review.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class CuradorDeContenido extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade = CascadeType.ALL)
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
