package com.example.impostor

import android.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.impostor.ui.theme.ImpostorTheme

@Composable
fun EndScreen(viewModel: GameViewModel, menuTransition: () -> Unit) {
    val votingResult = viewModel.voting
    val imposterIndex = viewModel.currImpostorIndex
    val players = viewModel.players
    val impostorName = players[imposterIndex]
    val currSecret = viewModel.currSecret
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            var votedImpostor: String = ""
            var voteCount: Int = 0
            votingResult.forEach { (key, votes) ->
                if (key != impostorName && votes > voteCount) {
                    votedImpostor = key
                    voteCount = votes
                }
            }
            if ((votingResult[impostorName] ?: 0) > voteCount) {
                ImpostorDetected(impostorName, currSecret, menuTransition)
            } else {
                ImpostorWon(impostorName, votedImpostor, currSecret, menuTransition)
            }
        }
    }
}

@Composable
fun ImpostorDetected(impostorName: String, currSecret: String, menuTransition: () -> Unit) {
    var resultText by remember { mutableStateOf("") }
    var guess by remember { mutableStateOf("") }
    var guessDone by remember { mutableStateOf(false) }
    var resultMessage by remember { mutableStateOf("") }

    if (guessDone) {
        Row {
            Text(
                text = resultMessage,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(15.dp),
                fontSize = 30.sp,
                color = MaterialTheme.colorScheme.onPrimary,
                style = TextStyle(
                    lineHeight = 44.sp,
                ),
            )
        }
    }
    Row {
        Text(
            text = "Der Impostor $impostorName wurde enttarnt!",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            fontSize = 25.sp,
            style = TextStyle(
                lineHeight = 32.sp,
            ),
        )
    }
    if (!guessDone) {
        Row {
            Text(
                text = "Der Impostor kann noch gewinnen, wenn der gesuchte Begriff richtig erraten wird.",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                fontSize = 25.sp,
                style = TextStyle(
                    lineHeight = 32.sp,
                ),
            )
        }
        Row {
            TextField(
                value = guess,
                onValueChange = { it: String -> guess = it },
                label = { Text("Gesuchter Begriff") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            )
        }
    }
    Row {
        if (!guessDone) {
            Button(
                onClick = {
                    if (currSecret.lowercase() == guess.lowercase()) {
                        resultText = "$impostorName hat $currSecret erraten!"
                        resultMessage = "$impostorName hat gewonnen!"
                    } else {
                        resultText = "$impostorName hat $guess geraten, der Begriff war $currSecret."
                        resultMessage = "$impostorName hat verloren!"
                    }
                    guessDone = true
                },
                shape = RoundedCornerShape(7.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
            ) {
                Text("Begriff Raten")
            }
        } else {
            Column {
                Row {
                    Text(
                        text = resultText,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        fontSize = 25.sp,
                        style = TextStyle(
                            lineHeight = 32.sp,
                        ),
                    )
                }
                Button(
                    onClick = {
                        menuTransition()
                    },
                    shape = RoundedCornerShape(7.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                ) {
                    Text("Weiter")
                }
            }
        }
    }
}

@Composable
fun ImpostorWon(
    impostorName: String,
    votedImpostor: String,
    currSecret: String,
    menuTransition: () -> Unit
) {
    Row {
        Text(
            text = "$impostorName hat gewonnen!",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(8.dp)
                )
                .padding(15.dp),
            fontSize = 30.sp,
            color = MaterialTheme.colorScheme.onPrimary,
            style = TextStyle(
                lineHeight = 44.sp,
            ),
        )
    }
    Row {
        Text(
            text = "Falsch beschuldigt wurde $votedImpostor, das Geheime Wort war $currSecret.",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            fontSize = 25.sp,
            style = TextStyle(
                lineHeight = 32.sp,
            ),
        )
    }
    Row {
        Button(
            onClick = {
                menuTransition()
            },
            shape = RoundedCornerShape(7.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Text("Weiter")
        }
    }
}