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
    		@RequestParam(name = "descripcion_categoria",  required = false) String descripcionCategoria) {
        return categoriaService.obtenerCategorias(idCategoria,descripcionCategoria);
    }
	
	/**
	 * Método que agrega una nueva categoría.
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Categoria add(@RequestBody Categoria categoria) {
			return categoriaService.crearCategoria(categoria);
	}
	
	/**
	 * Método que elimina una categoría.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Categoria categoria) {
			categoriaService.eliminarCategoria(categoria);
	}
	
	/**
	 * Método que edita una categoría.
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Categoria modify(@RequestBody Categoria categoria) {
			return categoriaService.editarCategoria(categoria);
	}
}
