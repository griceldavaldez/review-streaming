package com.review.bean;

import java.io.Serializable;
import java.util.List;
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
	
	
	@OneToMany
	private List<Categoria> categoriasAModerar;
	
	public CuradorDeContenido() {
		this.setTipoUsuario(TipoUsuarioEnum.CURADOR);
	}

	public List<Categoria> getCategoriasAModerar() {
		return categoriasAModerar;
	}

	public void setCategoriasAModerar(List<Categoria> categoriasAModerar) {
		this.categoriasAModerar = categoriasAModerar;
	}

	@Override
	public String toString() {
		return "CuradorDeContenido [catergoriasAModerar=" + categoriasAModerar + ", idUsuario=" + idUsuario
				+ ", nombre=" + nombre + ", contrasenha=" + "******" + ", email=" + email
				+ ", fechaRegistro=" + fechaRegistro + ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado
				+ ", tipoUsuario=" + tipoUsuario + "]";
	}

}
