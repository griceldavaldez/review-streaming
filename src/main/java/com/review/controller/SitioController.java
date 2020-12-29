package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.bean.SitioReview;
import com.review.constants.ApiPaths;
import com.review.exceptions.ReviewException;
import com.review.service.SitioService;

@RestController
@RequestMapping(ApiPaths.SITIO)
public class SitioController {
	@Autowired
	private SitioService sitioService;
	
	/**
	 * Método que lista los sitios de review con los filtros indicados.
	 * 
	 * @return Lista de sitios de review.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SitioReview> list(
    		@RequestParam(name = "id_sitio_review",  required = false) Long idSitioReview,
    		@RequestParam(name = "nombre",  required = false) String nombre) {
        return sitioService.obtenerSitios(idSitioReview,nombre);
    }
	
	/**
	 * Método que agrega un nuevo sitio de review.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public SitioReview add(@RequestBody SitioReview sitioReview) throws ReviewException {
		try {
			return sitioService.crearSitio(sitioReview);
		} catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al agregar sitio Review.");
		}
	}
	
	/**
	 * Método que elimina un sitio de review.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestParam(name = "id_sitio_review",  required = true) Long idSitioReview) throws ReviewException {
		try {
			sitioService.eliminarSitio(idSitioReview);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al eliminar sitio Review.");
		}
	}
	
	/**
	 * Método que edita un sitio de review.
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
    public SitioReview modify(@RequestBody SitioReview sitioReview) throws ReviewException {
		try {
			return sitioService.editarSitio(sitioReview);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al modificar sitio Review.");
		}
	}
}
