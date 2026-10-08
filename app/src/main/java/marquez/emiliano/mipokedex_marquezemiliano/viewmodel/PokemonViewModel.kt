package marquez.emiliano.mipokedex_marquezemiliano.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var wildPokemon by mutableStateOf(listOf<Pokemon?>(null))

    fun capturePokemon() {

    }
}
