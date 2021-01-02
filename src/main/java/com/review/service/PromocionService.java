package com.review.service;

import java.util.List;

import com.review.bean.Promocion;
import com.review.exceptions.ReviewException;

public interface PromocionService {
	/**
	 * Método para crear una promoción. Facilitar los atributos de la promoción a crear, excepto el idPromocion (que se crea automaticamente).
	 * 
	 * @param Promocion La promocion, indicando los atributos con los cuales crear.
	 * @return Un numero distinto de cero si la creacion de Promocion se hizo correctamente
	 */
	public Promocion crearPromocion(Promocion Promocion) throws ReviewException;
	
	/**
	 * Metodo para editar una promocion. Facilitar el atributo idPromocion para ubicar la promocion a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param Promocion La promocion, indicando los atributos a modificar.
	 * @return Un numero distinto de cero si la modificacion de Promocion se hizo correctamente
	 */
	public Promocion editarPromocion(Promocion Promocion) throws ReviewException;
	
	/**
	 * Metodo para obtener una lista de promociones por ciertos filtros. Si no se indican filtros, se obtienen todas las promociones.
	 * 
	 * @param idPromocion Filtro para indicar que se desean obtener las promociones con este id. Puede ser null.
	 * @param tipoPromocion Filtro para indicar que se desean obtener las promociones de este tipo. Puede ser null.
	 * @return Lista de promociones que cumplan con los filtros indicados.
	 */
	public List<Promocion> obtenerPromociones(Long idPromocion, String tipoPromocion, String descripcionPromocion) throws ReviewException;
	
	/**
	 * Metodo para eliminar una promocion. Facilitar el atributo idPromocion para ubicar la promocion a eliminar.
	 * 
	 * @param idPromocion Numero identificador de la promocion.
	 * @return nada
	 */
	public void eliminarPromocion(Long idPromocion) throws ReviewException;
}
