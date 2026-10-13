package com.github.arseniji.couriermobile.core.designSystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.github.arseniji.couriermobile.R

val Onest = FontFamily(
    listOf(FontWeight.Normal, FontWeight.Medium, FontWeight.SemiBold, FontWeight.Bold).map { weight ->
        Font(
            resId = R.font.onest,
            weight = weight,
            variationSettings = FontVariation.Settings(FontVariation.weight(weight.weight)),
        )
    }
)

private val Base = Typography()

private fun TextStyle.tabular(weight: FontWeight? = null) =
    copy(fontFamily = Onest, fontFeatureSettings = "tnum", fontWeight = weight ?: fontWeight)

val Typography = Typography(
    displayLarge = Base.displayLarge.tabular(FontWeight.Bold),
    displayMedium = Base.displayMedium.tabular(FontWeight.Bold),
    displaySmall = Base.displaySmall.tabular(FontWeight.Bold),
    headlineLarge = Base.headlineLarge.tabular(FontWeight.Bold).copy(letterSpacing = (-0.5).sp),
    headlineMedium = Base.headlineMedium.tabular(FontWeight.Bold).copy(letterSpacing = (-0.3).sp),
    headlineSmall = Base.headlineSmall.tabular(FontWeight.SemiBold),
    titleLarge = Base.titleLarge.tabular(FontWeight.SemiBold),
    titleMedium = Base.titleMedium.tabular(FontWeight.SemiBold),
    titleSmall = Base.titleSmall.tabular(FontWeight.SemiBold),
    bodyLarge = Base.bodyLarge.tabular(),
    bodyMedium = Base.bodyMedium.tabular(),
    bodySmall = Base.bodySmall.tabular(),
    labelLarge = Base.labelLarge.tabular(FontWeight.SemiBold),
    labelMedium = Base.labelMedium.tabular(FontWeight.Medium),
    labelSmall = Base.labelSmall.tabular(FontWeight.Medium),
)

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(20.dp),
    extraLarge = RoundedCornerShape(28.dp),
)
