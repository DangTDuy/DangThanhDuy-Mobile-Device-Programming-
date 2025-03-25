package com.example.tuan_4_bai_tap_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "manhinhmodau") {
                composable("manhinhmodau") { Manhinhmodau(navController) }
                composable("manhinhdetail") { Manhinhdetail(navController)}
            }
        }
    }
}


@Composable
fun Manhinhmodau(navController: NavController) {
    val items = listOf(
        Pair("Complete Android Project", Color(0xFFD0E6FF)),
        Pair("Complete Android Project", Color(0xFFE6BABA)),
        Pair("Complete Android Project", Color(0xFFE6E6A8)),
        Pair("Complete Android Project", Color(0xFFE6BABA)),
        Pair("Complete Android Project", Color(0xFFD0E6FF))
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp).offset(y = 50.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.hinh2),
                contentDescription = "Back",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "List",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )

            Spacer(modifier = Modifier.size(40.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(items) { (title, bgColor) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .clickable { navController.navigate("manhinhdetail") },
                    colors = CardDefaults.cardColors(bgColor)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(text = "Finish the UI, integrate API, and write documentation", fontSize = 16.sp)
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.image_3),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Manhinhdetail(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .offset(y = 50.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.hinh2),
                contentDescription = "Back",
                modifier = Modifier
                    .size(40.dp)
                    .clickable { navController.popBackStack() }
            )

            Text(
                text = "Detail",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )

            Spacer(modifier = Modifier.size(40.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Complete Android Project",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Finish the UI, integrate API, and write documentation",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))


        Text(text = "Subtasks", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        val subtasks = listOf(
            "This task is related to Fitness. It needs to be completed",
            "This task is related to Fitness. It needs to be completed",
            "This task is related to Fitness. It needs to be completed"
        )
        subtasks.forEach {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(Color(0xFFE6E6E6))
            ) {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Attachments", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        val attachments = listOf("document_1_0.pdf", "document_1_0.pdf")
        attachments.forEach {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(Color(0xFFE6E6E6))
            ) {
                Text(
                    text = it,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}
