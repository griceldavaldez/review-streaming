package com.review.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.review.bean.TipoPromocion;

@Repository
public interface TipoPromocionRepository extends PagingAndSortingRepository<TipoPromocion, Long> {

}
