package com.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.SitioReview;
import com.review.exceptions.ReviewException;
import com.review.repository.SitioReviewRepository;
import com.review.service.SitioService;
import com.review.utils.ListarUtils;
import com.review.utils.ValidarUtils;


/*
 *Clase que implementa los metodos de la interfaz de SitioService
 *
 */

@Service
public class SitioServiceImpl implements SitioService {

	@Autowired
	private SitioReviewRepository sitioRepository;

	@Override
	public SitioReview crearSitio(SitioReview sitio) throws ReviewException {
		ValidarUtils.validarCreacionSitio(sitio);
		return sitioRepository.save(sitio);
	}

	@Override
	public SitioReview editarSitio(SitioReview sitio) throws ReviewException{
		if(sitio.getIdSitioReview() != null && sitioRepository.existsById(sitio.getIdSitioReview())){
			Optional<SitioReview> recuperarSitio = sitioRepository.findById(sitio.getIdSitioReview());
			SitioReview sitioExistente = recuperarSitio.get();
			if(! ValidarUtils.isEmptyString(sitio.getNombre())) {
				sitioExistente.setNombre(sitio.getNombre());
			}
			if(sitio.getPuntajeMaximo() != null ) {
				sitioExistente.setPuntajeMaximo(sitio.getPuntajeMaximo());
			}
			return sitioRepository.save(sitioExistente);
			
		}else {
			throw new ReviewException("No se puede editar sitio porque no existe en la base de datos");
		}
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
	public void eliminarSitio(Long idSitio) throws ReviewException{
		if(idSitio != null && sitioRepository.existsById(idSitio)) {
			sitioRepository.deleteById(idSitio);
		}else {
			throw new ReviewException("No se puede eliminar sitio porque no existe en la base de datos.");
		}
	}

}
