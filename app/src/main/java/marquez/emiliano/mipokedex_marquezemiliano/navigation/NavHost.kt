package marquez.emiliano.mipokedex_marquezemiliano.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import marquez.emiliano.mipokedex_marquezemiliano.model.data.sqllite.DatabaseHelper
import marquez.emiliano.mipokedex_marquezemiliano.model.data.sqllite.PokemonDAO
import marquez.emiliano.mipokedex_marquezemiliano.model.data.sqllite.PokemonRepository
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.AddPokemonScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.LoginScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.MenuPokedexScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonDetailScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.PokemonHuntScreen
import marquez.emiliano.mipokedex_marquezemiliano.view.screens.ProfileScreen
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.AddPokemonViewModel
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.PokemonDetailViewModel
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.UserViewModel

@Composable
fun MyApp(innerPadding: PaddingValues, userViewModel: UserViewModel, pokemonDetailViewModel: PokemonDetailViewModel) {
    val navController = rememberNavController()
    val navigateToDetail = { id: Int -> navController.navigate(route = PokemonDetail(id)) }

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
                onNavigateToAddPokemon = {
                    navController.navigate(route = AddPokemon)
                },
                onNavigateToProfile = {
                    navController.navigate(route = Profile)
                }
            )
        }
        composable<Profile> {
            ProfileScreen(
                innerPadding = innerPadding,
                userViewModel = userViewModel,
                onLogout = {
                    userViewModel.logout()
                    navController.navigate(Login) {
                        popUpTo(PokemonList) { inclusive = true }
                    }
                }
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
        composable<AddPokemon> {
            val context = LocalContext.current
            val addPokemonViewModel: AddPokemonViewModel = viewModel(
                factory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                        val dbHelper = DatabaseHelper(context)
                        val dao = PokemonDAO(dbHelper)
                        val repository = PokemonRepository(dao)
                        @Suppress("UNCHECKED_CAST")
                        return AddPokemonViewModel(repository) as T
                    }
                }
            )
            AddPokemonScreen(innerPadding = innerPadding, addPokemonViewModel = addPokemonViewModel)
        }
    }
}
