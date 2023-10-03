package com.example.sevenminuteworkoutapp.domain.model

data class ExerciseUIModel (
    val id: Int,
    val name: String,
    val image: Int,
    val isCompleted: Boolean,
    val isSelected: Boolean
)