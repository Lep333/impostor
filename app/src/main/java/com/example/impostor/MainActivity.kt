package com.example.impostor

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.text.InputType
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import com.example.impostor.ui.theme.Pink40
import com.example.impostor.ui.theme.Pink80
import com.example.impostor.ui.theme.Purple40
import com.example.impostor.ui.theme.Purple80
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController: NavHostController = rememberNavController()
            val navBackStackEntry = remember { navController.currentBackStackEntry }
            val viewModel: GameViewModel by viewModels()
            ImpostorTheme (darkTheme = true) {
                Scaffold(modifier = Modifier
                    .fillMaxSize()
                    .background(Pink40)) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "Start",
                        modifier = Modifier.padding(innerPadding)
                    )  {
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
            }
        }
    }
}

@Composable
fun MenuScreen(startGame: (SnapshotStateList<String>) -> Unit, viewModel: GameViewModel, modifier: Modifier = Modifier) {
    var playerName by remember { mutableStateOf("") }
    var playerList = viewModel.players
    val context = LocalContext.current

    Column (Modifier.padding(16.dp)) {
        Text (
            text = "Impostor",
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 80.sp,
            lineHeight = 116.sp
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(60.dp)
        ) {
            TextField(
                value = playerName,
                onValueChange = { it: String -> playerName = it },
                label = { Text("Spieler Name") },
                modifier = Modifier.weight(6f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = {
                    if (playerName != "" && playerName !in playerList) {
                        playerList.add(playerName)
                        playerName = ""
                    } else {
                        Toast.makeText(context, "Bitte keine Duplikate/leere Namen eingeben", Toast.LENGTH_SHORT).show()
                    }
                          },
                shape = RoundedCornerShape(7.dp),
                modifier = Modifier
                    .weight(4f)
                    .fillMaxSize()
            ) { Text(
                text = "Spieler hinzufügen",
                textAlign = TextAlign.Center,
            ) }
        }
        Spacer(Modifier.height(10.dp))
        if (playerList.isNotEmpty()) {
            Column (
                modifier = Modifier
                    .border(width = 2.dp, MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(7.dp))
                    .padding(16.dp)
            ) {
                Row {
                    Text(
                        "Spieler",
                        modifier = Modifier,
                    )
                }
                playerList.forEach { name ->
                    Row {
                        Button(
                            onClick = { playerList.remove(name) },
                            shape = RoundedCornerShape(7.dp),
                            modifier = Modifier
                                .padding(8.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = name,
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
        Spacer(Modifier.height(10.dp))
        Row {
            Button(
                onClick =
                    {
                        if (playerList.size > 2) {
                            viewModel.updateCurrIndex(0)
                            startGame(playerList)
                        } else {
                            Toast.makeText(context, "Imposter benötigt mindestens 3 Spieler", Toast.LENGTH_SHORT).show()
                        }
                    },
                shape = RoundedCornerShape(7.dp),
                modifier = Modifier.fillMaxWidth()
            ) { Text("Spiel Starten") }
        }
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