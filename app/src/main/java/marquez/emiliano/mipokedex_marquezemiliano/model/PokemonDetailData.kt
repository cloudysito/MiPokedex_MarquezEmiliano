package marquez.emiliano.mipokedex_marquezemiliano.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.DarkBluePokedex
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PurplePokedex

@Immutable
data class PokemonType(
    val name: String,
    val color: Color,
)

@Immutable
data class RelatedPokemon(
    val nameWithNumber: String,
    @param:DrawableRes val imageRes: Int,
)

@Immutable
data class PokemonDetailData(
    val name: String,
    val number: String,
    val height: String,
    val weight: String,
    val ability: String,
    val description: String,
    val types: List<PokemonType>,
    @param:DrawableRes val mainImageRes: Int,
    @param:DrawableRes val bgPokeballRes: Int,
    @param:DrawableRes val starIconRes: Int,
    val relatedPokemonLeft: RelatedPokemon,
    val relatedPokemonRight: RelatedPokemon,
    val headerBgColor: Color,
)

fun sampleGengarData(): PokemonDetailData {
    return PokemonDetailData(
        name = "Gengar",
        number = "#0094",
        height = "1.50m",
        weight = "40.5kg",
        ability = "Cuerpo Maldito",
        description = "En luna llena, a este Pokémon le gusta imitar las sombras de la gente y burlarse de sus miedos.",
        types = listOf(
            PokemonType("Fantasma", PurplePokedex),
            PokemonType("Veneno", DarkBluePokedex),
        ),
        mainImageRes = R.drawable.gengar,
        bgPokeballRes = R.drawable.pokeballdos,
        starIconRes = R.drawable.estrella,
        relatedPokemonLeft = RelatedPokemon("Mew #0151", R.drawable.mew_pa),
        relatedPokemonRight = RelatedPokemon("Jigglypuff #0039", R.drawable.jigglypuff_pa),
        headerBgColor = PurplePokedex,
    )
}
