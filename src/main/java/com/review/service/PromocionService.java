package com.review.service;

import java.util.List;

import com.review.bean.Promocion;
import com.review.exceptions.ReviewException;

public interface PromocionService {
	/**
	 * Método para crear una promoción. Facilitar los atributos de la promoción a crear, excepto el idPromocion (que se crea automaticamente).
	 * 
	 * @param Promocion La promocion, indicando los atributos con los cuales crear.
	 * @return Promocion creada
	 * @throws ReviewException
	 */
	public Promocion crearPromocion(Promocion promocion) throws ReviewException;
	
	/**
	 * Metodo para editar una promocion. Facilitar el atributo idPromocion para ubicar la promocion a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param Promocion La promocion, indicando los atributos a modificar.
	 * @throws ReviewException
	 */
	public Promocion editarPromocion(Promocion promocion) throws ReviewException;
	
	/**
	 * Metodo para obtener una lista de promociones por ciertos filtros. Si no se indican filtros, se obtienen todas las promociones.
	 * 
	 * @param idPromocion Filtro para indicar que se desean obtener las promociones con este id. Puede ser null.
	 * @param tipoPromocion Filtro para indicar que se desean obtener las promociones de este tipo. Puede ser null.
	 * @param descripcionPromocion Filtro para indicar descripcion de las promociones. Puede ser null
	 * @return Lista de promociones con los filtros indicados.
	 * @throws ReviewException
	 */
	public List<Promocion> obtenerPromociones(Long idPromocion, String tipoPromocion, String descripcionPromocion) throws ReviewException;
	
	/**
	 * Metodo para eliminar una promocion. Facilitar el atributo idPromocion para ubicar la promocion a eliminar.
	 * 
	 * @param idPromocion Numero identificador de la promocion.
	 * @throws ReviewException
	 */
	public void eliminarPromocion(Long idPromocion) throws ReviewException;
}
