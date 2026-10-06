package marquez.emiliano.mipokedex_marquezemiliano.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import marquez.emiliano.mipokedex_marquezemiliano.data.Pokemons
import marquez.emiliano.mipokedex_marquezemiliano.screens.MenuPokedexScreen
import marquez.emiliano.mipokedex_marquezemiliano.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = PokemonList
    ) {
        composable<PokemonList> {
            MenuPokedexScreen(
                innerPadding = innerPadding,
                onNavigateToDetail = { id ->
                    navController.navigate(PokemonDetail(id))
                }
            )
        }
        composable<PokemonDetail> { backStackEntry ->
            val pokemonDetailRoute: PokemonDetail = backStackEntry.toRoute()
            val pokemonId = pokemonDetailRoute.pokemon
            val pokemon = Pokemons().pokemonList.find { it.number == pokemonId } ?: Pokemons().gengar
            PokemonDetailScreen(
                innerPadding = innerPadding,
                pokemon = pokemon
            )
        }
    }
}
