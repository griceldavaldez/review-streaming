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

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario crearUsuario(Usuario usuario) throws ReviewException {
		ValidarUtils.validarCreacionUsuario(usuario);
		usuario.setEstado(EstadoEnum.ACTIVO);
		usuario.setFechaRegistro(new Date());
		usuario.setFechaVencimiento(DateUtils.sumarDiasDate(usuario.getFechaRegistro(), Constantes.DIAS_VENCIMIENTO));
		/*Agregamos este bloque de condigo para asegurarnos de que si recibe una instancia de Espectador
		 no pueda setear los atributos isPremium y Lista de promociones, ya que esto solo corresponde
		 a un Espectador Premium y para tener derecho a estos campos debe el Espectador debe convertirse a premium necesariamente*/
		if(TipoUsuarioEnum.ESPECTADOR.equals(usuario.getTipoUsuario())) {
			Espectador espectador = (Espectador)  usuario;
			if(espectador.getPromociones() != null || espectador.getIsPremium() != false) {
				espectador.setPromociones(null);
				espectador.setIsPremium(false);
				return usuarioRepository.save(espectador);
			}
		}
		return usuarioRepository.save(usuario);

	}

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
	
	@Override
	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum tipoUsuario, String email, EstadoEnum estado) {
		Usuario usuarioNuevo = new Usuario();
		usuarioNuevo.setIdUsuario(idUsuario);
		usuarioNuevo.setNombre(nombre);
		usuarioNuevo.setTipoUsuario(tipoUsuario);
		usuarioNuevo.setEmail(email);
		usuarioNuevo.setEstado(estado);
		return ListarUtils.listar(usuarioNuevo, usuarioRepository);
	}
	
	
	@Override
	public void eliminarUsuario(Long idUsuario) throws ReviewException{
			if(idUsuario != null && usuarioRepository.existsById(idUsuario) ) {
				usuarioRepository.deleteById(idUsuario);
			}else {
				throw new ReviewException("No se puede eliminar usuario porque no existe en la base de datos");
			}
	}

	@Override
	public void notificarVencimiento() throws ReviewException {
		try {
			//obtener usuarios con credencial vencida
			List<Usuario> usuarios = usuarioRepository.findExpiredUsersCredential();
			
			if(usuarios != null && !usuarios.isEmpty()) {
				for(Usuario u : usuarios) {
					try {
						u.setEstado(EstadoEnum.INACTIVO);
						EmailUtils.notificarVencimientoEmail(u);
					} catch (Exception e) {
						System.out.println("No se pudo notificar vencimiento al usuario ID: " + u.getIdUsuario());
					}
				}
			}
		} catch (Exception e) {
			throw new ReviewException("Hubo un problema al notificar vencimiento a los usuarios.");
		}
	}

	@Override
	public Usuario renovarCredencial(Long idUsuario) throws ReviewException {
		if(idUsuario != null && usuarioRepository.existsById(idUsuario)) {
			Optional<Usuario> val = usuarioRepository.findById(idUsuario);
			Usuario usuario = val.get();
			usuario.setFechaVencimiento(DateUtils.sumarDiasDate(new Date(), Constantes.DIAS_VENCIMIENTO));
			usuario.setEstado(EstadoEnum.ACTIVO);
			return usuarioRepository.save(usuario);
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

	
	@Override
	public CuradorDeContenido editarCurador(CuradorDeContenido curador) throws ReviewException {
		if(curador.getIdUsuario() != null && usuarioRepository.existsById(curador.getIdUsuario())) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(curador.getIdUsuario());
			CuradorDeContenido curadorExistente = (CuradorDeContenido) recuperarUsuario.get();
			actualizarAtributosComunes(curador, curadorExistente);
			if(curador.getCatergoriasAModerar() != null || ! curador.getCatergoriasAModerar().isEmpty()) {
				curadorExistente.setCatergoriasAModerar(curador.getCatergoriasAModerar());
			}
			return usuarioRepository.save(curadorExistente);
		}else {
			throw new ReviewException("No se puede editar el curador porque no existe en la base de datos.");
		}
	}

	
	@Override
	public Espectador editarEspectador(Espectador espectador) throws ReviewException {
		if(espectador.getIdUsuario() != null && usuarioRepository.existsById(espectador.getIdUsuario())) {
			Optional<Usuario> recuperarUsuario = usuarioRepository.findById(espectador.getIdUsuario());
			Espectador espectadorExistente = (Espectador) recuperarUsuario.get();
			actualizarAtributosComunes(espectador, espectadorExistente);
			if(espectador.getIsPremium()) {
				espectadorExistente.setPromociones (espectador.getPromociones());
			}
			return usuarioRepository.save(espectadorExistente);
		}else {
			throw new ReviewException("No se puede editar el curador porque no existe en la base de datos.");
		}
		
	
	}
	
}

