# Proyecto-DAW-POKEDEX



## Introducción



Este proyecto trata de la creación de una aplicación web que simula una tienda de compra de pokemons.



## Arquitectura



├── pokemon
│ ├── application
│ │ ├── command
│ │ │ └── CreatePokemonCommand.java
│ │ ├── service
│ │ │ ├── CreatePokemonService.java
│ │ │ └── FindPokemonService.java
│ │ └── usecase
│ │ ├── CreatePokemonUseCase.java
│ │ └── FindPokemonUseCase.java
│ ├── domain
│ │ └── model
│ │ └── Pokemon.java
│ └── infraestructure
│ ├── config
│ │ └── PokemonConfig.java
│ ├── mapper
│ │ └── PokemonMapper.java
│ └── web
│ └── mvc
│ ├── controller
│ │ └── PokemonController.java
│ └── dto
│ ├── PokemonRequest.java
│ └── PokemonResponse.java

...



### Técnicas utilizadas



Para realizar este proyecto hicimos uso de diferentes técnicas de desarrollo, la primera de ellas fue el vertical slicing, ya que con ella se puede trabajar de manera individual y aislada sin comprometer el resto del proyecto

