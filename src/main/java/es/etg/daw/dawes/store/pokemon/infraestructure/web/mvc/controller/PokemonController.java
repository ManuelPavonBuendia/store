package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.etg.daw.dawes.store.pokemon.application.command.CreatePokemonCommand;
import es.etg.daw.dawes.store.pokemon.application.service.CreatePokemonService;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.infraestructure.mapper.PokemonMapper;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonRequest;
import es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto.PokemonResponse;
import es.etg.daw.dawes.store.pokemon.application.service.FindPokemonService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller 
@RequestMapping ("/pokemons") //URL será /pokemons
@RequiredArgsConstructor 

public class PokemonController {

    private final CreatePokemonService createPokemonService;
    private final FindPokemonService findPokemonService;

    @PostMapping
    @ResponseBody
    public String createPokemon(PokemonRequest request) {
        CreatePokemonCommand commando = PokemonMapper.toCommand(request);

        Pokemon pokemon = createPokemonService.createPokemon(commando);
        
        return """
            <!DOCTYPE html>
            <html lang="es">
              <head>
                <meta charset="UTF-8">
                <title>Producto</title>
              </head>
              <body>
                <h1>Pokemon: %s - %s</h1>
                <p>Tipo: %s </p>
                <p>Precio: %s </p>
                <p>Creado el: %s </p>
              </body>
            </html>
            """.formatted(pokemon.getId(), pokemon.getNombre(), pokemon.getTipo(), pokemon.getPrecio(), pokemon.getCreatedAt());
    }

     @GetMapping
    @ResponseBody
    public String allPokemon() {
        List<Pokemon> pokemons = findPokemonService.findAll();

        String filas = "";
        for (Pokemon pokemon : pokemons) {
            PokemonResponse p = PokemonMapper.toResponse(pokemon);

            filas += """
                <tr>
                  <td>%s</td>
                  <td>%s</td>
                  <td>%s</td>
                  <td>%s €</td>
                  <td>%s</td>
                </tr>
                """.formatted(p.id(), p.nombre(), p.tipo(), p.precio(), p.createdAt());
        }

        return """
            <!DOCTYPE html>
            <html lang="es">
              <head>
                <meta charset="UTF-8">
                <title>Pokemons</title>
              </head>
              <body>
                <h1>Listado de Pokemon</h1>
                <table border="1">
                  <tr>
                    <th>ID</th><th>Nombre</th><th>Tipo</th><th>Precio</th><th>Creado el</th>
                  </tr>
                  %s
                </table>
              </body>
            </html>
            """.formatted(filas);
    }
    
}
