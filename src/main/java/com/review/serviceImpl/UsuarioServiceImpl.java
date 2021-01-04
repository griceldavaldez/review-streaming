package com.review.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Administrador;
import com.review.bean.CuradorDeContenido;
import com.review.bean.Espectador;
import com.review.bean.Usuario;
import com.review.bean.Usuario.EstadoEnum;
import com.review.bean.Usuario.TipoUsuarioEnum;
import com.review.constants.Constantes;
import com.review.exceptions.ReviewException;
import com.review.repository.UsuarioRepository;
import com.review.service.UsuarioService;
import com.review.utils.EmailUtils;
import com.review.utils.ListarUtils;
import com.review.utils.DateUtils;
import com.review.utils.ValidarUtils;

/*
 *Clase que implementa los metodos de la interfaz de UsuarioService
 *
 */

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	/*Metodo para verificar y actualizar atributos de un usuario existente en la base de datos*/
	
	private void actualizarAtributosComunes(Usuario usuario, Usuario usuarioExistente) {
		if(! ValidarUtils.isEmptyString(usuario.getNombre())) {
			usuarioExistente.setNombre(usuario.getNombre());
		}
		if(! ValidarUtils.isEmptyString(usuario.getContrasenha())) {
			usuarioExistente.setContrasenha(usuario.getContrasenha());
		}
		if(! ValidarUtils.isEmptyString(usuario.getEmail())) {
			usuarioExistente.setEmail(usuario.getEmail());
		}	
	}
	

	/*Metodo para obtener una lista de usuarios por ciertos filtros*/
	
	@Override
	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum tipoUsuario, String email, EstadoEnum estado) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		usuario.setNombre(nombre);
		usuario.setTipoUsuario(tipoUsuario);
		usuario.setEmail(email);
		usuario.setEstado(estado);
		return ListarUtils.listar(usuario, usuarioRepository);
	}
	
	/* Metodo para eliminar un usuario*/
	
	@Override
	public void eliminarUsuario(Long idUsuario) throws ReviewException{
			if(idUsuario != null && usuarioRepository.existsById(idUsuario) ) {
				usuarioRepository.deleteById(idUsuario);
			}else {
				throw new ReviewException("No se puede eliminar usuario porque no existe en la base de datos");
			}
	}

	/*Metodo que envia un mensaje por correo o push notification al usuario cuyo credencial esta por expirar.*/
	
	@Override
	public void notificarVencimiento() throws ReviewException {
		try {
			//obtener usuarios con credencial vencida
			List<Usuario> usuarios = usuarioRepository.findExpiredUsersCredential();
			
			if(usuarios != null && !usuarios.isEmpty()) {
				for(Usuario usuarioANotificar : usuarios) {
					try {
						usuarioANotificar.setEstado(EstadoEnum.INACTIVO);
						EmailUtils.notificarVencimientoEmail(usuarioANotificar);
					} catch (Exception e) {
						System.out.println("No se pudo notificar vencimiento al usuario ID: " + usuarioANotificar.getIdUsuario());
					}
				}
			}
		} catch (Exception e) {
			throw new ReviewException("Hubo un problema al notificar vencimiento a los usuarios.");
		}
	}
	
	/*Metodo que renueva la credencial de un usuario*/
	
	@Override
	public Usuario renovarCredencial(Long idUsuario) throws ReviewException {
		if(idUsuario != null && usuarioRepository.existsById(idUsuario)) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(idUsuario);
			Usuario usuarioExistente = recuperarUsuario.get();
			usuarioExistente.setFechaVencimiento(DateUtils.sumarDiasDate(new Date(), Constantes.DIAS_VENCIMIENTO));
			usuarioExistente.setEstado(EstadoEnum.ACTIVO);
			return usuarioRepository.save(usuarioExistente);
		}else {
			throw new ReviewException("No se puede renovar credencial porque el usuario no existe.");
		}
	}

	@Override
	public Usuario convertirPremium(Long idUsuario) throws ReviewException {
		if(idUsuario != null && usuarioRepository.existsById(idUsuario) ) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(idUsuario);
			Espectador usuarioExistente = (Espectador) recuperarUsuario.get();
			if(TipoUsuarioEnum.ESPECTADOR.equals(usuarioExistente.getTipoUsuario())) {
				usuarioExistente.setIsPremium(true);
				return usuarioRepository.save(usuarioExistente);
			}else {
				throw new ReviewException("Usuario con ID: " + idUsuario + " no es espectador.");
			}
		}else {
			throw new ReviewException("Usuario con ID: " + idUsuario + " no existe en la base de datos." );
		}
		
	}

	/* Metodo para editar un usuario administrador*/
	
	@Override
	public Administrador editarAdministrador(Administrador administrador) throws ReviewException {
		if(administrador.getIdUsuario() != null && usuarioRepository.existsById(administrador.getIdUsuario())) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(administrador.getIdUsuario());
			Administrador administradorExistente = (Administrador) recuperarUsuario.get();
			actualizarAtributosComunes(administrador, administradorExistente);
			return usuarioRepository.save(administradorExistente);
		}else {
			throw new ReviewException("No se puede editar el administrador porque no existe en la base de datos.");
		}
	}

	/* Metodo para editar un usuario curador de contenido*/
	
	@Override
	public CuradorDeContenido editarCurador(CuradorDeContenido curador) throws ReviewException {
		if(curador.getIdUsuario() != null && usuarioRepository.existsById(curador.getIdUsuario())) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(curador.getIdUsuario());
			CuradorDeContenido curadorExistente = (CuradorDeContenido) recuperarUsuario.get();
			actualizarAtributosComunes(curador, curadorExistente);
			if(curador.getCategoriasAModerar() != null || ! curador.getCategoriasAModerar().isEmpty()) {
				curadorExistente.setCategoriasAModerar(curador.getCategoriasAModerar());
			}
			return usuarioRepository.save(curadorExistente);
		}else {
			throw new ReviewException("No se puede editar el curador porque no existe en la base de datos.");
		}
	}

	/* Metodo para editar un usuario espectador*/
	
	@Override
	public Espectador editarEspectador(Espectador espectador) throws ReviewException {
		if(espectador.getIdUsuario() != null && usuarioRepository.existsById(espectador.getIdUsuario())) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(espectador.getIdUsuario());
			Espectador espectadorExistente = (Espectador) recuperarUsuario.get();
			actualizarAtributosComunes(espectador, espectadorExistente);
			if(espectadorExistente.getIsPremium() && espectador.getPromociones()!= null) {
				espectadorExistente.setPromociones (espectador.getPromociones());
			}
			return usuarioRepository.save(espectadorExistente);
		}else {
			throw new ReviewException("No se puede editar el curador porque no existe en la base de datos.");
		}
		
	
	}

	/* Metodo para crear un usuario administrador*/
	
	@Override
	public Administrador crearAdministrador(Administrador administrador) throws ReviewException {
		ValidarUtils.validarCreacionUsuario(administrador);
		administrador.setEstado(EstadoEnum.ACTIVO);
		administrador.setFechaRegistro(new Date());
		administrador.setFechaVencimiento(DateUtils.sumarDiasDate(administrador.getFechaRegistro(), Constantes.DIAS_VENCIMIENTO));
		return usuarioRepository.save(administrador);
	}
	
	/* Metodo para crear un usuario espectador*/
	
	@Override
	public Espectador crearEspectador(Espectador espectador) throws ReviewException {
		ValidarUtils.validarCreacionUsuario(espectador);
		espectador.setEstado(EstadoEnum.ACTIVO);
		espectador.setFechaRegistro(new Date());
		espectador.setFechaVencimiento(DateUtils.sumarDiasDate(espectador.getFechaRegistro(), Constantes.DIAS_VENCIMIENTO));
		/*Agregamos este bloque de condigo para asegurarnos de que si recibe una instancia de Espectador
		 no pueda setear los atributos isPremium y Lista de promociones, ya que esto solo corresponde
		 a un Espectador Premium y para tener derecho a estos campos debe el Espectador debe convertirse a premium necesariamente*/
		if(espectador.getPromociones() != null || espectador.getIsPremium() != false) {
			espectador.setPromociones(null);
			espectador.setIsPremium(false);
		}
		return usuarioRepository.save(espectador);
	}
	
	/* Metodo para crear un usuario curador de contenido*/
	
	@Override
	public CuradorDeContenido crearCurador(CuradorDeContenido curador) throws ReviewException {
		ValidarUtils.validarCreacionUsuario(curador);
		curador.setEstado(EstadoEnum.ACTIVO);
		curador.setFechaRegistro(new Date());
		curador.setFechaVencimiento(DateUtils.sumarDiasDate(curador.getFechaRegistro(), Constantes.DIAS_VENCIMIENTO));
		return usuarioRepository.save(curador);
	}
	
}

