package com.review.service;

import java.util.List;

import com.review.bean.Categoria;

public interface CategoriaService {
	
	/** Creación de nueva categoría.
	 * @param categoria Datos de la categoría a crear.
	 * @return La categoría creada.
	 */
	public Categoria crearCategoria(Categoria categoria);
	
	
	/** Edición de la categoría.
	 * @param categoria Datos nuevos de la categoría.
	 * @return La categoría editada.
	 */
	public Categoria editarCategoria(Categoria categoria);
	

	/** Obtención de lista de categorías disponibles. 
	 * @param idCategoria Filtro de id que indica el id de la categoría a obtener.
	 * @param descripcionCategoria Filtro que indica la descripción de la categoría a obtener.
	 * @return
	 */
	public List<Categoria> obtenerCategorias(Long idCategoria, String descripcionCategoria);
	
	/** Eliminación de categoría.
	 * @param categoria Datos de la categoría a eliminar.
	 */
	public void eliminarCategoria(Categoria categoria);

}
