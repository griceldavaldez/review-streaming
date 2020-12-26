package com.review.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Example;

import com.review.repository.QueryByExampleExecutor;

public class ListarUtils {
	
	public static <T> List<T> listar(T filtro, QueryByExampleExecutor<T> repository){
		Example<T> example = (Example<T>) Example.of(filtro);
		Iterator<T> iterator = repository.findAll(example).iterator();
		List<T> lista = new ArrayList<>();
		while(iterator.hasNext()) {
			lista.add(iterator.next());
		}
		return lista;
	}
}
