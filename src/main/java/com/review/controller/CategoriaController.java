package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.bean.Categoria;
import com.review.constants.ApiPaths;
import com.review.exceptions.ReviewException;
import com.review.service.CategoriaService;

@RestController
@RequestMapping(ApiPaths.CATEGORIA)
public class CategoriaController {
	@Autowired
	private CategoriaService categoriaService;
	
	/**
	 * Método que lista todas las categorías.
	 * 
	 * @return Lista de categorias.
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Categoria> list(
    		@RequestParam(name = "id_categoria",  required = false) Long idCategoria,
    		@RequestParam(name = "descripcion_categoria",  required = false) String descripcionCategoria) throws ReviewException{
        try {
			return categoriaService.obtenerCategorias(idCategoria,descripcionCategoria);
        } catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			throw new ReviewException("Ocurrió un error inesperado al listar Categorias.");
		}
    }
	
	/**
	 * Método que agrega una nueva categoría.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Categoria add(@RequestBody Categoria categoria) throws ReviewException {
			try {
				return categoriaService.crearCategoria(categoria);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al agregar categoria.");
			}
	}
	
	/**
	 * Método que elimina una categoría.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestBody Categoria categoria) throws ReviewException {
			try {
				categoriaService.eliminarCategoria(categoria);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al eliminar categoria.");
			}
	}
	
	/**
	 * Método que edita una categoría.
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Categoria modify(@RequestBody Categoria categoria) throws ReviewException {
			try {
				return categoriaService.editarCategoria(categoria);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al modificar categoria.");
			}
	}
}
