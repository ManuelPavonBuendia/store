# Tienda de pokémon

## ¿Qué es este proyecto?

Es una aplicación Java con Spring Boot para gestionar un catálogo de Pokémon. Actualmente permite listar, crear, editar y eliminar elementos.
Los datos se mantienen en un repositorio mock en memoria y se precargan tres Pokémon de ejemplo. Al reiniciar la aplicación, se recupera el catálogo inicial.

## Empezar

Requisitos: Java 17. El repositorio incluye Maven Wrapper.

```bash
./mvnw spring-boot:run
```

En Windows:

```bat
mvnw.cmd spring-boot:run
```

La aplicación usa el puerto 8080 por defecto. El formulario estático para crear un Pokémon se utiliza en `/formulario-crear-pokemon.html`.

## Documentación detallada

- [Arquitectura y estructura del código](doc/arquitectura.md): capas, paquetes y flujo de una petición.
- [API y ejemplos](doc/api.md): rutas, formatos de entrada, validaciones y comandos `curl`.
- [Ejecución y desarrollo](doc/desarrollo.md): requisitos, comandos Maven Wrapper y notas para contribuir.

## Tecnologías principales

- Java 17
- Spring Boot 4.1.1
- Maven
- Spring MVC
- MapStruct y Lombok

