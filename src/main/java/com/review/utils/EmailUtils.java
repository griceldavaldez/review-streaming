package com.review.utils;

public final class EmailUtils {

  	public static final Integer DIAS_DURACION_CREDENCIAL = 30;
  	public static final String NRO_TELEFONO = "021  123 456";

  	private EmailUtils() {
  		throw new UnsupportedOperationException("Clase no instanciable!");
  	}

  	public static void notificarVencimientoEmail(Notificable notificable) {
  		String email = notificable.getEmail();
  		String nombre = notificable.getNombre();
  		String asunto = "Vencimiento de credencial - Review System";
  		String cuerpo = String.format(
  				"Sr/a. %s\nSu credencial de acceso al sistema ha caducado. Favor comunicarse al %s.\nMuchas gracias!",
  				nombre,
  				NRO_TELEFONO);
  		
  		EmailUtils.enviarEmail(email, asunto, cuerpo);
  	}
  	
  	public static void enviarEmail(String email, String asunto, String cuerpo) {
  		System.out.println("Enviando email a ... " + email);
  		System.out.println("Asunto: " + asunto);
  		System.out.println("Cuerpo: " + cuerpo);
  		System.out.println("Email enviado correctamente.");
  	}
}