package marquez.emiliano.mipokedex_marquezemiliano.model.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.model.preferences.PokemonSerializer
import marquez.emiliano.mipokedex_marquezemiliano.model.preferences.UserPreferences

val Context.dataStore: DataStore<Pokemon> by dataStore(
    fileName = "pokemon.json",
    serializer = PokemonSerializer,
    scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
)

class CompanionPreferences(private val context: Context) {
    private val shared = context.getSharedPreferences(
        UserPreferences.ARCHIVO,
        Context.MODE_PRIVATE
    )

    suspend fun saveCompanion(companion: Pokemon) {
        context.dataStore.updateData {
            companion
        }
        shared.edit().putLong("companion_selection_time", System.currentTimeMillis()).apply()
    }

    fun pokemonCompanion(): Flow<Pokemon> = context.dataStore.data.map { pokemon ->
        pokemon
    }

    fun getCompanionDays(): Int {
        val selectionTime = shared.getLong("companion_selection_time", 0L)
        if (selectionTime == 0L) return 0
        val diffMillis = System.currentTimeMillis() - selectionTime
        val days = (diffMillis / (1000 * 60 * 60 * 24)).toInt()
        return if (days < 0) 0 else days
    }
}
