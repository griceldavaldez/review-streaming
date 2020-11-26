package com.review.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.review.bean.*;

public final class SortUtils {
	
	public enum SortMode {ASC, DESC}

	public static void sortUsuarioPorNombre(final SortMode sortMode, List<Usuario> list) {
		
		Collections.sort(list, new Comparator<Usuario>(){
		    public int compare(Usuario o1, Usuario o2) {
		    	if(SortMode.DESC.equals(sortMode)) {
		    		return o2.getNombre().compareToIgnoreCase(o1.getNombre());
		    	}
		    	return o1.getNombre().compareToIgnoreCase(o2.getNombre());
		    }
		});
	}
	
	public static void main(String[] args) {
		List<Usuario> list = new ArrayList<Usuario>();
		Usuario u = new Administrador();
		u.setNombre("Carlos");
		Usuario u2 = new Administrador();
		u2.setNombre("José");
		Usuario u3 = new Administrador();
		u3.setNombre("Ana");
		list.add(u);
		list.add(u2);
		list.add(u3);
		
		SortUtils.sortUsuarioPorNombre(SortMode.DESC,list);

		for(Usuario a : list) {
			System.out.println(a.getNombre());
		}
	}
}
