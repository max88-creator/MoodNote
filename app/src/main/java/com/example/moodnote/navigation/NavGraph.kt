package com.example.moodnote.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moodnote.screens.AddMoodScreen
import com.example.moodnote.screens.MoodListScreens
import com.example.moodnote.view_model.MoodViewModel

@Composable
fun NavGraph(
    viewModel: MoodViewModel
) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable("main_screen") {
            MoodListScreens(viewModel = viewModel,
                onAddClick = {navController.navigate("add")})
        }
        composable("add") {
            AddMoodScreen(viewModel = viewModel, onNoteAdded = { navController.popBackStack()})
        }
    }
}