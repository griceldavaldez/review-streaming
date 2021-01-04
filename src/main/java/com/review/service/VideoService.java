package com.review.service;

import java.util.List;

import com.review.bean.Pelicula;
import com.review.bean.Serie;
import com.review.bean.Video;
import com.review.exceptions.ReviewException;
import com.review.bean.Video.TipoVideoEnum;

public interface VideoService {
	/**
	 * Método para crear un video. Recibirá instancia de Serie o de Pelicula. Facilitar los atributos del video a crear, excepto el idVideo (que se crea automáticamente).
	 * 
	 * @return El video recientemente creado
	 *  @throws ReviewException
	 */
	
	public Video crearVideo(Video video) throws ReviewException;
	
	
	/**
	 * Metodo para obtener una lista de videos por ciertos filtros. Si no se indican filtros, se obtienen todos los videos.
	 * 
	 * @param idVideo Filtro para indicar que se desean obtener los videos con este id. Puede ser null.
	 * @param titulo Filtro para indicar que se desean obtener los videos con este titulo (o que contenga). Puede ser null.
	 * @param tipoVideo Filtro para indicar tipo de video "SERIE" o "PELICULA". Puede ser null
	 * @return Lista de videos que se obtuvieron con los filtros indicados.
	 */
	
	public List<Video> obtenerVideos(Long idVideo, String titulo, TipoVideoEnum tipoVideo);
	
	
	/**
	 * Metodo para eliminar un video. Facilitar el atributo idVideo para ubicar el video a eliminar.
	 * 
	 * @param idVideo Numero identificador del video.
	 * @throws ReviewException
	 */
	
	public void eliminarVideo(Long idVideo) throws ReviewException;

	
	/** Metodo para editar una pelicula existente en la base de datos.
	 * 
	 * @param video Datos a utilizar para editar. Debe incluirse el idVideo.
	 * @throws ReviewException
	 */
	
	public Pelicula editarPelicula(Pelicula pelicula) throws ReviewException;

	
	/** Metodo para editar una serie existente en la base de datos.
	 * 
	 * @param video Datos a utilizar para editar. Debe incluirse el idVideo.
	 * @throws ReviewException
	 */
	public Serie editarSerie(Serie serie) throws ReviewException;
	
}
