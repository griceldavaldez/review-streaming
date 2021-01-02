package com.review.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.review.bean.Categoria;

/*
 * Interfaz para almacenar y recuperar los datos de categorias 
 */

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>, QueryByExampleExecutor<Categoria> {}
