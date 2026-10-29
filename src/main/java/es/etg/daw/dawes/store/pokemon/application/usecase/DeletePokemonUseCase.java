package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.util.List;

import es.etg.daw.dawes.store.pokemon.domain.error.PokemonNotFoundException;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletePokemonUseCase {

    public PokemonRepository pokemonRepository;

    public void delete(int id) {

        List<Pokemon> pokemons = pokemonRepository.getAll();

        if (pokemons.isEmpty())
            throw new PokemonNotFoundException();

        if(pokemonRepository.getById(id).isEmpty())
            throw new PokemonNotFoundException(id);

        pokemonRepository.deteteById(id);
    }
}