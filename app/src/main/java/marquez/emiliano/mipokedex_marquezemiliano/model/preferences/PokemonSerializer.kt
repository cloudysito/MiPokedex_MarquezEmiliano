package marquez.emiliano.mipokedex_marquezemiliano.model.preferences

import androidx.datastore.core.Serializer
import kotlinx.serialization.json.Json
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon
import java.io.InputStream
import java.io.OutputStream

object PokemonSerializer : Serializer<Pokemon> {
    override val defaultValue: Pokemon = Pokemon(
        name = "",
        number = -1,
        type = "",
        description = "",
        height = 0f,
        weight = 0f,
        favorite = false,
        ability = "",
        image = R.drawable.bulbasaur
    )

    override suspend fun readFrom(input: InputStream): Pokemon {
        return try {
            val bytes = input.readBytes()
            if (bytes.isEmpty()) {
                defaultValue
            } else {
                Json.decodeFromString(
                    deserializer = Pokemon.serializer(),
                    string = bytes.decodeToString()
                )
            }
        } catch (exception: Exception) {
            defaultValue
        }
    }

    override suspend fun writeTo(
        t: Pokemon,
        output: OutputStream
    ) {
        try {
            output.write(
                Json.encodeToString(
                    serializer = Pokemon.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        } catch (exception: Exception) {
            // Safe fallback
        }
    }
}
