
# TIMA Android Prototype – AI Generation Prompt

Actúa como un **ingeniero senior de Android especializado en Jetpack Compose**.

Debes generar el código base de una **aplicación Android navegable (no funcional)** llamada **TIMA**.

La aplicación **NO necesita lógica de negocio ni conexión con APIs, sensores o backend**.  
El objetivo es **simular el flujo de navegación entre pantallas** basado en wireframes de UX.

---

# Stack tecnológico obligatorio

Usar:

- Kotlin
- Jetpack Compose
- Material Design 3
- Navigation Compose
- Android Studio (Kotlin DSL)

NO usar:

- Base de datos
- APIs
- Backend
- Bluetooth
- Sensores
- Smartwatch real
- Persistencia

Los datos deben ser **estáticos o simulados**.

---

# Objetivo de la aplicación

Crear un **prototipo navegable de la app TIMA**, una aplicación que:

- programa alarmas
- obliga al usuario a completar un reto físico
- se sincroniza con un smartwatch
- registra actividad física
- sincroniza datos en la nube

Esta versión es **solo una simulación visual**.

---

# Flujo de pantallas

## Onboarding / sincronización de reloj

1. SplashScreen
2. SyncWatchScreen
3. WatchProviderScreen
4. SyncingWatchScreen
5. WatchSyncedScreen

## Flujo de alarma

6. CreateAlarmScreen  
7. AlarmScheduledScreen

## Flujo de reto

8. CreateChallengeScreen  
9. ExerciseTypeScreen  
10. HeartRateScreen  
11. StepsGpsScreen

## Sincronización en nube

12. DataSyncPromptScreen  
13. LoginScreen  
14. CloudSyncProgressScreen  
15. SyncCompletedScreen

## Pantalla final

16. SuccessScreen

---

# Requisitos de diseño

Usar **Material Design 3**.

Estilo visual tipo wireframe:

- fondo blanco
- componentes simples
- botones grandes
- diseño limpio

Componentes recomendados:

- Column
- Card
- Button
- TextField
- Icon

---

# Navegación

Implementar navegación con **Navigation Compose**.

Crear:

navigation/
- AppRoutes.kt
- AppNavGraph.kt

Las rutas deben incluir:

Splash  
SyncWatch  
WatchProvider  
SyncingWatch  
WatchSynced  
CreateAlarm  
AlarmScheduled  
CreateChallenge  
ExerciseType  
HeartRate  
StepsGps  
DataSyncPrompt  
Login  
CloudSyncProgress  
SyncCompleted  
Success  

Cada pantalla debe tener **un botón que navegue a la siguiente**.

---

# Estructura del proyecto

app/
src/main/java/com/tima/app/

- MainActivity.kt
- navigation/
  - AppRoutes.kt
  - AppNavGraph.kt
- ui/
  - screens/
  - components/

---

# Componentes reutilizables

Crear:

- PrimaryButton
- SecondaryButton
- AppHeader
- ProgressCard

---

# Entregables

La IA debe generar:

1. MainActivity
2. AppNavGraph completo
3. Definición de rutas
4. Todas las pantallas Compose
5. Componentes reutilizables

El proyecto debe **compilar y permitir navegar entre todas las pantallas**.

---

# Restricciones

NO implementar:

- backend
- login real
- base de datos
- sensores
- APIs externas

Todo debe ser **simulación visual para un prototipo UX**.
