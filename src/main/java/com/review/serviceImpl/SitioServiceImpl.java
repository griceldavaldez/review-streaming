package com.review.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.SitioReview;
import com.review.repository.SitioReviewRepository;
import com.review.service.SitioService;
import com.review.utils.ListarUtils;


@Service
public class SitioServiceImpl implements SitioService {

	@Autowired
	private SitioReviewRepository sitioRepository;

	@Override
	public SitioReview crearSitio(SitioReview sitio) {
		//TODO validar creacion de sitio
		return sitioRepository.save(sitio);
	}

	@Override
	public SitioReview editarSitio(SitioReview sitio) {
		//TODO validar edicion de sitio
		return sitioRepository.save(sitio);
	}

	@Override
	public List<SitioReview> obtenerSitios(Long idSitioReview, String nombre) {
		Boolean hayIdSitio = idSitioReview != null;
		Boolean hayNombreSitio = nombre != null && !nombre.isEmpty();
		
		SitioReview s = new SitioReview();
		if(hayIdSitio) {
			s.setIdSitioReview(idSitioReview);
		}
		if(hayNombreSitio) {
			s.setNombre(nombre);
		}
		return ListarUtils.listar(s, sitioRepository);
	}

	@Override
	public void eliminarSitio(SitioReview sitio) {
		sitioRepository.delete(sitio);
	}

}
