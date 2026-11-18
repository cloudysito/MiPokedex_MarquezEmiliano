package marquez.emiliano.mipokedex_marquezemiliano.model.data.sqllite

import android.content.ContentValues
import android.database.Cursor
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

class PokemonMapper {
    fun getPokemon(cursor: Cursor): Pokemon {
        val name = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_NAME))
        val number = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_NUMBER))
        val type = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_TYPE))
        val description = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_DESCRIPTION))
        val height = cursor.getFloat(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_HEIGHT))
        val weight = cursor.getFloat(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_WEIGHT))
        val favorite = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_FAVORITE)) == 1
        val ability = cursor.getString(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_ABILITY))
        val image = cursor.getInt(cursor.getColumnIndexOrThrow(Contract.Pokemons.COLUMN_NAME_IMAGE))

        return Pokemon(
            name = name,
            number = number,
            type = type,
            description = description,
            height = height,
            weight = weight,
            favorite = favorite,
            ability = ability,
            image = image
        )
    }

    fun getContentValues(pokemon: Pokemon): ContentValues {
        val values = ContentValues().apply {
            put(Contract.Pokemons.COLUMN_NAME_NUMBER, pokemon.number)
            put(Contract.Pokemons.COLUMN_NAME_NAME, pokemon.name)
            put(Contract.Pokemons.COLUMN_NAME_TYPE, pokemon.type)
            put(Contract.Pokemons.COLUMN_NAME_DESCRIPTION, pokemon.description)
            put(Contract.Pokemons.COLUMN_NAME_HEIGHT, pokemon.height)
            put(Contract.Pokemons.COLUMN_NAME_WEIGHT, pokemon.weight)
            put(Contract.Pokemons.COLUMN_NAME_FAVORITE, if (pokemon.favorite) 1 else 0)
            put(Contract.Pokemons.COLUMN_NAME_ABILITY, pokemon.ability)
            put(Contract.Pokemons.COLUMN_NAME_IMAGE, pokemon.image)
        }
        return values
    }
}
