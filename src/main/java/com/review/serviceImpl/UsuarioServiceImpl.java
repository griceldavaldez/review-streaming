package com.review.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Espectador;
import com.review.bean.EspectadorPremium;
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
		return usuarioRepository.save(usuario);

	}

	@Override
	public Usuario editarUsuario(Usuario usuario) throws ReviewException {
		if(usuario.getIdUsuario() != null || usuarioRepository.existsById(usuario.getIdUsuario())) {
			return usuarioRepository.save(usuario);
		}else {
			throw new ReviewException("No se puede editar el usuario porque no existe en la base de datos");
		}
	}

	@Override
	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum tipoUsuario, String email, EstadoEnum estado) {
		Usuario c = new Usuario();
		c.setIdUsuario(idUsuario);
		c.setNombre(nombre);
		c.setTipoUsuario(tipoUsuario);
		c.setEmail(email);
		c.setEstado(estado);
		return ListarUtils.listar(c, usuarioRepository);
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
			Optional<Usuario> val = usuarioRepository.findById(idUsuario);
			Usuario usuario = val.get();
			if(TipoUsuarioEnum.ESPECTADOR.equals(usuario.getTipoUsuario())) {
				EspectadorPremium premium = new EspectadorPremium((Espectador) usuario);
				EspectadorPremium c = usuarioRepository.save(premium);
				if(c != null) {
					usuarioRepository.deleteById(idUsuario);
					return c;
				}else {
					throw new ReviewException("No se pudo crear el usuario premium.");
				}
			}else {
				throw new ReviewException("Usuario con ID: " + idUsuario + " no es espectador.");
			}
			
		}else {
			throw new ReviewException("Usuario con ID: " + idUsuario + " no existe." );
		}
		
	}
	
}

