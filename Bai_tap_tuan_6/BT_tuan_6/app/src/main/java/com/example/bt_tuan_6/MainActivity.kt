package com.example.bt_tuan_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bt_tuan_6.screens.AddScreen
import com.example.bt_tuan_6.screens.ListScreen
import com.example.bt_tuan_6.ui.theme.Bt_tuan_6Theme
import com.example.bt_tuan_6.viewmodel.TaskViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Bt_tuan_6Theme {
                val navController = rememberNavController()
                val viewModel: TaskViewModel = viewModel()

                NavHost(navController = navController, startDestination = "list") {
                    composable("list") {
                        ListScreen(viewModel = viewModel, onAddClick = {
                            navController.navigate("add")
                        })
                    }
                    composable("add") {
                        AddScreen(viewModel = viewModel, onBack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}