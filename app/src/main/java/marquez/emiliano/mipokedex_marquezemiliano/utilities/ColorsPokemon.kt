package marquez.emiliano.mipokedex_marquezemiliano.utilities

import androidx.compose.ui.graphics.Color
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Bug
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Dark
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.DarkGray
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Dragon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Electric
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Fairy
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Fight
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Fire
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Flying
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Ghost
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Grass
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Ground
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Ice
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Normal
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.OffWhite
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Poison
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Psych
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Rock
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Water

fun getColorByType(type: String): Pair<Color, Color> {
    return when (type.trim().lowercase()) {
        "normal" -> Pair(Normal, OffWhite)
        "water", "agua" -> Pair(Water, OffWhite)
        "fire", "fuego" -> Pair(Fire, OffWhite)
        "psych", "psychic", "psiquico", "psíquico" -> Pair(Psych, OffWhite)
        "ghost", "fantasma" -> Pair(Ghost, OffWhite)
        "bug", "bicho" -> Pair(Bug, OffWhite)
        "poison", "veneno" -> Pair(Poison, OffWhite)
        "grass", "planta" -> Pair(Grass, OffWhite)
        "ground", "tierra" -> Pair(Ground, OffWhite)
        "rock", "roca" -> Pair(Rock, OffWhite)
        "electric", "electrico", "eléctrico" -> Pair(Electric, DarkGray)
        "fairy", "hada" -> Pair(Fairy, DarkGray)
        "fight", "fighting", "lucha" -> Pair(Fight, DarkGray)
        "flying", "volador" -> Pair(Flying, DarkGray)
        "dragon", "dragón" -> Pair(Dragon, OffWhite)
        "dark", "siniestro" -> Pair(Dark, OffWhite)
        "ice", "hielo" -> Pair(Ice, DarkGray)
        else -> Pair(Normal, OffWhite)
    }
}
