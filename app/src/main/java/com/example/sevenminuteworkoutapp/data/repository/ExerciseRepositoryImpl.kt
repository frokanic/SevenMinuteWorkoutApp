package com.example.sevenminuteworkoutapp.data.repository

import com.example.sevenminuteworkoutapp.data.local.ExerciseDataSource
import com.example.sevenminuteworkoutapp.data.model.Exercise

class ExerciseRepositoryImpl(
    private val exerciseDataSource: ExerciseDataSource
): ExerciseRepository {

    override fun getExercises(): List<Exercise> {
        return exerciseDataSource.getExercises()
    }
}
