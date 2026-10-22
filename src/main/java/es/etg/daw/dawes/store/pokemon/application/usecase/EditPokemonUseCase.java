package es.etg.daw.dawes.store.pokemon.application.usecase;

import java.time.LocalDateTime;

import es.etg.daw.dawes.store.pokemon.application.command.EditPokemonCommand;
import es.etg.daw.dawes.store.pokemon.domain.model.Pokemon;

public class EditPokemonUseCase {
    public Pokemon update(EditPokemonCommand command) {
        return new Pokemon (command.id(), "Pokemon" + command.id(), "tipo", command.foto(), command.precio(), LocalDateTime.now());
    }
}
