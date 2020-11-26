package com.review.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import com.review.bean.*;

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
	
//PARA PROBAR EL CODIGO, FUNCIONA DESDE CUALQUIER OTRA CLASE TAMBIEN 	
	public static void main(String[] args) {
		
		//para ordenar usuarios 
		List<Usuario> list = new ArrayList<Usuario>();
		Administrador u = new Administrador();
		u.setNombre("Carlos");
		Administrador u2 = new Administrador();
		u2.setNombre("José");
		Administrador u3 = new Administrador();
		u3.setNombre("Ana");
		list.add(u);
		list.add(u2);
		list.add(u3);
		SortUtils.sortPorNombre(SortMode.ASC,list);
		SortUtils.imprimirLista(list, "\nLista ordenada en forma ascendente (A-Z) \n");
		
		//para ordenar sitios de review
		List<SitioReview> list2 = new ArrayList<SitioReview>();
		SitioReview sitio1 = new SitioReview();
		sitio1.setNombre("IMDB");
		SitioReview sitio2 = new SitioReview();
		sitio2.setNombre("Rotten Tomatoes");
		SitioReview sitio3 = new SitioReview();
		sitio3.setNombre("Film Affinity");
		list2.add(sitio1);
		list2.add(sitio2);
		list2.add(sitio3);
		SortUtils.sortPorNombre(SortMode.DESC,list2);
		SortUtils.imprimirLista(list2, "\nLista ordenada en forma descendente (Z-A) \n");
		
		//para ordenar videos
		
		List<Video> list3 = new ArrayList<Video>();
		Pelicula peli1= new Pelicula();
		peli1.setTitulo("Star Wars");
		Pelicula peli2= new Pelicula();
		peli2.setTitulo("Harry Potter");
		Pelicula peli3= new Pelicula();
		peli3.setTitulo("It");
		list3.add(peli1);
		list3.add(peli2);
		list3.add(peli3);
		SortUtils.sortPorNombre(SortMode.ASC,list3);
		SortUtils.imprimirLista(list3, "\nLista ordenada en forma ascendente (A-Z) \n");
		
	} 
}
