package com.review.utils;

import com.review.bean.Pelicula;

public class ValidarUtils {
	
	/**
	 * Utilidad que verifica si los atributos de la clase video están inicializados
	 * 
	 * @param val Instancia de Video o Serie
	 */
	public static void validarVideo(Validable val) {
		
		/*if(val.getIdVideo()==0) {
		System.out.println("No hay id de la Pelicula");
		}*/
		
		//se verifica si alguno de los campos está incompleto para avisar que faltan datos
		if(val.getTitulo().isBlank()) {
			System.out.println("No hay titulo");
		}
		
		if(val.getDescripcion().isBlank()) {
			System.out.println("No hay descripción");
		}
		
		if(val.getCategoria()==null) {
			System.out.println("No hay categoria");
		}
		
		if(val.getPuntajes()==null) {
			System.out.println("No hay puntajes");
		}
	}
	
	//PARA PROBAR EL CODIGO
	public static void main(String[] args) {
		Pelicula peli = new Pelicula();
		//peli.setAnhoEstreno(2020);
		peli.setTitulo("It");
		ValidarUtils.validarVideo(peli);
	}
	
	
		
}
