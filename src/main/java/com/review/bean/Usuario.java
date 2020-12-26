package com.review.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.review.utils.interfaces.Notificable;
import com.review.utils.interfaces.Ordenable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable, Notificable, Ordenable{

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
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long idUsuario;
	
	protected String nombre;
	protected String contrasenha;
	protected String email;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	protected Date fechaRegistro;
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	protected Date fechaVencimiento;
	@Enumerated(EnumType.STRING)
	protected EstadoEnum estado;
	@Enumerated(EnumType.STRING)
	protected TipoUsuarioEnum tipoUsuario;
	
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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
