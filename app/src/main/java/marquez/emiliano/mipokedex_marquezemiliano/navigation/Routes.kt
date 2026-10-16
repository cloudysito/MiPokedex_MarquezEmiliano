package marquez.emiliano.mipokedex_marquezemiliano.navigation

import kotlinx.serialization.Serializable

@Serializable
object PokemonList

@Serializable
object PokemonHunt

@Serializable
data class PokemonDetail(val pokemon: Int)
