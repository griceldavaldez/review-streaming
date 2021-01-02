# review-streaming
Sistema de recomendación para streamings.

Para hacer funcionar el sistema:
-En el insomnia, importar el archivo .json que ya contiene los requests necesarios.
-Importar la base de datos y colocarla en el mismo path que se indica en el archivo application.properties del sts, con el nombre spring.datasource.url="".
De esta forma, ya hay datos cargados con los que se pueden trabajar para hacer las pruebas de CRUD.

*Requests*:
Todos los requests se hacen a la direccion principal localhost:8080/api/lp3/, agregando a cada una una parte más de la direccion. 

-Editar administrador:
Request de tipo POST. Se agrega usuario/modify-administrador a la direccion principal.
Se envia una lista en formato JSON con el idUsuario, modificando el campo que se desee, por ejemplo nombre, contraseña o email. No es necesario incluir todos los campos para realizar la modificacion.

-Editar pelicula:
Request de tipo POST. Se agrega video/modify-pelicula a la direccion principal.
Se envia una lista en formato JSON con el idVideo, modificando el campo que se desee, por ejemplo titulo o descripcion. No es necesario incluir todos los campos para realizar la modificacion.


-Listar videos:
Request de tipo GET. Se agrega video/list a la direccion principal. En la opcion "Query" del Insomnia se pueden agregar filtros, como el idVideo, tipoVideo, etc. Esto modifica el URL agregando ?id_video=<>. Se pueden agregar varios filtros al mismo tiempo, como id, titulo, tipo, etc. Si no se gregan filtros se listan todos los videos.

-Editar serie:
Request de tipo POST. Se agrega video/modify-serie a la direccion principal. Se envia una lista en formato JSON con el idVideo, modificando el campo que se desee, por ejemplo titulo o descripcion. No es necesario incluir todos los campos para realizar la modificacion.

-Renovar credencial:
Request de tipo POST. Se agrega usuario/renovar-credencial. Utiliza el idUsuario para 
filtrar.

-Notificar vencimiento:
Request de tipo GET. Se agrega usuario/notificar-vencimiento-usuarios a la direccion principal. Se imprime en la consola (no en insomnia) el mensaje que se envia al usuario cuyas credenciales estan vencidas.

-Editar curador
Request de tipo POST. Se agrega usuario/modify-curador a la direccion principal. Se envia una lista en formato JSON con el idUsuario, modificando el campo que se desee, en este caso las opciones son solo las categorias a moderar. No es necesario incluir todos los campos para realizar la modificacion.

-Editar espectador:
Request de tipo POST. Se agrega usuario/modify-espectador a la direccion principal. Se envia una lista en formato JSON con el idUsuario, modificando el campo que se desee, por ejemplo las promociones a las que puede acceder el espectador. No es necesario incluir todos los campos para realizar la modificacion.

-Crear curador:
Request de tipo POST. Se agrega usuario/add-curador a la direccion principal. Se envia en formato JSON una lista de los datos basicos para crear un curador, como nombre, contraseña e email, ademas de las categorias a moderar.

-Eliminar usuario:
Request de tipo DEL. Se agrega usuario/delete a la direccion principal.
Se envia en formato JSON el idUsuario del que se desea eliminar. 

-Listar usuarios:
Request de tipo POST. Se agrega usuario/list a la direccion principal. Con la opcion de "Query" del Insomnia se pueden agregar filtros como el id_usuario, estado, rol, etc. Esto agrega al URL los filtros, como ?id_usuario=<>. Si no se le pasan filtros, retorna todos los usuarios. 

-Eliminar promocion:
Request de tipo DEL. Se agrega promocion/delete a la direccion principal. Se envia en formato JSON el idPromocion de la que se desea eliminar. 

-Editar promocion:
Request de tipo POST. Se agrega promocion/modify a la direccion principal. Se envia una lista en formato JSON con el idPromocion, modificando el campo que se desee, por ejemplo la descripcion de la promocion. 

-Listar promociones: 
Request de tipo GET. Se agrega promocion/list a la direccion principal. Con la opcion de "Query" del insomnia se pueden elegir y modificar los filtros para listar las promociones, como por ejemplo el id o el tipo. Esto agrega al URL el filtro, como por ejemplo ?id_promocion=<>. Si no se agregan filtros se listan todas.

-Eliminar sitio:
Request de tipo DEL. Se agrega sitio/delete a la direccion principal. Se envia en formato JSON el idPromocion de la que se desea eliminar. 

-Crear pelicula:
Request de tipo POST. Se agrega video/add-pelicula a la direccion principal. Se envia en formato JSON la descripcion de la pelicula, su nombre,categoria, etc.

-Crear promocion:
Request de tipo POST. Se agrega promocion/add a la direccion principal. Se envia en formato JSON el tipo de promocion y su descripcion.

-Convertir a Premium:
Request de tipo POST. Se agrega usuario/convertir-premium a la direccion principal. En la opcion de "Query" del Insomnia se especifica el id del usuario que se desea convertir en premium. 

-Crear Espectador:
Request de tipo POST. Se agrega usuario/add-espectador a la direccion principal. Se envia una lista en formato JSON con los datos del usuario a ser creado. No se puede crear un usuario premium directamente ni agregarle promociones, sino que es necesario usar el request "Convertir a Premium" primero, y luego podran agregarse promociones.

-Crear administrador:
Request de tipo POST. Se agrega usuario/add-administrador a la direccion principal. Se envia una lista en formato JSON con los datos necesarios para crear un usuario, o sea nombre, contraseña e email. 

-Editar categoria:
Request de tipo POST. Se agrega categoria/modify a la direccion principal. Se envia una lista en formato JSON con la categoria que se desea modificar, con el id y la descripcion.

-Listar sitios:
Request de tipo GET. Se agrega sitio/list a la direccion principal. Con la opcion de "Query" del Insomnia se pueden agregar filtros para listar. Por ejemplo si se marca la opcion de id_sitio_review 1, se agrega al URL ?id_sitio_review=1. Si no se agregan filtros, se listan todos los sitios.

-Eliminar categoria:
Request de tipo DEL. Se agrega categoria/delete a la direccion principal. Con la opcion de "Query" se marca el id de la categoria que se desea eliminar, lo que agrega ?id_categoria=<> al URL. 

-Listar categorias:
Request de tipo GET. Se agrega categoria /list a la direccion principal. Con la opcion de "Query" se pueden agregar filtros a la busqueda como por ejemplo el id, lo que agrega ?id_categoria=<> a la URL. Si no se especifican filtros se listan todas las categorias. 

-Crear categoria:
Request de tipo POST. Se agrega categoria/add a la direccion principal. Se envia en formato JSON la descripcion de la categoria que se desea crear.

-Crear sitio:
Request de tipo POST. Se agrega sitio/add a la direccion principal. Se envia en formato JSON el nombre y el puntaje maximo del sitio que se puede crear.

-Editar sitio:
Request de tipo POST. Se agrega sitio/modify a la direccion principal. Se envia en formato JSON el id de la categoria a modificar y el campo modificado.

-Crear serie:
Request de tipo POST. Se agrega video/add-serie a la direccion principal. Se envia en formato JSON los datos necesarios para crear una serie, por ejemploi titulo, descripcion y puntajes.

