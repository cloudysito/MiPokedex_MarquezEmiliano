package marquez.emiliano.mipokedex_marquezemiliano.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import marquez.emiliano.mipokedex_marquezemiliano.model.data.Users

class UserViewModel(
    private val users: Users
) : ViewModel() {
    var loginError by mutableStateOf(false)
        private set

    var errorDescription by mutableStateOf("")
        private set

    fun login(email: String, password: String) {
        val user = users.loginService(email, password)
        if (user == null) {
            loginError = true
            errorDescription = "Usuario o contraseña incorrectos"
        } else {
            loginError = false
            errorDescription = ""
            users.saveUser(user)
        }
    }

    fun isLoggedIn(): Boolean {
        return users.isLoggedIn()
    }
}
