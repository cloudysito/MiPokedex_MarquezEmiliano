package marquez.emiliano.mipokedex_marquezemiliano.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.model.PokemonDetailData
import marquez.emiliano.mipokedex_marquezemiliano.model.RelatedPokemon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.RedPokedex

/**
 * Custom Composable for Pokemon Type Badges (e.g. Fantasma, Veneno)
 */
@Composable
fun PokemonTypeBadge(
    text: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
) {
    Text(
        text = text,
        color = textColor,
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        textAlign = TextAlign.Center,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .padding(horizontal = 20.dp, vertical = 6.dp),
    )
}

/**
 * Custom Composable for individual Pokemon Stats (e.g. Altura 1.50m, Peso 40.5kg, Habilidad Cuerpo Maldito)
 */
@Composable
fun PokemonStatItem(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    labelColor: Color = RedPokedex,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        Text(
            text = label,
            color = labelColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = value,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Black,
        )
    }
}

/**
 * Custom Composable for related/evolution Pokemon items
 */
@Composable
fun PokemonRelatedCard(
    relatedPokemon: RelatedPokemon,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier.clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(id = relatedPokemon.imageRes),
            contentDescription = relatedPokemon.nameWithNumber,
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Fit,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = relatedPokemon.nameWithNumber,
            fontSize = 14.sp,
            color = Color.Black,
            textAlign = TextAlign.Center,
        )
    }
}

/**
 * Custom Composable for the Top Detail Header (Name, Star icon, Pokeball background watermark, Pokemon number)
 */
@Composable
fun PokemonDetailHeader(
    name: String,
    number: String,
    @DrawableRes starIconRes: Int,
    @DrawableRes pokeballBgRes: Int,
    onFavoriteClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(260.dp),
    ) {
        // Pokeball watermark top-right
        Image(
            painter = painterResource(id = pokeballBgRes),
            contentDescription = null,
            modifier = Modifier
                .size(190.dp)
                .align(Alignment.TopEnd)
                .offset(x = 10.dp, y = 20.dp),
            alpha = 0.9f,
        )

        // Name and Favorite Star
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 48.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = name,
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Black,
            )
            Image(
                painter = painterResource(id = starIconRes),
                contentDescription = "Favorite",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onFavoriteClick() },
            )
        }

        // Pokemon Number
        Text(
            text = number,
            color = Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 48.dp, top = 92.dp),
        )
    }
}

/**
 * Custom Composable for the bottom curved white card containing stats, description, related pokemon, and navigation buttons
 */
@Composable
fun PokemonDetailContentCard(
    pokemonData: PokemonDetailData,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    onRelatedPokemonClick: (RelatedPokemon) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        color = Color.White,
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 90.dp, bottom = 20.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.fillMaxWidth(),
            ) {
                // Type Badges Row
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    pokemonData.types.forEachIndexed { index, type ->
                        if (index > 0) Spacer(modifier = Modifier.width(16.dp))
                        PokemonTypeBadge(
                            text = type.name,
                            backgroundColor = type.color,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Stats Section
                // Row 1: Height and Ability
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    PokemonStatItem(
                        label = stringResource(id = R.string.altura),
                        value = pokemonData.height,
                    )
                    PokemonStatItem(
                        label = stringResource(id = R.string.habilidad),
                        value = pokemonData.ability,
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Row 2: Weight
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    PokemonStatItem(
                        label = stringResource(id = R.string.peso),
                        value = pokemonData.weight,
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Description
                Text(
                    text = pokemonData.description,
                    fontSize = 18.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    lineHeight = 24.sp,
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(24.dp))

                // Related Pokemon Section
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    PokemonRelatedCard(
                        relatedPokemon = pokemonData.relatedPokemonLeft,
                        onClick = { onRelatedPokemonClick(pokemonData.relatedPokemonLeft) },
                    )
                    PokemonRelatedCard(
                        relatedPokemon = pokemonData.relatedPokemonRight,
                        onClick = { onRelatedPokemonClick(pokemonData.relatedPokemonRight) },
                    )
                }
            }

            // Bottom Navigation Arrows
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.flecha_izquierda),
                    contentDescription = "Previous",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { onPreviousClick() },
                )
                Image(
                    painter = painterResource(id = R.drawable.flecha_derecha),
                    contentDescription = "Next",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { onNextClick() },
                )
            }
        }
    }
}
