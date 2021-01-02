# review-streaming
Sistema de recomendación para streamings.

Para hacer funcionar el sistema:
-En el insomnia, importar el archivo .json que ya contiene los requests necesarios.
-Importar la base de datos y colocarla en el mismo path que se indica en el archivo application.properties del sts, con el nombre spring.datasource.url="".
De esta forma, ya hay datos cargados con los que se pueden trabajar para hacer las pruebas de CRUD.

*Resquests*:
Todos los requests se hacen a la direccion principal localhost:8080/api/lp3/, agregando a cada una una parte más de la direccion. 

-Editar administrador:
Request de tipo POST. Se agrega usuario/modify-administrador a la direccion principal.
Se envia una lista en formato JSON con el idUsuario, modificando el campo que se desee, por ejemplo nombre, contraseña o email. No es necesario incluir todos los campos para realizar la modificacion.

-Editar pelicula:
Request de tipo POST. Se agrega video/modify-pelicula a la direccion principal.
Se envia una lista en formato JSON con el idVideo, modificando el campo que se desee, por ejemplo titulo o descripcion. No es necesario incluir todos los campos para realizar la modificacion.


-Listar videos: //revisar tambien
Request de tipo GET. Se envia una lista en formato JSON con los filtros que se desee aplicar para listar, por ejemplo, poner tipoVideo: "PELICULA". 

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
//revisarrrr

-Eliminar promocion:
Request de tipo DEL. Se agrega promocion/delete a la direccion principal. Se envia en formato JSON el idPromocion de la que se desea eliminar. 

-Editar promocion:
Request de tipo POST. Se agrega promocion/modify a la direccion principal. Se envia una lista en formato JSON con el idPromocion, modificando el campo que se desee, por ejemplo la descripcion de la promocion. 

-Listar promociones: //revisar
Request de tipo GET. Se agrega promocion/list a la direccion principal. Con la opcion de "Query" del insomnia se pueden elegir y modificar los filtros para listar las promocinoes. 

-Eliminar sitio:
Request de tipo DEL. Se agrega sitio/delete a la direccion principal. Se envia en formato JSON el idPromocion de la que se desea eliminar. 

-Crear pelicula:
Request de tipo POST. Se agrega video/add-pelicula a la direccion principal. Se envia en formato JSON la descripcion de la pelicula, su nombre,categoria, etc.

-Crear promocion:
Request de tipo POST. Se agrega promocion/add a la direccion principal. Se envia en formato JSON el tipo de promocion y su descripcion.

-Convertir a premium:
-Crear Espectador:
-Crear administrador:
-Editar categoria:
-Listar sitios:
-Eliminar categoria:
-Listar categorias:
-Crear categoria:
-Crear sitio:
-Editar sitio:
-Crear serie:
