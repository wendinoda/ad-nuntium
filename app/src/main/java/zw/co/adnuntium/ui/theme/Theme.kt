package zw.co.adnuntium.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


private val LightThemeColors = lightColors(
    primary = KELLYGREEN,
    primaryVariant = FORESTGREEN,
    onPrimary = Color.White,
    secondary = KELLYGREEN,
    secondaryVariant = FORESTGREEN,
    onSecondary = Color.White,
    error = RED800
)

private val DarkThemeColors = darkColors(
    primary = LIGHTGREEN,
    primaryVariant = KELLYGREEN,
    onPrimary = Color.Black,
    secondary = LIGHTGREEN,
    onSecondary = Color.Black,
    error = RED500
)

@Composable
fun AdNuntiumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colors = if (darkTheme) DarkThemeColors else LightThemeColors,
        typography = AdTypography,
        content = content
    )
}
