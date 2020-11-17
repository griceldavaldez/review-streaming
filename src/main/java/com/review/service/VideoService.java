package com.review.service;

import java.util.List;

import com.review.bean.Video;

public interface VideoService {
	/**
	 * M�todo para crear un video. Facilitar los atributos del video a crear, excepto el idVideo (que se crea autom�ticamente).
	 * 
	 * @param video
	 * @return Cantidad de videos creados.
	 */
	public Integer crearVideo(Video video);
	
	/**
	 * M�todo para editar un video. Facilitar el atributo idVideo para ubicar el video a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param sitioReview
	 * @return Cantidad de sitios modificados.
	 */
	public Integer editarVideo(Video video);
	
	
}
