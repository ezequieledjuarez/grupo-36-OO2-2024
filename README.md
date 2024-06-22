# Sistema De Gestión de Stock

Versión de Java requerida >17

Versión de Maven requerida >3.6.X

Antes de levantar el proyecto modificar en el archivo application.yml los campos url, username y password que se encuentran en datasource

url: ubicación de la base de datos 

	ej: jdbc:{{motor}}://{{host}}:{{port}}/{{bd}}
		
		{{motor}}: motor de base de datos.
			ej: mysql, postgresql.
		{{host}}: Sitio donde se encuentra alojada la base de datos.
			ej: localhost
		{{port}}: Puerto en el que se encuentra levantada la base de de datos.
			ej: 3306, 5432
		{{bd}}: Nombre de la base de datos
		
Para levantar una base de datos en MySQL la sentencia que se debe ejecutar es la siguiente: 

**CREATE SCHEMA {{bd}} ;**

Comandos Maven para levantar el proyecto desde una consola de comandos 

La ubicación donde se levanta la consola debe ser a la altura del archivo pom.xml 

** mvn clean package **

** mvn mvn spring-boot:run**

La documentación del proyecto puede visualizarse una vez levantado el proyecto en las siguientes rutas:

* **{{protocol}}://{{host}}:{{port}}/v3/api-docs**

* **{{protocol}}://{{host}}:{{port}}/swagger-ui/index.html**