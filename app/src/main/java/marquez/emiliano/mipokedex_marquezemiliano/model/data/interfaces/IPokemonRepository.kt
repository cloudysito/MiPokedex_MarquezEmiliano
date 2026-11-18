package marquez.emiliano.mipokedex_marquezemiliano.model.data.interfaces

import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

interface IPokemonRepository {
    suspend fun addPokemon(pokemon: Pokemon)
    suspend fun getPokemons(): List<Pokemon>
    suspend fun getFavoritePokemons(): List<Pokemon>
    suspend fun getPokemonsByType(type: String): List<Pokemon>
    suspend fun updatePokemon(pokemon: Pokemon)
    suspend fun deletePokemon(id: Int)
}
