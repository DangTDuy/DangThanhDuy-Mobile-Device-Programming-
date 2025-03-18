package com.example.jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.compose.foundation.clickable
import androidx.navigation.compose.*

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
    NavHost(navController = navController, startDestination = "home_screen") {
        composable("home_screen") { MainScreen(navController) }
        composable("second_screen") { SecondScreen(navController) }
        composable("text_screen") { ScrText(navController)}
        composable("image_screen") { ScrImage(navController) }
        composable("textfield_screen") { ScrTextField(navController) }
        composable("password_field") { ScrPasswordField(navController) }
        composable ("column_screen") { ScrColumn(navController)}
        composable ("row_screen") { ScrRow(navController)}
    }
}

// ------------------- Màn hình chính -------------------
@Composable
fun MainScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.hinh1),
            contentDescription = "Jetpack Compose Logo",
            modifier = Modifier.size(300.dp).padding(bottom = 0.dp) .offset(y = -100.dp)
        )

        Text(text = "Jetpack Compose", fontSize = 24.sp, fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(y = -30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Jetpack Compose is a modern UI toolkit for building native Android applications using a declarative programming approach.",
            fontSize = 18.sp, textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("second_screen") },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2196F3)),
            modifier = Modifier.fillMaxWidth().height(56.dp)
                .offset(y = 150.dp)
        ) {
            Text(text = "I'm ready", color = Color.White, fontSize = 18.sp)
        }
    }
}



// màn hình hiển thị thành phần
@Composable
fun SecondScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
        Text(
            text = "UI Components List",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
                .padding(bottom = 100.dp),
            textAlign = TextAlign.Center
        )

        // Nhóm "Display"
        Text(
            text = "Display",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = { navController.navigate("text_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x4D2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Text",
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 18.sp,
                    modifier = Modifier
                    .offset(x = -120.dp)
                )
                Text(
                    text = "Displays text",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                    .offset(x = -120.dp)
                )
            }
        }

        Button(
            onClick = { navController.navigate("image_screen")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x4D2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Image",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                    .offset(x = -100.dp)
                )
                Text(
                    text = "Displays an image",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                    .offset(x = -100.dp)
                )
            }
        }

        // Nhóm "Input"
        Text(
            text = "Input",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        Button(
            onClick = { navController.navigate("textfield_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x4D2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "TextField",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                    .offset(x = -100.dp)
                )
                Text(
                    text = "Input field for text",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                    .offset(x = -100.dp)
                )
            }
        }

        Button(
            onClick = { navController.navigate("password_field")},
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x4D2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "PasswordField",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .offset(x = -80.dp)
                )
                Text(
                    text = "Input field for passwords",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                    .offset(x = -80.dp)
                )
            }
        }

        Text(
            text = "Layout",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = { navController.navigate("column_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x4D2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Column",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                    .offset(x = -65.dp)
                )
                Text(
                    text = "Arranges elements vertically",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                    .offset(x = -65.dp)
                )
            }
        }


        Button(
            onClick = { navController.navigate("row_screen") },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0x4D2196F3)),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Row",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier
                    .offset(x = -60.dp)
                )
                Text(
                    text = "Arranges elements horizontally",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    modifier = Modifier
                    .offset(x = -60.dp)
                )
            }
        }
    }
}


// màn hình hiển thị thành phần Text

@Composable
fun ScrText(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
            Text(
                text = "Text",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier
                    .fillMaxWidth()
                    .offset(y = 60.dp)
                    .padding(bottom = 100.dp),
                textAlign = TextAlign.Center
            )
            Text(
                text = "<",
                fontSize = 27.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2196F3),
                modifier = Modifier
                    .offset(y = -70.dp)
                    .padding(bottom = 100.dp)
                    .clickable(onClick = { navController.navigate("second_screen") })
            )
        Image(
            painter = painterResource(id = R.drawable.hinh2),
            contentDescription = "Minh hoa",
            modifier = Modifier.size(300.dp).padding(bottom = 0.dp) .offset(y = -100.dp)
        )

    }
}

// Màn hình hiển thị thành phần Image
@Composable
fun ScrImage(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
        Text(
            text = "Image",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
                .padding(bottom = 100.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "<",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .offset(y = -70.dp)
                .padding(bottom = 100.dp)
                .clickable(onClick = { navController.navigate("second_screen") })
        )
    }
}


// Màn hình hiển thị thành phần TextField
@Composable
fun ScrTextField(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
        Text(
            text = "TextField",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
                .padding(bottom = 100.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "<",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .offset(y = -70.dp)
                .padding(bottom = 100.dp)
                .clickable(onClick = { navController.navigate("second_screen") })
        )
    }
}


// Màn hình hiển thị thành phần PasswordField
@Composable
fun ScrPasswordField( navController: NavHostController ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
        Text(
            text = "PasswordField",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
                .padding(bottom = 100.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "<",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .offset(y = -70.dp)
                .padding(bottom = 100.dp)
                .clickable(onClick = { navController.navigate("second_screen") })
        )
    }
}


// Màn hình hiển thị thành phần Column
@Composable
fun ScrColumn( navController: NavHostController ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
        Text(
            text = "Column",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
                .padding(bottom = 100.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "<",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .offset(y = -70.dp)
                .padding(bottom = 100.dp)
                .clickable(onClick = { navController.navigate("second_screen") })
        )
    }
}

// Màn hình hiển thị thành phần Row
@Composable
fun ScrRow( navController: NavHostController ){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Tiêu đề chính
        Text(
            text = "Row",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = 60.dp)
                .padding(bottom = 100.dp),
            textAlign = TextAlign.Center
        )
        Text(
            text = "<",
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF2196F3),
            modifier = Modifier
                .offset(y = -70.dp)
                .padding(bottom = 100.dp)
                .clickable(onClick = { navController.navigate("second_screen") })
        )
    }
}