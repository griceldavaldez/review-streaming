package com.review.utils;

public class ValidarUtils {
	
	/**
	 * Utilidad que verifica si los atributos de la clase video est�n inicializados
	 * 
	 * @param val 
	 */
	public static void validarVideo(Validable val) {
		//se verifica si alguno de los campos est� incompleto para avisar que faltan datos
		
		if(val.getIdVideo()==0) {
			System.out.println("No hay id de video");
		}
		
		if(val.getTitulo().isBlank()) {
			System.out.println("No hay titulo");
		}
		
		if(val.getDescripcion().isBlank()) {
			System.out.println("No hay descripci�n");
		}
		
		if(val.getCategoria()==null) {
			System.out.println("No hay categoria");
		}
		
		if(val.getPuntajes()==null) {
			System.out.println("No hay puntajes");
		}
	}
	
	
}
