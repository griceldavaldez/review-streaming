package com.review.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;

import com.review.repository.QueryByExampleExecutor;

public class ListarUtils {
	
	/** Listar elementos de acuerdo a un determinado filtro.
	 * @param <T> Tipo de dato esperado.
	 * @param filtro Instancia del tipo de los elementos a retornar, cuyos valores en atributos serán tratados como filtros.
	 * @param repository El repository a utilizar para realizar la búsqueda.
	 * @return La lista resultante de la búsqueda.
	 */
	public static <T> List<T> listar(T filtro, QueryByExampleExecutor<T> repository){
		Iterator<T> iterator = null;
		if(filtro == null) {
			//no se tiene filtro, se devolvera todo
			iterator = repository.findAll().iterator();
		}else {
			ExampleMatcher matcher = MatcherUtils.getStringMatcher(
					ExampleMatcher.StringMatcher.CONTAINING, 
					getStringMatches(filtro));

			Example<T> example = (Example<T>) Example.of(filtro);
			if(matcher != null) {
				example = (Example<T>) Example.of(filtro, matcher);
			}
			iterator = repository.findAll(example).iterator();
		}
		
		List<T> lista = new ArrayList<>();
		while(iterator.hasNext()) {
			lista.add(iterator.next());
		}
		return lista;
	}
	
	/** Para obtener todos los nombres de los atributos tipo string de la instancia filtro.
	 * @param <T> Tipo de dato de la instancia.
	 * @param filtro Instancia a revisar.
	 * @return Lista de String.
	 */
	private static <T> List<String> getStringMatches(T filtro) {
		List<String> stringMatches = new ArrayList<>();
		for(Field f : filtro.getClass().getDeclaredFields()) {
			if(f.getType().equals(String.class)) {
				stringMatches.add(f.getName());
			}
		}
		if(stringMatches != null && !stringMatches.isEmpty()) {
			return stringMatches;
		}
		return null;
	}
}
