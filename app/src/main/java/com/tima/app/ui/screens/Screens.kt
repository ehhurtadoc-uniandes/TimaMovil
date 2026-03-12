package com.tima.app.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.tima.app.R
import com.tima.app.navigation.AppRoutes
import com.tima.app.ui.components.*

@Composable
fun SimpleScreenLayout(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Scaffold(
        topBar = { AppHeader(title) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = content
        )
    }
}

// 1. SplashScreen
@Composable
fun SplashScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        contentAlignment = Alignment.Center
    ) {
        // Logo centrado en el medio exacto de la pantalla
        Image(
            painter = painterResource(id = R.drawable.tima_logo),
            contentDescription = "TIMA Logo",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .wrapContentHeight()
        )

        // Botón en la parte inferior
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 48.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Button(
                onClick = { navController.navigate(AppRoutes.SYNC_WATCH) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0A1F44)
                ),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(
                    text = "Comenzar",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White
                )
            }
        }
    }
}

// 2. SyncWatchScreen
@Composable
fun SyncWatchScreen(navController: NavController) {
    SimpleScreenLayout(title = "Sincronizar Reloj") {
        Text("Conecta  tu smartwatch para empezar", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Buscar Dispositivos", onClick = { navController.navigate(AppRoutes.WATCH_PROVIDER) })
    }
}

// 3. WatchProviderScreen
@Composable
fun WatchProviderScreen(navController: NavController) {
    SimpleScreenLayout(title = "Selecciona Proveedor") {
        SecondaryButton("Garmin", onClick = { navController.navigate(AppRoutes.SYNCING_WATCH) })
        Spacer(modifier = Modifier.height(16.dp))
        SecondaryButton("Wear OS", onClick = { navController.navigate(AppRoutes.SYNCING_WATCH) })
        Spacer(modifier = Modifier.height(16.dp))
        SecondaryButton("Apple Watch", onClick = { navController.navigate(AppRoutes.SYNCING_WATCH) })
    }
}

// 4. SyncingWatchScreen
@Composable
fun SyncingWatchScreen(navController: NavController) {
    SimpleScreenLayout(title = "Sincronizando...") {
        LinearProgressIndicator(
            progress = 0f,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Conectando con el reloj...")
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Continuar", onClick = { navController.navigate(AppRoutes.WATCH_SYNCED) })
    }
}

// 5. WatchSyncedScreen
@Composable
fun WatchSyncedScreen(navController: NavController) {
    SimpleScreenLayout(title = "Reloj Conectado") {
        Text("¡Sincronización Exitosa!", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Siguiente", onClick = { navController.navigate(AppRoutes.CREATE_ALARM) })
    }
}

// 6. CreateAlarmScreen
@Composable
fun CreateAlarmScreen(navController: NavController) {
    SimpleScreenLayout(title = "Crear Alarma") {
        OutlinedTextField(value = "06:30 AM", onValueChange = {}, label = { Text("Hora") }, readOnly = true)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Guardar Alarma", onClick = { navController.navigate(AppRoutes.ALARM_SCHEDULED) })
    }
}

// 7. AlarmScheduledScreen
@Composable
fun AlarmScheduledScreen(navController: NavController) {
    SimpleScreenLayout(title = "Alarma Programada") {
        Text("Tu alarma está lista para las 06:30 AM", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Crear Reto", onClick = { navController.navigate(AppRoutes.CREATE_CHALLENGE) })
    }
}

// 8. CreateChallengeScreen
@Composable
fun CreateChallengeScreen(navController: NavController) {
    SimpleScreenLayout(title = "Crear Reto") {
        Text("Define un reto físico para apagar la alarma")
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Elegir Ejercicio", onClick = { navController.navigate(AppRoutes.EXERCISE_TYPE) })
    }
}

// 9. ExerciseTypeScreen
@Composable
fun ExerciseTypeScreen(navController: NavController) {
    SimpleScreenLayout(title = "Tipo de Ejercicio") {
        SecondaryButton("Pasos (GPS)", onClick = { navController.navigate(AppRoutes.HEART_RATE) })
        Spacer(modifier = Modifier.height(16.dp))
        SecondaryButton("Mantener Ritmo Cardíaco", onClick = { navController.navigate(AppRoutes.HEART_RATE) })
    }
}

// 10. HeartRateScreen
@Composable
fun HeartRateScreen(navController: NavController) {
    SimpleScreenLayout(title = "Ritmo Cardíaco") {
        ProgressCard("BPM Actual vs Objetivo", 0.6f)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Siguiente Prueba", onClick = { navController.navigate(AppRoutes.STEPS_GPS) })
    }
}

// 11. StepsGpsScreen
@Composable
fun StepsGpsScreen(navController: NavController) {
    SimpleScreenLayout(title = "Pasos / GPS") {
        ProgressCard("Distancia recorrida", 0.8f)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Sincronizar Datos", onClick = { navController.navigate(AppRoutes.DATA_SYNC_PROMPT) })
    }
}

// 12. DataSyncPromptScreen
@Composable
fun DataSyncPromptScreen(navController: NavController) {
    SimpleScreenLayout(title = "Sincronizar con la Nube") {
        Text("¿Deseas guardar tus progresos en la nube?")
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Iniciar Sesión / Sincronizar", onClick = { navController.navigate(AppRoutes.LOGIN) })
    }
}

// 13. LoginScreen
@Composable
fun LoginScreen(navController: NavController) {
    SimpleScreenLayout(title = "Iniciar Sesión") {
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Usuario") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Contraseña") })
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Ingresar", onClick = { navController.navigate(AppRoutes.CLOUD_SYNC_PROGRESS) })
    }
}

// 14. CloudSyncProgressScreen
@Composable
fun CloudSyncProgressScreen(navController: NavController) {
    SimpleScreenLayout(title = "Subiendo Datos") {
        LinearProgressIndicator(
            progress = 0f,  // Float directo — compatible con Material3 1.1.x
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text("Por favor, espera...")
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Continuar", onClick = { navController.navigate(AppRoutes.SYNC_COMPLETED) })
    }
}

// 15. SyncCompletedScreen
@Composable
fun SyncCompletedScreen(navController: NavController) {
    SimpleScreenLayout(title = "Sincronización Completa") {
        Text("Tus datos están seguros en la nube", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        PrimaryButton("Ver Resumen", onClick = { navController.navigate(AppRoutes.SUCCESS) })
    }
}

// 16. SuccessScreen
@Composable
fun SuccessScreen(navController: NavController) {
    SimpleScreenLayout(title = "¡Reto Completado!") {
        Text("¡Has superado tu reto de hoy! Vuelve a descansar tranquilamente.", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(32.dp))
        SecondaryButton("Volver al Inicio", onClick = { 
            navController.navigate(AppRoutes.SPLASH) {
                popUpTo(AppRoutes.SPLASH) { inclusive = true }
            }
        })
    }
}
