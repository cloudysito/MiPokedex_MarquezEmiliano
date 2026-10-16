package marquez.emiliano.mipokedex_marquezemiliano.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import marquez.emiliano.mipokedex_marquezemiliano.model.data.pokemonList
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

class PokemonViewModel : ViewModel() {
    var wildPokemon by mutableStateOf<Pokemon?>(null)
        private set

    var capturedPokemon by mutableStateOf(listOf<Pokemon>())
        private set

    var gonePokemon by mutableStateOf(false)
        private set

    var isPokemonCaptured by mutableStateOf(false)
        private set

    fun searchPokemon() {
        wildPokemon = pokemonList.random()
        isPokemonCaptured = false
        gonePokemon = false
    }

    fun capturePokemon() {
        wildPokemon?.let { pokemon ->
            val isCaptured = (1..2).random()
            if (isCaptured == 1) {
                capturedPokemon = capturedPokemon + pokemon
                gonePokemon = false
                wildPokemon = null
                isPokemonCaptured = true
            } else {
                gonePokemon = true
                wildPokemon = null
                isPokemonCaptured = false
            }
        }
    }
}
