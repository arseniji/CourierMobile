package com.github.arseniji.courierapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.arseniji.courierapp.ui.navigation.MainAppScreen
import com.github.arseniji.courierapp.ui.theme.CourierAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CourierAppTheme(){
                MainAppScreen()
            }
        }
    }
}