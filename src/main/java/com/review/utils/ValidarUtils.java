package com.review.utils;

import com.review.bean.Usuario;
import com.review.exceptions.ReviewException;
import com.review.utils.interfaces.Validable;

public class ValidarUtils {
	
	/**
	 * Utilidad que verifica si los atributos de la clase video estan inicializados
	 * 
	 * @param val Instancia de Pelicula o Serie
	 * @throws ReviewException 
	 */
	public static void validarCreacionVideo(Validable val) throws ReviewException {
		/*se verifica si alguno de los campos esta incompleto para avisar que faltan datos, 
		 en caso de ser asi retorna falso, de lo contrario retorna verdadero, lo que significa
		 que minimamente esos campos fueron completados*/
		if(isEmptyString(val.getTitulo())) {
			System.out.println("No hay titulo");
			throw new ReviewException("Para crear el video se requiere de un título.");
		}
		
		if(isEmptyString(val.getDescripcion())) {
			System.out.println("No hay descripcion");
			throw new ReviewException("Para crear el video se requiere de un título.");
		}
		
		if(val.getCategoria() == null) {
			System.out.println("No hay categoria");
			throw new ReviewException("Para crear el video se requiere de una categoria.");
		}
	}
	
	
	
	public static void validarUsuario(Usuario usuario) throws ReviewException {
		if(usuario.getNombre() == null || usuario.getNombre().isBlank()) {
			throw new ReviewException("Para crear el usuario se requiere de un nombre.");
		}
		
		if(usuario.getContrasenha() == null || usuario.getContrasenha().isBlank()) {
			throw new ReviewException("Para crear el usuario se requiere de una contrasenha.");
		}
		
		if(usuario.getEmail() == null || usuario.getEmail().isBlank()) {
			throw new ReviewException("Para crear el usuario se requiere de un email.");
		}
	}
	
	public static Boolean isEmptyString(String val) {
		return val == null || val.isBlank();
	}
}

