package com.review.service;

import java.util.List;

import com.review.bean.Categoria;
import com.review.exceptions.ReviewException;

public interface CategoriaService {
	
	/** Creación de nueva categoría.
	 * @param categoria Datos de la categoría a crear.
	 * @return La categoría creada.
	 * @throws ReviewException
	 */
	public Categoria crearCategoria(Categoria categoria) throws ReviewException;
	
	
	/** Edición de la categoría.
	 * @param categoria Datos nuevos de la categoría.
	 * @return La categoría editada.
	 * @throws ReviewException
	 */
	public Categoria editarCategoria(Categoria categoria) throws ReviewException;
	

	/** Obtención de lista de categorías disponibles. 
	 * @param idCategoria Filtro de id que indica el id de la categoría a obtener.
	 * @param descripcionCategoria Filtro que indica la descripción de la categoría a obtener.
	 * @return Lista de categorias con dicho filtro
	 * @throws ReviewException
	 */
	public List<Categoria> obtenerCategorias(Long idCategoria, String descripcionCategoria) throws ReviewException;
	
	/** Eliminación de categoría.
	 * @param categoria Datos de la categoría a eliminar.
	 * @throws ReviewException
	 */
	public void eliminarCategoria(Categoria categoria) throws ReviewException;

}
