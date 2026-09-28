package marquez.emiliano.mipokedex_marquezemiliano.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = PurplePokedex,
    secondary = DarkBluePokedex,
    background = PurplePokedex,
    surface = WhitePokedex
)

@Composable
fun PokemonDetailTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
