package com.example.sevenminuteworkoutapp.data.local

import com.example.sevenminuteworkoutapp.data.model.Exercise
import com.example.sevenminuteworkoutapp.domain.model.ExerciseUIModel

interface ExerciseDataSource {

    fun getExercises(): List<Exercise>

}