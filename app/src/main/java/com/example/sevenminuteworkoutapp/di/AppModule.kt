package com.example.sevenminuteworkoutapp.di

import com.example.sevenminuteworkoutapp.data.local.ExerciseDataSourceImpl
import com.example.sevenminuteworkoutapp.data.repository.ExerciseRepositoryImpl
import com.example.sevenminuteworkoutapp.domain.usecase.GetExercisesUseCase
import com.example.sevenminuteworkoutapp.presentation.screen.exercise.ExerciseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    single {
        ExerciseDataSourceImpl()
    }

    single {
        ExerciseRepositoryImpl(get())
    }

    single {
        GetExercisesUseCase(get())
    }

    viewModel {
        ExerciseViewModel()
    }

    scope(named("workoutScope")) {
        scoped {
            ExerciseViewModel()
        }
    }
}