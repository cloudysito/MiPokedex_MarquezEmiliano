package marquez.emiliano.mipokedex_marquezemiliano.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marquez.emiliano.mipokedex_marquezemiliano.components.FavoritesRow
import marquez.emiliano.mipokedex_marquezemiliano.components.PokedexGrid
import marquez.emiliano.mipokedex_marquezemiliano.data.Pokemons
import marquez.emiliano.mipokedex_marquezemiliano.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokemonDetailTheme

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues,
    pokemonList: List<Pokemon> = Pokemons().pokemonList,
    onNavigateToDetail: (Int) -> Unit = {}
) {
    val favoriteList = pokemonList.filter { it.favorite }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(horizontal = 10.dp)
    ) {
        Text(
            text = "Mis Favoritos",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 10.dp)
        )

        FavoritesRow(
            favoriteList = favoriteList,
            modifier = Modifier.padding(vertical = 5.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Todos mis pokemones",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        PokedexGrid(
            pokemonList = pokemonList,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPokedexScreenPreview() {
    PokemonDetailTheme {
        MenuPokedexScreen(innerPadding = PaddingValues(0.dp))
    }
}
