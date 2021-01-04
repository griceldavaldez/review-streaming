package com.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Promocion;
import com.review.exceptions.ReviewException;
import com.review.repository.PromocionRepository;
import com.review.service.PromocionService;
import com.review.utils.ListarUtils;
import com.review.utils.ValidarUtils;

/**
 *Clase que implementa los metodos de la interfaz de PromocionService
 *
 */

@Service
public class PromocionServiceImpl implements PromocionService{

	@Autowired
	private PromocionRepository promocionRepository; 
	
	/* Método para crear una promoción.*/
	
	@Override
	public Promocion crearPromocion(Promocion promocion) throws ReviewException{
		ValidarUtils.validarCreacionPromocion(promocion);
		return promocionRepository.save(promocion);
	}
	
	/* Metodo para editar una promocion*/
	
	@Override
	public Promocion editarPromocion(Promocion promocion) throws ReviewException{
		if(promocion.getIdPromocion() != null && promocionRepository.existsById(promocion.getIdPromocion())){
			Optional<Promocion> recuperarPromocion = promocionRepository.findById(promocion.getIdPromocion());
			Promocion promocionExistente = recuperarPromocion.get();
			if(! ValidarUtils.isEmptyString(promocion.getDescripcionPromocion())) {
				promocionExistente.setDescripcionPromocion(promocion.getDescripcionPromocion());
			}
			if(promocion.getTipoPromocion() != null) {
				promocionExistente.setTipoPromocion(promocion.getTipoPromocion());
			}
			return promocionRepository.save(promocionExistente);
		}else {
			throw new ReviewException("No se puede editar la promocion porque no existe en la base de datos");
		}
	}
	
	/*Metodo para obtener una lista de promociones por ciertos filtros*/
	
	@Override
	public List<Promocion> obtenerPromociones(Long idPromocion, String tipoPromocion, String descripcionPromocion) throws ReviewException{
		Promocion filtroPromocion=new Promocion();
		filtroPromocion.setIdPromocion(idPromocion);
		filtroPromocion.setTipoPromocion(tipoPromocion);
		filtroPromocion.setDescripcionPromocion(descripcionPromocion);
		return ListarUtils.listar(filtroPromocion, promocionRepository);
	}
	
	/*Metodo para eliminar una promocion.*/
	
	@Override
	public void eliminarPromocion(Long idPromocion) throws ReviewException{
		if(idPromocion != null && promocionRepository.existsById(idPromocion)) {
			promocionRepository.deleteById(idPromocion);
		}else {
			throw new ReviewException("No se puede eliminar la promocion porque no existe en la base de datos");
		}
	}
}
