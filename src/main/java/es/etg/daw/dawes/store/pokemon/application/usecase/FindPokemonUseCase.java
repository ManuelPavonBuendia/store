package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class FindPokemonUseCase {

    public List<Pokemon> findAll() {
        List<Pokemon> lista = new ArrayList<>();
        lista.add(new Pokemon(1, "Pikachu", "Eléctrico", "Pikachu.png", 25.0, LocalDateTime.now()));
        lista.add(new Pokemon(2, "Charmander", "Fuego", "Charmander.png", 15.0, LocalDateTime.now()));
        lista.add(new Pokemon(3, "Squirtle", "Agua", "Squirtle.png", 15.0, LocalDateTime.now()));

        return lista;
    }
}
