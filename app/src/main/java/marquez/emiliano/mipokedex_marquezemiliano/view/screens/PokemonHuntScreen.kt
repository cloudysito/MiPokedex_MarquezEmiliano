package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.PokemonViewModel

@Composable
fun PokemonHuntScreen(innerPadding: PaddingValues, viewModel: PokemonViewModel = viewModel()) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Button({}) {
            Text("Buscar pokemon en la hierva")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonHuntPreview() {
    PokemonHuntScreen(PaddingValues(15.dp))
}
