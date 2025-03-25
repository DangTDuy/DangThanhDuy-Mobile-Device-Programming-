package com.example.tuan_4_bai_tap_1

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
                composable("manhinhlist") { Manhinhlist(navController) }
                composable("manhinhdetail") { Manhinhdetail(navController) }
            }
        }
    }
}

@Composable
fun Manhinhmodau(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .offset(y = -90.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.hinh1),
            contentDescription = "Logo",
            modifier = Modifier.size(270.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Navigation",
            fontSize = 22.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(50.dp))


        Text(
            text = "is a framework that simplifies the",
            fontSize = 17.sp
        )
        Text(
            text = "implementation of navigation between different",
            fontSize = 17.sp
        )
        Text(
            text = "UI components (activities, fragments, or",
            fontSize = 17.sp
        )
        Text(
            text = "composables) in an app",
            fontSize = 17.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = { navController.navigate("manhinhlist") },
            colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
            modifier = Modifier
                .offset (y = 140.dp)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(text = "PUSH",
                fontSize = 23.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun Manhinhlist(navController: NavController) {
    val items = (1..5).map { "$it | The only way to do great work is to love what you do." } +
            listOf("1.000.000 | The only way to do great work is to love what you do.")

    Column(modifier = Modifier.fillMaxSize().padding(16.dp).offset(y = 100.dp)) {
            Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.hinh2),
                contentDescription = "Back",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.popBackStack() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "LazyColumn",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.offset(x = 100.dp)
            )
        }


        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(items) { item ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable {navController.navigate("manhinhdetail")},
                    colors = CardDefaults.cardColors(Color(0xFFD0E6FF))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = item, fontSize = 16.sp, modifier = Modifier.weight(1f))
                        Icon(
                            painter = painterResource(id = R.drawable.image_3),
                            contentDescription = "Arrow",
                            modifier = Modifier.size(24.dp)
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
            .offset(y = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.hinh2),
                contentDescription = "Back",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { navController.popBackStack() }
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Detail",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue,
                modifier = Modifier.offset(x = 130.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "\"The only way to do great work is to love what you do.\"",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.image_4),
            contentDescription = "Quote Image",
            modifier = Modifier.size(400.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("manhinhmodau") },
            colors = ButtonDefaults.buttonColors(Color(0xFF2196F3)),
            modifier = Modifier
                .offset (y = 100.dp)
                .fillMaxWidth()
                .height(60.dp)
        ) {
            Text(text = "BACK TO ROOT",
                fontSize = 23.sp,
                color = Color.White
            )
        }
    }
}

