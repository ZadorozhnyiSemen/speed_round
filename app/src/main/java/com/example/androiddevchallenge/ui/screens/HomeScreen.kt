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

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
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
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.AppTheme
import com.example.androiddevchallenge.ui.theme.ThemeData
import dev.chrisbanes.accompanist.coil.CoilImage

data class HomeItem(val imageUrl: String, val text: String)

@Composable
fun HomePage() {
    val items1 = listOf(
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
    )
    val items2 = listOf(
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
    )
    val items3 = listOf(
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
        HomeItem("https://picsum.photos/300/300", "Short mantras"),
    )
    Scaffold(bottomBar = { BottomNav(bottomItems) }, floatingActionButton = { ActionButton() }, floatingActionButtonPosition = FabPosition.Center) {
        val scrollstate = rememberScrollState()
        Column(
            Modifier
                .padding(horizontal = 16.dp)
                .verticalScroll(scrollstate)
        ) {
            Spacer(modifier = Modifier.height(56.dp))
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = "Search", textStyle = ThemeData.typography.body1.copy(color = ThemeData.colors.onSurface), onValueChange = { },
                leadingIcon = {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = R.drawable.ic_baseline_search_24),
                        contentDescription = null
                    )
                }
            )

            Text(
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                text = "Favorite collections".toUpperCase(),
                style = ThemeData.typography.h2.copy(color = ThemeData.colors.onBackground)
            )
            Modifier.height(8.dp)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items1.size / 2) { index ->
                    val first = index * 2
                    val second = first + 1
                    Column(verticalArrangement = Arrangement.Center) {
                        CardItem(item = items1[first])
                        Spacer(modifier = Modifier.height(8.dp))
                        CardItem(item = items1[second])
                    }
                }
            }
            Text(
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                text = "Align your body".toUpperCase(),
                style = ThemeData.typography.h2.copy(color = ThemeData.colors.onBackground)
            )
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentPadding = PaddingValues(end = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items2) { index1 ->
                    CircleItem(item = index1)
                }
            }
            Text(
                modifier = Modifier.paddingFromBaseline(top = 40.dp),
                text = "Align your mind".toUpperCase(),
                style = ThemeData.typography.h2.copy(color = ThemeData.colors.onBackground)
            )
            Modifier.height(8.dp)
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                contentPadding = PaddingValues(end = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(items3) { index2 ->
                    CircleItem(item = index2)
                }
            }
        }
    }
}

@Composable
fun BottomBar() {
    BottomAppBar() {
        Column(verticalArrangement = Arrangement.Center) {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_spa_24),
                contentDescription = null
            )
            Text("HOME", style = ThemeData.typography.caption)
        }
        Column {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_spa_24),
                contentDescription = null
            )
            Text("PROFILE", style = ThemeData.typography.caption)
        }
    }
}

@Composable
@Preview
fun HomePageLight() {
    AppTheme(darkTheme = false) {
        HomePage()
    }
}

@Composable
@Preview
fun HomePageDark() {
    AppTheme(darkTheme = true) {
        HomePage()
    }
}

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    item: HomeItem
) {
    Row(
        modifier = modifier
            .height(56.dp)
            .width(192.dp)
            .clip(ThemeData.shapes.small)
            .background(ThemeData.colors.surface),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .clip(ThemeData.shapes.small)
                .size(56.dp),
        ) {
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = item.text, style = ThemeData.typography.h3.copy(color = ThemeData.colors.onSurface))
    }
}

@Composable
fun CircleItem(
    modifier: Modifier = Modifier,
    item: HomeItem
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CoilImage(
            data = item.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            fadeIn = true,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(text = item.text, modifier = Modifier.paddingFromBaseline(top = 24.dp), style = ThemeData.typography.h3.copy(color = ThemeData.colors.onSurface))
    }
}

sealed class BottomNav(val name: String, @DrawableRes val icon: Int) {
    object Home : BottomNav("HOME", R.drawable.ic_baseline_spa_24)
    object Profile : BottomNav("PROFILE", R.drawable.ic_baseline_account_circle_24)
}

val bottomItems = listOf(
    BottomNav.Home,
    BottomNav.Profile
)

@Composable
private fun BottomNav(items: List<BottomNav>) {
    BottomNavigation(Modifier.height(56.dp), backgroundColor = ThemeData.colors.background, elevation = 8.dp) {
        items.forEach {
            BottomNavigationItem(
                selected = it.name == "HOME", onClick = { },
                icon = {
                    Icon(
                        modifier = Modifier.size(18.dp),
                        painter = painterResource(id = it.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(it.name, style = ThemeData.typography.caption)
                }
            )
        }
    }
}

@Composable
private fun ActionButton() {
    FloatingActionButton(modifier = Modifier.offset(y = 42.dp), onClick = {}, shape = CircleShape, backgroundColor = ThemeData.colors.primary) {
        Icon(painter = painterResource(id = R.drawable.ic_baseline_play_arrow_24), contentDescription = null, tint = ThemeData.colors.onPrimary)
    }
}
