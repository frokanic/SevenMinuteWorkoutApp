package com.example.sevenminuteworkoutapp.presentation.util

sealed class Screen(val route: String) {
    object InitialScreen: Screen("initial_screen")
    object GetReadyScreen: Screen("get_ready_screen")
    object ExerciseScreen: Screen("exercise_screen")
}
