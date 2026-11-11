package marquez.emiliano.mipokedex_marquezemiliano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import marquez.emiliano.mipokedex_marquezemiliano.model.data.CompanionPreferences
import marquez.emiliano.mipokedex_marquezemiliano.model.data.Users
import marquez.emiliano.mipokedex_marquezemiliano.navigation.MyApp
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokedexListTheme
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.PokemonDetailViewModel
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val users = Users(this)
        val companionPreferences = CompanionPreferences(this)
        val userViewModel = UserViewModel(users, companionPreferences)
        val pokemonDetailViewModel = PokemonDetailViewModel(companionPreferences)
        enableEdgeToEdge()
        setContent {
            PokedexListTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(innerPadding, userViewModel, pokemonDetailViewModel)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokedexListTheme {

    }
}
