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
import androidx.navigation.compose.rememberNavController
import com.example.sevenminuteworkoutapp.presentation.screen.exercise.ExerciseScreenViewModel
import com.example.sevenminuteworkoutapp.presentation.screen.getready.GetReadyScreen
import com.example.sevenminuteworkoutapp.presentation.screen.getready.GetReadyScreenViewModel
import com.example.sevenminuteworkoutapp.presentation.screen.initial.InitialScreen
import com.example.sevenminuteworkoutapp.presentation.ui.theme.SevenMinuteWorkoutAppTheme
import com.example.sevenminuteworkoutapp.presentation.util.Screen
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.compose.viewModel
import org.koin.androidx.scope.activityScope
import org.koin.core.scope.Scope

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
                        composable(route = Screen.GetReadyScreen.route) {
                            val viewModel: GetReadyScreenViewModel by viewModel()
                            GetReadyScreen(navController = navController, viewModel = viewModel)
                        }
                        composable(route = Screen.ExerciseScreen.route) {
                            val viewModel: ExerciseScreenViewModel by viewModel()

                        }
                    }
                }
            }
        }
    }
}