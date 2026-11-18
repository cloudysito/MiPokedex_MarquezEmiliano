package marquez.emiliano.mipokedex_marquezemiliano.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import marquez.emiliano.mipokedex_marquezemiliano.model.data.interfaces.IPokemonRepository
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

class AddPokemonViewModel (private val pokemonRepository: IPokemonRepository): ViewModel() {
    private val pokemonsMutable = MutableStateFlow<List<Pokemon>>(emptyList())
    val pokemons: StateFlow<List<Pokemon>> = pokemonsMutable.asStateFlow()

    var pokemonSaved by mutableStateOf(false)
        private set

    fun loadPokemons() {
        viewModelScope.launch {
            pokemonsMutable.value = pokemonRepository.getPokemons()
        }
    }

    fun savePokemon(
        name: String,
        type: String,
        number: Int,
        description: String,
        height: Float,
        weight: Float,
        ability: String
    ) {
        val savingPokemon = Pokemon(
            name = name,
            number = number,
            type = type,
            description = description,
            height = height,
            weight = weight,
            favorite = false,
            ability = ability,
            image = -1
        )

        viewModelScope.launch {
            pokemonRepository.addPokemon(savingPokemon)
            pokemonSaved = true
            loadPokemons()
        }
    }
}