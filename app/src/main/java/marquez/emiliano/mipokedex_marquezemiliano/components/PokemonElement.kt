package marquez.emiliano.mipokedex_marquezemiliano.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.OffWhite
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokemonDetailTheme
import marquez.emiliano.mipokedex_marquezemiliano.utilities.getColorByType

@Composable
fun FavoritePokemon(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    val primaryType = pokemon.type.split("/").firstOrNull() ?: pokemon.type
    val colors = getColorByType(primaryType)

    val sweepGradient = Brush.sweepGradient(
        listOf(
            colors.first,
            OffWhite,
            colors.first,
            OffWhite,
            colors.first
        )
    )

    Column(
        modifier = modifier.padding(vertical = 15.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                modifier = Modifier.border(
                    border = BorderStroke(width = 5.dp, brush = sweepGradient),
                    shape = CircleShape
                )
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    modifier = Modifier
                        .width(75.dp)
                        .padding(5.dp)
                )
            }

            NumberChip(
                text = "${pokemon.number}",
                colors = colors,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }

        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Composable
fun PokemonCell(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    val primaryType = pokemon.type.split("/").firstOrNull() ?: pokemon.type
    val colors = getColorByType(primaryType)

    val sweepGradient = Brush.sweepGradient(
        listOf(
            colors.first,
            OffWhite,
            colors.first,
            OffWhite,
            colors.first
        )
    )

    Column(
        modifier = modifier.padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                modifier = Modifier.border(
                    border = BorderStroke(width = 5.dp, brush = sweepGradient),
                    shape = CircleShape
                )
            ) {
                Image(
                    painter = painterResource(id = pokemon.image),
                    contentDescription = pokemon.name,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(10.dp)
                )
            }

            NumberChip(
                text = "${pokemon.number}",
                colors = colors,
                modifier = Modifier.align(Alignment.TopEnd)
            )
        }

        Text(
            text = pokemon.name,
            style = MaterialTheme.typography.labelLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePokemonPreview() {
    PokemonDetailTheme {
        FavoritePokemon(
            pokemon = Pokemon(
                name = "Gengar",
                number = 94,
                type = "Ghost/Poison",
                description = "Under a full moon, this Pokémon likes to mimic shadows.",
                height = 1.5f,
                weigth = 40.5f,
                favorite = true,
                ability = "Cursed Body",
                image = R.drawable.gengar
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCellPreview() {
    PokemonDetailTheme {
        PokemonCell(
            pokemon = Pokemon(
                name = "Gengar",
                number = 94,
                type = "Ghost/Poison",
                description = "Under a full moon, this Pokémon likes to mimic shadows.",
                height = 1.5f,
                weigth = 40.5f,
                favorite = true,
                ability = "Cursed Body",
                image = R.drawable.gengar
            )
        )
    }
}
