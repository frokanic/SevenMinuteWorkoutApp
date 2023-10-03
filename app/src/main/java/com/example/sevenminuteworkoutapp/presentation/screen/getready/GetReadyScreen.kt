package com.example.sevenminuteworkoutapp.presentation.screen.getready

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import android.graphics.Paint
import androidx.compose.foundation.background
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.sevenminuteworkoutapp.presentation.util.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GetReadyScreen(
    navController: NavController,
    viewModel: GetReadyScreenViewModel
) {
    val shouldNavigate = viewModel.shouldNavigate.value

    if (shouldNavigate) {
        navController.navigate(Screen.ExerciseScreen.route)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(navController)
        }
    ) {
        GetReadyForAnimation(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Color.White),
            viewModel = viewModel
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    navController: NavController
) {
    TopAppBar(
        title = {
            Text(
                text = "  7MinutesWorkout",
                fontWeight = FontWeight.W600
            )
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.navigate(Screen.InitialScreen.route)
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back arrow from the 7 minutes workout screen"
                )
            }
        }
    )
}

@Composable
fun GetReadyForAnimation(
    modifier: Modifier,
    viewModel: GetReadyScreenViewModel
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = modifier.fillMaxSize()
        ) {
            val outerRadius = size.width * .14f
            val middleRadius = size.width * .12f
            val innerRadius = size.width * .105f

            drawContext.canvas.nativeCanvas.apply {
                val text = "Get Ready For"
                val textSize = size.width * .07f
                val paint = Paint().apply {
                    color = android.graphics.Color.parseColor("#008F24")
                    this.textSize = textSize
                    textAlign = Paint.Align.CENTER
                }
                val textPositionY = center.y - outerRadius - textSize * 1.2f - 100
                drawText(
                    text,
                    center.x,
                    textPositionY,
                    paint
                )
            }
            drawCircle(
                color = Color(0xFF008F24),
                radius = innerRadius,
                center = Offset(size.width / 2, size.height / 2 - 100)
            )
            drawCircle(
                color = Color(0xFFD4DEE7),
                radius = middleRadius,
                center = Offset(size.width / 2, size.height / 2 - 100),
                style = Stroke(
                    width = 5f
                )
            )
            drawArc(
                color = Color(0xFF008F24),
                startAngle = -90f,
                sweepAngle = 360f * (viewModel.seconds.intValue.toFloat() / viewModel.totalSeconds.intValue.toFloat()),
                useCenter = false,
                topLeft = Offset(
                    x = (size.width / 2) - middleRadius,
                    y = (size.height / 2) - middleRadius  - 100
                ),
                size = Size(
                    width = middleRadius * 2,
                    height = middleRadius * 2
                ),
                style = Stroke(
                    width = 5f
                )
            )
            drawCircle(
                color = Color(0xFF008F24),
                radius = outerRadius,
                center = Offset(size.width / 2, size.height / 2 - 100),
                style = Stroke(
                    width = 10f
                )
            )
            drawContext.canvas.nativeCanvas.apply {
                val paint = Paint().apply {
                    color = android.graphics.Color.WHITE
                    textSize = size.width * .1f
                    textAlign = Paint.Align.CENTER
                }
                val text = viewModel.seconds.intValue.toString()
                val textBounds = android.graphics.Rect()
                paint.getTextBounds(text, 0, text.length, textBounds)
                val textHeight = textBounds.height()
                drawText(
                    text,
                    center.x,
                    center.y + textHeight / 2f  - 100,
                    paint
                )
            }
        }
    }
}