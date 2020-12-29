package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.review.bean.Promocion;
import com.review.bean.TipoPromocion;
import com.review.exceptions.ReviewException;
import com.review.service.PromocionService;

public class PromocionController {
	@Autowired
	private PromocionService promocionService;
	
	/**
	 * MÃ©todo que lista todas las promociones.
	 * 
	 * @return Lista de promociones.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Promocion> list(
    		@RequestParam(name = "id_promocion",  required = false) Long idPromocion,
    		@RequestParam(name = "tipo_promocion",  required = false) TipoPromocion tipoPromocion,
    		@RequestParam(name = "descripcion_promocion",  required = false) String descripcionPromocion) throws ReviewException{
        try {
			return promocionService.obtenerPromociones(idPromocion,tipoPromocion);
        } catch (ReviewException e1) {
			throw e1;
        } catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrio un error inesperado al listar promociones.");
		}
    }
	
	/**
	 * MÃ©todo que agrega una nueva promocion.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Promocion add(@RequestBody Promocion promocion) throws ReviewException {
			try {
				return promocionService.crearPromocion(promocion);
	        } catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				System.out.println(e);
				throw new ReviewException("OcurriÃ³ un error inesperado al agregar promocion.");
			}
	}
	
	/**
	 * MÃ©todo que elimina una categorÃ­a.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Promocion promocion) throws ReviewException {
			try {
				promocionService.eliminarPromocion(promocion.getIdPromocion());
	        } catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				System.out.println(e);
				throw new ReviewException("OcurriÃ³ un error inesperado al eliminar categoria.");
			}
	}
	
	/**
	 * MÃ©todo que edita una promocion.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Promocion modify(@RequestBody Promocion promocion) throws ReviewException {
			try {
				return promocionService.editarPromocion(promocion);
	        } catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				System.out.println(e);
				throw new ReviewException("Ocurrio un error inesperado al modificar la promocion.");
			}
	}
}
