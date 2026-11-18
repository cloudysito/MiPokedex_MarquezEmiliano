package marquez.emiliano.mipokedex_marquezemiliano.model.data.sqllite

import marquez.emiliano.mipokedex_marquezemiliano.model.data.interfaces.IPokemonRepository
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

class PokemonRepository(private val dao: PokemonDAO) : IPokemonRepository {

    override suspend fun addPokemon(pokemon: Pokemon) {
        dao.insertPokemon(pokemon)
    }

    override suspend fun getPokemons(): List<Pokemon> {
        return dao.getAllPokemons()
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        return dao.getFavoritePokemons()
    }

    override suspend fun getPokemonsByType(type: String): List<Pokemon> {
        return dao.getPokemonByType(type)
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        dao.updatePokemon(pokemon)
    }

    override suspend fun deletePokemon(id: Int) {
        dao.getPokemonById(id)?.let {
            dao.deletePokemon(it)
        }
    }
}
