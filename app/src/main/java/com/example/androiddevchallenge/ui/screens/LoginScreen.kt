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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
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
fun Login(loginComplete: () -> Unit) {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = ThemeData.images.loginLogo),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("LOG IN", style = ThemeData.typography.h1, modifier = Modifier.paddingFromBaseline(top = 200.dp))
                Spacer(modifier = Modifier.height(32.dp))
                TextField(modifier = Modifier.fillMaxWidth().background(ThemeData.colors.surface), value = "Email address", onValueChange = {}, textStyle = ThemeData.typography.body1.copy(color = ThemeData.colors.onSurface))
                Spacer(modifier = Modifier.height(8.dp))
                TextField(modifier = Modifier.fillMaxWidth().background(ThemeData.colors.surface), value = "Password", onValueChange = {}, textStyle = ThemeData.typography.body1.copy(color = ThemeData.colors.onSurface))
                Spacer(modifier = Modifier.height(8.dp))
                Box(modifier = Modifier.height(72.dp).fillMaxWidth().clip(ThemeData.shapes.medium).clickable { loginComplete() }.background(ThemeData.colors.primary), contentAlignment = Alignment.Center) {
                    Text("LOG IN", style = ThemeData.typography.button.copy(color = ThemeData.colors.onPrimary))
                }
                Row(modifier = Modifier.paddingFromBaseline(top = 32.dp)) {
                    Text(text = "Don't have an account? ", style = ThemeData.typography.body1.copy(ThemeData.colors.onBackground))
                    Text(text = "Sign up", style = ThemeData.typography.body1.copy(ThemeData.colors.onBackground))
                }
            }
        }
    }
}

@Composable
@Preview
fun LoginPageLight() {
    AppTheme(darkTheme = false) {
        Login({})
    }
}

@Composable
@Preview
fun LoginPageDark() {
    AppTheme(darkTheme = true) {
        Login({})
    }
}
