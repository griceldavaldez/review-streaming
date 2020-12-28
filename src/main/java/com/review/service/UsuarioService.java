package com.review.service;

import java.util.List;

import com.review.bean.Usuario;
import com.review.bean.Usuario.TipoUsuarioEnum;
import com.review.exceptions.ReviewException;

public interface UsuarioService {
	/**
	 * Metodo para crear un Usuario. Recibir instancia de Administrador, CuradorDeContenido o de Espectador. 
	 * Facilitar los atributos del usuario a crear, excepto el idUsuario (que se crea automaticamente).
	 * 
	 * @param usuario El usuario, indicando los atributos con los cuales crear.
	 * @return Usuario creado
	 * @throws ReviewException 
	 */
	
	public Usuario crearUsuario(Usuario usuario) throws ReviewException;
	
	
	/**
	 * Metodo para editar un usuario. Facilitar el atributo idUsuario para ubicar el usuario a editar, y luego los nuevos valores de los atributos a actualizar.
	 *
	 * @param usuario El usuario, indicando los atributos con los cuales modificar, 
	 * @return Usuario modificado
	 */
	
	public Usuario editarUsuario(Usuario usuario);
	
	
	/**
	 * Metodo para obtener una lista de usuarios por ciertos filtros. Si no se indican filtros, se obtienen todos los usuarios.
	 * 
	 * @param idUsuario Filtro para indicar que se desean obtener al usuario con este id. Puede ser null.
	 * @param nombre Filtro para indicar que se desean obtener los usuarios con este nombre (o que contenga). Puede ser null.
	 * @param tipoUsuario Filtro para indicar el rol del usuario. Puede ser null, en este caso lista todos los usuarios
	 * @return Lista de usuarios con los filtros indicados 
	 */
	
	public List<Usuario> obtenerUsuario(Long idUsuario, String nombre, TipoUsuarioEnum rol);
	
	
	/**
	 * Metodo para eliminar un usuario. Facilitar el atributo idUsuario para ubicar al usuario a eliminar.
	 * 
	 * @param idUsuario Numero identificador del usuario.
	 */
	public void eliminarUsuario(Long idUsuario);
	
	/**
	 * Metodo que envia un mensaje por correo o push notificacion al usuario cuyo credencial esta por vencer
	 * 
	 * Para simular el envio de la notificacion se imprimira en el log. Este metodo debe revisar la fecha de vencimiento de todos los usuarios
	 * y notificarle
	 */
	public void notificarVencimiento();
}
