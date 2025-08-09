package com.example.impostor

import PrivateScreen
import PublicScreen
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController

@Composable
fun App(innerPadding: PaddingValues) {
    val navController: NavHostController = rememberNavController()
    val viewModel: GameViewModel = viewModel()
    NavHost(
        navController = navController,
        startDestination = "Start",
        modifier = Modifier.padding(innerPadding)
    ) {
        composable("Start") {
            MenuScreen(
                startGame = {
                    viewModel.updateCurrSecret(words.random())
                    viewModel.updatePlayers(it)
                    viewModel.updateCurrImpostorIndex()
                    navController.navigate("PublicScreen")
                },
                viewModel,
                modifier = Modifier.padding(innerPadding)
            )
        }
        composable("PublicScreen") {
            PublicScreen(
                viewModel,
                {
                    navController.navigate("PrivateScreen") {
                        popUpTo("BlankScreen") { inclusive = true }
                    }
                },
                {
                    navController.navigate("RoundFinished")
                }
            )
        }
        composable("PrivateScreen") {
            PrivateScreen(
                viewModel.currIndex,
                players = viewModel.players,
                viewModel.currImpostorIndex,
                viewModel.currSecret,
                {
                    navController.navigate("BlankScreen") {
                        popUpTo("BlankScreen") { inclusive = true }
                    }
                }
            )
        }
        composable("BlankScreen") {
            BlankScreen(
                viewModel,
                {
                    navController.navigate("PublicScreen")
                    viewModel.incrementCurrIndex()
                }
            )
        }
        composable("RoundFinished") {
            RoundFinished(
                viewModel,
                {
                    viewModel.updateCurrIndex(0)
                    navController.navigate("VotingScreen")
                },
            )
        }
        composable("VotingScreen") {
            VotingScreen(
                viewModel,
                {
                    navController.navigate("EndScreen")
                }
            )
        }
        composable("EndScreen") {
            EndScreen(viewModel, {
                viewModel.resetGame()
                navController.navigate("Start")
            })
        }
    }
}
