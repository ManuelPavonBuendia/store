# API de Pokémon

La aplicación se está ejecutando en `http://localhost:8080`.

| Método | Ruta | Resultado |
| --- | --- | --- |
| `GET` | `/pokemons` | Lista los Pokémon en JSON. |
| `POST` | `/pokemons` | Crea un Pokémon desde datos de formulario y devuelve una página HTML con el resultado. |
| `PUT` | `/pokemons/{id}` | Actualiza un Pokémon desde JSON y devuelve el recurso en JSON. |
| `DELETE` | `/pokemons/{id}` | Elimina el Pokémon. |

## Listar

```bash
curl http://localhost:8080/pokemons
```

La respuesta contiene objetos con `id`, `nombre`, `tipo`, `foto`, `precio` y `createdAt`.

## Crear

El controlador recibe `PokemonRequest` como parámetro de formulario:

```bash
curl -X POST http://localhost:8080/pokemons \
  -H 'Content-Type: application/x-www-form-urlencoded' \
  --data-urlencode 'nombre=Bulbasaur' \
  --data-urlencode 'tipo=Planta' \
  --data-urlencode 'foto=https://example.com/bulbasaur.png' \
  --data-urlencode 'precio=25'
```

También está disponible el formulario del navegador en `/formulario-crear-pokemon.html`.

## Editar

El cuerpo del `PUT` es JSON. Envía los campos del Pokémon:

```bash
curl -X PUT http://localhost:8080/pokemons/1 \
  -H 'Content-Type: application/json' \
  -d '{"nombre":"Bulbasaur","tipo":"Planta","foto":"https://example.com/bulbasaur.png","precio":30}'
```

## Eliminar

```bash
curl -i -X DELETE http://localhost:8080/pokemons/1
```

Los identificadores `1`, `2` y `3` se precargan en el repositorio mock.

## Validaciones de entrada

- `nombre`: no puede estar vacío y no admite espacios ni saltos de línea.
- `tipo`: no puede estar vacío.
- `precio`: debe estar entre 0 y 100, inclusive.
- `foto`: no tiene una restricción declarada actualmente.

Las validaciones se aplican en el endpoint de creación mediante `@Valid`.