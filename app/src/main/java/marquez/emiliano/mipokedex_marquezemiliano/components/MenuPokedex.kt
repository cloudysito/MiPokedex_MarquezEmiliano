package marquez.emiliano.mipokedex_marquezemiliano.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Green
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokemonDetailTheme

@Composable
fun PokemonRow(pokemon: Pokemon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier
                .width(80.dp)
                .padding(10.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(0.7f),
            verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            Text(
                text = pokemon.name,
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                text = pokemon.description,
                fontSize = 10.sp
            )

            Row(
                modifier = Modifier.fillMaxWidth(0.85f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Alto: ${pokemon.height}",
                    style = MaterialTheme.typography.labelMedium
                )
                Text(
                    text = "Peso: ${pokemon.weigth}",
                    style = MaterialTheme.typography.labelMedium
                )
            }
        }

        Text(
            text = "${pokemon.number}",
            modifier = Modifier
                .align(Alignment.Top)
                .background(Green)
                .padding(horizontal = 5.dp, vertical = 2.dp)
        )
    }
}

@Composable
fun pokemonRow(pokemon: Pokemon) {
    PokemonRow(pokemon = pokemon)
}


@Composable
fun MenuPokedex(pokemonList: List<Pokemon>, innerPadding: PaddingValues) {
    LazyColumn(contentPadding = innerPadding) {
        items(pokemonList) { pokemon -> PokemonRow(pokemon) }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonRowPreview() {
    PokemonDetailTheme {
        PokemonRow(
            pokemon = Pokemon(
                name = "Gengar",
                number = 94,
                type = "Ghost/Poison",
                description = "Under a full moon, this Pokémon likes to mimic the shadows of people.",
                height = 1.5f,
                weigth = 40.5f,
                favorite = true,
                ability = "Cursed Body",
                image = R.drawable.gengar
            )
        )
    }
}
