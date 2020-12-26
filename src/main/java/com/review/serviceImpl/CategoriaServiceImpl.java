package com.review.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.review.bean.Categoria;
import com.review.repository.CategoriaRepository;
import com.review.service.CategoriaService;


@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria editarCategoria(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public List<Categoria> obtenerCategorias(Long idCategoria, String descripcionCategoria) {
		Boolean hayIdCategoria = idCategoria != null && idCategoria.compareTo((long) 0) != 0;
		Boolean hayDescripcionCategoria = descripcionCategoria != null && !descripcionCategoria.isEmpty();
		/*
		if(!hayDescripcionCategoria && !hayIdCategoria) {
			//lanzar una excepcion
			return null;
		}else {
			if(hayDescripcionCategoria && hayIdCategoria) {
				return categoriaRepository.findByIdDescripcionCategoria(idCategoria, descripcionCategoria);
			}else {
				if(hayDescripcionCategoria) {
					return categoriaRepository.findByDescripcionCategoria(descripcionCategoria);
				}else {
					return categoriaRepository.findByIdCategoria(idCategoria);
				}
			}
		}*/
		Categoria c = new Categoria();
		if(hayIdCategoria) {
			c.setIdCategoria(idCategoria);
		}
		if(hayDescripcionCategoria) {
			c.setDescripcionCategoria(descripcionCategoria);
		}
		Example<Categoria> categoriaExample = Example.of(c);
		Iterator<Categoria> iterator = categoriaRepository.findAll(categoriaExample).iterator();
		List<Categoria> categorias = new ArrayList<>();
		while(iterator.hasNext()) {
			categorias.add(iterator.next());
		}
		return categorias;
	}

	@Override
	public void eliminarCategoria(Categoria categoria) {
		categoriaRepository.delete(categoria);
	}

}
