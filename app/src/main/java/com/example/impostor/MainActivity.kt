package com.example.impostor

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.InputType
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextLayoutInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impostor.ui.theme.ImpostorTheme
import androidx.navigation.compose.NavHost
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController: NavHostController = rememberNavController()
            val viewModel: GameViewModel by viewModels()
            ImpostorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Start",
                        modifier = Modifier.padding(innerPadding)
                    )  {
                        composable("Start") {
                            MenuScreen(
                                startGame = {
                                    viewModel.updatePlayers(it)
                                    navController.navigate("PublicScreen")
                                },
                                modifier = Modifier.padding(innerPadding)
                            )
                        }
                        composable("PublicScreen") {
                            PublicScreen(
                                players = viewModel.players,
                                viewModel.currIndex,
                                {
                                    viewModel.updateCurrPlayer(it)
                                    navController.navigate("PrivateScreen")
                                }
                            )
                        }
                        composable("PrivateScreen") {
                            PrivateScreen(
                                currPlayer = viewModel.currPlayer,
                                {
                                    viewModel.incrementCurrIndex()
                                    navController.navigate("PublicScreen")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MenuScreen(startGame: (List<String>) -> Unit, modifier: Modifier = Modifier) {
    var playerName by remember { mutableStateOf("") }
    val playerList = remember { mutableStateListOf<String>() }
    Column (Modifier.padding(16.dp)) {
        Text(
            text = "Impostor",
            modifier = modifier,
            fontSize = 90.sp,
            lineHeight = 116.sp
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
        ) {
            TextField(
                value = playerName,
                onValueChange = { it: String -> playerName = it },
                label = { Text("Player Name") },
                modifier = modifier
            )
            Button(
                onClick = {
                    playerList.add(playerName)
                    println(playerList)
                    playerName = ""
                          },
                shape = RoundedCornerShape(7.dp)
            ) { Text("Add Player") }
        }
        playerList.forEach { name ->
            Text(
                text = name,
                fontSize = 20.sp,
                modifier = Modifier
                    .background(Color.Magenta)
                    .padding(8.dp)
            )
        }
        Button(
            onClick = { startGame(playerList) }
        ) { Text("Start Game") }
    }
}

@Composable
fun PlayerInput(modifier: Modifier = Modifier) {
    var playerName by remember { mutableStateOf("") }
    TextField(
        value = playerName,
        onValueChange = { it: String -> playerName = it },
        label = { Text("hello") },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun MenuScreenPreview() {
    ImpostorTheme {
        MenuScreen({ })
    }
}