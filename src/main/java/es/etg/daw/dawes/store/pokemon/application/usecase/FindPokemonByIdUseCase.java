package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.util.Optional;

import es.etg.daw.dawes.store.pokemon.domain.error.PokemonNotFoundException;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindPokemonByIdUseCase {

    public final PokemonRepository pokemonRepository;

    public Pokemon findById(int id) {
        Optional<Pokemon> opt = pokemonRepository.getById(id);

        if (opt.isEmpty()) {
            throw new PokemonNotFoundException(id);
        }

        return opt.get();
    }
}
