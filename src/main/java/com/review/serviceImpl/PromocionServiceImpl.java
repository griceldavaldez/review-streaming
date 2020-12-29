package com.review.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Promocion;
import com.review.bean.TipoPromocion;
import com.review.exceptions.ReviewException;
import com.review.repository.PromocionRepository;
import com.review.service.PromocionService;
import com.review.utils.ListarUtils;
import com.review.utils.ValidarUtils;

@Service
public class PromocionServiceImpl implements PromocionService{

	@Autowired
	private PromocionRepository promocionRepository; 
	
	@Override
	public Promocion crearPromocion(Promocion promocion) throws ReviewException{
		ValidarUtils.validarPromocion(promocion);
		return promocionRepository.save(promocion);
	}
	
	@Override
	public Promocion editarPromocion(Promocion promocion) throws ReviewException{
		if(promocion.getIdPromocion() != null && promocionRepository.existsById(promocion.getIdPromocion())){
			Optional<Promocion> val = promocionRepository.findById(promocion.getIdPromocion());
			Promocion promocionExistente = val.get();
			if(! ValidarUtils.isEmptyString(promocion.getDescripcionPromocion())) {
				promocionExistente.setDescripcionPromocion(promocion.getDescripcionPromocion());
			}
			if(! ValidarUtils.isEmptyString(promocion.getTipoPromocion().toString())) {
				promocionExistente.setTipoPromocion(promocion.getTipoPromocion());
			}
			return promocionRepository.save(promocionExistente);
		}else {
			throw new ReviewException("No se puede editar la promocion porque no existe en la base de datos");
		}
	}
	
	public List<Promocion> obtenerPromociones(Long idPromocion, TipoPromocion tipoPromocion) throws ReviewException{
		Promocion promocion=new Promocion();
		promocion.setIdPromocion(idPromocion);
		promocion.setTipoPromocion(tipoPromocion);
		return ListarUtils.listar(promocion, promocionRepository);
	}
	
	public void eliminarPromocion(Long idPromocion) throws ReviewException{
		if(idPromocion != null && promocionRepository.existsById(idPromocion)) {
			promocionRepository.deleteById(idPromocion);
		}else {
			throw new ReviewException("No se puede eliminar la promocion porque no esta en la base de datos");
		}
	}
}
