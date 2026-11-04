package es.etg.daw.dawes.store.pokemon.infraestructure.web.mvc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record PokemonRequest(
    
    @NotBlank
    String nombre, 
    
    @NotBlank 
    String tipo, String foto, 
    
    @Min(value = 0)
    @Max(value = 100)
    double precio) {

}