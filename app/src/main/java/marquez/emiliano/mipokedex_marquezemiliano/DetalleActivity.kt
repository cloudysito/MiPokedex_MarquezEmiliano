package marquez.emiliano.mipokedex_marquezemiliano

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import marquez.emiliano.mipokedex_marquezemiliano.ui.PokemonDetailScreen
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokemonDetailTheme

class DetalleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonDetailTheme {
                PokemonDetailScreen(
                    onPreviousClick = { finish() }
                )
            }
        }
    }
}
