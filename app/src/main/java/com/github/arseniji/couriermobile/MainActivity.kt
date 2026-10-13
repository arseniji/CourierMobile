package com.github.arseniji.couriermobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.github.arseniji.couriermobile.ui.navigation.MainAppScreen
import com.github.arseniji.couriermobile.ui.theme.CourierMobileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            CourierMobileTheme(){
                MainAppScreen()
            }
        }
    }
}