package marquez.emiliano.mipokedex_marquezemiliano.model.data.interfaces

import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

interface IPokemonDAO {
    suspend fun insertPokemon(pokemon: Pokemon)
    suspend fun getAllPokemons(): List<Pokemon>
    suspend fun getPokemonById(id: Int): Pokemon?
    suspend fun getFavoritePokemons(): List<Pokemon>
    suspend fun getPokemonByType(type: String): List<Pokemon>
    suspend fun updatePokemon(pokemon: Pokemon)
    suspend fun deletePokemon(pokemon: Pokemon)
}
