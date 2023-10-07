package com.example.sevenminuteworkoutapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.sevenminuteworkoutapp.presentation.screen.exercise.GetReadyScreen
import com.example.sevenminuteworkoutapp.presentation.screen.exercise.ExerciseViewModel
import com.example.sevenminuteworkoutapp.presentation.screen.initial.InitialScreen
import com.example.sevenminuteworkoutapp.presentation.ui.theme.SevenMinuteWorkoutAppTheme
import com.example.sevenminuteworkoutapp.presentation.util.Screen
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin

class MainActivity : ComponentActivity(), AndroidScopeComponent {

    override val scope: Scope by activityScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val screenWidth = LocalConfiguration.current.screenWidthDp.dp
            val density = LocalDensity.current.density

            SevenMinuteWorkoutAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.InitialScreen.route
                    ) {
                        composable(route = Screen.InitialScreen.route) {
                            InitialScreen(navController = navController, screenWidth, density)
                        }
                        navigation(
                            startDestination = Screen.GetReadyScreen.route,
                            route = "exercise"
                        ) {
                            val koin = getKoin()
                            val exerciseScope = koin.getOrCreateScope("workout", named("workoutScope"))

                            composable(route = Screen.GetReadyScreen.route) {
                                val viewModel: ExerciseViewModel by exerciseScope.inject()
                                GetReadyScreen(navController = navController, viewModel = viewModel)
                            }
                            composable(route = Screen.ExerciseScreen.route) {
                                val viewModel: ExerciseViewModel by exerciseScope.inject()

                            }
                        }
                    }
                }
            }
        }
    }
}