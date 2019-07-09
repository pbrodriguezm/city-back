# SERVICIOS REST DE CODIGO MOVIL
Se utilizó : Maven, Spark Framework and Hibernate

* Maven
	- En los ficheros .pom se encuentran todas las librerias que se usan en el proyecto y su versión.

* Hibernate
	- Configurado mediante anotaciones JPA.
	- En el fichero persistence.xml hay que ir añadiendo las nuevas entidades que se creen.
	- Existe un DAO genérico que al extender de él ya tendríamos las operaciones básicas. En caso de necesitar consultas específicas se añadirian en el DAO de la propia entidad.

* Spark Framework
	- Se encarga de servir todas las peticiones REST. 

* GSON
	- Para convertir los objetos en JSON y los JSON en objetos necesitamos alguna forma de serializar y deserializar. Para esto existe GSON de Google.

* INSTALACIÓN
	- Clonar el respositorio
	- En eclipse: File --> Import --> "Existing Maven Projects"
	- la base de datos esta en: 3.18.116.129
	- Usuario db: codigo
	- clave bd: ------ T3
	- En fichero persistence.xml poner datos de conexión, es decir, contraseña, nombre de usuario y nombre de la base de datos. En este caso se llama test.

* COMPILAR
	- Desde terminal o desde Eclipse: Run as, Maven Build, colocare en "Goals" clean install, Cada cambio hace lo mismo
	- Ir a la carpeta target del proyecto y tendremos un jar con todo listo para funcionar.

* EJECUTAR
	- java -jar spark-rest.jar
	- Ir al localhost:8080 y el poryecto estará funcionando.
	- Servicio REST de prueba: localhost:8080/persona/id, siendo id el id de un objeto existente en la tabla Persona de la base de datos test.
