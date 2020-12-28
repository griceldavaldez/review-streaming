package com.review.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.review.bean.Usuario;
import com.review.bean.Usuario.TipoUsuarioEnum;
import com.review.exceptions.ReviewException;
import com.review.repository.UsuarioRepository;
import com.review.service.UsuarioService;
import com.review.utils.ValidarUtils;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario crearUsuario(Usuario usuario) throws ReviewException {
		ValidarUtils.validarUsuario(usuario);
		return usuarioRepository.save(usuario);

	}

	@Override
	public Usuario editarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum tipoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarUsuario(Long idUsuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void notificarVencimiento() {
		// TODO Auto-generated method stub

	}

}
