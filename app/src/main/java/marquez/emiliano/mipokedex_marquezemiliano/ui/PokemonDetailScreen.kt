package marquez.emiliano.mipokedex_marquezemiliano.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import marquez.emiliano.mipokedex_marquezemiliano.model.PokemonDetailData
import marquez.emiliano.mipokedex_marquezemiliano.model.RelatedPokemon
import marquez.emiliano.mipokedex_marquezemiliano.model.sampleGengarData
import marquez.emiliano.mipokedex_marquezemiliano.ui.components.PokemonDetailContentCard
import marquez.emiliano.mipokedex_marquezemiliano.ui.components.PokemonDetailHeader
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.PokemonDetailTheme

@Composable
fun PokemonDetailScreen(
    pokemonData: PokemonDetailData = sampleGengarData(),
    modifier: Modifier = Modifier,
    onFavoriteClick: () -> Unit = {},
    onPreviousClick: () -> Unit = {},
    onNextClick: () -> Unit = {},
    onRelatedPokemonClick: (RelatedPokemon) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(pokemonData.headerBgColor)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            PokemonDetailHeader(
                name = pokemonData.name,
                number = pokemonData.number,
                starIconRes = pokemonData.starIconRes,
                pokeballBgRes = pokemonData.bgPokeballRes,
                onFavoriteClick = onFavoriteClick
            )

            PokemonDetailContentCard(
                pokemonData = pokemonData,
                onPreviousClick = onPreviousClick,
                onNextClick = onNextClick,
                onRelatedPokemonClick = onRelatedPokemonClick,
                modifier = Modifier.weight(1f)
            )
        }

        Image(
            painter = painterResource(id = pokemonData.mainImageRes),
            contentDescription = pokemonData.name,
            modifier = Modifier
                .size(240.dp)
                .align(Alignment.TopCenter)
                .offset(y = 110.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PokemonDetailScreenPreview() {
    PokemonDetailTheme {
        PokemonDetailScreen()
    }
}
