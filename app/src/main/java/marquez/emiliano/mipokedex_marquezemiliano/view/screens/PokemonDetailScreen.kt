package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import marquez.emiliano.mipokedex_marquezemiliano.R
import marquez.emiliano.mipokedex_marquezemiliano.model.data.bulbasaur
import marquez.emiliano.mipokedex_marquezemiliano.model.domain.Pokemon
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Grey
import marquez.emiliano.mipokedex_marquezemiliano.utilities.getColorByType

@Composable
fun PokemonDetailScreen(
    innerPadding: PaddingValues,
    pokemon: Pokemon,
    colors: Pair<Color, Color> = getColorByType(pokemon.type)
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colors.first)
            .padding(innerPadding)
    ) {
        Column(
            modifier = Modifier
                .padding(start = 25.dp)
        ) {
            Text(
                text = pokemon.name,
                color = colors.second,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "N° " + pokemon.number,
                modifier = Modifier
                    .padding(horizontal = 20.dp),
                color = Grey,
                fontSize = 20.sp
            )
        }
        Image(
            painter = painterResource(id = R.drawable.estrella),
            contentDescription = "star",
            modifier = Modifier
                .padding(10.dp)
                .size(45.dp)
                .align(Alignment.TopEnd)
        )
        Image(
            painter = painterResource(id = R.drawable.pokeball),
            contentDescription = "pokeball",
            modifier = Modifier
                .offset(x = 200.dp, y = 65.dp)
                .size(230.dp)
        )
        CuadroBlanco(pokemon)
        Image(
            painter = painterResource(pokemon.image),
            contentDescription = "${pokemon.name} image",
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 25.dp)
                .size(260.dp),
            alignment = Alignment.Center
        )
    }
}

@Composable
fun CuadroBlanco(pokemon: Pokemon) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 220.dp),
        shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 80.dp, start = 24.dp, end = 24.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val types = pokemon.type.split("/")
                types.forEach { type ->
                    val (typeColor, textColor) = getColorByType(type.trim())
                    Surface(
                        shape = RoundedCornerShape(16.dp),
                        color = typeColor
                    ) {
                        Text(
                            text = type.trim(),
                            color = textColor,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${pokemon.height} m",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Altura",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = "${pokemon.weight} kg",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Peso",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = pokemon.ability,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Habilidad",
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = pokemon.description,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonDetailScreenPreview() {
    PokemonDetailScreen(PaddingValues(10.dp, 15.dp), bulbasaur, getColorByType(bulbasaur.type))
}
