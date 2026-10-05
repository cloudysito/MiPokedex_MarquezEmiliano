package marquez.emiliano.mipokedex_marquezemiliano.data

import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.domain.Pokemon

class Pokemons {
    val pokemonList = listOf(
        Pokemon("Bulbasaur", 1, "Grass/Poison", "There is a plant seed on its back from the day this Pokémon is born.", 0.7f, 6.9f, false, "Overgrow", R.drawable.bulbasaur),
        Pokemon("Charmander", 4, "Fire", "The flame on its tail shows the strength of its life force.", 0.6f, 8.5f, true, "Blaze", R.drawable.charmander),
        Pokemon("Dreepy", 885, "Dragon/Ghost", "After being reborn as a ghost Pokémon, it wanders the skies searching for memories of its past life.", 0.5f, 2.0f, false, "Clear Body", R.drawable.dreepy),
        Pokemon("Azelf", 482, "Psychic", "Known as the Being of Willpower, it is said that it gave humans the determination to overcome difficulties.", 0.3f, 0.3f, true, "Levitate", R.drawable.azelf),
        Pokemon("Jigglypuff", 39, "Normal/Fairy", "Uses its alluring eyes to enrapture its foe, then sings a pleasant melody to lull them to sleep.", 0.5f, 5.5f, false, "Cute Charm", R.drawable.jigglypuff),
        Pokemon("Gengar", 94, "Ghost/Poison", "Under a full moon, this Pokémon likes to mimic the shadows of people and laugh at their fright.", 1.5f, 40.5f, true, "Cursed Body", R.drawable.gengar),
        Pokemon("Snorlax", 143, "Normal", "Its stomach is said to be so strong that it can even eat moldy or rotten food.", 2.1f, 460.0f, false, "Immunity", R.drawable.snorlax),
        Pokemon("Mew", 151, "Psychic", "Its DNA is said to contain the genetic codes of all Pokémon, allowing it to use all kinds of techniques.", 0.4f, 4.0f, true, "Synchronize", R.drawable.mew),
        Pokemon("Porygon-Z", 474, "Normal", "Its programming was modified to enable travel through alien dimensions, resulting in erratic behavior.", 0.9f, 34.0f, true, "Adaptability", R.drawable.porygon_z),
        Pokemon("Mimikyu", 778, "Ghost/Fairy", "Its actual appearance is unknown. A scholar who saw what was under its rag overwhelmed by terror and died.", 0.2f, 0.7f, false, "Disguise", R.drawable.mimikyu)
    )

    val gengar = Pokemon(
        "Gengar",
        94,
        "Ghost/Poison",
        "Under a full moon, this Pokémon likes to mimic the shadows of people and laugh at their fright.",
        1.5f,
        40.5f,
        true,
        "Cursed Body",
        R.drawable.gengar
    )
}
