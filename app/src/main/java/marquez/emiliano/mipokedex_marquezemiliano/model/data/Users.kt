package marquez.emiliano.mipokedex_marquezemiliano.model.data

import android.content.Context
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.User
import marquez.emiliano.mipokedex_marquezemiliano.model.preferences.UserPreferences

class Users(context: Context) {
    private val shared = context.getSharedPreferences(
        UserPreferences.ARCHIVO,
        Context.MODE_PRIVATE
    )

    private val users = listOf(
        User("ash@pokemon.com", "pikachu", "Ash"),
        User("misty@pokemon.com", "starmie", "Misty"),
        User("brock@pokemon.com", "onix", "Brock")
    )

    fun getUserByMail(mail: String): User? {
        return users.firstOrNull { it.email == mail }
    }

    fun loginService(email: String, password: String): User? {
        return getUserByMail(email)?.takeIf { it.password == password }
    }

    fun saveUser(user: User) {
        shared.edit()
            .putString(UserPreferences.USER, user.email)
            .putString(UserPreferences.USERNAME, user.name)
            .apply()
    }

    fun isLoggedIn(): Boolean {
        return !shared.getString(UserPreferences.USER, null).isNullOrEmpty() &&
            !shared.getString(UserPreferences.USERNAME, null).isNullOrEmpty()
    }

    fun logout() {
        shared.edit().clear().apply()
    }
}
