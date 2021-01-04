package com.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Video.TipoVideoEnum;
import com.review.bean.Pelicula;
import com.review.bean.Serie;
import com.review.bean.Video;
import com.review.exceptions.ReviewException;
import com.review.repository.VideoRepository;
import com.review.service.VideoService;
import com.review.utils.ListarUtils;
import com.review.utils.ValidarUtils;


/**
 *Clase que implementa los metodos de la interfaz de VideoService
 *
 */

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoRepository videoRepository;

	/*Método para crear un video*/
	
	@Override
	public Video crearVideo(Video video) throws ReviewException{
		ValidarUtils.validarCreacionVideo(video);
		return videoRepository.save(video);
	}

	/*Metodo para editar una pelicula existente en la base de datos.*/
	
	@Override
	public Pelicula editarPelicula(Pelicula pelicula) throws ReviewException {
		if(pelicula.getIdVideo() != null && videoRepository.existsById(pelicula.getIdVideo())) {
			Optional<Video> recuperarPelicula = videoRepository.findById(pelicula.getIdVideo());
			Pelicula peliculaExistente = (Pelicula) recuperarPelicula.get();
			
			actualizarAtributosComunes(pelicula, peliculaExistente);
			if(pelicula.getAnhoEstreno() != null) {
				peliculaExistente.setAnhoEstreno(pelicula.getAnhoEstreno());
			}
			if(! ValidarUtils.isEmptyString(pelicula.getDirector())) {
				peliculaExistente.setDirector(pelicula.getDirector());
			}
			if(! ValidarUtils.isEmptyString(pelicula.getSaga())) {
				peliculaExistente.setSaga(pelicula.getSaga());
			}
			if(pelicula.getDuracionMinutos() != null) {
				peliculaExistente.setDuracionMinutos(pelicula.getDuracionMinutos());
			}
			return videoRepository.save(peliculaExistente);
			
		}else {
			throw new ReviewException("No se puede editar la pelicula porque no existe en la base de datos");
		}
	}
	
	/*Metodo para editar una serie existente en la base de datos.*/
	
	@Override
	public Serie editarSerie(Serie serie) throws ReviewException {
		if(serie.getIdVideo() != null && videoRepository.existsById(serie.getIdVideo())) {
			Optional<Video> recuperarVideo = videoRepository.findById(serie.getIdVideo());
			Serie serieExistente = (Serie) recuperarVideo.get();
			
			actualizarAtributosComunes(serie, serieExistente);
			
			if(serie.getTemporadas() != null  ) {
				serieExistente.setTemporadas(serie.getTemporadas());
			}
			
			return videoRepository.save(serieExistente);
			
		}else {
			throw new ReviewException("No se puede editar la serie porque no existe en la base de datos");
		}
	}
	
	/*Metodo para obtener una lista de videos por ciertos filtros*/
	
	@Override
	public List<Video> obtenerVideos(Long idVideo, String titulo, TipoVideoEnum tipoVideo) {
		Video video = new Video();
		video.setIdVideo(idVideo);
		video.setTitulo(titulo);
		video.setTipoVideo(tipoVideo);
		return ListarUtils.listar(video, videoRepository);
	}
	
	/*Metodo para eliminar un video*/
	
	@Override
	public void eliminarVideo(Long idVideo) throws ReviewException{
		if(idVideo != null && videoRepository.existsById(idVideo)) {
			videoRepository.deleteById(idVideo);
		}else {
			throw new ReviewException("No se puede eliminar el video porque no existe en la base de datos");
		}
	}
	
	/*Metodo que verifica y actualiza los campos de un video existente*/
	
	private void actualizarAtributosComunes(Video video, Video videoExistente) {
		if(! ValidarUtils.isEmptyString(video.getTitulo())) {
			videoExistente.setTitulo(video.getTitulo());
		}
		if(! ValidarUtils.isEmptyString(video.getDescripcion())) {
			videoExistente.setDescripcion(video.getDescripcion());
		}
		if(video.getPuntajes() != null) {
			videoExistente.setPuntajes(video.getPuntajes());
		}
		if(video.getCategoria() != null) {
			videoExistente.setCategoria(video.getCategoria());
		}		
	}
}
