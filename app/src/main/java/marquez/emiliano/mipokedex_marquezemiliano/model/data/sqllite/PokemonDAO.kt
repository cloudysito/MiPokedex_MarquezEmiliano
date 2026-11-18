package marquez.emiliano.mipokedex_marquezemiliano.model.data.sqllite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import marquez.emiliano.mipokedex_marquezemiliano.model.data.interfaces.IPokemonDAO
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon

class PokemonDAO(private val databaseHelper: DatabaseHelper) : IPokemonDAO {
    private val mapper = PokemonMapper()

    override suspend fun insertPokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = databaseHelper.writableDatabase
            db.insert(Contract.Pokemons.TABLE_NAME, null, mapper.getContentValues(pokemon))
            db.close()
        }
    }

    override suspend fun getAllPokemons(): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = databaseHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME}"
            val cursor = db.rawQuery(query, null)
            cursor.use { c ->
                buildList {
                    while (c.moveToNext()) {
                        add(mapper.getPokemon(c))
                    }
                }
            }
        }
    }

    override suspend fun getPokemonById(id: Int): Pokemon? {
        return withContext(Dispatchers.IO) {
            val db = databaseHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_ID} = ?"
            val cursor = db.rawQuery(query, arrayOf(id.toString()))
            cursor.use {
                if (it.moveToFirst()) {
                    mapper.getPokemon(it)
                } else {
                    null
                }
            }
        }
    }

    override suspend fun getFavoritePokemons(): List<Pokemon> {
        TODO("Not yet implemented")
    }

    override suspend fun getPokemonByType(type: String): List<Pokemon> {
        return withContext(Dispatchers.IO) {
            val db = databaseHelper.readableDatabase
            val query = "SELECT * FROM ${Contract.Pokemons.TABLE_NAME} WHERE ${Contract.Pokemons.COLUMN_NAME_TYPE} = ?"
            val cursor = db.rawQuery(query, arrayOf(type))
            cursor.use {
                buildList {
                    while (it.moveToNext()) {
                        add(mapper.getPokemon(it))
                    }
                }
            }
        }
    }

    override suspend fun updatePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = databaseHelper.writableDatabase
            val values = mapper.getContentValues(pokemon)
            db.update(
                Contract.Pokemons.TABLE_NAME,
                values,
                "${Contract.Pokemons.COLUMN_ID} = ?",
                arrayOf(pokemon.number.toString())
            )
            db.close()
        }
    }

    override suspend fun deletePokemon(pokemon: Pokemon) {
        withContext(Dispatchers.IO) {
            val db = databaseHelper.writableDatabase
            db.delete(
                Contract.Pokemons.TABLE_NAME,
                "${Contract.Pokemons.COLUMN_ID} = ?",
                arrayOf(pokemon.number.toString())
            )
            db.close()
        }
    }
}
