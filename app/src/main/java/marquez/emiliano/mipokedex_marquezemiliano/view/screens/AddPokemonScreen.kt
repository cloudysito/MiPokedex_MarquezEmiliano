package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.pokemonTypes
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Typography
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.AddPokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddPokemonScreen(innerPadding: PaddingValues, addPokemonViewModel: AddPokemonViewModel) {
    var number by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var type by remember { mutableStateOf(pokemonTypes[0]) }
    var description by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var ability by remember { mutableStateOf("") }
    var openType by remember { mutableStateOf(false) }

    val pokemonList by addPokemonViewModel.pokemons.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        addPokemonViewModel.loadPokemons()
    }

    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Text(
            "Agregar pokemon",
            Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = Typography.titleLarge
        )
        Spacer(Modifier.size(20.dp))
        TextField(
            value = number,
            onValueChange = { number = it },
            label = {
                Text("Numero de Pokemon")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        TextField(
            value = name,
            onValueChange = { name = it },
            label = {
                Text("Nombre")
            }
        )
        ExposedDropdownMenuBox(
            expanded = openType,
            onExpandedChange = { openType = it }
        ) {
            OutlinedTextField(
                readOnly = true,
                label = { Text("Selecciona un pokemon") },
                value = type,
                onValueChange = {},
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = openType) },
                modifier = Modifier.menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = openType,
                onDismissRequest = { openType = false }
            ) {
                pokemonTypes.forEach { t ->
                    DropdownMenuItem(
                        text = { Text(t) },
                        onClick = {
                            type = t
                            openType = false
                        }
                    )
                }
            }
        }
        TextField(
            value = description,
            onValueChange = { description = it },
            label = {
                Text("Descripcion")
            }
        )
        TextField(
            value = height,
            onValueChange = { height = it },
            label = {
                Text("Altura")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        TextField(
            value = weight,
            onValueChange = { weight = it },
            label = {
                Text("Peso")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
        TextField(
            value = ability,
            onValueChange = { ability = it },
            label = {
                Text("Habilidad")
            }
        )
        Button(onClick = {
            addPokemonViewModel.savePokemon(
                name = name.toString(),
                type = type.toString(),
                number = number.toString().toIntOrNull() ?: 0,
                description = description.toString(),
                height = height.toString().toFloatOrNull() ?: 0f,
                weight = weight.toString().toFloatOrNull() ?: 0f,
                ability = ability.toString()
            )
        }) {
            Text("Guardar")
        }

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(pokemonList) { pokemon ->
                Text(
                    text = pokemon.toString(),
                    style = Typography.bodyLarge
                )
            }
        }
    }
}
