package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.bean.Usuario;
import com.review.bean.Usuario.TipoUsuarioEnum;
import com.review.constants.ApiPaths;
import com.review.exceptions.ReviewException;
import com.review.service.UsuarioService;

@RestController
@RequestMapping(ApiPaths.USUARIO)
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	/**
	 * Método que lista todos los usuarios
	 * 
	 * @return Lista de usuarios
	 */
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Usuario> list(
    		@RequestParam(name = "id_usuario",  required = false) Long idUsuario,
    		@RequestParam(name = "nombre",  required = false) String nombre,
    		@RequestParam(name = "rol",  required = false) TipoUsuarioEnum rol) {
        return usuarioService.obtenerUsuario(idUsuario,nombre, rol );
    }
	
	/**
	 * Método que agrega un nuevo usuario
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public Usuario add(@RequestBody Usuario usuario) throws ReviewException {
			try {
				return usuarioService.crearUsuario(usuario);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al agregar usuario.");
			}
	}
	
	/**
	 * Método que elimina un usuario
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id_usuario",  required = false) Long idUsuario) {
		usuarioService.eliminarUsuario(idUsuario);
	}
	

	/**
	 * Método que edita un usuario
	 */
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
    public Usuario modify(@RequestBody Usuario usuario) {
			return  usuarioService.editarUsuario(usuario);
	}
	
	/**
	 * Notificar vencimiento a usuarios
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/notificar-vencimiento-usuarios", method = RequestMethod.GET)
    public void notificarVencimientoUsuarios() throws ReviewException {
			try {
				usuarioService.notificarVencimiento();
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				System.out.println(e);
				throw new ReviewException("Ocurrió un error inesperado al notificar vencimiento a usuarios.");
			}
	}
}
