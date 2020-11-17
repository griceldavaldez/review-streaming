package com.review.service;

import java.util.List;

import com.review.bean.Promocion;

public interface PromocionService {
	/**
	 * Método para crear una promoción. Facilitar los atributos de la promoción a crear, excepto el idPromocion (que se crea automáticamente).
	 * 
	 * @param Promocion La promocion, indicando los atributos con los cuales crear.
	 * @return Cantidad de promociones creadas.
	 */
	public Integer crearPromocion(Promocion Promocion);
	
	/**
	 * Método para editar una promoción. Facilitar el atributo idPromocion para ubicar la promoción a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param Promocion La promocion, indicando los atributos a modificar.
	 * @return Cantidad de promociones modificadas.
	 */
	public Integer editarPromocion(Promocion Promocion);
	
	/**
	 * Método para obtener una lista de promociones por ciertos filtros. Si no se indican filtros, se obtienen todas las promociones.
	 * 
	 * @param idPromocion Filtro para indicar que se desean obtener las promociones con este id. Puede ser null.
	 * @param tipoPromocion Filtro para indicar que se desean obtener las promociones de este tipo. Puede ser null.
	 * @return Lista de promociones que cumplan con los filtros indicados.
	 */
	public List<Promocion> obtenerPromociones(Integer idPromocion, String tipoPromocion);
	
	/**
	 * Método para eliminar una promoción. Facilitar el atributo idPromocion para ubicar la promoción a eliminar.
	 * 
	 * @param idPromocion Número identificador de la promoción.
	 * @return Cantidad de promociones eliminadas.
	 */
	public Integer eliminarPromocion(Integer idPromocion);
}
