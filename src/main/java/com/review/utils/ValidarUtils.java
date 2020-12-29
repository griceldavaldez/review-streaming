package com.review.utils;

import com.review.bean.Promocion;
import com.review.bean.SitioReview;
import com.review.bean.Usuario;
import com.review.bean.Video;
import com.review.exceptions.ReviewException;

public class ValidarUtils {
	
	/**
	 * Utilidad que verifica si los atributos obligatorios de la clase video estan inicializados
	 * 
	 * @param val Instancia de Pelicula o Serie
	 * @throws ReviewException 
	 */
	public static void validarCreacionVideo(Video val) throws ReviewException {
		/*se verifica si alguno de los campos esta incompleto para avisar que faltan datos, 
		 en caso de ser asi retorna falso, de lo contrario retorna verdadero, lo que significa
		 que minimamente esos campos fueron completados*/
		if(isEmptyString(val.getTitulo())) {
			System.out.println("No hay titulo");
			throw new ReviewException("Para crear el video se requiere de un título.");
		}
		
		if(isEmptyString(val.getDescripcion())) {
			System.out.println("No hay descripcion");
			throw new ReviewException("Para crear el video se requiere de una descripcion.");
		}
		
		if(val.getCategoria() == null) {
			System.out.println("No hay categoria");
			throw new ReviewException("Para crear el video se requiere de una categoria.");
		}
	}
	
	/**
	 * Utilidad que verifica si los atributos obligatorios de la clase usuario estan inicializados
	 * 
	 * @param val Instancia de Administrador, espectador o curador 
	 * @throws ReviewException 
	 */
	public static void validarCreacionUsuario(Usuario usuario) throws ReviewException {
		if(isEmptyString(usuario.getNombre())) {
			throw new ReviewException("Para crear el usuario se requiere de un nombre.");
		}
		
		if(isEmptyString(usuario.getContrasenha()) ) {
			throw new ReviewException("Para crear el usuario se requiere de una contrasenha.");
		}
		
		if(isEmptyString(usuario.getEmail())) {
			throw new ReviewException("Para crear el usuario se requiere de un email.");
		}
	}
	
	/**
	 * Utilidad que verifica si los atributos obligatorios de la clase sitioReview estan inicializados
	 * 
	 * @param val Instancia de sitioReview
	 * @throws ReviewException 
	 */
	public static void validarCreacionSitio(SitioReview val) throws ReviewException {
		
		if(isEmptyString(val.getNombre())) {
			throw new ReviewException("Para crear el sitio se requiere de un nombre.");
		}
		
		if(val.getPuntajeMaximo() == null || val.getPuntajeMaximo().compareTo((double) 0) == 0) {
			throw new ReviewException("Para crear el sitio se requiere de un un puntaje maximo.");
		}
	}
	
	public static void validarPromocion(Promocion promocion) throws ReviewException {
		if(promocion.getDescripcionPromocion()==null || promocion.getDescripcionPromocion().isBlank()) {
			throw new ReviewException("Para crear la promocion se requiere indicar una descripcion.");
		}
		
		if(promocion.getTipoPromocion()==null || promocion.getTipoPromocion().toString().isBlank()) {
			throw new ReviewException("Para crear la promocion se requiere indicar un tipo (cupon, descuento,etc.).");
		}
	}

	
	/**
	 * Utilidad que controla si un string esta vacio
	 * 
	 * @param val String a evaluar
	 * @return Valor booleano
	 */
	public static Boolean isEmptyString(String val) {
		return val == null || val.isBlank();
	}
}

