package com.example.bt_tuan_6.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bt_tuan_6.R
import com.example.bt_tuan_6.ui.theme.CardColors
import com.example.bt_tuan_6.viewmodel.TaskViewModel
import kotlin.random.Random

@Composable
fun ListScreen(viewModel: TaskViewModel, onAddClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
                Text(
                    text = "List",
                    fontSize = 25.sp,
                    color = Color(0xFF2196F3),
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(start = 120.dp, end = 145.dp),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.resource__),
                    contentDescription = "",
                    modifier = Modifier.size(40.dp)
                )
            }

            // Thay Column bằng LazyColumn
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 90.dp), // chừa khoảng trống cho nút Add
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewModel.tasks) { task ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        backgroundColor = CardColors[Random.nextInt(CardColors.size)],
                        elevation = 0.dp
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = task.title,
                                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold),
                                color = Color.Black
                            )
                            Text(
                                text = task.description,
                                style = MaterialTheme.typography.body2,
                                color = Color.Black
                            )
                        }
                    }
                }
            }
        }


        Image(
            painter = painterResource(id = R.drawable.bground),
            contentDescription = "",
            modifier = Modifier
                .size(450.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .offset(y = 100.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 170.dp)
                .align(Alignment.BottomCenter)
                .offset(y = (-50).dp)
        ) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .background(Color(0xFF2196F3), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                IconButton(onClick = onAddClick) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Task",
                        tint = Color.White
                    )
                }
            }
        }
    }
}