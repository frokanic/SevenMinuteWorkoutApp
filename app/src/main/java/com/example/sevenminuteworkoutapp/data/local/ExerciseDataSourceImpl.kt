package com.example.sevenminuteworkoutapp.data.local

import com.example.sevenminuteworkoutapp.R
import com.example.sevenminuteworkoutapp.data.model.Exercise

class ExerciseDataSourceImpl: ExerciseDataSource {

    override fun getExercises(): List<Exercise> {
        return listOf(
            Exercise(1, "Jumping Jacks", R.drawable.ic_jumping_jacks, false),
            Exercise(2, "Wall Sit", R.drawable.ic_wall_sit, false),
            Exercise(3, "Push Up", R.drawable.ic_push_up, false),
            Exercise(4, "Abdominal Crunch", R.drawable.ic_abdominal_crunch, false),
            Exercise(5, "Step-Up onto Chair", R.drawable.ic_step_up_onto_chair, false),
            Exercise(6, "Squat", R.drawable.ic_squat, false),
            Exercise(7, "Tricep Dip On Chair", R.drawable.ic_triceps_dip_on_chair, false),
            Exercise(8, "Plank", R.drawable.ic_plank, false),
            Exercise(9, "High Knees Running In Place", R.drawable.ic_high_knees_running_in_place, false),
            Exercise(10, "Lunges", R.drawable.ic_lunge, false),
            Exercise(11, "Push up and Rotation", R.drawable.ic_push_up_and_rotation, false),
            Exercise(12, "Side Plank", R.drawable.ic_side_plank, false)
        )
    }
}