package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.util.List;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.error.PokemonNotFoundException;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditPokemonUseCase {

    public PokemonRepository pokemonRepository;

    public Pokemon update(EditPokemonCommand command) {

        List<Pokemon> pokemons = pokemonRepository.getAll();

        if (pokemons.isEmpty())
            throw new PokemonNotFoundException();

        if(pokemonRepository.getById(command.id()).isEmpty())
            throw new PokemonNotFoundException(command.id());

        Pokemon pokemon = pokemonRepository.getById(command.id()).get();

        pokemon.setFoto(command.foto());
        pokemon.setPrecio(command.precio());

        return pokemonRepository.save(pokemon);
    }
}