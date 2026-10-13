package com.github.arseniji.couriermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.arseniji.couriermobile.core.designSystem.theme.CourierAppTheme
import com.github.arseniji.couriermobile.ui.MainAppScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CourierAppTheme {
                MainAppScreen()
            }
        }
    }
}