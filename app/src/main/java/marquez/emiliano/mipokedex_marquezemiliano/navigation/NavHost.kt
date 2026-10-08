package marquez.emiliano.mipokedex_marquezemiliano.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import marquez.emiliano.mipokedex_marquezemiliano.model.data.getPokemonByNumber
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.MenuPokedexScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonDetailScreen

@Composable
fun MyApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = PokemonList) {
        composable<PokemonList> {
            MenuPokedexScreen(
                innerPadding,
                onNavigateToDetail = { id ->
                    navController.navigate(route = PokemonDetail(id))
                }
            )
        }
        composable<PokemonDetail> {
            val pokemon = it.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(innerPadding, getPokemonByNumber(pokemon))
        }
    }
}
