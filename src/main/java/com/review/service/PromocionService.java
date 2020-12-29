package com.review.service;

import java.util.List;

import com.review.bean.Promocion;
import com.review.bean.TipoPromocion;
import com.review.exceptions.ReviewException;

public interface PromocionService {
	/**
	 * Mï¿½todo para crear una promociï¿½n. Facilitar los atributos de la promociï¿½n a crear, excepto el idPromocion (que se crea automï¿½ticamente).
	 * 
	 * @param Promocion La promocion, indicando los atributos con los cuales crear.
	 * @return Un numero distinto de cero si la creacion de Promocion se hizo correctamente
	 */
	public Promocion crearPromocion(Promocion Promocion) throws ReviewException;
	
	/**
	 * Mï¿½todo para editar una promociï¿½n. Facilitar el atributo idPromocion para ubicar la promociï¿½n a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param Promocion La promocion, indicando los atributos a modificar.
	 * @return Un numero distinto de cero si la modificacion de Promocion se hizo correctamente
	 */
	public Promocion editarPromocion(Promocion Promocion) throws ReviewException;
	
	/**
	 * Mï¿½todo para obtener una lista de promociones por ciertos filtros. Si no se indican filtros, se obtienen todas las promociones.
	 * 
	 * @param idPromocion Filtro para indicar que se desean obtener las promociones con este id. Puede ser null.
	 * @param tipoPromocion Filtro para indicar que se desean obtener las promociones de este tipo. Puede ser null.
	 * @return Lista de promociones que cumplan con los filtros indicados.
	 */
	public List<Promocion> obtenerPromociones(Long idPromocion, TipoPromocion tipoPromocion) throws ReviewException;
	
	/**
	 * Mï¿½todo para eliminar una promociï¿½n. Facilitar el atributo idPromocion para ubicar la promociï¿½n a eliminar.
	 * 
	 * @param idPromocion Numero identificador de la promocion.
	 * @return nada
	 */
	public void eliminarPromocion(Long idPromocion) throws ReviewException;
}
