package com.review.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;

public interface QueryByExampleExecutor<T> {
	<S extends T> Iterable<S> findAll(Example<S> example);
	<S extends T> Iterable<S> findAll(Example<S> example, Sort sort);
}
