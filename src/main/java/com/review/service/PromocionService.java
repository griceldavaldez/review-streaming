package com.review.service;

import java.util.List;

import com.review.bean.Promocion;

public interface PromocionService {
	/**
	 * M�todo para crear una promoci�n. Facilitar los atributos de la promoci�n a crear, excepto el idPromocion (que se crea autom�ticamente).
	 * 
	 * @param Promocion La promocion, indicando los atributos con los cuales crear.
	 * @return Cantidad de promociones creadas.
	 */
	public Integer crearPromocion(Promocion Promocion);
	
	/**
	 * M�todo para editar una promoci�n. Facilitar el atributo idPromocion para ubicar la promoci�n a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param Promocion La promocion, indicando los atributos a modificar.
	 * @return Cantidad de promociones modificadas.
	 */
	public Integer editarPromocion(Promocion Promocion);
	
	/**
	 * M�todo para obtener una lista de promociones por ciertos filtros. Si no se indican filtros, se obtienen todas las promociones.
	 * 
	 * @param idPromocion Filtro para indicar que se desean obtener las promociones con este id. Puede ser null.
	 * @param tipoPromocion Filtro para indicar que se desean obtener las promociones de este tipo. Puede ser null.
	 * @return Lista de promociones que cumplan con los filtros indicados.
	 */
	public List<Promocion> obtenerPromociones(Integer idPromocion, String tipoPromocion);
	
	/**
	 * M�todo para eliminar una promoci�n. Facilitar el atributo idPromocion para ubicar la promoci�n a eliminar.
	 * 
	 * @param idPromocion N�mero identificador de la promoci�n.
	 * @return Cantidad de promociones eliminadas.
	 */
	public Integer eliminarPromocion(Integer idPromocion);
}
