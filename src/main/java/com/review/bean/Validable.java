package com.review.bean;

import java.util.List;

/*
 * La interfaz se utiliza para validar que los campos estén completos, para
 * que por ejemplo no se agreguen videos sin nombre o id, etc.
 * Se utiliza en Video y sus hijos (Pelicula y Serie)
 */

public interface Validable {
	Integer getIdVideo();
	String getTitulo();
	String getDescripcion();
	List<Puntaje> getPuntajes();
	Categoria getCategoria();	
}
