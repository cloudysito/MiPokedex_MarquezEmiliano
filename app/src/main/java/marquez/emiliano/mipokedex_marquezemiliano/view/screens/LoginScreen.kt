package marquez.emiliano.mipokedex_marquezemiliano.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import marquez.emiliano.mipokedex_marquezemiliano.model.data.CompanionPreferences
import marquez.emiliano.mipokedex_marquezemiliano.model.data.Users
import marquez.emiliano.mipokedex_marquezemiliano.viewmodel.UserViewModel

@Composable
fun LoginScreen(
    innerPadding: PaddingValues,
    users: Users,
    onNavigateToMenu: () -> Unit,
    context: android.content.Context = LocalContext.current,
    viewModel: UserViewModel = remember(users, context) { UserViewModel(users, CompanionPreferences(context)) }
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        if (viewModel.isLoggedIn()) {
            onNavigateToMenu()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Correo") }
        )
        Spacer(Modifier.size(12.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(Modifier.size(12.dp))
        Button(onClick = {
            viewModel.login(email, password)
            if (!viewModel.loginError) {
                onNavigateToMenu()
            }
        }) {
            Text("Iniciar sesión")
        }
        if (viewModel.loginError) {
            Text(
                text = viewModel.errorDescription,
                color = Color.Red,
                fontStyle = FontStyle.Italic
            )
        }
    }
}
