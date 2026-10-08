package marquez.emiliano.mipokedex_marquezemiliano.view.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import marquez.emiliano.mipokedex_marquezemiliano.model.data.bulbasaur
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.OffWhite
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Typography
import marquez.emiliano.mipokedex_marquezemiliano.utilities.getColorByType

@Composable
fun PokemonRow(pokemon: Pokemon, onNavigateToDetail: (id: Int) -> Unit = {}) {
    Row(
        Modifier
            .fillMaxWidth()
            .clickable { onNavigateToDetail(pokemon.number.toInt()) }
            .padding(horizontal = 10.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image",
            Modifier
                .width(80.dp)
                .padding(10.dp)
        )

        Column(Modifier.fillMaxWidth(.7f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(pokemon.name, style = Typography.labelLarge)
            Text(
                pokemon.description,
                fontSize = 10.sp
            )
            Row(
                Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Height: ${pokemon.height}", style = Typography.labelMedium)
                Text("Weight: ${pokemon.weight}", style = Typography.labelMedium)
            }
        }
        NumberChip("${pokemon.number}", getColorByType(pokemon.type), Modifier.align(Alignment.Top))
    }
}

@Composable
fun FavoritePokemon(pokemon: Pokemon, onNavigateToDetail: (id: Int) -> Unit) {
    val colors = getColorByType(pokemon.type)
    Column(
        Modifier
            .width(150.dp)
            .padding(vertical = 15.dp)
            .clickable(true, onClick = { onNavigateToDetail(pokemon.number.toInt()) }),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Box(
                Modifier.border(
                    BorderStroke(
                        5.dp,
                        Brush.sweepGradient(
                            listOf(
                                colors.first,
                                OffWhite,
                                colors.first,
                                OffWhite,
                                colors.first
                            )
                        )
                    )
                )
            ) {
                Image(
                    painterResource(pokemon.image),
                    contentDescription = "${pokemon.name} image",
                    Modifier
                        .width(75.dp)
                        .align(Alignment.Center)
                        .padding(5.dp)
                )
            }
            NumberChip("${pokemon.number}", colors, Modifier.align(Alignment.BottomEnd).offset(15.dp, 15.dp))
        }
        Text(pokemon.name, style = Typography.labelLarge)
    }
}

@Composable
fun PokemonCell(pokemon: Pokemon, onNavigateToDetail: (id: Int) -> Unit = {}) {
    val colors = getColorByType(pokemon.type)

    Column(
        modifier = Modifier.clickable { onNavigateToDetail(pokemon.number.toInt()) },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(pokemon.image),
                contentDescription = pokemon.name,
                Modifier
                    .size(150.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Fit
            )
            NumberChip("${pokemon.number}", colors, Modifier.align(Alignment.TopEnd).offset(10.dp, (-10).dp))
        }
        Text(text = pokemon.name, textAlign = TextAlign.Center, style = Typography.labelLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonElementPreview() {
    PokemonCell(bulbasaur)
}
