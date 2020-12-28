package com.review.utils;

import java.util.Calendar;
import java.util.Date;

public final class Utils {
	
	/**
	 * @param fecha Fecha a la que se sumarán los días indicados.
	 * @param dias Cantidad de días a sumar a la fecha especificada.
	 * @return La fecha resultante de la suma.
	 */
	public static Date sumarDiasDate(Date fecha, Integer dias) {
		if(fecha == null) return null;
		if(dias == null || dias.equals(0)) return fecha;
		Calendar c = Calendar.getInstance();
		c.setTime(fecha);
		c.add(Calendar.DAY_OF_YEAR, dias);
		return c.getTime();
	}
}
