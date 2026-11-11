package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.model.data.getFavoritePokemons
import marquez.emiliano.mipokedex_marquezemiliano.model.data.pokemonList
import marquez.emiliano.mipokedex_marquezemiliano.model.preferences.UserPreferences
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Blue
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Green
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.LightBlue
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.LightGreen
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Typography
import marquez.emiliano.mipokedex_marquezemiliano.view.components.FavoritesRow
import marquez.emiliano.mipokedex_marquezemiliano.view.components.MenuPokedex
import marquez.emiliano.mipokedex_marquezemiliano.view.components.PokedexGrid

@Composable
fun MenuPokedexScreen(
    innerPadding: PaddingValues,
    onNavigateToDetail: (id: Int) -> Unit,
    onNavigateToHunt: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onLogout: () -> Unit
) {
    val shared = LocalContext.current.getSharedPreferences(
        UserPreferences.ARCHIVO,
        android.content.Context.MODE_PRIVATE
    )
    var grid by remember {
        mutableStateOf(shared.getBoolean(UserPreferences.POKEMON_DISPLAY, false))
    }

    Column(modifier = Modifier.padding(innerPadding).padding(horizontal = 12.dp)) {
        // Top Action Bar with Profile and Catch/Logout buttons
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onNavigateToProfile() }) {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "profile",
                    modifier = Modifier.size(36.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FloatingActionButton(
                    onClick = { onNavigateToHunt() },
                    modifier = Modifier.size(42.dp)
                ) {
                    Text("+", style = Typography.labelLarge)
                }
                OutlinedButton(onClick = onLogout) {
                    Text("Cerrar")
                }
            }
        }

        Spacer(Modifier.size(12.dp))

        // Favorite Pokemons Section
        Text(
            text = "Favorite Pokemons",
            style = Typography.titleLarge,
            fontWeight = FontWeight.Bold
        )

        FavoritesRow(getFavoritePokemons(), onNavigateToDetail)
        Spacer(Modifier.size(15.dp))

        // All Pokemons Section Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "All pokemons",
                style = Typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Switch(
                checked = grid,
                onCheckedChange = {
                    grid = it
                    shared.edit().putBoolean(UserPreferences.POKEMON_DISPLAY, it).apply()
                },
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

        Spacer(Modifier.size(8.dp))

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
    MenuPokedexScreen(
        PaddingValues(10.dp, 15.dp),
        onNavigateToDetail = {},
        onNavigateToHunt = {},
        onNavigateToProfile = {},
        onLogout = {}
    )
}
