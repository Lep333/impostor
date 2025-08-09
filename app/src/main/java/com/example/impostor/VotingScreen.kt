package com.example.impostor

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun VotingScreen(
    viewModel: GameViewModel,
    endScreenTransition: () -> Unit
) {
    val players = viewModel.players
    val currIndex = viewModel.currIndex
    if (viewModel.currIndex < players.size) {
        val currPlayer = players[currIndex]
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), contentAlignment = Alignment.Center) {
            Column {
                Text(
                    text = "$currPlayer stimmt ab",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                )
                players.forEach { name ->
                    if (currPlayer != name) {
                        Row {
                            Button(
                                onClick = {
                                    viewModel.vote(name)
                                    viewModel.incrementCurrIndex()
                                },
                                shape = RoundedCornerShape(7.dp),
                            ) {
                                Text(
                                    text = name,
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.fillMaxWidth(),
                                )
                            }
                        }
                    }
                }
            }
        }
    } else {
        endScreenTransition()
    }
}