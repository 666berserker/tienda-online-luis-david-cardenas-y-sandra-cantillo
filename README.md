# Proyecto Tienda Online - Taller Parcial

## Integrantes  
Luis David Cárdenas y Sandra Cantillo

Backend API REST en Spring Boot (Java 17, Gradle - Groovy).
## Tecnologías

- Java 17
- Spring Boot 3.2.x (compatible con Java 17; no existe Spring Boot 4 estable a la fecha)
- Spring Data JPA
- Spring Security + JWT
- MySQL
- Gradle (Groovy)

## Configuración de base de datos

La base de datos **tienda_online** y sus tablas deben existir previamente.

En `src/main/resources/application.properties` configura tu usuario y contraseña de MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tienda_online?useSSL=false&serverTimezone=UTC
spring.datasource.username=tu_usuario_mysql
spring.datasource.password=tu_contraseña_mysql
```

El puerto del backend es:

```properties
server.port=9093
```

Al iniciar la aplicación:

- Se insertan datos iniciales mediante `data.sql` (usuarios, una categoría, productos y comentarios).
- La clase `DataInitializer` encripta las contraseñas en la tabla `Usuario` usando **BCrypt** si aún están en texto plano.

## Ejecución

Desde la raíz del proyecto:

### En Windows

```bash
gradlew.bat bootRun
```

También puedes generar el JAR:

```bash
./gradlew clean build
java -jar build/libs/tienda-online-0.0.1-SNAPSHOT.jar
```

## Endpoints principales

### Autenticación (JWT)

### Productos (público, sin seguridad)

### Comentarios (público, sin seguridad)

### Carrito de compras (requiere JWT)

## Notas

- El modelo de datos usa exactamente las tablas dadas en el script (`Usuario`, `Categoria`, `Producto`, `Comentarios`, `CarritoDeCompras`, `Carrito_Productos`, `OrdenDeCompra`, `Orden_Productos`).
- El proyecto está listo para ser importado en IntelliJ IDEA / Eclipse como proyecto Gradle.
