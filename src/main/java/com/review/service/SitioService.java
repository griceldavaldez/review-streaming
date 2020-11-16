package com.review.service;

import com.review.bean.SitioReview;

public interface SitioService {
	/**
	 * Método para crear un sitio de review. Facilitar los atributos del sitio a crear, excepto el idSitioReview (que se crea automáticamente).
	 * 
	 * @param sitioReview
	 * @return Cantidad de sitios creados.
	 */
	public Integer crearSitio(SitioReview sitioReview);
	
	/**
	 * Método para editar un sitio de review. Facilitar el atributo idSitioReview para ubicar el sitio a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param sitioReview
	 * @return Cantidad de sitios modificados.
	 */
	public Integer editarSitio(SitioReview sitioReview);
	
	
}
