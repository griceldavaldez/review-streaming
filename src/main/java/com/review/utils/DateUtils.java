package com.review.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Utilidad para manejar las fechas 
 */

public final class DateUtils {
	
	/**
	 * Metodo que suma la cantidad de dias dada un numero entero. 
	 * 
	 * @param fecha Fecha a la que se sumarán los días indicados.
	 * @param dias Cantidad de días a sumar a la fecha especificada.
	 * @return La fecha resultante de la suma.
	 */
	public static Date sumarDiasDate(Date fecha, Integer dias) {
		if(fecha == null) return null;
		if(dias == null || dias.equals(0)) return fecha;
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(fecha);
		calendario.add(Calendar.DAY_OF_YEAR, dias);
		return calendario.getTime();
	}
}
