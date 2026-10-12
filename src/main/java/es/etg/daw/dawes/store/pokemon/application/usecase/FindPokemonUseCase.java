package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;
import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class FindPokemonUseCase {
    public List<Pokemon> findAll() {
        return List.of(
            Pokemon.builder().id(1).nombre("Pikachu").tipo("Eléctrico")
                   .foto("pikachu.png").precio(25.0)
                   .createdAt(LocalDateTime.now()).build(),
            Pokemon.builder().id(2).nombre("Charmander").tipo("Fuego")
                   .foto("charmander.png").precio(15.0)
                   .createdAt(LocalDateTime.now()).build(),
            Pokemon.builder().id(3).nombre("Squirtle").tipo("Agua")
                   .foto("squirtle.png").precio(15.0)
                   .createdAt(LocalDateTime.now()).build()
        );
    }
}
