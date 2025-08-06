package com.example.impostor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.impostor.ui.theme.ImpostorTheme

@Composable
fun GameScreen(players: List<String>) {
    Text("Hello from the Game Screen!")
    PublicScreen(players, 0, {})
}

@Composable
fun PublicScreen(players: List<String>, currIndex: Int, privateInformation: (String) -> Unit) {
    if (currIndex < players.size) {
        val playerName = players[currIndex]
        Column {
            Text("$playerName ist an der Reihe")
            Button(onClick = {
                privateInformation(playerName)
            }) {
                Text("Geheime Informationen ansehen")
            }
        }
    } else {
        RoundFinished()
    }
}

@Composable
fun PrivateScreen(currPlayer: String, nextPlayer: () -> Unit) {
    Column {
        Text("voll geheim hier $currPlayer...")
        Button( onClick = {
            nextPlayer()
        } ) {
            Text("Hab mir alles voll gut gemerkt...")
        }
    }
}

@Composable
fun RoundFinished() {
    Column {
        Text("Runde starten...")
        Button(onClick = {}) {
            Text("Zur Abstimmung")
        }
    }
}