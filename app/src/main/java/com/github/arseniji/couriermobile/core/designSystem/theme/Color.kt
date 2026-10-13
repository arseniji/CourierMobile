package com.github.arseniji.couriermobile.core.designSystem.theme


import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

val FreshColors = lightColorScheme(
    primary = Color(0xFF12A150),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFDDF3E4),
    onPrimaryContainer = Color(0xFF0E5A30),
    secondary = Color(0xFF0F3D2E),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFE7EEE9),
    onSecondaryContainer = Color(0xFF13261C),
    tertiary = Color(0xFFB07F00),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFFF1C2),
    onTertiaryContainer = Color(0xFF6B4E00),
    background = Color(0xFFF2F5F1),
    onBackground = Color(0xFF13261C),
    surface = Color(0xFFF2F5F1),
    onSurface = Color(0xFF13261C),
    surfaceVariant = Color(0xFFE7EEE9),
    onSurfaceVariant = Color(0xFF5B6B61),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFFFFFFF),
    surfaceContainer = Color(0xFFFFFFFF),
    surfaceContainerHigh = Color(0xFFEDF1EE),
    surfaceContainerHighest = Color(0xFFE3EBE5),
    outline = Color(0xFFC5D0C8),
    outlineVariant = Color(0xFFE3EBE5),
    error = Color(0xFFD93025),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFCE4E1),
    onErrorContainer = Color(0xFF8C1D18),
)

val NightColors = darkColorScheme(
    primary = Color(0xFFC6F36B),
    onPrimary = Color(0xFF15200A),
    primaryContainer = Color(0xFF33402A),
    onPrimaryContainer = Color(0xFFD7F79A),
    secondary = Color(0xFFB9C2C9),
    onSecondary = Color(0xFF15181B),
    secondaryContainer = Color(0xFF23272B),
    onSecondaryContainer = Color(0xFFF2F4F5),
    tertiary = Color(0xFFFFC94D),
    onTertiary = Color(0xFF2B2000),
    tertiaryContainer = Color(0xFF3D3218),
    onTertiaryContainer = Color(0xFFFFD97A),
    background = Color(0xFF0F1113),
    onBackground = Color(0xFFF2F4F5),
    surface = Color(0xFF0F1113),
    onSurface = Color(0xFFF2F4F5),
    surfaceVariant = Color(0xFF23272B),
    onSurfaceVariant = Color(0xFF8D959C),
    surfaceContainerLowest = Color(0xFF1A1D21),
    surfaceContainerLow = Color(0xFF1A1D21),
    surfaceContainer = Color(0xFF15181B),
    surfaceContainerHigh = Color(0xFF23272B),
    surfaceContainerHighest = Color(0xFF2A2F35),
    outline = Color(0xFF3A4047),
    outlineVariant = Color(0xFF2A2F35),
    error = Color(0xFFFF6B5E),
    onError = Color(0xFF3B0A06),
    errorContainer = Color(0xFF4A1D19),
    onErrorContainer = Color(0xFFFFB4AB),
)

@Immutable
data class CourierColors(
    val hero: Color,
    val onHero: Color,
    val onHeroMuted: Color,
    val heroAccent: Color,
    val heroBar: Color,
    val mapStyleUrl: String,
    val route: Color,
    val routeCasing: Color,
    val sheetHandle: Color,
)

val FreshExtraColors = CourierColors(
    hero = Color(0xFF0F3D2E),
    onHero = Color(0xFFFFFFFF),
    onHeroMuted = Color(0xFF9FD8B5),
    heroAccent = Color(0xFF3DDC84),
    heroBar = Color(0xFF2E7D57),
    mapStyleUrl = "https://tiles.openfreemap.org/styles/liberty",
    route = Color(0xFF12A150),
    routeCasing = Color(0xFFFFFFFF),
    sheetHandle = Color(0x80000000),
)

val NightExtraColors = CourierColors(
    hero = Color(0xFF1A1D21),
    onHero = Color(0xFFF2F4F5),
    onHeroMuted = Color(0xFF8D959C),
    heroAccent = Color(0xFFC6F36B),
    heroBar = Color(0xFF3A4047),
    mapStyleUrl = "https://tiles.openfreemap.org/styles/dark",
    route = Color(0xFFC6F36B),
    routeCasing = Color(0xFF0F1113),
    sheetHandle = Color(0x99FFFFFF),
)

val StarColor = Color(0xFFFFB300)
