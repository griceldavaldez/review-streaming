package com.review.utils;

import java.util.List;

import com.review.bean.Categoria;
import com.review.bean.Puntaje;

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
