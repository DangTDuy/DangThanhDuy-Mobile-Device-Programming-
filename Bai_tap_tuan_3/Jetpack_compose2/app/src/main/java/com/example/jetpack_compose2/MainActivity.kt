package com.example.jetpack_compose2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.background
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import kotlinx.coroutines.delay
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavGraph(navController)
        }
    }
}

// Navigation Graph
@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash_screen") {
        composable("splash_screen") { SplashScreen(navController) }
        composable("home_screen") { MainScreen(navController) }
        composable("second_screen") { SecondScreen(navController) }
        composable("third_screen") { ThirdScreen(navController) }
        composable("home") { Home(navController) }



    }
}

// ------------------- Splash Screen -------------------
@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(Unit) {
        delay(3000)
        navController.navigate("home_screen") {
            popUpTo("splash_screen") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.hinh1),
            contentDescription = "App Logo",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = "UTH SmartTasks",
            color = Color(0xFF006EE9),
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(y = 100.dp)


        )

    }
}


@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = -80.dp),
//
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFF006EE9), shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFFEEF5FD), shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFFEEF5FD), shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(200.dp))

            Text(
                text = "Skip",
                color = Color(0xFF006EE9),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable { navController.navigate("home") }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.hinh2),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .offset(y = 20.dp)
        )


        Text(
            text = "Easy Time Management",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("second_screen") },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .offset(y = 100.dp)
        ) {
            Text(text = "Next", color = Color.White, fontSize = 18.sp)
        }
    }
}

@Composable
fun SecondScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = -80.dp),
//
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFF006EE9), shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFFEEF5FD), shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFFEEF5FD), shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(200.dp))

            Text(
                text = "Skip",
                color = Color(0xFF006EE9),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable { navController.navigate("home") }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.hinh3),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .offset(y = 20.dp)
        )


        Text(
            text = "Increase Work Effectiveness",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "Time management and the determination of more important tasks will give your job statistics better and always improve",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier .offset(y = 100.dp)) {
            Image(
                painter = painterResource(id = R.drawable.back)
                , contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.popBackStack() }
            )


            Spacer(modifier = Modifier. width(40.dp))

            Button(
                onClick = { navController.navigate("third_screen") },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                modifier = Modifier
                    .height(55.dp)
                    .width(250.dp)

            ) {
                Row {
                    Text(
                        text = "Next",
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}



@Composable
fun ThirdScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = -80.dp),
//
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFF006EE9), shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFFEEF5FD), shape = CircleShape)
            )

            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .size(10.dp)
                    .background(Color(0xFFEEF5FD), shape = CircleShape)
            )
            Spacer(modifier = Modifier.width(200.dp))

            Text(
                text = "Skip",
                color = Color(0xFF006EE9),
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .clickable { navController.navigate("home") }
            )
        }

        Image(
            painter = painterResource(id = R.drawable.hinh4),
            contentDescription = null,
            modifier = Modifier
                .size(400.dp)
                .offset(y = 20.dp)
        )


        Text(
            text = "Reminder Notification ",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Text(
            text = "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier .offset(y = 90.dp)) {
            Image(
                painter = painterResource(id = R.drawable.back)
                , contentDescription = null,
                modifier = Modifier
                    .size(50.dp)
                    .clickable { navController.popBackStack() }
            )


            Spacer(modifier = Modifier. width(40.dp))

            Button(
                onClick = { navController.navigate("home") },
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
                modifier = Modifier
                    .height(55.dp)
                    .width(250.dp)

            ) {
                Row {
                    Text(
                        text = "Get ",
                        color = Color.White,
                        fontSize = 18.sp
                    )

                    Text(
                        text = "Started",
                        color = Color.White,
                        fontSize = 19.sp
                    )
                }
            }
        }
    }
}




@Composable
fun Home(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center)
    {
        Text(
            "Ứng dụng do:\nĐặng Thanh Duy phát triển.\nNhấn vào để về trang đầu !",
            color = Color(0xFF006EE9),
            fontSize = 30.sp,
            modifier = Modifier
                .clickable { navController.navigate("home_screen") }
        )
    }
}



