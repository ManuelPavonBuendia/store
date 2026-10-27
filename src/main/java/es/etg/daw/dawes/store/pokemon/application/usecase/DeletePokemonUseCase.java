package es.etg.daw.dawes.store.pokemon.application.usecase;

@AllArgsConstructor
public class DeletePokemonUseCase {

    public PokemonRepository pokemonRepository;

    public void delete(int id) {
        pokemonRepository.deteteById(id);
    }
}