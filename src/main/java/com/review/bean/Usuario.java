package com.review.bean;

import java.io.Serializable;

public abstract class Usuario implements Serializable {

	public enum TipoUsuarioEnum {
		ADMINISTRADOR,CURADOR,ESPECTADOR
	}
	public enum EstadoEnum {
		ACTIVO,INACTIVO
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Integer idUsuario;
	protected String nombre;
	protected String contrasenha;
	protected EstadoEnum estado;
	protected TipoUsuarioEnum tipoUsuario;
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrasenha() {
		return contrasenha;
	}
	public void setContrasenha(String contrasenha) {
		this.contrasenha = contrasenha;
	}
	public EstadoEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	public TipoUsuarioEnum getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuarioEnum tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
}
