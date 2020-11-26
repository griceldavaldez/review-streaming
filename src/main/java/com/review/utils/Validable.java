package com.review.utils;

import java.util.List;

import com.review.bean.Categoria;
import com.review.bean.Puntaje;

/*
 * La interfaz se utiliza para validar que los campos est�n completos, para
 * que por ejemplo no se agreguen videos sin nombre o id, etc.
 * Se utiliza en Video y sus hijos (Pelicula y Serie)
 */

public interface Validable {
	public Integer getIdVideo();
	public String getTitulo();
	public String getDescripcion();
	public List<Puntaje> getPuntajes();
	public Categoria getCategoria();	
}
