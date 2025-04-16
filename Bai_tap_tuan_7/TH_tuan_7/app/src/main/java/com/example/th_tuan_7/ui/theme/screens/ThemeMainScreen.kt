package com.example.th_tuan_7.ui.theme.screens

import android.content.Context
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.th_tuan_7.R
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val Context.dataStore by preferencesDataStore(name = "theme_prefs")
val THEME_KEY = stringPreferencesKey("theme")

enum class AppTheme { BLUE, DARK, PINK }

@Composable
fun ThemeMainScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    var selectedTheme by remember { mutableStateOf(AppTheme.BLUE) }
    var appliedTheme by remember { mutableStateOf(AppTheme.BLUE) }

    val themeFlow = context.dataStore.data.map { prefs ->
        prefs[THEME_KEY] ?: "BLUE"
    }

    val savedTheme by themeFlow.collectAsState(initial = "BLUE")

    LaunchedEffect(savedTheme) {
        appliedTheme = runCatching { AppTheme.valueOf(savedTheme) }.getOrDefault(AppTheme.BLUE)
        selectedTheme = appliedTheme
    }

    // Chuyển màu mượt cho background
    val backgroundColor by animateColorAsState(
        targetValue = when (appliedTheme) {
            AppTheme.BLUE -> Color(0XFF79C1F3)
            AppTheme.DARK -> Color.Black
            AppTheme.PINK -> Color(0xFFD346B7)
        },
        label = "BackgroundColor"
    )

    // Chuyển màu mượt cho chữ
    val textColor by animateColorAsState(
        targetValue = when (appliedTheme) {
            AppTheme.BLUE -> Color.Black
            AppTheme.DARK -> Color.White
            AppTheme.PINK -> Color.White
        },
        label = "TextColor"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 350.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Setting",
                    color = textColor,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Choosing the right theme sets the tone and personality of your app",
                    fontSize = 12.sp,
                    color = textColor,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .padding(bottom = 9.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ab),
                contentDescription = "Light Theme",
                modifier = Modifier
                    .size(100.dp)
                    .clickable { selectedTheme = AppTheme.BLUE }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.cd),
                contentDescription = "Dark Theme",
                modifier = Modifier
                    .size(100.dp)
                    .clickable { selectedTheme = AppTheme.PINK }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Image(
                painter = painterResource(id = R.drawable.ef),
                contentDescription = "Blue Theme",
                modifier = Modifier
                    .size(100.dp)
                    .clickable { selectedTheme = AppTheme.DARK }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.button),
            contentDescription = "Apply Button",
            modifier = Modifier
                .size(150.dp)
                .align(Alignment.CenterHorizontally)
                .clickable {
                    appliedTheme = selectedTheme
                    scope.launch {
                        context.dataStore.edit { prefs ->
                            prefs[THEME_KEY] = selectedTheme.name
                        }
                    }
                }
        )
    }
}
