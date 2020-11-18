package com.review.service;

import java.util.List;

import com.review.bean.Usuario;
import com.review.bean.Usuario.TipoUsuarioEnum;

public interface UsuarioService {
	/**
	 * Método para crear un Usuario. Recibirá instancia de Administrador, CuradorDeContenido o de Espectador. 
	 * Facilitar los atributos del usuario a crear, excepto el idUsuario (que se crea automáticamente).
	 * 
	 * @param usuario El usuario, indicando los atributos con los cuales crear.
	 * @return Un numero distinto de cero si la creacion de Usuario se hizo correctamente
	 */
	
	public Integer crearUsuario(Usuario usuario);
	
	
	/**
	 * Método para editar un usuario. Facilitar el atributo idUsuario para ubicar el usuario a editar, y luego los nuevos valores de los atributos a actualizar.
	 *
	 * @param usuario El usuario, indicando los atributos con los cuales modificar.
	 * @return Un numero distinto de cero si la modificacion de Video se hizo correctamente
	 */
	
	public Integer editarUsuario(Usuario usuario);
	
	
	/**
	 * Método para obtener una lista de usuarios por ciertos filtros. Si no se indican filtros, se obtienen todos los usuarios.
	 * 
	 * @param idUsuario Filtro para indicar que se desean obtener al usuario con este id. Puede ser null.
	 * @param nombre Filtro para indicar que se desean obtener los usuarios con este nombre (o que contenga). Puede ser null.
	 * @param tipoUsuario Filtro para indicar el rol del usuario. Puede ser null, en este caso lista todos los usuarios
	 * @return Lista de usuarios con los filtros indicados 
	 */
	
	public List<Usuario> obtenerUsuario(Integer idUsuario, String nombre, TipoUsuarioEnum tipoUsuario);
	
	
	/**
	 * Método para eliminar un usuario. Facilitar el atributo idUsuario para ubicar al usuario a eliminar.
	 * 
	 * @param idUsuario Número identificador del usuario.
	 * @return Un numero distinto de cero si la eliminacion de Usuario se hizo correctamente
	 */
	public Integer eliminarUsuario(Integer idUsuario);
	
	/**
	 * Método que envia un mensaje por correo o push notificacion al usuario cuyo credencial esta por vencer
	 * 
	 * Para simular el envio de la notificacion se imprimirá en el log. Este metodo debe revisar la fecha de vencimiento de todos los usuarios
	 * y notificarle
	 */
	public void notificarVencimiento();
}
