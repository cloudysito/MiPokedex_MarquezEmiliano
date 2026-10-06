package marquez.emiliano.mipokedex_marquezemiliano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import marquez.emiliano.mipokedex_marquezemiliano.screens.MenuPokedexScreen
import marquez.emiliano.mipokedex_marquezemiliano.data.Pokemons
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokemonDetailTheme

class PokedexListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val pokemons = Pokemons()
        setContent {
            PokemonDetailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MenuPokedexScreen(
                        innerPadding = innerPadding,
                        pokemonList = pokemons.pokemonList
                    )
                }
            }
        }
    }
}
