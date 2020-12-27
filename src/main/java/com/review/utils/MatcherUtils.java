package com.review.utils;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

public class MatcherUtils {

	/**
	 * @param containing Indica cuál es el método de comparación de cada valor de matchs.
	 * @param matchs Cada uno de los atributos que son tipo string y que se desea sea un filtro a tener en cuenta en la búsqueda.
	 * @return Un ExampleMatcher.
	 */
	public static ExampleMatcher getStringMatcher(StringMatcher stringMatcher, List<String> matchs) {
		if(stringMatcher == null || matchs == null || matchs.isEmpty()) {
			return null;
		}
		String[] array = Arrays.copyOf(matchs.toArray(), matchs.size(),
                String[].class);
		return ExampleMatcher.matching()
                .withIgnoreCase(array).withStringMatcher(stringMatcher);
	}
	
}
