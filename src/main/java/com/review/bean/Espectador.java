package com.review.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(referencedColumnName="idUsuario")
public class Espectador extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Boolean isPremium;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Promocion> promociones;
	
	public Espectador() {
		this.setTipoUsuario(TipoUsuarioEnum.ESPECTADOR);
		this.isPremium = false;
		this.promociones = null;
	}

	public Boolean getIsPremium() {
		return isPremium;
	}

	public void setIsPremium(Boolean isPremium) {
		this.isPremium = isPremium;
	}

	public List<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(List<Promocion> promociones) {
		this.promociones = promociones;
	}

	@Override
	public String toString() {
		return "Espectador [isPremium=" + isPremium + ", idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", contrasenha=" + "******" + ", email=" + email + ", fechaRegistro=" + fechaRegistro
				+ ", fechaVencimiento=" + fechaVencimiento + ", estado=" + estado + ", tipoUsuario=" + tipoUsuario
				+ "]";
	}


}
