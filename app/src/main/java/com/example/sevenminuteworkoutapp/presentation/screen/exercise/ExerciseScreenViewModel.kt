package com.example.sevenminuteworkoutapp.presentation.screen.exercise

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sevenminuteworkoutapp.domain.model.ExerciseUIModel
import com.example.sevenminuteworkoutapp.domain.usecase.GetExercisesUseCase

class ExerciseScreenViewModel(
    private val getExercisesUseCase: GetExercisesUseCase
): ViewModel() {

    private lateinit var exerciseList: List<ExerciseUIModel>

    var seconds = mutableIntStateOf(30)
    var totalSeconds = mutableIntStateOf(30)

    var shouldNavigate: MutableState<Boolean> = mutableStateOf(false)

    init {
        getExercises()
        countDownTimer()
    }

    private fun getExercises() {
        exerciseList = getExercisesUseCase.execute()
    }

    private fun countDownTimer() {

        val exerciseTimer = object: CountDownTimer(30000, 1000) {
            override fun onTick(p0: Long) {
                seconds.intValue--
            }

            override fun onFinish() {
                shouldNavigate.value = true
            }
        }
        exerciseTimer.start()
    }
}