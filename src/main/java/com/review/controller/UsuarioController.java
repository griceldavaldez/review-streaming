package com.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.review.bean.Administrador;
import com.review.bean.CuradorDeContenido;
import com.review.bean.Espectador;
import com.review.bean.Usuario;
import com.review.bean.Usuario.EstadoEnum;
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
	 * Método que lista todos los usuarios segun los filtros indicados
	 * @return Lista de usuarios encontrados
	 */
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Usuario> list(
    		@RequestParam(name = "id_usuario",  required = false) Long idUsuario,
    		@RequestParam(name = "nombre",  required = false) String nombre,
    		@RequestParam(name = "rol",  required = false) TipoUsuarioEnum rol,
    		@RequestParam(name = "email", required = false) String email,
    		@RequestParam(name = "estado", required = false) EstadoEnum estado) throws ReviewException{
        try {
			return usuarioService.obtenerUsuario(idUsuario,nombre, rol, email, estado );
        } catch (Exception e) {
			throw new ReviewException("Ocurrió un error inesperado al listar usuarios.");
		}
    }
	
	/**
	 * Método que agrega un nuevo usuario
	 * @throws ReviewException 
	 */
	@RequestMapping(value = "/add-administrador", method = RequestMethod.POST)
    public Administrador addAdministrador(@RequestBody Administrador administrador) throws ReviewException {
			try {
				return usuarioService.crearAdministrador(administrador);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al agregar administrador.");
			}
	}
	
	@RequestMapping(value = "/add-espectador", method = RequestMethod.POST)
    public Espectador addEspectador(@RequestBody Espectador espectador) throws ReviewException {
			try {
				return usuarioService.crearEspectador(espectador);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al agregar espectador.");
			}
	}
	
	@RequestMapping(value = "/add-curador", method = RequestMethod.POST)
    public CuradorDeContenido addCurador(@RequestBody CuradorDeContenido curador) throws ReviewException {
			try {
				return  usuarioService.crearCurador(curador);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al agregar curador.");
			}
	}
	
	@RequestMapping(value = "/convertir-premium", method = RequestMethod.POST)
    public Usuario convertirEspectadorAPremium(@RequestParam(name = "id_usuario",  required = true) Long idUsuario) throws ReviewException {
			try {
				return usuarioService.convertirPremium(idUsuario);
			} catch (ReviewException e1) {
				throw e1;
			} catch (Exception e) {
				throw new ReviewException("Ocurrió un error inesperado al convertir a premium.");
			}
	}

	
	/**
	 * Método que elimina un usuario
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id_usuario",  required = true) Long idUsuario) throws ReviewException  {
		try {
			usuarioService.eliminarUsuario(idUsuario);
		}catch (ReviewException e1) {
			throw e1;
		}catch (Exception e) {
			throw new ReviewException("Ocurrió un error inesperado al eliminar usuario.");
		}
	}
	

	/**
	 * Método que edita un usuario
	 */
	@RequestMapping(value = "/modify-administrador", method = RequestMethod.POST)
    public Administrador modifyAdministrador(@RequestBody Administrador administrador) throws ReviewException{
		try {
			return  usuarioService.editarAdministrador(administrador);
		}catch (ReviewException e1) {
			throw e1;
		}catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/modify-espectador", method = RequestMethod.POST)
    public Espectador modifyEspectador(@RequestBody Espectador espectador) throws ReviewException{
		try {
			return  usuarioService.editarEspectador(espectador);
		}catch (ReviewException e1) {
			throw e1;
		}catch (Exception e) {
			throw e;
		}
	}
	
	@RequestMapping(value = "/modify-curador", method = RequestMethod.POST)
    public CuradorDeContenido modifyCurador(@RequestBody CuradorDeContenido curador) throws ReviewException{
		try {
			return  usuarioService.editarCurador(curador);
		}catch (ReviewException e1) {
			throw e1;
		}catch (Exception e) {
			throw e;
		}
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
	
	/**
	 * Metodo que permite renovar credencial de un usuario
	 * 
	 * @param idUsuario El identificador del usuario
	 * @throws ReviewException
	 */
	@RequestMapping(value = "/renovar-credencial", method = RequestMethod.POST)
	public Usuario renovarCredencial(@RequestParam(name = "id_usuario",  required = true) Long idUsuario) throws ReviewException{
		try {
			return usuarioService.renovarCredencial(idUsuario);
		} catch (ReviewException e1) {
			throw e1;
		} catch (Exception e) {
			throw new ReviewException("Ocurrió un error inesperado al renovar credencial del usuario.");
		}
	}
}
