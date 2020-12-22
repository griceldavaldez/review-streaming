package com.review.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.review.bean.Video;
import com.review.repository.VideoRepository;
import com.review.service.VideoService;
import com.review.utils.ValidarUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VideoServiceImpl implements VideoService {
	
	@Autowired
	private VideoRepository videoRepository;

	@Override
	public Integer crearVideo(Video video) {
		if(ValidarUtils.validarVideo(video)) {
			videoRepository.save(video);
			return 1;
		}
		return null;
	}

	@Override
	public Integer editarVideo(Video video) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Video> obtenerVideos() {
		List<Video> videos = new ArrayList<>();
		Iterator<Video> iteratorVideos = videoRepository.findAll().iterator();
		while(iteratorVideos.hasNext()) {
			videos.add(iteratorVideos.next());
		}
		return videos;
	}
	
	/*@Override
	public Video obtenerVideoPorId(Long idVideo) {
		Video video = videoRepository.findById(idVideo);
		return video;
	}*/
	
	
	@Override
	public Integer eliminarVideo(Integer idVideo) {
		// TODO Auto-generated method stub
		return null;
	}

}
