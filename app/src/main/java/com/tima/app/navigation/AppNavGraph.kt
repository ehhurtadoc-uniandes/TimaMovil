package com.tima.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tima.app.ui.screens.*

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.SYNC_WATCH) {
        composable(AppRoutes.SYNC_WATCH) { SyncWatchScreen(navController) }
        composable(AppRoutes.WATCH_PROVIDER) { WatchProviderScreen(navController) }
        composable(AppRoutes.SYNCING_WATCH) { SyncingWatchScreen(navController) }
        composable(AppRoutes.WATCH_SYNCED) { WatchSyncedScreen(navController) }
        composable(AppRoutes.CREATE_ALARM) { CreateAlarmScreen(navController) }
        composable(AppRoutes.ALARM_SCHEDULED) { AlarmScheduledScreen(navController) }
        composable(AppRoutes.CREATE_CHALLENGE) { CreateChallengeScreen(navController) }
        composable(AppRoutes.EXERCISE_TYPE) { ExerciseTypeScreen(navController) }
        composable(AppRoutes.HEART_RATE) { HeartRateScreen(navController) }
        composable(AppRoutes.STEPS_GPS) { StepsGpsScreen(navController) }
        composable(AppRoutes.DATA_SYNC_PROMPT) { DataSyncPromptScreen(navController) }
        composable(AppRoutes.LOGIN) { LoginScreen(navController) }
        composable(AppRoutes.CLOUD_SYNC_PROGRESS) { CloudSyncProgressScreen(navController) }
        composable(AppRoutes.SYNC_COMPLETED) { SyncCompletedScreen(navController) }
        composable(AppRoutes.SUCCESS) { SuccessScreen(navController) }
    }
}
