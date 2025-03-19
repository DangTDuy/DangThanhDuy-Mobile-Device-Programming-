package com.example.thuc_hanh_buoi_3

import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thuc_hanh_buoi_3.ui.theme.Thuc_hanh_buoi_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Thuc_hanh_buoi_3Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var message by remember { mutableStateOf("Hello") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "My First App",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(90.dp))

        Text(
            text = message,
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(90.dp))

        Button(
            onClick = { message = "I'm\nNguyen Van A" },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            )
        ) {
            Text(text = "Say Hi!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    Thuc_hanh_buoi_3Theme {
        MainScreen()
    }
}
