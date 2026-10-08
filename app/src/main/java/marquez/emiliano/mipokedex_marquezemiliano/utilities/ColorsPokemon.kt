package marquez.emiliano.mipokedex_marquezemiliano.utilities

import androidx.compose.ui.graphics.Color
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Bug
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.DarkGray
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Electric
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Fairy
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Fight
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Fire
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Flying
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Ghost
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Grass
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Ground
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Normal
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.OffWhite
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Poison
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Psych
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Rock
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Water

fun getColorByType(type: String): Pair<Color, Color> {
    var color: Color
    var dark = true
    when {
        type.lowercase().contains("normal") -> color = Normal
        type.lowercase().contains("electric") -> {
            color = Electric
            dark = false
        }
        type.lowercase().contains("water") -> color = Water
        type.lowercase().contains("fire") -> color = Fire
        type.lowercase().contains("fairy") -> {
            color = Fairy
            dark = false
        }
        type.lowercase().contains("grass") -> color = Grass
        type.lowercase().contains("psychic") -> color = Psych
        type.lowercase().contains("fighting") || type.lowercase().contains("fight") -> {
            color = Fight
            dark = false
        }
        type.lowercase().contains("ghost") -> color = Ghost
        type.lowercase().contains("bug") -> color = Bug
        type.lowercase().contains("poison") -> color = Poison
        type.lowercase().contains("ground") -> color = Ground
        type.lowercase().contains("rock") -> color = Rock
        type.lowercase().contains("flying") -> {
            color = Flying
            dark = false
        }
        else -> color = Normal
    }

    return Pair(color, if (dark) OffWhite else DarkGray)
}
