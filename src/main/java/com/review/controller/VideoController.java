package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.bean.Pelicula;
import com.review.bean.Serie;
import com.review.bean.Video;
import com.review.bean.Video.TipoVideoEnum;
import com.review.constants.ApiPaths;
import com.review.exceptions.ReviewException;
import com.review.service.VideoService;

@RestController
@RequestMapping(ApiPaths.VIDEO)
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	/**
	 * Metodo que lista todos los videos de la base de datos
	 * @return Lista de videos 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Video> list(@RequestParam(name = "id_video",  required = false) Long idVideo,
    		@RequestParam(name = "titulo",  required = false) String titulo,
    		@RequestParam(name = "tipo_video", required = false) TipoVideoEnum tipoVideo){
			return videoService.obtenerVideos(idVideo, titulo, tipoVideo);
    }
	
	/**
	 * Metodo que agrega un nuevo video a la base de datos
	 */
	@RequestMapping(value = "/add-pelicula", method = RequestMethod.POST)
    public Video addPelicula(@RequestBody Pelicula video) throws ReviewException{
		try {
			return videoService.crearVideo(video);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al agregar pelicula.");
		}
	}
	
	/**
	 * Método que agrega un video tipo serie.
	 */
	@RequestMapping(value = "/add-serie", method = RequestMethod.POST)
    public Video addSerie(@RequestBody Serie serie) throws ReviewException{
		try {
			return videoService.crearVideo(serie);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al agregar serie.");
		}	
	}
	
	@RequestMapping(value = "/modify-serie", method = RequestMethod.POST)
    public Serie modifySerie(@RequestBody Serie video) throws ReviewException{
		try {
			return videoService.editarSerie(video);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al editar serie.");
		}
	}
	
	@RequestMapping(value = "/modify-pelicula", method = RequestMethod.POST)
    public Pelicula modifyPelicula(@RequestBody Pelicula video) throws ReviewException{
		try {
			return videoService.editarPelicula(video);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al editar pelicula.");
		}
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id_video",  required = true) Long idVideo) throws ReviewException{
		try {
			videoService.eliminarVideo(idVideo);
		}catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			System.out.println(e);
			throw new ReviewException("Ocurrió un error inesperado al eliminar video.");
		}
	}
	
	
	
}
