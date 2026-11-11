package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import marquez.emiliano.mipokedex_marquezemiliano.model.data.bulbasaur
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Purple40
import marquez.emiliano.mipokedex_marquezemiliano.ui.theme.Typography
import marquez.emiliano.mipokedex_marquezemiliano.utilities.getColorByType
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.UserViewModel

@Composable
fun ProfileScreen(innerPadding: PaddingValues, userViewModel: UserViewModel = viewModel()){
    val companionState by userViewModel.companion.collectAsState()
    val pokemon = if (companionState.name.isNotEmpty()) companionState else bulbasaur
    val companionDays = userViewModel.getCompanionDays()
    val daysText = if (companionDays == 1) "1 día de ser tu compañero" else "$companionDays días de ser tu compañero"

    Column(
        Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            userViewModel.currentUser?.name ?: "nombre usuario",
            style = Typography.displayLarge,
            color = Purple40
        )
        Text(
            userViewModel.currentUser?.email ?: "usuario@mail.com",
            style = Typography.titleLarge,
            color = Purple40
        )
        Spacer(Modifier.size(50.dp))
        Text("Mi compañero", style = Typography.titleLarge)
        Image(painterResource(pokemon.image), contentDescription = pokemon.name + "image")
        Text(pokemon.name, style = Typography.titleMedium, color = getColorByType(pokemon.type).first)
        Spacer(Modifier.size(8.dp))
        Text(
            text = daysText,
            style = Typography.bodyLarge,
            color = Purple40
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen(){
    ProfileScreen(PaddingValues())
}
