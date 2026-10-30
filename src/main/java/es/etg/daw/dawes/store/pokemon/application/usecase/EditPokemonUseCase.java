package es.etg.daw.dawes.store.pokemon.application.usecase;


import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;
import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditPokemonUseCase {

    private final PokemonRepository pokemonRepository;
    private final FindPokemonByIdUseCase findPokemonByIdUseCase;

    public Pokemon update(EditPokemonCommand command) {
        Pokemon pokemon = findPokemonByIdUseCase.findById(command.id());

        pokemon.setFoto(command.foto());
        pokemon.setPrecio(command.precio());

        return pokemonRepository.save(pokemon);
    }
}