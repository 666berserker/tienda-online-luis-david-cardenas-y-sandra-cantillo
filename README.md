
# Proyecto Tienda Online - Taller Parcial

Backend API REST en Spring Boot (Java 17, Gradle - Groovy) para la plataforma de tienda online.

## Tecnologías

- Java 17
- Spring Boot 3.2.x (compatible con Java 17; no existe Spring Boot 4 estable a la fecha)
- Spring Data JPA
- Spring Security + JWT
- MySQL
- Gradle (Groovy)

## Configuración de base de datos

La base de datos **tienda_online** y sus tablas deben existir previamente, creadas con el script que te entregó el docente.

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

### En Linux / macOS

```bash
./gradlew bootRun
```

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

- `POST /api/auth/login`

Body JSON:

```json
{
  "correoElectronico": "juan.perez@email.com",
  "password": "Qwerty123"
}
```

Devuelve:

```json
{
  "token": "Bearer-Token-JWT..."
}
```

Usa el token en el header:

```http
Authorization: Bearer <token>
```

### Productos (público, sin seguridad)

- `GET /api/productos/bajo-stock?maxStock=15`  
  Lista todos los productos con stock menor o igual a `maxStock`.

### Comentarios (público, sin seguridad)

- `GET /api/comentarios/desde?fecha=2025-05-01T00:00:00`  
  Lista los comentarios cuya fecha sea **posterior** al parámetro `fecha` (formato ISO `yyyy-MM-dd'T'HH:mm:ss`).

### Carrito de compras (requiere JWT)

- `POST /api/carritos`  
  Crea un carrito para el usuario autenticado, descuenta stock y calcula subtotal e impuestos.

Body de ejemplo:

```json
{
  "items": [
    { "idProducto": 1, "cantidad": 2 },
    { "idProducto": 3, "cantidad": 1 }
  ]
}
```

- `GET /api/carritos/{idCarrito}/productos`  
  Lista los productos de un carrito **si el carrito pertenece al usuario autenticado**.

## Notas

- El modelo de datos usa exactamente las tablas dadas en el script (`Usuario`, `Categoria`, `Producto`, `Comentarios`, `CarritoDeCompras`, `Carrito_Productos`, `OrdenDeCompra`, `Orden_Productos`).
- El proyecto está listo para ser importado en IntelliJ IDEA / Eclipse como proyecto Gradle.
