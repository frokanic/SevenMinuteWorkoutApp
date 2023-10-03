package com.example.sevenminuteworkoutapp.data.repository

import com.example.sevenminuteworkoutapp.data.model.Exercise

interface ExerciseRepository {

    fun getExercises(): List<Exercise>

}