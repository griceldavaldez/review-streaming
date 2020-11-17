package com.review.service;

import java.util.List;

import com.review.bean.Video;

public interface VideoService {
	/**
	 * M�todo para crear un video. Recibir� instancia de Serie o de Pelicula. Facilitar los atributos del video a crear, excepto el idVideo (que se crea autom�ticamente).
	 * 
	 * @param video
	 * @return Cantidad de videos creados.
	 */
	public Integer crearVideo(Video video);
	
	/**
	 * M�todo para editar un video. Facilitar el atributo idVideo para ubicar el video a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param video El video indicando los atributos a modificar.
	 * @return Cantidad de videos modificados.
	 */
	public Integer editarVideo(Video video);
	
	/**
	 * M�todo para obtener una lista de videos por ciertos filtros. Si no se indican filtros, se obtienen todos los videos.
	 * 
	 * @param idVideo Filtro para indicar que se desean obtener los videos con este id. Puede ser null.
	 * @param titulo Filtro para indicar que se desean obtener los videos con este titulo (o que contenga). Puede ser null.
	 * @param idSitioReview Filtro para indicar que se desean obtener los videos de este sitio. Puede ser null.
	 * @param idCategoria Filtro para indicar que se desean obtener los videos con esta categoria. Puede ser null.
	 * @return Lista de videos que se obtuvieron con los filtros indicados.
	 */
	public List<Video> obtenerVideos(Integer idVideo, String titulo, Integer idSitioReview, Integer idCategoria);
	
	/**
	 * M�todo para eliminar un video. Facilitar el atributo idVideo para ubicar el video a eliminar.
	 * 
	 * @param idVideo N�mero identificador del video.
	 * @return Cantidad de videos eliminados.
	 */
	public Integer eliminarVideo(Integer idVideo);
}
