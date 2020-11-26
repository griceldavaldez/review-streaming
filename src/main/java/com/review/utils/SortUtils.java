package com.review.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.review.bean.Administrador;
import com.review.bean.Pelicula;
import com.review.bean.SitioReview;
import com.review.bean.Usuario;

//import com.review.bean.*;

public final class SortUtils {
	
	public enum SortMode {ASC, DESC}

	public static void sortPorNombre(final SortMode sortMode, List<Ordenable> list) {
		
		Collections.sort(list, new Comparator<Ordenable>(){
		    public int compare(Ordenable o1, Ordenable o2) {
		    	if(SortMode.DESC.equals(sortMode)) {
		    		return o2.getNombre().compareToIgnoreCase(o1.getNombre());
		    	}
		    	return o1.getNombre().compareToIgnoreCase(o2.getNombre());
		    }
		});
	}
	
	public static void imprimirListaOrdenada(List<Ordenable> list) {
		System.out.println("\nLista ordenada\n");
		for(Ordenable a : list) {
			System.out.println(a.getNombre());
		}
	}
	
//PARA PROBAR EL CODIGO, FUNCIONA DESDE CUALQUIER OTRA CLASE TAMBIEN 	
	public static void main(String[] args) {
		
		//para ordenar usuarios 
		List<Ordenable> list = new ArrayList<Ordenable>();
		Usuario u = new Administrador();
		u.setNombre("Carlos");
		Usuario u2 = new Administrador();
		u2.setNombre("José");
		Usuario u3 = new Administrador();
		u3.setNombre("Ana");
		list.add(u);
		list.add(u2);
		list.add(u3);
		SortUtils.sortPorNombre(SortMode.DESC,list);
		SortUtils.imprimirListaOrdenada(list);
		
		//para ordenar sitios de review
		List<Ordenable> list2 = new ArrayList<Ordenable>();
		SitioReview sitio1 = new SitioReview();
		sitio1.setNombre("IMDB");
		SitioReview sitio2 = new SitioReview();
		sitio2.setNombre("Rotten Tomatoes");
		SitioReview sitio3 = new SitioReview();
		sitio3.setNombre("Film Affinity");
		list2.add(sitio1);
		list2.add(sitio2);
		list2.add(sitio3);
		SortUtils.sortPorNombre(SortMode.ASC,list2);
		SortUtils.imprimirListaOrdenada(list2);
		
		//para ordenar videos
		
		List<Ordenable> list3 = new ArrayList<Ordenable>();
		Pelicula peli1= new Pelicula();
		peli1.setTitulo("Titanic");
		Pelicula peli2= new Pelicula();
		peli2.setTitulo("El Señor de los Anilllos");
		Pelicula peli3= new Pelicula();
		peli3.setTitulo("It");
		list3.add(peli1);
		list3.add(peli2);
		list3.add(peli3);
		SortUtils.sortPorNombre(SortMode.ASC,list3);
		SortUtils.imprimirListaOrdenada(list3);
		
	} 
}
