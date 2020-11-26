package com.review.bean;

import java.util.Date;

/*
 * Es la interfaz que se utiliza para poder aplicar las utilidades de notificaciones
 * Se implementa en usuarios y sus hijos
 */

public interface Notificable {
	String getEmail();
	String getNombre();
	Date getFechaVencimiento();
}
