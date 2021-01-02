package com.review.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.review.utils.interfaces.Ordenable;

public final class SortUtils {
	
	public enum SortMode {ASC, DESC}
	
	/**
	 * Utilidad que ordena una lista de Ordenables (Usuario, SitioReview, Video) en forma ascendente o descendente
	 * 
	 * @param sortMode Indica si el ordenamiento se hace en forma forma ascendente o descendente. Puede tener dos valores {ASC o DESC}
	 * @param list La lista que se desea ordenar
	 */
	public static void sortPorNombre(final SortMode sortMode, List<? extends Ordenable> list) {
		
		Collections.sort(list, new Comparator<Ordenable>(){
		    public int compare(Ordenable o1, Ordenable o2) {
		    	if(SortMode.DESC.equals(sortMode)) {
		    		return o2.getNombre().compareToIgnoreCase(o1.getNombre());
		    	}
		    	return o1.getNombre().compareToIgnoreCase(o2.getNombre());
		    }
		});
	}
	
	
	/**
	 * Utilidad que imprime una lista del tipo ordenable.
	 * 
	 * @param list La lista a imprimir 
	 */
	public static void imprimirLista(List<? extends Ordenable> list, String mensaje) {
		System.out.println(mensaje);
		for(Ordenable a : list) {
			System.out.println(a.getNombre());
		}
	}
}
