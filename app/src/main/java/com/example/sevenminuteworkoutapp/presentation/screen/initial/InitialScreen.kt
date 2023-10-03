package com.example.sevenminuteworkoutapp.presentation.screen.initial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sevenminuteworkoutapp.R
import com.example.sevenminuteworkoutapp.presentation.util.Screen

@Composable
fun InitialScreen(
    navController: NavController,
    screenWidth: Dp,
    density: Float
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogo(Modifier
            .padding(start = 8.dp, end = 8.dp)
            .fillMaxWidth()
            .aspectRatio(1.5f)
        )
        Spacer(modifier = Modifier.padding(16.dp))
        StartButton(navController, screenWidth, density)
    }
}

@Composable
fun AppLogo(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(
            id = R.drawable.img_main_page
        ),
        contentDescription = "App Logo"
    )
}

@Composable
fun StartButton(
    navController: NavController, screenWidth: Dp, density: Float
) {
    val fontSize = (screenWidth.value / 8) / density
    OutlinedButton(
        onClick = {
                  navController.navigate(Screen.GetReadyScreen.route)
                  },
        modifier = Modifier
            .width(screenWidth * 0.35f)
            .height(screenWidth * 0.35f),
        shape = CircleShape,
        border = BorderStroke(4.dp, Color(0xFF008F24))
    ) {
        Text(
            text = "Start",
            color = Color.Black,
            fontSize = fontSize.sp
        )
    }
}
