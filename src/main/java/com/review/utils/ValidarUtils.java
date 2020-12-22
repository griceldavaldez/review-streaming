package com.review.utils;

public class ValidarUtils {
	
	/**
	 * Utilidad que verifica si los atributos de la clase video estan inicializados
	 * 
	 * @param val Instancia de Pelicula o Serie
	 */
	public static boolean validarVideo(Validable val) {
		/*se verifica si alguno de los campos esta incompleto para avisar que faltan datos, 
		 en caso de ser asi retorna falso, de lo contrario retorna verdadero, lo que significa
		 que minimamente esos campos fueron completados*/
		if(val.getTitulo().isBlank()) {
			System.out.println("No hay titulo");
			return false;
		}
		
		if(val.getDescripcion().isBlank()) {
			System.out.println("No hay descripcion");
			return false;
		}
		
		if(val.getCategoria()==null) {
			System.out.println("No hay categoria");
			return false;
		}
		
		if(val.getPuntajes()==null) {
			System.out.println("No hay puntajes");
			return false;
		}
		
		return true;
	}
}

