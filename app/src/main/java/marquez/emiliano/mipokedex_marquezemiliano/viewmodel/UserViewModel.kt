package marquez.emiliano.mipokedex_marquezemiliano.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import marquez.emiliano.mipokedex_marquezemiliano.model.data.CompanionPreferences
import marquez.emiliano.mipokedex_marquezemiliano.model.data.Users
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.User
import marquez.emiliano.mipokedex_marquezemiliano.model.preferences.PokemonSerializer

class UserViewModel(
    val users: Users, private val companionDataStore: CompanionPreferences
) : ViewModel() {
    var currentUser by mutableStateOf<User?>(null)
        private set

    init {
        currentUser = users.getCurrentUser()
    }

    var loginError by mutableStateOf(false)
        private set

    var errorDescription by mutableStateOf("")
        private set

    val companion: StateFlow<Pokemon> = companionDataStore.pokemonCompanion().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = PokemonSerializer.defaultValue
    )

    fun login(email: String, password: String) {
        val user = users.loginService(email, password)
        if (user == null) {
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos"
            currentUser = null
        } else {
            loginError = false
            errorDescription = ""
            currentUser = user
            users.saveUser(user)
        }
    }

    fun logout() {
        users.logout()
        currentUser = null
        loginError = false
        errorDescription = ""
    }

    fun isLoggedIn(): Boolean {
        return currentUser != null || users.isLoggedIn()
    }

    fun getCompanionDays(): Int {
        return companionDataStore.getCompanionDays()
    }
}
