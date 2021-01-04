package com.review.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.review.bean.Promocion;

/**
 * Interfaz para almacenar y recuperar los datos de promociones
 */

@Repository
public interface PromocionRepository extends PagingAndSortingRepository<Promocion, Long>, QueryByExampleExecutor<Promocion>  {

}
