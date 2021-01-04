package com.review.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.review.bean.SitioReview;

/**
 * Interfaz para almacenar y recuperar los datos de sitios de review
 */

@Repository
public interface SitioReviewRepository extends PagingAndSortingRepository<SitioReview, Long>, QueryByExampleExecutor<SitioReview> {

}
