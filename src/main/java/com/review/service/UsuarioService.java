package com.review.service;

import java.util.List;

import com.review.bean.Administrador;
import com.review.bean.CuradorDeContenido;
import com.review.bean.Espectador;
import com.review.bean.Usuario;
import com.review.bean.Usuario.EstadoEnum;
import com.review.bean.Usuario.TipoUsuarioEnum;
import com.review.exceptions.ReviewException;

public interface UsuarioService {
	
	/**
	 * Metodo para crear un usuario administrador.
	 * 
	 * @param administrador El usuario administrador, indicando los atributos con los cuales crear.
	 * @return Administrador creado
	 * @throws ReviewException 
	 */
	
	public Administrador crearAdministrador(Administrador administrador) throws ReviewException;
	
	/**
	 * Metodo para crear un usuario espectador.
	 * 
	 * @param espectador El usuario espectador, indicando los atributos con los cuales crear.
	 * @return Espectador creado
	 * @throws ReviewException 
	 */
	
	public Espectador crearEspectador(Espectador espectador) throws ReviewException;
	
	/**
	 * Metodo para crear un usuario curador de contenido.
	 * 
	 * @param curador El usuario curador, indicando los atributos con los cuales crear.
	 * @return Curador creado
	 * @throws ReviewException 
	 */
	
	public CuradorDeContenido crearCurador(CuradorDeContenido curador) throws ReviewException;
	
	/**
	 * Metodo para editar un usuario administrador. Facilitar el atributo idUsuario para ubicar el 
	 * usuario a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @return Administrador modificado
	 */
	
	public Administrador editarAdministrador(Administrador administrador) throws ReviewException;
	
	/**
	 * Metodo para editar un usuario curador de contenido. Facilitar el atributo idUsuario para ubicar el 
	 * usuario a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @return CuradorDeContenido modificado
	 */
	
	public CuradorDeContenido editarCurador(CuradorDeContenido curador) throws ReviewException;
	
	/**
	 * Metodo para editar un usuario espectador. Facilitar el atributo idUsuario para ubicar el 
	 * usuario a editar, y luego los nuevos valores de los atributos a actualizar.
	 * 
	 * @return Espectador modificado
	 */
	
	public Espectador editarEspectador(Espectador espectador) throws ReviewException;
	
	
	/**
	 * Metodo para obtener una lista de usuarios por ciertos filtros. Si no se indican filtros, se obtienen todos los usuarios.
	 * 
	 * @param idUsuario Filtro para indicar que se desean obtener al usuario con este id. Puede ser null.
	 * @param nombre Filtro para indicar que se desean obtener los usuarios con este nombre (o que contenga). Puede ser null.
	 * @param rol Filtro para indicar el rol del usuario. Puede ser null.
	 * @param email Filtro para indicar el email del usuario. Puede ser null.
	 * @param estado Filtro para indicar el estado del usuario. Puede ser null.
	 * @return Lista de usuarios con los filtros indicados 
	 */

	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum rol, String email, EstadoEnum estado);
	
	
	/**
	 * Metodo para eliminar un usuario. Facilitar el atributo idUsuario para ubicar al usuario a eliminar.
	 * 
	 * @param idUsuario Numero identificador del usuario.
	 * @throws ReviewException
	 */
	
	public void eliminarUsuario(Long idUsuario) throws ReviewException;
	
	/**
	 * Metodo que envia un mensaje por correo o push notification al usuario cuyo credencial esta por expirar.
	 * 
	 * Para simular el envio de la notificacion se imprimira en el log. Este metodo debe revisar la fecha de vencimiento de todos los usuarios
	 * y notificarle
	 * @throws ReviewException 
	 */
	public void notificarVencimiento() throws ReviewException;
	
	
	/**
	 * Metodo que renueva la credencial de un usuario
	 * 
	 * @param idUsuario
	 * @throws ReviewException 
	 */
	
	public Usuario renovarCredencial(Long idUsuario) throws ReviewException;


	/**
	 * Metodo que convierte un espectador a premium
	 * 
	 * @param idUsuario
	 * @throws ReviewException
	 */
	public Usuario convertirPremium(Long idUsuario) throws ReviewException;

}
