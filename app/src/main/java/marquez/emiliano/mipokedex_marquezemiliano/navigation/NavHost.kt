package marquez.emiliano.mipokedex_marquezemiliano.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.LoginScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.MenuPokedexScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonDetailScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonHuntScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.ProfileScreen
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.PokemonDetailViewModel
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues, userViewModel: UserViewModel, pokemonDetailViewModel: PokemonDetailViewModel) {
    val navController = rememberNavController()
    val navigateToDetail = {id: Int -> navController.navigate(route = PokemonDetail(id))}

    NavHost(navController, startDestination = Login) {
        composable<Login> {
            LoginScreen(
                innerPadding = innerPadding,
                users = userViewModel.users,
                onNavigateToMenu = {
                    navController.navigate(PokemonList) {
                        popUpTo(Login) { inclusive = true }
                    }
                },
                viewModel = userViewModel
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
                onNavigateToProfile = {
                    navController.navigate(route = Profile)
                },
                onLogout = {
                    userViewModel.logout()
                    navController.navigate(Login) {
                        popUpTo(PokemonList) { inclusive = true }
                    }
                }
            )
        }
        composable<Profile> {
            ProfileScreen(
                innerPadding = innerPadding,
                userViewModel = userViewModel
            )
        }
        composable<PokemonDetail> {
            val pokemonDetail = it.toRoute<PokemonDetail>()
            PokemonDetailScreen(
                innerPadding = innerPadding,
                pokemonNumber = pokemonDetail.pokemon,
                pokemonDetailViewModel = pokemonDetailViewModel
            )
        }
        composable<PokemonHunt> {
            PokemonHuntScreen(innerPadding, onNavigateToDetail = navigateToDetail)
        }
    }
}
