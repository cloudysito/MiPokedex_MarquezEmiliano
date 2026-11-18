package marquez.emiliano.mipokedex_marquezemiliano.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
object Login

@Serializable
object PokemonHunt

@Serializable
object Profile

@Serializable
object AddPokemon

@Serializable
data class PokemonDetail(val pokemon: Int)
