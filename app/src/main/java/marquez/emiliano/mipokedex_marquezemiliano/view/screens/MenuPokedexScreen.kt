package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.model.data.getFavoritePokemons
import marquez.emiliano.mipokedex_marquezemiliano.model.data.pokemonList
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Blue
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Green
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.LightBlue
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.LightGreen
import marquez.emiliano.mipokedex_marquezemiliano.view.components.FavoritesRow
import marquez.emiliano.mipokedex_marquezemiliano.view.components.MenuPokedex
import marquez.emiliano.mipokedex_marquezemiliano.view.components.PokedexGrid

@Composable
fun MenuPokedexScreen(innerPadding: PaddingValues, onNavigateToDetail: (id: Int) -> Unit) {
    var grid by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(innerPadding)) {
        Text("Favorite Pokemons")
        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)
        Spacer(Modifier.size(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("All pokemons")
            Switch(
                checked = grid,
                onCheckedChange = { grid = it },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Green,
                    checkedTrackColor = LightGreen,
                    uncheckedThumbColor = Blue,
                    uncheckedTrackColor = LightBlue,
                    uncheckedBorderColor = Color.Transparent
                ),
                thumbContent = {
                    if (grid) {
                        Icon(
                            painterResource(R.drawable.ic_puntos),
                            contentDescription = "grid icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    } else {
                        Icon(
                            painterResource(R.drawable.ic_hoja),
                            contentDescription = "list icon",
                            modifier = Modifier.size(SwitchDefaults.IconSize)
                        )
                    }
                }
            )
        }

        if (grid) {
            PokedexGrid(pokemonList, onNavigateToDetail)
        } else {
            MenuPokedex(pokemonList, PaddingValues(0.dp), onNavigateToDetail)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    MenuPokedexScreen(PaddingValues(10.dp, 15.dp)) {}
}


