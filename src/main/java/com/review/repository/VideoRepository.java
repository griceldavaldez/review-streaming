package com.review.repository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.review.bean.Video;

@Repository
public interface VideoRepository extends PagingAndSortingRepository<Video, Long>, QueryByExampleExecutor<Video> {

}
