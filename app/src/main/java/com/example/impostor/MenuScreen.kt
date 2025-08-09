package com.example.impostor

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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