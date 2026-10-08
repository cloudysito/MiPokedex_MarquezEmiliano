package marquez.emiliano.mipokedex_marquezemiliano.model.domain

data class PokedexState(
    val team: List<Pokemon> = emptyList(),
    val lastCaptured: Pokemon? = null
)
