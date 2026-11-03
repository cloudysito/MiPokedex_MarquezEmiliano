package marquez.emiliano.mipokedex_marquezemiliano.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import marquez.emiliano.mipokedex_marquezemiliano.model.data.Users
import marquez.emiliano.mipokedex_marquezemiliano.model.data.getPokemonByNumber
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.LoginScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.MenuPokedexScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonDetailScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonHuntScreen
import androidx.compose.ui.platform.LocalContext

@Composable
fun MyApp(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    val users = Users(LocalContext.current)
    val navigateToDetail = {id: Int -> navController.navigate(route = PokemonDetail(id))}

    NavHost(navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                innerPadding = innerPadding,
                users = users,
                onNavigateToMenu = {
                    navController.navigate(PokemonList) {
                        popUpTo(Login) { inclusive = true }
                    }
                }
            )
        }
        composable<PokemonList> {
            MenuPokedexScreen(
                innerPadding,
                onNavigateToDetail = { id ->
                    navController.navigate(route = PokemonDetail(id))
                },
                onNavigateToHunt = {
                    navController.navigate(route = PokemonHunt)
                },
                onLogout = {
                    users.logout()
                    navController.navigate(Login) {
                        popUpTo(PokemonList) { inclusive = true }
                    }
                }
            )
        }
        composable<PokemonDetail> {
            val pokemon = it.arguments?.getInt("pokemon") ?: -1
            PokemonDetailScreen(innerPadding, getPokemonByNumber(pokemon))
        }
        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding, onNavigateToDetail = navigateToDetail)
        }
    }
}
