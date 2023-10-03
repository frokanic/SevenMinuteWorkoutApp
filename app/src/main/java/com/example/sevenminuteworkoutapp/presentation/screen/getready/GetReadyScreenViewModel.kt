package com.example.sevenminuteworkoutapp.presentation.screen.getready

import android.os.CountDownTimer
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class GetReadyScreenViewModel: ViewModel() {

    var seconds = mutableIntStateOf(10)
    var totalSeconds = mutableIntStateOf(10)

    var shouldNavigate: MutableState<Boolean> = mutableStateOf(false)

    init {
        countDownTimer()
    }

    private fun countDownTimer() {

        val restTimer = object: CountDownTimer(10000, 1000) {
            override fun onTick(p0: Long) {
                seconds.intValue--
            }

            override fun onFinish() {
                shouldNavigate.value = true
            }
        }
        restTimer.start()
    }
}