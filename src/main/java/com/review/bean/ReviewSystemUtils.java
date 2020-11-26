package com.review.bean;

public class ReviewSystemUtils {
	
	//Las primeras utildades son para notificaciones a los usuarios, sean del tipo que sean
	public static void notificarVencimiento(Notificable persona) {
		System.out.println("Se notifico a " +persona.getNombre()+" al correo " + persona.getEmail()+ " que sus credenciales expiran el " + persona.getFechaVencimiento());
	}
	
	public static void notificar(Notificable persona, String mensaje) {
		//para una notificacion genérica
		System.out.println("Se envío el mensaje: "+ mensaje+ "a el usuario" + persona.getNombre());
	}
	
	public static void validar(Validable val) {
		//se verifica si alguno de los campos está incompleto para avisar que faltan datos
		
		if(val.getIdVideo()==0) {
			System.out.println("No hay id de video");
		}
		
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
	
	
}
