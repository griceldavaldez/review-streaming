package com.review.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Usuario;
import com.review.bean.Usuario.TipoUsuarioEnum;
import com.review.constants.Constantes;
import com.review.exceptions.ReviewException;
import com.review.repository.UsuarioRepository;
import com.review.service.UsuarioService;
import com.review.utils.EmailUtils;
import com.review.utils.ListarUtils;
import com.review.utils.Utils;
import com.review.utils.ValidarUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario crearUsuario(Usuario usuario) throws ReviewException {
		ValidarUtils.validarUsuario(usuario);
		usuario.setFechaRegistro(new Date());
		usuario.setFechaVencimiento(Utils.sumarDiasDate(usuario.getFechaRegistro(), Constantes.DIAS_VENCIMIENTO));
		return usuarioRepository.save(usuario);

	}

	@Override
	public Usuario editarUsuario(Usuario usuario) {
		// TODO cambiar aqui la fecha de vencimiento, para renovar credencial luego de su vencimiento
		return null;
	}

	@Override
	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum tipoUsuario) {
		return ListarUtils.listar(null, usuarioRepository);
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notificarVencimiento() throws ReviewException {
		try {
			//obtener usuarios con credencial vencida
			List<Usuario> usuarios = usuarioRepository.findExpiredUsersCredential();
			
			if(usuarios != null && !usuarios.isEmpty()) {
				for(Usuario u : usuarios) {
					try {
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
}

