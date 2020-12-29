package com.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Video.TipoVideoEnum;
import com.review.bean.Video;
import com.review.exceptions.ReviewException;
import com.review.repository.VideoRepository;
import com.review.service.VideoService;
import com.review.utils.ListarUtils;
import com.review.utils.ValidarUtils;


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
	public Video editarVideo(Video video) throws ReviewException {
		if(video.getIdVideo() != null && videoRepository.existsById(video.getIdVideo())) {
			Optional<Video> val = videoRepository.findById(video.getIdVideo());
			Video videoExistente = val.get();
			/*Haciendo de esta forma si modifica correctamente el video existente en la BD*/
			if(! ValidarUtils.isEmptyString(video.getTitulo())) {
				videoExistente.setTitulo(video.getTitulo());
			}
			if(! ValidarUtils.isEmptyString(video.getDescripcion())) {
				videoExistente.setDescripcion(video.getDescripcion());
			}
			return videoRepository.save(videoExistente);
			
		}else {
			throw new ReviewException("No se puede editar el video porque no existe en la base de datos");
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
