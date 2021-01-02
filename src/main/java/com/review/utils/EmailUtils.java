package com.review.utils;

import com.review.constants.Constantes;
import com.review.utils.interfaces.Notificable;

public final class EmailUtils {
 	
  	/**
  	 * Utilidad que notifica vencimiento de credencial a traves de un correo electronico
  	 * 
  	 * @param notificable Instancia de un notificable
  	 */
  	public static void notificarVencimientoEmail(Notificable notificable) {
  		String email = notificable.getEmail();
  		String nombre = notificable.getNombre();
  		String asunto = "Vencimiento de credencial - Review System";
  		String cuerpo = String.format(
  				"Sr/a. %s\nSu credencial de acceso al sistema ha caducado. Favor comunicarse al %s.\nMuchas gracias!",
  				nombre, Constantes.NRO_TELEFONO);
  		
  		EmailUtils.enviarEmail(email, asunto, cuerpo);
  	}
  	
  	/**
  	 * Utilidad que envia un correo, simula el envio con una impresion en consola
  	 * 
  	 * @param email Direccion de correo 
  	 * @param asunto Motivo del mensaje
  	 * @param cuerpo Mensaje
  	 */
  	
  	public static void enviarEmail(String email, String asunto, String cuerpo) {
  		System.out.println("Enviando email a ... " + email);
  		System.out.println("Asunto: " + asunto);
  		System.out.println("Cuerpo: " + cuerpo);
  		System.out.println("Email enviado correctamente.");
  	}
}