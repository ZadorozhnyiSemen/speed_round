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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.ThemeData

@Composable
internal fun Welcome(welcomeComplete: () -> Unit) {
    Scaffold() {
        Image(
            painter = painterResource(id = ThemeData.images.welcomeLogo),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = painterResource(id = ThemeData.images.welcomeTextLogo), contentDescription = null)
            Spacer(modifier = Modifier.height(32.dp))
            Box(modifier = Modifier.clickable {}.fillMaxWidth().height(72.dp).clip(ThemeData.shapes.medium).background(ThemeData.colors.primary), contentAlignment = Alignment.Center) {
                Text("SIGN UP", style = ThemeData.typography.button.copy(color = ThemeData.colors.onPrimary))
            }
            Spacer(modifier = Modifier.height(8.dp))
            Box(modifier = Modifier.clickable { welcomeComplete() }.fillMaxWidth().height(72.dp).clip(ThemeData.shapes.medium).background(ThemeData.colors.secondary), contentAlignment = Alignment.Center) {
                Text("LOG IN", style = ThemeData.typography.button.copy(color = ThemeData.colors.onSecondary))
            }
        }
    }
}

@Composable
@Preview
fun WelcomePageLight() {
    AppTheme(darkTheme = false) {
        Welcome({})
    }
}

@Composable
@Preview
fun WelcomePageDark() {
    AppTheme(darkTheme = true) {
        Welcome({})
    }
}
