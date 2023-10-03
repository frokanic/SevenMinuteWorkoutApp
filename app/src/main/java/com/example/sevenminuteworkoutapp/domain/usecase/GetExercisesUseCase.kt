package com.example.sevenminuteworkoutapp.domain.usecase

import com.example.sevenminuteworkoutapp.data.model.Exercise
import com.example.sevenminuteworkoutapp.data.repository.ExerciseRepository
import com.example.sevenminuteworkoutapp.domain.model.ExerciseUIModel

class GetExercisesUseCase(
    private val exerciseRepository: ExerciseRepository
) {

    fun execute(): List<ExerciseUIModel> {
        return mapDomainToUI(exerciseRepository.getExercises())
    }

    private fun mapDomainToUI(exercises: List<Exercise>): List<ExerciseUIModel> {
        return exercises.map {
            ExerciseUIModel(
                id = it.id,
                name = it.name,
                image = it.image,
                isCompleted = it.isCompleted,
                isSelected = false
            )
        }
    }
}