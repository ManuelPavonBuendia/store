# Arquitectura y estructura

El código de Pokémon está separado en capas para mantener las reglas de negocio apartadas de los detalles web y de almacenamiento. La estructura sigue ideas de arquitectura limpia y organiza la funcionalidad por dominio. Se utiliza una arquitectura `Clean` para desacoplar todo lo posible el código y asi los posibles cambios sean lo mínimo

## Capas

### Dominio (`pokemon/domain`)

Contiene el modelo `Pokemon`, los contratos de repositorio y errores del dominio. El modelo incluye `id`, `nombre`, `tipo`, `foto`, `precio` y `createdAt`.

### Aplicación (`pokemon/application`)

Contiene los casos de uso, servicios y comandos para crear, buscar, editar y eliminar Pokémon. Coordina la operación solicitada usando los contratos del dominio.

### Infraestructura (`pokemon/infraestructure`)

Implementa los adaptadores concretos: controlador MVC, DTO de entrada y salida, mapper y repositorio mock.

## Flujo de una petición

En una operación HTTP, `PokemonController` recibe la petición, convierte los datos de transporte con `PokemonMapper` y llama al servicio de aplicación correspondiente. El servicio ejecuta el caso de uso y trabaja con el repositorio definido por el dominio; el adaptador mock resuelve la operación sobre un mapa en memoria.

## Persistencia y datos iniciales

`PokemonRepositoryMockImpl` mantiene los datos en memoria y `PokemonFactory` crea tres registros al iniciar. No hay una base de datos configurada, por lo que los cambios no sobreviven al reinicio.

## Otras rutas relevantes

- `src/main/resources/static/`: formulario HTML estático.
- `src/main/resources/application.properties`: configuración de Spring.
- `src/main/resources/messages.properties`: mensajes de validación.
