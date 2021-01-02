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


/*
 *Clase que implementa los metodos de la interfaz de VideoService
 *
 */

@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Video crearVideo(Video video) throws ReviewException{
		ValidarUtils.validarCreacionVideo(video);
		return videoRepository.save(video);
	}

	@Override
	public Pelicula editarPelicula(Pelicula video) throws ReviewException {
		if(video.getIdVideo() != null && videoRepository.existsById(video.getIdVideo())) {
			Optional<Video> val = videoRepository.findById(video.getIdVideo());
			Pelicula videoExistente = (Pelicula)val.get();
			
			actualizarAtributosComunes(video, videoExistente);
			if(video.getAnhoEstreno() != null) {
				videoExistente.setAnhoEstreno(video.getAnhoEstreno());
			}
			if(! ValidarUtils.isEmptyString(video.getDirector())) {
				videoExistente.setDirector(video.getDirector());
			}
			if(! ValidarUtils.isEmptyString(video.getSaga())) {
				videoExistente.setSaga(video.getSaga());
			}
			if(video.getDuracionMinutos() != null) {
				videoExistente.setDuracionMinutos(video.getDuracionMinutos());
			}
			return videoRepository.save(videoExistente);
			
		}else {
			throw new ReviewException("No se puede editar la pelicula porque no existe en la base de datos");
		}
	}

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

	@Override
	public List<Video> obtenerVideos(Long idVideo, String titulo, TipoVideoEnum tipoVideo) {
		Video video = new Video();
		video.setIdVideo(idVideo);
		video.setTitulo(titulo);
		video.setTipoVideo(tipoVideo);
		return ListarUtils.listar(video, videoRepository);
	}
	
	
	@Override
	public void eliminarVideo(Long idVideo) throws ReviewException{
		if(idVideo != null && videoRepository.existsById(idVideo)) {
			videoRepository.deleteById(idVideo);
		}else {
			throw new ReviewException("No se puede eliminar el video porque no existe en la base de datos");
		}
	}
}
