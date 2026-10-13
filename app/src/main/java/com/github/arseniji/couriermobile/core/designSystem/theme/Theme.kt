package com.github.arseniji.couriermobile.core.designSystem.theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

private val LocalCourierColors = staticCompositionLocalOf { FreshExtraColors }

@Composable
fun CourierAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(LocalCourierColors provides if (darkTheme) NightExtraColors else FreshExtraColors) {
        MaterialTheme(
            colorScheme = if (darkTheme) NightColors else FreshColors,
            typography = Typography,
            shapes = Shapes,
            content = content,
        )
    }
}

object CourierTheme {
    val colors: CourierColors
        @Composable @ReadOnlyComposable
        get() = LocalCourierColors.current
}
