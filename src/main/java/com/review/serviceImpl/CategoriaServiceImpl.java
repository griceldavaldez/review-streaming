package com.review.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Categoria;
import com.review.exceptions.ReviewException;
import com.review.repository.CategoriaRepository;
import com.review.service.CategoriaService;
import com.review.utils.ListarUtils;


/**
 *Clase que implementa los metodos de la interfaz de CategoriaService
 *
 */

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	/*Metodo que crea una nueva categoria*/
	
	@Override
	public Categoria crearCategoria(Categoria categoria) throws ReviewException{
		//controlamos que no reciba una instancia vacia para poder guardar en la BD
		Boolean hayDescripcionCategoria = categoria.getDescripcionCategoria() != null && !categoria.getDescripcionCategoria().isEmpty();
		if(hayDescripcionCategoria) {
			return categoriaRepository.save(categoria);
		}else {
			throw new ReviewException("No se puede crear una categoria sin indicar su descripcion");
		}
	}
	
	/*Metodo que edita una categoria existente en la base de datos*/
	
	@Override
	public Categoria editarCategoria(Categoria categoria) throws ReviewException {
		if(categoria.getIdCategoria() != null && categoriaRepository.existsById(categoria.getIdCategoria())) {
			java.util.Optional <Categoria> recuperarCategoria = categoriaRepository.findById(categoria.getIdCategoria());
			Categoria categoriaExistente = recuperarCategoria.get();
			if (categoria.getDescripcionCategoria()  != null) {
				categoriaExistente.setDescripcionCategoria(categoria.getDescripcionCategoria());
			}
			return categoriaRepository.save(categoriaExistente);
		}else {
			throw new ReviewException("No se puede editar la categoria porque no existe en la base de datos.");
		}
	}
	
	/*Metodo que lista las categorias*/
	
	@Override
	public List<Categoria> obtenerCategorias(Long idCategoria, String descripcionCategoria) throws ReviewException {
		Boolean hayIdCategoria = idCategoria != null && idCategoria.compareTo((long) 0) != 0;
		Boolean hayDescripcionCategoria = descripcionCategoria != null && !descripcionCategoria.isEmpty();
		
		Categoria filtroCategoria = new Categoria();
		if(hayIdCategoria) {
			filtroCategoria.setIdCategoria(idCategoria);
		}
		if(hayDescripcionCategoria) {
			filtroCategoria.setDescripcionCategoria(descripcionCategoria);
		}
		return ListarUtils.listar(filtroCategoria, categoriaRepository);
	}
	
	/*Metodo que elimina una categoria*/
	
	@Override
	public void eliminarCategoria(Long idCategoria) throws ReviewException{
		if(idCategoria != null && categoriaRepository.existsById(idCategoria)) {
			categoriaRepository.deleteById(idCategoria);
		}else {
			throw new ReviewException("No se puede eliminar categoria porque no existe en la base de datos.");
		}
	}

}
