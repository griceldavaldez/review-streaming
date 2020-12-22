package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.review.bean.Video;
import com.review.constants.ApiPaths;
import com.review.service.VideoService;

@RestController
@RequestMapping(ApiPaths.VIDEO)
public class VideoController {
	@Autowired
	private VideoService videoService;
	
	/**
	 * Metodo que lista todos los videos de la base de datos
	 * 
	 * @return Lista de videos 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Video> list() {
        return videoService.obtenerVideos();
    }
	
	/**
	 * Metodo que agrega un nuevo video a la base de datos
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@RequestBody Video video) {
			videoService.crearVideo(video);
	}
}
