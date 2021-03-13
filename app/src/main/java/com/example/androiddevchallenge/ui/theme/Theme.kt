/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.staticCompositionLocalOf
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.system.LocalSysUiController

private val DarkColorPalette = darkColors(
    primary = white,
    secondary = rust300,
    background = gray900,
    surface = white150,
    onPrimary = gray900,
    onSecondary = gray900,
    onBackground = taupe100,
    onSurface = white800
)

private val LightColorPalette = lightColors(
    primary = gray900,
    secondary = rust600,
    background = taupe100,
    surface = white850,
    onPrimary = white,
    onSecondary = white,
    onBackground = taupe800,
    onSurface = gray800
)

private val DefaultElevation = Elevations()

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
    val images = if (darkTheme) DarkImages else LightImages

    val sys = LocalSysUiController.current
    SideEffect {
        sys.setSystemBarsColor(
            color = colors.background.copy(alpha = .15f)
        )
    }

    CompositionLocalProvider(
        LocalElevations provides DefaultElevation,
        LocalImages provides images
    ) {
        MaterialTheme(
            colors = colors,
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object ThemeData {
    val colors: Colors
        @Composable
        get() = MaterialTheme.colors

    val typography: Typography
        @Composable
        get() = MaterialTheme.typography

    val shapes: Shapes
        @Composable
        get() = MaterialTheme.shapes

    val elevations: Elevations
        @Composable
        get() = LocalElevations.current

    val images: Images
        @Composable
        get() = LocalImages.current
}

@Immutable
data class Images(
    @DrawableRes val welcomeLogo: Int,
    @DrawableRes val welcomeTextLogo: Int,
    @DrawableRes val loginLogo: Int
)

internal val LocalImages = staticCompositionLocalOf<Images> {
    error("No LocalImages specified")
}

private val DarkImages = Images(
    welcomeLogo = R.drawable.ic_dark_welcome,
    welcomeTextLogo = R.drawable.ic_dark_logo,
    loginLogo = R.drawable.ic_dark_login
)

private val LightImages = Images(
    welcomeLogo = R.drawable.ic_light_welcome,
    welcomeTextLogo = R.drawable.ic_light_logo,
    loginLogo = R.drawable.ic_light_login
)
