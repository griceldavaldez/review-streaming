package com.review.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Categoria;
import com.review.exceptions.ReviewException;
import com.review.repository.CategoriaRepository;
import com.review.service.CategoriaService;
import com.review.utils.ListarUtils;


@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		//controlamos que no reciba una instancia vacia para poder guardar en la BD
		Boolean hayDescripcionCategoria = categoria.getDescripcionCategoria() != null && !categoria.getDescripcionCategoria().isEmpty();
		if(hayDescripcionCategoria) {
			return categoriaRepository.save(categoria);
		}
		return null;
	}

	@Override
	public Categoria editarCategoria(Categoria categoria) {
		/* Primero comprobamos si existe la categoria a editar y 
		luego controlamos si la instanacia si la instancia tiene un campo a modificar*/
		if(categoriaRepository.existsById(categoria.getIdCategoria())) {
			Boolean hayDescripcionCategoria = categoria.getDescripcionCategoria()  != null && !categoria.getDescripcionCategoria() .isEmpty();
			if (hayDescripcionCategoria) {
				return categoriaRepository.save(categoria);
			}
		}
		return null;
	}

	@Override
	public List<Categoria> obtenerCategorias(Long idCategoria, String descripcionCategoria) throws ReviewException {
		Boolean hayIdCategoria = idCategoria != null && idCategoria.compareTo((long) 0) != 0;
		Boolean hayDescripcionCategoria = descripcionCategoria != null && !descripcionCategoria.isEmpty();
		
		Categoria c = new Categoria();
		if(hayIdCategoria) {
			c.setIdCategoria(idCategoria);
		}
		if(hayDescripcionCategoria) {
			c.setDescripcionCategoria(descripcionCategoria);
		}
		return ListarUtils.listar(c, categoriaRepository);
	}

	@Override
	public void eliminarCategoria(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}

}
