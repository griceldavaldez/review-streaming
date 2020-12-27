package com.review.service;

import java.util.List;

import com.review.bean.SitioReview;

public interface SitioService {
	/**
	 * M�todo para crear un sitio de review. Facilitar los atributos del sitio a crear, excepto el idSitioReview (que se crea autom�ticamente).
	 * 
	 * @param sitioReview
	 * @return El sitio creado.
	 */
	public SitioReview crearSitio(SitioReview sitioReview);
	
	/**
	 * M�todo para editar un sitio de review. Facilitar el atributo idSitioReview para ubicar el sitio a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param sitioReview
	 * @return El sitio actualizado.
	 */
	public SitioReview editarSitio(SitioReview sitioReview);
	
	/**
	 * M�todo para obtener una lista de sitios de review por ciertos filtros. Si no se indican filtros, se obtienen todos los sitios.
	 * 
	 * @param idSitioReview Filtro para indicar que se desean obtener los sitios con este id. Puede ser null.
	 * @param nombre Filtro para indicar que se desean obtener los sitios con nombre (o que por lo menos contengan este string dentro del nombre). Puede ser null.
	 * @return Lista de sitios que se obtuvieron con los filtros indicados.
	 */
	public List<SitioReview> obtenerSitios(Long idSitioReview, String nombre);
	
	/**
	 * M�todo para eliminar un sitio de review. Facilitar el atributo idSitioReview para ubicar el sitio a eliminar.
	 * 
	 * @param sitio Datos del sitio a eliminar.
	 */
	public void eliminarSitio(SitioReview sitio);
}
