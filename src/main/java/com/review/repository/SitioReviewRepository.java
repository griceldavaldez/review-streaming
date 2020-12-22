package com.review.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.review.bean.SitioReview;

@Repository
public interface SitioReviewRepository extends PagingAndSortingRepository<SitioReview, Long> {

}
