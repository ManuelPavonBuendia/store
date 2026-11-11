package es.etg.daw.dawes.store.pokemon.application.usecase;


import es.etg.daw.dawes.store.pokemon.domain.repository.PokemonRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeletePokemonUseCase {

    private final PokemonRepository pokemonRepository;
    private final FindPokemonByIdUseCase findPokemonByIdUseCase;

    public void delete(int id) {
        findPokemonByIdUseCase.findById(id); 
        pokemonRepository.deteteById(id);
    }
}