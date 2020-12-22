package com.review.service;

import java.util.List;

import com.review.bean.Video;

public interface VideoService {
	/**
	 * M�todo para crear un video. Recibir� instancia de Serie o de Pelicula. Facilitar los atributos del video a crear, excepto el idVideo (que se crea autom�ticamente).
	 * 
	 * @param video
	 * @return Un numero distinto de cero si la creacion de Video se hizo correctamente
	 */
	public Integer crearVideo(Video video);
	
	/**
	 * M�todo para editar un video. Facilitar el atributo idVideo para ubicar el video a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @param video El video indicando los atributos a modificar.
	 * @return Un numero distinto de cero si la modificacion de Video se hizo correctamente
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
	//public List<Video> obtenerVideos(Long idVideo, String titulo, Integer idSitioReview, Integer idCategoria);
	
	public List<Video> obtenerVideos();
	
	//public Video obtenerVideoPorId(Long idVideo);
	
	/**
	 * M�todo para eliminar un video. Facilitar el atributo idVideo para ubicar el video a eliminar.
	 * 
	 * @param idVideo N�mero identificador del video.
	 * @return Un numero distinto de cero si la eliminacion de Video se hizo correctamente
	 */
	
	public Integer eliminarVideo(Integer idVideo);
	
}
