package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.bean.Promocion;
import com.review.constants.ApiPaths;
import com.review.exceptions.ReviewException;
import com.review.service.PromocionService;

@RestController
@RequestMapping(ApiPaths.PROMOCION)
public class PromocionController {
	@Autowired
	private PromocionService promocionService;
	
	/**
	 * Metodo que lista todas las promociones segun filtros indicados.
	 * @return Lista de promociones.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Promocion> list(
    		@RequestParam(name = "id_promocion",  required = false) Long idPromocion,
    		@RequestParam(name = "tipo_promocion",  required = false) String tipoPromocion,
    		@RequestParam(name = "descripcion_promocion",  required = false) String descripcionPromocion) throws ReviewException{
        try {
			return promocionService.obtenerPromociones(idPromocion,tipoPromocion, descripcionPromocion);
        } catch (ReviewException reviewException) {
			throw reviewException;
        } catch (Exception error) {
			System.out.println(error);
			throw new ReviewException("Ocurrio un error inesperado al listar promociones.");
		}
    }
	
	/**
	 * Metodo que agrega una nueva promocion.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Promocion add(@RequestBody Promocion promocion) throws ReviewException {
			try {
				return promocionService.crearPromocion(promocion);
	        } catch (ReviewException reviewException) {
				throw reviewException;
			} catch (Exception error) {
				System.out.println(error);
				throw new ReviewException("Ocurrio un error inesperado al agregar promocion.");
			}
	}
	
	/**
	 * Metodo que elimina una promocion
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id_promocion",  required = true) Long idPromocion) throws ReviewException {
			try {
				promocionService.eliminarPromocion(idPromocion);
	        } catch (ReviewException reviewException) {
				throw reviewException;
			} catch (Exception error) {
				System.out.println(error);
				throw new ReviewException("Ocurrio un error inesperado al eliminar promocion.");
			}
	}
	
	/**
	 * Metodo que edita una promocion.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Promocion modify(@RequestBody Promocion promocion) throws ReviewException {
			try {
				return promocionService.editarPromocion(promocion);
	        } catch (ReviewException reviewException) {
				throw reviewException;
			} catch (Exception error) {
				System.out.println(error);
				throw new ReviewException("Ocurrio un error inesperado al modificar la promocion.");
			}
	}
}
