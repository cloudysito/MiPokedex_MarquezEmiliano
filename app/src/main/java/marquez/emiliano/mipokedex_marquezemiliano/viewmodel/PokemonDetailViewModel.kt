package marquez.emiliano.mipokedex_marquezemiliano.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import marquez.emiliano.mipokedex_marquezemiliano.model.data.CompanionPreferences
import marquez.emiliano.mipokedex_marquezemiliano.model.data.getPokemonByNumber
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.model.preferences.PokemonSerializer

class PokemonDetailViewModel(private val companionDataStore: CompanionPreferences) : ViewModel() {

    var pokemon by mutableStateOf<Pokemon?>(null)
        private set

    var companionSavedMessage by mutableStateOf<String?>(null)
        private set

    val companion: StateFlow<Pokemon> = companionDataStore.pokemonCompanion().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PokemonSerializer.defaultValue
    )

    fun loadPokemon(pokemonNumber: Int) {
        pokemon = getPokemonByNumber(pokemonNumber)
    }

    fun saveCompanion(pokemon: Pokemon) {
        viewModelScope.launch {
            companionDataStore.saveCompanion(pokemon)
            companionSavedMessage = "Compañero seleccionado"
        }
    }

    fun clearCompanionMessage() {
        companionSavedMessage = null
    }
}
